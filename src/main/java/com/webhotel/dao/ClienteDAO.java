package com.webhotel.dao;

import java.util.List;

import com.webhotel.modelos.Cliente;

public interface ClienteDAO {

	Cliente buscarXId(int id);

	Cliente buscarXAyN(String ayn);

	void guardar(Cliente cliente);

	void borrarXId(int id);

	List<Cliente> listarClientes();
}
