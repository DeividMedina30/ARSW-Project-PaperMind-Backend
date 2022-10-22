package edu.eci.arsw.PaperMind.repository;

import edu.eci.arsw.PaperMind.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepositoryy extends JpaRepository<Nota, Long> {
}
