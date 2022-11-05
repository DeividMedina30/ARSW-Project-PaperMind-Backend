package edu.eci.arsw.PaperMind.backend.repository;


import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //componente encargado de resolver el acceso a los datos de nuestro micro-servicio.
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

    @Query(value = "SELECT b FROM bibliotecas b WHERE b.nombre = :nombre")
    Biblioteca findByName(@Param("nombre") String nombre);

}
