package edu.eci.arsw.papermind.backend.services;

import edu.eci.arsw.papermind.backend.model.Login;
import edu.eci.arsw.papermind.backend.model.User;
import edu.eci.arsw.papermind.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        User newUser = null;
        try{
            newUser = userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    public User validateLogin(Login login) {
        User searchedUser = userRepository.findByUsernameAndPassword(login.getCorreo(), login.getContraseña());
        try{
            if(searchedUser == null){
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchedUser;

    }
}
