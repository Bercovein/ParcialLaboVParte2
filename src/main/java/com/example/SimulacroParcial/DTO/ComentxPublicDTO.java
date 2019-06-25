package com.example.SimulacroParcial.DTO;

import javax.validation.constraints.NotEmpty;

public class ComentxPublicDTO {

    @NotEmpty (message = "El titulo no debe estar vacío")
    private String titulo;
    @NotEmpty (message = "El nombre del dueño no debe estar vacío")
    private String dueño;
    @NotEmpty (message = "La cantidad de mensajes no debe ser vacía,debe ser cero o mas")
    private Integer cantComent;

}
