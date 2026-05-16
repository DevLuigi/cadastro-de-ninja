package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> listarTodos() {
        return missaoRepository.findAll();
    }

    public MissaoModel buscarPorId(long id) {
        return missaoRepository.findById(id).orElse(null);
    }

    public MissaoModel salvar(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    public MissaoModel alterar(long id, MissaoModel missao) {
        if (!missaoRepository.existsById(id)) {
            return null;
        }

        missao.setId(id);
        return missaoRepository.save(missao);
    }

    public Boolean deletar(long id) {
        if (!missaoRepository.existsById(id)) {
            return false;
        }

        missaoRepository.deleteById(id);
        return true;
    }

}
