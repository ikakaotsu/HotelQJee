package com.webhotel.servicios;

import java.util.List;

import com.webhotel.modelos.Cliente;

public interface ClienteServicio {

	Cliente buscarXId(int id);
	
	Cliente buscarXNyA(String nya);
	
	void guardarCliente(Cliente cliente);
	
	void actualizarCliente(Cliente cliente);
	
	void borrarClienteXid(int id);
	
	List<Cliente> listarClientes();
    
    
    
    
    	
		
	
}
