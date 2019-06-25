package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.domain.Comentario;
import com.example.SimulacroParcial.domain.Publicacion;
import com.example.SimulacroParcial.domain.Usuario;
import com.example.SimulacroParcial.repository.IComentarioRepository;
import com.example.SimulacroParcial.repository.IPublicacionRepository;
import com.example.SimulacroParcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

@Service
public class AllContentService {

    @Autowired
    IPublicacionRepository publicaciones;

    @Autowired
    IUsuarioRepository usuarios;

    @Autowired
    IComentarioRepository comentarios;


    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> getComentarios() throws InterruptedException {
        sleep(2000);
        return CompletableFuture.completedFuture(comentarios.findAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> getUsuarios() throws InterruptedException {
        sleep(2000);
        return CompletableFuture.completedFuture(usuarios.findAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> getPublicacion() throws InterruptedException {
        sleep(2000);
        return CompletableFuture.completedFuture(publicaciones.findAll());
    }
}
