package edu.eci.arsw.PaperMind.backend.controller;

import edu.eci.arsw.PaperMind.backend.exception.ResourceNotFoundException;
import edu.eci.arsw.PaperMind.backend.model.Login;
import edu.eci.arsw.PaperMind.backend.model.User;
import edu.eci.arsw.PaperMind.backend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//es un controller especial en RESTful especificacion y equivale a la suma de @Controller y @ResponseBody.
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserContoller {

    @Autowired
    private UserServices userServices;

    @PostMapping(value="/users")
    public ResponseEntity<?> addUser(@RequestBody User user)  {
        try{
            User newUser = userServices.addUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value="/login")
    public ResponseEntity<?> doLogin(@RequestBody Login login)  {
        try{
            User loggedUser = userServices.validateLogin(login);
            return new ResponseEntity<>(loggedUser, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}