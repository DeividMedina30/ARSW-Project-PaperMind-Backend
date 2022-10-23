package edu.eci.arsw.PaperMind.backend.services;
import edu.eci.arsw.PaperMind.backend.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.backend.model.Nota;
import edu.eci.arsw.PaperMind.backend.repository.NotaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class NotaServices {
    @Autowired
    static
    NotaRepository notaRepository;

    public List<Nota> getNota() {

        return notaRepository.findAll();
    }
    public static Nota getNotaID(Long idNota) throws ResourceNotFoundException, ResourceNotFoundException {
        Nota nota = notaRepository.findById(idNota).orElseThrow(()-> new ResourceNotFoundException(String.format("No se encontro la NOTA con el ID: %d", idNota)));
        return nota;
    }
    public Nota saveNota (Nota nota){
        return this.notaRepository.save(nota);
    }

    public Nota updateNota(Long idNota, Nota NotaDatos) throws ResourceNotFoundException {
        Nota nota = getNotaID(idNota);
        nota.setNombre(NotaDatos.getNombre());
        nota.setFecha_modificacion(LocalDateTime.now());
        nota.setDescripcion(NotaDatos.getDescripcion());
        return notaRepository.save(nota);
    }
    public void deleteNota(Long idNota) throws ResourceNotFoundException {
        Nota notaID = getNotaID(idNota);
        notaRepository.delete(notaID);
    }






}
