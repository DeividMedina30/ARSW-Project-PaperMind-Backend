package edu.eci.arsw.PaperMind.backend.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notas")
public class Nota {
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nota;

    @Column(name= "idbiblioteca")
    private Long idbiblioteca;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacion;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fecha_modificacion;
    @Column(name = "texto")
    private String texto;
    public Nota(){
        super();
    }

    public Nota(String nombre, LocalDateTime fecha_creacion, LocalDateTime fecha_modificacion){
        super();
        this.idbiblioteca=idbiblioteca;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.texto=texto;
    }

    public Long getId_nota() {
        return id_nota;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setId_nota(Long id_nota) {
        this.id_nota = id_nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdbiblioteca() {
        return idbiblioteca;
    }

    public void setIdbiblioteca(Long idbiblioteca) {
        this.idbiblioteca = idbiblioteca;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
