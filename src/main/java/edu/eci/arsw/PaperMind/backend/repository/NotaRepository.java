package edu.eci.arsw.PaperMind.backend.repository;

import edu.eci.arsw.PaperMind.backend.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

}
