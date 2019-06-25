package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.DTO.ComentxPublicDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComentxPublicRepository extends JpaRepository<ComentxPublicDTO,Integer> {

    String queryPuntoDos = "select p.titulo, u.nombre, count(c.id) from publicaciones p" +
            "inner join usuarios u on u.id = p.usuario_id" +
            "inner join comentarios c on c.id = p.comentario_id" +
            "group by u.nombre";

    @Query (value = queryPuntoDos, nativeQuery = true)
    List<ComentxPublicDTO> getComentxPublicDto();

}
