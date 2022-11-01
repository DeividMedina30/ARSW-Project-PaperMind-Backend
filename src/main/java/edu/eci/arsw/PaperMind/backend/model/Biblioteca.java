package edu.eci.arsw.PaperMind.backend.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

@Entity //Una entidad es un objeto, elemento o ‘cosa’ con atributos particulares que lo distinguen. Por ejemplo, este podría ser un ‘user
@Table(name = "bibliotecas")
public class Biblioteca {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)//El valor de esta PK es generada automáticamente con esta anotación
	private Long id_biblioteca;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@Column(name = "fecha_modificacion")
	private Date fecha_modificacion;

	@Column(name = "descripcion")
	private String descripcion;

	public Biblioteca(){
		super();
	}

	public Biblioteca(String nombre, Date fecha_creacion, Date fecha_modificacion){
		super();
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}

	public Long getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(Long id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
