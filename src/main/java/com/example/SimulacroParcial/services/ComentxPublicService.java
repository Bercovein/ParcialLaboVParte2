package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.DTO.ComentxPublicDTO;
import com.example.SimulacroParcial.repository.IComentxPublicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentxPublicService {

    @Autowired
    IComentxPublicRepository comentxPublic;

    public List<ComentxPublicDTO> getAll(){
        return comentxPublic.getComentxPublicDto();
    }

}
