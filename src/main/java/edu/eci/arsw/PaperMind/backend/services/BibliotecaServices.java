package edu.eci.arsw.PaperMind.backend.services;

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

    public ResponseEntity<?> saveBiblioteca(Biblioteca biblioteca){
        String nombre = biblioteca.getNombre();
        Biblioteca bibliotecaRespuesta = getBibliotecaByName(nombre);
        if(bibliotecaRespuesta != null){
            return new ResponseEntity<>("Error al crear nueva Biblioteca",HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(this.bibliotecaRepository.save(biblioteca), HttpStatus.CREATED);
    }

    public List<Biblioteca> getBibliotecas(){
        return bibliotecaRepository.findAll();
    }

    public Biblioteca getBibliotecaByName(String name){
        Biblioteca biblioteca;
        biblioteca = bibliotecaRepository.findByNombre(name);
        return biblioteca;
    }

    public ResponseEntity<?> updateBiblioteca(String name, Biblioteca bibliotecaDatos) {
        Biblioteca bibliotecaActualizar = getBibliotecaByName(name);
        Biblioteca bibliotecaExistente = getBibliotecaByName(bibliotecaDatos.getNombre());
        if((bibliotecaExistente == null) || (bibliotecaActualizar.getId_biblioteca().equals(bibliotecaExistente.getId_biblioteca()))){
        }
        else if((!bibliotecaDatos.getNombre().equals(bibliotecaExistente.getNombre()))){
        }else{
            return new ResponseEntity<>("Error al actualizar la Biblioteca.",HttpStatus.NOT_FOUND);
        }
        updateBiblioteca(bibliotecaActualizar, bibliotecaDatos);
        return new ResponseEntity<>(getBibliotecaByName(bibliotecaDatos.getNombre()) ,HttpStatus.OK);
    }

    private void updateBiblioteca(Biblioteca bibliotecaActualizar, Biblioteca bibliotecaDatos){
        bibliotecaActualizar.setNombre(bibliotecaDatos.getNombre());
        bibliotecaActualizar.setFecha_modificacion(bibliotecaDatos.getFecha_modificacion());
        bibliotecaActualizar.setDescripcion(bibliotecaDatos.getDescripcion());
        bibliotecaRepository.save(bibliotecaActualizar);
    }

    public ResponseEntity<?> deleteBiblioteca(String nombre) {
        Biblioteca biblioteca = getBibliotecaByName(nombre);
        if(biblioteca == null){
            return new ResponseEntity<>("Error al borrar nueva biblioteca Biblioteca",HttpStatus.BAD_REQUEST);
        }
        bibliotecaRepository.deleteById(biblioteca.getId_biblioteca());
        return new ResponseEntity<>("Se borro correctamente la biblioteca",HttpStatus.OK);
    }

}