package com.webhotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webhotel.dao.ClienteDAO;
import com.webhotel.modelos.Cliente;

@Service("clienteServicio")
@Transactional
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteDAO dao;
	
	
	public Cliente buscarXId(int id) {
		return dao.buscarXId(id);
	}
	
	public Cliente buscarXNyA(String ayn) {
		return dao.buscarXAyN(ayn);
	}
	
	public void guardarCliente(Cliente cliente) {
		dao.guardar(cliente);
		
	}
	
	public void actualizarCliente(Cliente cliente) {
		Cliente entity = dao.buscarXId(cliente.getId());
		if(entity!=null){
			entity.setNombre(cliente.getNombre());
			entity.setApellido(cliente.getApellido());
			entity.setDomicilio(cliente.getDomicilio());
			entity.setPais(cliente.getPais());
			entity.setProvincia(cliente.getProvincia());
			entity.setLocalidad(cliente.getLocalidad());
			entity.setTelefono(cliente.getTelefono());
			entity.setLocalidad2(cliente.getLocalidad2());
			entity.setEmail(cliente.getEmail());
			
			entity.setTipo_documento(cliente.getTipo_documento());
			entity.setNro_documento(cliente.getNro_documento());
			entity.setEstado_civil(cliente.getEstado_civil());
			entity.setOcupacion(cliente.getOcupacion());
			entity.setFechanacimiento(cliente.getFechanacimiento());			
		}	
	}
	
	@Override
	public void borrarClienteXid(int id) {
		dao.borrarXId(id);
		
	}
	public List<Cliente> listarClientes() {
		return dao.listarClientes();
	} 

}
