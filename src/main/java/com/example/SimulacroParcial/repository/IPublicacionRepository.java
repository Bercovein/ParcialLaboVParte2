package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.DTO.PublicacionProjection;
import com.example.SimulacroParcial.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion,Integer> {

    String queryPuntoUno = "select p.titulo, u.nombre, count(c.id) from publicaciones p" +
            "inner join usuarios u on u.id = p.usuario_id" +
            "inner join comentarios c on c.id = p.comentario_id" +
            "group by u.nombre";

    @Query (value = queryPuntoUno, nativeQuery = true)
    List<PublicacionProjection> getComentxPublic();

}
