package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> listarTodos() {
        return ninjaRepository.findAll();
    }

    public NinjaModel buscarPorId(long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public NinjaDTO salvar(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public NinjaDTO alterar(long id, NinjaDTO ninjaDTO) {
        if (ninjaRepository.existsById(id)) {
            return null;
        }

        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public Boolean deletar(long id) {
        if (!ninjaRepository.existsById(id)) {
            return false;
        }

        ninjaRepository.deleteById(id);
        return true;
    }
}