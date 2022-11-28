package edu.eci.arsw.papermind.backend.repository;


import edu.eci.arsw.papermind.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository //componente encargado de resolver el acceso a los datos de nuestro micro-servicio.

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from usuarios where correo = :correo and contraseña =:password", nativeQuery = true)
    User findByUsernameAndPassword(@Param("correo") String correo, @Param("password") String password);

}
