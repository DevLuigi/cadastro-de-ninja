package dev.java10x.CadastroDeNinjas.ninjas;

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
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO salvar(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public NinjaDTO alterar(long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if (ninja.isEmpty()) {
            return null;
        }

        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel.setId(id);
        ninjaModel = ninjaRepository.save(ninjaModel);

        return ninjaMapper.map(ninjaModel);
    }

    public Boolean deletar(long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if (ninja.isEmpty()) {
            return false;
        }

        ninjaRepository.deleteById(id);
        return true;
    }
}