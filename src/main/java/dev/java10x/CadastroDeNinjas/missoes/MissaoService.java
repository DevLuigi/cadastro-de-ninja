package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> listarTodos() {
        List<MissaoDTO> missoes = missaoRepository.findAll().stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());

        return missoes;
    }

    public MissaoDTO buscarPorId(long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Missão com id " + id + " não encontrada")
                );
    }

    public MissaoDTO salvar(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        MissaoDTO missaoSalva = missaoMapper.map(missaoRepository.save(missaoModel));
        return missaoSalva;
    }

    public MissaoDTO alterar(long id, MissaoDTO missaoDTO) {
       Optional<MissaoModel> missao = missaoRepository.findById(id);
        if (missao.isEmpty()) {
            throw new ResourceNotFoundException("Missão com id " + id + " não encontrada");
        }

        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        missaoModel.setId(id);
        MissaoDTO missaoAlterada = missaoMapper.map(missaoRepository.save(missaoModel));
        return missaoAlterada;
    }

    public Boolean deletar(long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        if (missao.isEmpty()) {
            throw new ResourceNotFoundException("Missão com id " + id + " não encontrada");
        }

        missaoRepository.deleteById(id);
        return true;
    }

}
