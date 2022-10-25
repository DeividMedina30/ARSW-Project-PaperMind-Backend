package edu.eci.arsw.PaperMind.backend.controller;

import edu.eci.arsw.PaperMind.backend.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import edu.eci.arsw.PaperMind.backend.model.Nota;
import edu.eci.arsw.PaperMind.backend.repository.BibliotecaRepository;
import edu.eci.arsw.PaperMind.backend.repository.NotaRepository;
import edu.eci.arsw.PaperMind.backend.services.BibliotecaServices;
import edu.eci.arsw.PaperMind.backend.services.NotaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class NotaController {
    @RestController
    @RequestMapping("/api")
    @CrossOrigin("*")
    public class notaController {
        @Autowired
        private NotaRepository notaRepository;
        @Autowired
        private NotaServices notaServices;

        //Get Bibliotecas
        @GetMapping("/notas")
        public List<Nota> getAllBibliotecas(){
            return this.notaServices.getNota();
        }

        //Get Nota by ID
        @GetMapping("/Notas/{id}")
        public ResponseEntity<?> getNotaID(@PathVariable(value = "id") Long idNota) throws ResourceNotFoundException { //@PathVariable indica que nos referimos a datos incluidos dentro del mismo path del pedido
            return new ResponseEntity<>(NotaServices.getNotaID(idNota), HttpStatus.ACCEPTED);
        }
        //Save Nota
        @PostMapping("/Notas")
        public ResponseEntity<?> createNotas (@RequestBody Nota nota){
            try {
                return new ResponseEntity<>(this.notaServices.saveNota(nota), HttpStatus.CREATED);
            } catch (Exception ex) {
                return new ResponseEntity<>("Error al crear nueva Nota",HttpStatus.FORBIDDEN);
            }
        }
        //Update Nota
        @PutMapping("/nota/{id}")
        public ResponseEntity<?> updateNota(@PathVariable(value = "id") Long notaId, @RequestBody Nota NotaDatos) throws ResourceNotFoundException {
            return new ResponseEntity<>(this.notaServices.updateNota(notaId, NotaDatos), HttpStatus.ACCEPTED);
        }
        //Delete Biblioteca
        @DeleteMapping("/notas/{id}")
        public ResponseEntity<?> deleteNota (@PathVariable(value = "id") Long notaId) throws ResourceNotFoundException {
            this.notaServices.deleteNota(notaId);
            return new ResponseEntity<>("Nota Borrada", HttpStatus.OK);
        }

    }




}
