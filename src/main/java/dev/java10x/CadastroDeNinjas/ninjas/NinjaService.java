package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarTodos() {
        return ninjaRepository.findAll();
    }

    public NinjaModel buscarPorId(long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public NinjaModel salvar(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public NinjaModel alterar(long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            return null;
        }

        ninja.setId(id);
        return ninjaRepository.save(ninja);
    }

    public Boolean deletar(long id) {
        if (!ninjaRepository.existsById(id)) {
            return false;
        }

        ninjaRepository.deleteById(id);
        return true;
    }
}