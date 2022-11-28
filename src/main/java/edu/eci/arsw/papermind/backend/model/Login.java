package edu.eci.arsw.papermind.backend.model;

public class Login {

    private String correo;
    private String password;

    public Login(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String password) {
        this.password = password;
    }
}
