package com.example.SimulacroParcial.controller;


import com.example.SimulacroParcial.DTO.PublicacionDTO;
import com.example.SimulacroParcial.DTO.PublicacionProjection;
import com.example.SimulacroParcial.domain.Comentario;
import com.example.SimulacroParcial.domain.Publicacion;
import com.example.SimulacroParcial.domain.Punto3;
import com.example.SimulacroParcial.domain.Usuario;
import com.example.SimulacroParcial.services.AllContentService;
import com.example.SimulacroParcial.services.PublicacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RequestMapping("/publicaciones")
@RestController
public class PublicacionController {

    @Autowired
    PublicacionService publicacionService;

    @Autowired
    AllContentService allContentService;

    @PostMapping("/usuario/{id}")
    public void add (@RequestBody Publicacion publicacion,@PathVariable Integer id){
        publicacionService.add(publicacion,id);
    }

    @GetMapping("/usuario/{id}")
    public List<PublicacionDTO> getAllbyUser(@PathVariable Integer id){

        List<Publicacion> publicaciones = publicacionService.getAll(id);

        return publicaciones.stream().map(publicacion->convertToDto(publicacion)).collect(Collectors.toList());
    }

    public PublicacionDTO convertToDto(Publicacion publicacion){

        return new ModelMapper().map(publicacion,PublicacionDTO.class);
    }

    @GetMapping("/comentarios")
    public List<PublicacionProjection> getComentxPublic(){
        return publicacionService.getComentxPublic();
    }

    @GetMapping("/allContent")
    public ResponseEntity<Punto3> getAllContent() throws InterruptedException {

        CompletableFuture<List<Comentario>> comments = allContentService.getComentarios();
        CompletableFuture<List<Publicacion>> publications = allContentService.getPublicacion();
        CompletableFuture<List<Usuario>> users = allContentService.getUsuarios();

        List<Publicacion> pub = publications.join();
        List<Comentario>  com = comments.join();
        List<Usuario> usu = users.join();

        return ResponseEntity.status(200).body(new Punto3(pub,com,usu));
    }

}
