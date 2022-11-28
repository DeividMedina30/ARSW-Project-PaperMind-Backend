package edu.eci.arsw.papermind.backend.model;

import java.util.Date;
import javax.persistence.*;

@Entity //Una entidad es un objeto, elemento o ‘cosa’ con atributos particulares que lo distinguen. Por ejemplo, este podría ser un ‘user
@Table(name = "bibliotecas")
public class Biblioteca {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)//El valor de esta PK es generada automáticamente con esta anotación
	private Long idbiblioteca;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha_creacion")
	private Date recreational;

	@Column(name = "fecha_modificacion")
	private Date fecha_modification;

	@Column(name = "descripcion")
	private String description;

	public Biblioteca(){
		super();
	}

	public Biblioteca(String nombre, Date recreational, Date fecha_modification){
		super();
		this.nombre = nombre;
		this.recreational = recreational;
		this.fecha_modification = fecha_modification;
	}

	public Long getId_biblioteca() {
		return idbiblioteca;
	}

	public void setId_biblioteca(Long id_biblioteca) {
		this.idbiblioteca = id_biblioteca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_recreational() {
		return recreational;
	}

	public void setFecha_recreational(Date recreational) {
		this.recreational = recreational;
	}

	public Date getFecha_modification() {
		return fecha_modification;
	}

	public void setFecha_modification(Date fecha_modification) {
		this.fecha_modification = fecha_modification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
