package edu.eci.arsw.PaperMind.Biblioteca.services;


import edu.eci.arsw.PaperMind.Biblioteca.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.Biblioteca.model.Biblioteca;
import edu.eci.arsw.PaperMind.Biblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BibliotecaServices {

    @Autowired
    BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> getBibliotecas(){
        return bibliotecaRepository.findAll();
    }

    public Biblioteca getBibliotecaById(Long idBiblioteca) throws ResourceNotFoundException {
        Biblioteca biblioteca = bibliotecaRepository.findById(idBiblioteca).orElseThrow(() -> new ResourceNotFoundException(String.format("No se encontro la biblioteca con el ID: %d", idBiblioteca)));
        return biblioteca;
    }

    public Biblioteca saveBiblioteca(Biblioteca biblioteca){
        return this.bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca updateBiblioteca(Long idBiblioteca, Biblioteca bibliotecaDatos) throws ResourceNotFoundException {
        Biblioteca biblioteca = getBibliotecaById(idBiblioteca);
        biblioteca.setNombre(bibliotecaDatos.getNombre());
        biblioteca.setFecha_modificacion(LocalDateTime.now());
        biblioteca.setDescripcion(bibliotecaDatos.getDescripcion());
        return bibliotecaRepository.save(biblioteca);
    }

    public void deleteBiblioteca(Long idBiblioteca) throws ResourceNotFoundException {
        Biblioteca biblioteca = getBibliotecaById(idBiblioteca);
        bibliotecaRepository.delete(biblioteca);
    }
}
