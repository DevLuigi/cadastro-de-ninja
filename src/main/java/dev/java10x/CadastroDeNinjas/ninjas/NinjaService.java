package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        NinjaModel ninjaEncontrado = this.buscarPorId(id);
        if (ninjaEncontrado == null) {
            return null;
        }

        ninjaEncontrado = ninja;
        ninjaEncontrado.setId(id);

        return ninjaRepository.save(ninjaEncontrado);
    }

    public Boolean deletar(long id) {
        NinjaModel ninjaEncontrado = this.buscarPorId(id);
        if (ninjaEncontrado == null) {
            return false;
        }

        ninjaRepository.deleteById(id);
        return true;
    }
}