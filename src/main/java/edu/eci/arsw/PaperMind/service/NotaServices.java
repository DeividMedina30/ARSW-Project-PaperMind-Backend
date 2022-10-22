package edu.eci.arsw.PaperMind.service;


import edu.eci.arsw.PaperMind.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.model.Nota;
import edu.eci.arsw.PaperMind.repository.NotaRepositoryy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotaServices {
    @Autowired
    NotaRepositoryy notaRepository;

    public List<Nota> getNota() {
        return notaRepository.findAll();
    }
    public Nota getNotaID(Long idNota) throws ResourceNotFoundException, ResourceNotFoundException {
        Nota nota = notaRepository.findById(idNota).orElseThrow(()-> new ResourceNotFoundException(String.format("No se encontro la NOTA con el ID: %d", idNota)));
        return nota;
    }

}

