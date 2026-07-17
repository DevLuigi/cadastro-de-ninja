package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {
    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setDescricao(missaoDTO.getDescricao());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setLocalizacao(missaoDTO.getLocalizacao());
        // missaoModel.setNinjas(missaoDTO.getNinjas());
        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setDescricao(missaoModel.getDescricao());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());
        missaoDTO.setLocalizacao(missaoModel.getLocalizacao());
        // missaoDTO.setNinjas(missaoModel.getNinjas());
        return missaoDTO;
    }
}
