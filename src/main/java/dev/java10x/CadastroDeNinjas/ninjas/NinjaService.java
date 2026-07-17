package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.exception.BusinessException;
import dev.java10x.CadastroDeNinjas.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarTodos() {
        List<NinjaDTO> ninjas = ninjaRepository.findAll().stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

        return ninjas;
    }

    public NinjaDTO buscarPorId(long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Ninja com id " + id + " não encontrado")
                );
    }

    public NinjaDTO salvar(NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaEmail = ninjaRepository.findByEmail(ninjaDTO.getEmail());
        if (ninjaEmail.isPresent()) {
            throw new BusinessException("Esse e-mail já está em uso");
        }

        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public NinjaDTO alterar(long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if (ninja.isEmpty()) {
            throw new ResourceNotFoundException("Ninja com id " + id + " não encontrado");
        }

        Optional<NinjaModel> ninjaEmail = ninjaRepository.findByEmail(ninjaDTO.getEmail());
        if (ninjaEmail.isPresent() && ninjaEmail.get().getId() != id) {
            throw new BusinessException("Esse e-mail já está em uso");
        }

        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel.setId(id);
        ninjaModel = ninjaRepository.save(ninjaModel);

        return ninjaMapper.map(ninjaModel);
    }

    public Boolean deletar(long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if (ninja.isEmpty()) {
            throw new ResourceNotFoundException("Ninja com id " + id + " não encontrado");
        }

        ninjaRepository.deleteById(id);
        return true;
    }
}