package edu.eci.arsw.PaperMind.backend.repository;

import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest //proporciona una forma conveniente de configurar un entorno con una base de datos integrada para probar nuestras consultas de base de datos.
public class BibliotecaRepositoryTests {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Test
    void testFindByName(){
        Biblioteca biblioteca = new Biblioteca();
        
    }
}
