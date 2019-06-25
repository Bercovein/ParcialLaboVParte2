package com.example.SimulacroParcial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Punto3 {

    private List<Publicacion> publications;
    private List<Comentario> comments;
    private List<Usuario> users;
}
