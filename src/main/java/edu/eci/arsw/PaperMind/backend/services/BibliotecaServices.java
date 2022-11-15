package edu.eci.arsw.PaperMind.backend.services;


import edu.eci.arsw.PaperMind.backend.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import edu.eci.arsw.PaperMind.backend.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BibliotecaServices {

    @Autowired
    BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> getBibliotecas(){
        return (List<Biblioteca>) bibliotecaRepository.findAll();
    }

    public Biblioteca getBibliotecaById(Long idBiblioteca) throws ResourceNotFoundException {
        Biblioteca biblioteca = bibliotecaRepository.findById(idBiblioteca).orElseThrow(() -> new ResourceNotFoundException(String.format("No se encontro la biblioteca con el ID: %d", idBiblioteca)));
        return biblioteca;
    }

    public ResponseEntity<?> saveBiblioteca(Biblioteca biblioteca){
        String nombre = biblioteca.getNombre();
        Biblioteca bibliotecaRespuesta = getBibliotecaByName(nombre);
        if(bibliotecaRespuesta != null){
            return new ResponseEntity<>("Error al crear nueva Biblioteca",HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(this.bibliotecaRepository.save(biblioteca), HttpStatus.CREATED);
    }

    public Biblioteca updateBiblioteca(Long idBiblioteca, Biblioteca bibliotecaDatos) throws ResourceNotFoundException {
        Biblioteca biblioteca = getBibliotecaById(idBiblioteca);
        biblioteca.setNombre(bibliotecaDatos.getNombre());
        biblioteca.setFecha_modificacion(biblioteca.getFecha_modificacion());
        biblioteca.setDescripcion(bibliotecaDatos.getDescripcion());
        return bibliotecaRepository.save(biblioteca);
    }

    public ResponseEntity<?> deleteBiblioteca(String nombre) {
        Biblioteca biblioteca = getBibliotecaByName(nombre);
        if(biblioteca == null){
            return new ResponseEntity<>("Error al borrar nueva biblioteca Biblioteca",HttpStatus.BAD_REQUEST);    
        }
        bibliotecaRepository.deleteByName(nombre);
        return new ResponseEntity<>("Se borro correctamente la biblioteca",HttpStatus.OK);  
    }


    public Biblioteca getBibliotecaByName(String name){
        Biblioteca biblioteca = null;
        biblioteca = bibliotecaRepository.findByName(name.toLowerCase());
        return biblioteca;
    }


}