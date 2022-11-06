package edu.eci.arsw.PaperMind.backend.repository;


import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository //componente encargado de resolver el acceso a los datos de nuestro micro-servicio.
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

    @Query(value = "select * from bibliotecas b where lower(b.nombre) = :nombre", nativeQuery = true)
    Biblioteca findByName(@PathVariable("nombre") String nombre);

    @Query(value = "select * from bibliotecas b where lower(b.nombre) like %:nombre% or upper(b.nombre) like %:nombre% ", nativeQuery = true)
    List<Biblioteca> findBibliotecasByName(@PathVariable("nombre") String nombre);

}
