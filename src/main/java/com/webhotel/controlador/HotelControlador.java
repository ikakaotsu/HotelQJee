package com.webhotel.controlador;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webhotel.servicios.UsuarioPerfilServicio;
import com.webhotel.servicios.UsuarioServicio;
import com.webhotel.modelos.Cliente;
import com.webhotel.modelos.CtaCte;
import com.webhotel.modelos.Localidad;

import com.webhotel.servicios.ClienteServicio;
import com.webhotel.servicios.CtaCteServicio;
import com.webhotel.servicios.LocalidadServicio;
import com.webhotel.servicios.PaisServicio;
import com.webhotel.servicios.ProvinciaServicio;
import com.webhotel.modelos.UsuarioPerfil;
import com.webhotel.modelos.Usuario;
import com.webhotel.modelos.Pais;
import com.webhotel.modelos.Provincia;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class HotelControlador {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	@Autowired
	ClienteServicio clienteServicio;
	@Autowired
	CtaCteServicio ctacteServicio;
	
	
	@Autowired
	UsuarioPerfilServicio usuarioPerfilServicio;
	
	@Autowired
	PaisServicio paisServicio;
	
	@Autowired
	ProvinciaServicio provinciaServicio;
	
	@Autowired
	LocalidadServicio localidadServicio;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	
	@RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
	public String paginaInicial(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value={"/listahabitaciones"}, method = RequestMethod.GET)
	public String listaHabitaciones(ModelMap model){
		return "listahabitaciones";
		
	}
	
	/**
	 * Este metodo lista todo los usuario existentes
	 */
	@RequestMapping(value = {"/listausuarios" }, method = RequestMethod.GET)
	public String listarUsuarios(ModelMap model) {

		List<Usuario> usuarios = usuarioServicio.listarUsuarios();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listausuarios";
	}
	
	/**
	 * Este metodo provee el medio para agregar un nuevo usuario.
	 */
	@RequestMapping(value = { "/nuevousuario" }, method = RequestMethod.GET)
	public String nuevoUsuario(ModelMap model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("editar", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "usuario";
	}	
	/**
	 * Este metodo sera llamado por el submit del formulario conteniedo un pedido POST para guardar el usuario en la Base de datos.
	 * Tambien valida la entrada el usuario.
	 */
	@RequestMapping(value = { "/nuevousuario" }, method = RequestMethod.POST)
	public String guardarUsuario(@Valid Usuario usuario, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "usuario";
		}
		/*
		 * Almacena campos unicos [sso] debe implementarse la anotacion @Unique y aplicarce en el campo [sso] de la clase modelo [Usuario]
		 * 
		 * El bloque [if block] demuestra que se puede enviar errores personalizados fuera de la validacion del framework
		 *  o bien seguir usando mensages internalizados.
		 */
		if(!usuarioServicio.isUserSSOUnique(usuario.getId(), usuario.getSsoId())){
			FieldError ssoError =new FieldError("usuario","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{usuario.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registracion";
		}
		
		usuarioServicio.guardarUsario(usuario);

		model.addAttribute("exito", "Usuario " + usuario.getNombre() + " "+ usuario.getApellido() + " registro exitoso");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registracionexitosa";
	}
	
	/**
	 * Este metodo provee el medio para editar un usuario existente.
	 */
	@RequestMapping(value = { "/editar-usuario-{ssoId}" }, method = RequestMethod.GET)
	public String editarUsuario(@PathVariable String ssoId, ModelMap model) {
		Usuario usuario = usuarioServicio.buscarXSSO(ssoId);
		List<Localidad> localidades = localidadServicio.listarLocalidad(usuario.getProvincia());
		model.addAttribute("usuario", usuario);
		model.addAttribute("editar", true);
		model.addAttribute("localidades",localidades);
		model.addAttribute("loggedinuser", getPrincipal());
		return "usuario";
	}
	
	/**
	 * Este metodo sera llamado por el submit del formulario conteniedo un pedido POST para actualizar el usuario en la Base de datos.
	 * Tambien valida la entrada el usuario.
	 */
	@RequestMapping(value = { "/editar-usuario-{ssoId}" }, method = RequestMethod.POST)
	public String actualizarUsuario(@Valid Usuario usuario, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "usuario";
		}
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		usuarioServicio.actualizarUsuario(usuario);

		model.addAttribute("exito", "Usuario " + usuario.getNombre() + " "+ usuario.getApellido() + " actualizacion exitosa");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registracionexitosa";
	}
	
	/**
	 * Este metodo borrara un usuario por su valor SSOID
	 */
	@RequestMapping(value = { "/borrar-usuario-{ssoId}" }, method = RequestMethod.GET)
	public String borrarUsuario(@PathVariable String ssoId) {
		usuarioServicio.borrarUsuarioXSSO(ssoId);
		return "redirect:/listausuarios";
	}
	
	/**
	 * Este metodo provee de la lista de UsuariosPerfil
	 */
	@ModelAttribute("roles")
	public List<UsuarioPerfil> initializeProfiles() {
		return usuarioPerfilServicio.listar();
	}
	
	/**
	 * Este metodo provee de la lista los Paises
	 */
	@ModelAttribute("paises")
	public List<Pais>initializePaises(){
		return paisServicio.listarPaises();
	}
	/**
	 * Este metodo provee de la lista los Provincias
	 */
	@ModelAttribute("provincias")
	public List<Provincia>initializeProvincias(){
		return provinciaServicio.cargarProvincia();
	}
	/**
	 * Este metodo provee de la lista los Provincias segun su Pais con JQuery - JSON
	 */
	@RequestMapping(value = "obtenerprovincia", method = RequestMethod.GET)
	public  @ResponseBody List<Provincia>initializeProvincias(@RequestParam("idpais") int idpais){
		return provinciaServicio.listarProvincias(idpais);	
	}
	/**
	 * Este metodo provee de la lista los Localidad segun su Provincia con JQuery - JSON
	 */
	@RequestMapping(value = "obtenerlocalidad", method = RequestMethod.GET)
	public @ResponseBody List<Localidad>initializeLocalidades(@RequestParam("idprovincia") int idprovincia){
		return localidadServicio.listarLocalidad(idprovincia);
	}
	
	/**
	 * El metodo redirecciona cuando el permiso es negado
	 */
	@RequestMapping(value = "/Acceso_Denegado", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accesoDenegado";
	}
	
	/**
	 * Retorna verdadero si el usuario ya se encuentra autentificado[logged-in] de lo contrario devueve falso
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	/**
	 * Se encarga de los request GET del login
	 * Si el usuario se encuentra logeado[logged-in] y trata de logearse nuevamente se le direcciona a la pagina lista
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/index";  
	    }
	}
	/**
	 * Se encarga de los requests del logout 
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
//----------------------------Clientes--------------------------------------------------------------	
	
/* 	Metodo que inicializa la creacion para un nuevo Cliente.*/
	@RequestMapping(value = { "/nuevocliente"}, method = RequestMethod.GET)
	public String nuevoCliente(ModelMap model){
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("editar", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "cliente";
	}
	
	/**
	 * Llamado por el submit del formulario(POST) guarda el cliente en la Base de datos.
	 * Tambien valida la entrada el cliente.
	 */
	@RequestMapping(value = {"/nuevocliente"}, method = RequestMethod.POST)
	public String guardarCliente(@Valid Cliente cliente, ModelMap model) {

	/*	System.out.println("Pasa por aca:" + "  " + cliente.getApellido() + "  " + cliente.getDomicilio() + "  " + cliente.getEmail() + "  " +
				cliente.getEstado_civil() + "  " + cliente.getLocalidad() + "  " + cliente.getNombre() + "  " + cliente.getNro_documento() + "  " +
				cliente.getOcupacion() + "  " + cliente.getPais() + "  " + cliente.getProvincia() + "  " + cliente.getTelefono() + "  " +
				cliente.getTipo_documento() + "  " + cliente.getFechanacimiento());*/
		clienteServicio.guardarCliente(cliente);

		model.addAttribute("exito", "Cliente " + cliente.getNombre() + " "+ cliente.getApellido() + " registro exitoso");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registracionexitosa";
	}
	
	/*Lista los Clienes existentes en la BD*/
	@RequestMapping(value={"/listaclientes"}, method = RequestMethod.GET)
	public String listaclientes(ModelMap model){
		List<Cliente> cliente = clienteServicio.listarClientes();
		model.addAttribute("cliente", cliente);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listaclientes";
	}
	
	/*Edita el cliente seleccionado en la lista*/
	@RequestMapping(value = { "/editar-cliente-{id}" }, method = RequestMethod.GET)
	public String editarCliente(@PathVariable String id, ModelMap model) {
		Cliente cliente = clienteServicio.buscarXId(Integer.parseInt(id));
		List<Localidad> localidades = localidadServicio.listarLocalidad(cliente.getProvincia());
		model.addAttribute("cliente", cliente);
		model.addAttribute("editar", true);
		model.addAttribute("localidades",localidades);
		model.addAttribute("loggedinuser", getPrincipal());
		return "cliente";
	}
	
	/**
	 * Llamado por el submit del formulario(Post), actualiza el Cliente en la Base de datos.
	 * Tambien valida la entrada el usuario.
	 */
	@RequestMapping(value = { "/editar-cliente-{id}" }, method = RequestMethod.POST)
	public String actualizarCliente(@Valid Cliente cliente, BindingResult result,
			ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return "cliente";
		}

		clienteServicio.actualizarCliente(cliente);

		model.addAttribute("exito", "Cliente " + cliente.getNombre() + " "+ cliente.getApellido() + " actualizacion exitosa");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registracionexitosa";
	}
	
	/**
	 * Este metodo borrara un Cliente por su valor Id
	 */
	@RequestMapping(value = { "/borrar-cliente-{id}" }, method = RequestMethod.GET)
	public String borrarCliente(@PathVariable String id) {
		clienteServicio.borrarClienteXid(Integer.parseInt(id));;
		return "redirect:/listaclientes";
	}

//----------------------------CtaCte--------------------------------------------------------------	
	/* 	Metodo que inicializa la creacion para un nuevo CtaCte.*/
	@RequestMapping(value = { "/nuevoctacte"}, method = RequestMethod.GET)
	public String nuevoCtaCte(ModelMap model){
		CtaCte ctacte = new CtaCte();
		model.addAttribute("ctacte", ctacte);
		model.addAttribute("editar", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "ctacte";
	}	
	/**
	 * Llamado por el submit del formulario(POST) guarda la ctacte en la Base de datos.
	 * Tambien valida la entrada el cliente.
	 */
	@RequestMapping(value = {"/nuevoctacte"}, method = RequestMethod.POST)
	public String guardarCtaCte(@Valid CtaCte ctacte, ModelMap model) {

		ctacteServicio.guardarCtaCte(ctacte);

		model.addAttribute("exito", "CtaCte " + ctacte.getNombre() + " " + " registro exitoso");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registracionexitosa";
	}
	
	/*Lista las ctacte existentes en la BD*/
	@RequestMapping(value={"/listactacte"}, method = RequestMethod.GET)
	public String listactacte(ModelMap model){
		List<CtaCte> ctacte = ctacteServicio.listarCtaCte();
		model.addAttribute("ctacte", ctacte);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listactacte";
	}
	
	/*Edita la ctacte seleccionada en la lista*/
	@RequestMapping(value = { "/editar-ctacte-{id}" }, method = RequestMethod.GET)
	public String editarCtaCte(@PathVariable String id, ModelMap model) {
		CtaCte ctacte = ctacteServicio.buscarXId(Integer.parseInt(id));
		List<Localidad> localidades = localidadServicio.listarLocalidad(ctacte.getProvincia());
		model.addAttribute("ctacte", ctacte);
		model.addAttribute("editar", true);
		model.addAttribute("localidades",localidades);
		model.addAttribute("loggedinuser", getPrincipal());
		return "ctacte";
	}
	
	/**
	 * Llamado por el submit del formulario(Post), actualiza la ctacte en la Base de datos.
	 */
	@RequestMapping(value = { "/editar-ctacte-{id}" }, method = RequestMethod.POST)
	public String actualizarCtaCte(@Valid CtaCte ctacte, BindingResult result,
			ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return "ctacte";
		}

		ctacteServicio.actualizarCtaCte(ctacte);;

		model.addAttribute("exito", "CtaCte " + ctacte.getNombre() + " "+ ctacte.getApellido() + " actualizacion exitosa");
		model.addAttribute("loggedinuser", getPrincipal());
		return "listactacte";
	}
	
	/**
	 * Este metodo borrara un Cliente por su valor Id
	 */
	@RequestMapping(value = { "/borrar-ctacte-{id}" }, method = RequestMethod.GET)
	public String borrarCtaCte(@PathVariable String id) {
		ctacteServicio.borrarCtaCteXid(Integer.parseInt(id));;
		return "redirect:/listactacte";
	}
}
//----------------------------Ingreso Habitacion--------------------------------------------------------------	

