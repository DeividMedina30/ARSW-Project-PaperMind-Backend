package edu.eci.arsw.PaperMind.backend.controller;


import edu.eci.arsw.PaperMind.backend.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import edu.eci.arsw.PaperMind.backend.repository.BibliotecaRepository;
import edu.eci.arsw.PaperMind.backend.services.BibliotecaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //es un controller especial en RESTful especificacion y equivale a la suma de @Controller y @ResponseBody.
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BibliotecaController {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Autowired
    private BibliotecaServices bibliotecaServices;

    //Get Bibliotecas
    @GetMapping("/bibliotecas")
    public List<Biblioteca> getAllBibliotecas(){
        return this.bibliotecaServices.getBibliotecas();
    }

    //Get Biblioteca by Name
    @GetMapping("/bibliotecas/{name}")
    public ResponseEntity<?> getBibliotecaByName(@PathVariable(value = "name") String name) throws ResourceNotFoundException { //@PathVariable indica que nos referimos a datos incluidos dentro del mismo path del pedido
        return new ResponseEntity<>(bibliotecaServices.getBibliotecaByName(name),HttpStatus.ACCEPTED);
    }

    //Save Biblioteca
    @PostMapping("/bibliotecas")
    public ResponseEntity<?> createBiblioteca(@RequestBody Biblioteca biblioteca){
        return bibliotecaServices.saveBiblioteca(biblioteca);
    }

    //Update Bibblioteca
    @PutMapping("/bibliotecas/{id}")
    public ResponseEntity<?> updateBiblioteca(@PathVariable(value = "id") Long bibliotecaId, @RequestBody Biblioteca bibliotecaDatos) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.bibliotecaServices.updateBiblioteca(bibliotecaId, bibliotecaDatos), HttpStatus.ACCEPTED);
    }

    //Delete Biblioteca
    @DeleteMapping("/bibliotecas/{nombre}")
    public ResponseEntity<?> deleteBiblioteca(@PathVariable(value = "nombre") String nombre) throws ResourceNotFoundException {
        return this.bibliotecaServices.deleteBiblioteca(nombre);
    }

}
