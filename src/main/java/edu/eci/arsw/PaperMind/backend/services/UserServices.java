package edu.eci.arsw.PaperMind.backend.services;

import edu.eci.arsw.PaperMind.backend.model.Login;
import edu.eci.arsw.PaperMind.backend.model.User;
import edu.eci.arsw.PaperMind.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) throws Exception {
        User newUser = null;
        try{
            newUser = userRepository.save(user);
        } catch (Exception e) {
            throw new Exception("ERROR: El usuario no pudo ser añadido");
        }
        return newUser;
    }

    public User validateLogin(Login login) throws Exception {
        User searchedUser = userRepository.findByUsernameAndPassword(login.getCorreo(), login.getContraseña());
        if(searchedUser == null){
            throw new Exception("ERROR: Credenciales incorrectas");
        }
        return searchedUser;

    }
}
