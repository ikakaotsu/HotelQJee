package com.webhotel.modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.webhotel.modelos.UsuarioPerfil;


@Entity
@Table(name="USUARIO")
public class Usuario extends Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6628659264260637213L;
	@Column(name="CUIL")
	private int cuil;
	@Column(name="CATEGORIA")
	private String categoria;
	@Column(name="PROFESION")
	private String profesion;
	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;
	@Column(name="PASSWORD", nullable=false)
	private String password;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USUARIO_USUARIO_PERFIL", 
             joinColumns = { @JoinColumn(name = "USUARIO_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USUARIO_PERFIL_ID") })
	private Set<UsuarioPerfil> usuarioPerfil = new HashSet<UsuarioPerfil>();
	
	public Set<UsuarioPerfil> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(Set<UsuarioPerfil> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public Usuario() {
		super();
	}

	public Usuario(int cuil, String categoria, String profesion, String ssoId, String password) {
		super();
		this.cuil = cuil;
		this.categoria = categoria;
		this.profesion = profesion;
		this.ssoId = ssoId;
		this.password = password;
	}


	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
