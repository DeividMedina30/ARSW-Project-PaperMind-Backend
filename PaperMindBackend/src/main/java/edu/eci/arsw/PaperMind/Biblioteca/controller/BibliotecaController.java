package edu.eci.arsw.PaperMind.Biblioteca.controller;


import edu.eci.arsw.PaperMind.Biblioteca.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.Biblioteca.model.Biblioteca;
import edu.eci.arsw.PaperMind.Biblioteca.repository.BibliotecaRepository;
import edu.eci.arsw.PaperMind.Biblioteca.services.BibliotecaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController //es un controller especial en RESTful especificacion y equivale a la suma de @Controller y @ResponseBody.
@RequestMapping("/api")
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

    //Get Biblioteca by ID
    @GetMapping("/bibliotecas/{id}")
    public ResponseEntity<?> getBibliotecaById(@PathVariable(value = "id") Long idBibilioteca) throws ResourceNotFoundException { //@PathVariable indica que nos referimos a datos incluidos dentro del mismo path del pedido
        return new ResponseEntity<>(bibliotecaServices.getBibliotecaById(idBibilioteca),HttpStatus.ACCEPTED);
    }

    //Save Biblioteca
    @PostMapping("/bibliotecas")
    public ResponseEntity<?> createBiblioteca(@RequestBody Biblioteca biblioteca){
        try {
            return new ResponseEntity<>(this.bibliotecaServices.saveBiblioteca(biblioteca), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al crear nueva Biblioteca",HttpStatus.FORBIDDEN);
        }
    }

    //Update Bibblioteca
    @PutMapping("/bibliotecas/{id}")
    public ResponseEntity<?> updateBiblioteca(@PathVariable(value = "id") Long bibliotecaId, @RequestBody Biblioteca bibliotecaDatos) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.bibliotecaServices.updateBiblioteca(bibliotecaId, bibliotecaDatos), HttpStatus.ACCEPTED);
    }

    //Delete Biblioteca
    @DeleteMapping("/bibliotecas/{id}")
    public ResponseEntity<?> deleteBiblioteca(@PathVariable(value = "id") Long bibliotecaId) throws ResourceNotFoundException {
        this.bibliotecaServices.deleteBiblioteca(bibliotecaId);
        return new ResponseEntity<>("Biblioteca Borrada", HttpStatus.OK);
    }
}
