package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.Persona;

public interface PersonaServicio {
	public void agregarPersona(Persona p);
    public List<Persona> listarPersonas();
    
    Persona buscarXId(int id);
    Persona buscarXSSO(String sso);
}
