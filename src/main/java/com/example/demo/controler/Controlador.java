package com.example.demo.controler;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IcomprasService;
import com.example.demo.interfaceService.IinventarioService;
import com.example.demo.interfaceService.IloginService;
import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Login;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.compras;
import com.example.demo.service.api.PersonaServiceAPI;
import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;




@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IpersonaService servicePersona;
	private final IinventarioService serviceInventario;

	@Autowired
	private IloginService servicelogin;

	@Autowired
	private IcomprasService serviceCompras;
	
	@Autowired
	private PersonaServiceAPI personaServiceAPI;
	


	
	Controlador(IinventarioService serviceInventario) {
		this.serviceInventario = serviceInventario;
	}
	
	
	
	
    @GetMapping("/chart")


    private Map<String, Integer> obtenerDatosEstadisticos() {
        // Lógica para obtener datos (puedes reemplazar esto con tus propios datos)
        Map<String, Integer> datos = new HashMap<>();
        datos.put("Categoria 1", 30);
        datos.put("Categoria 2", 45);
        datos.put("Categoria 3", 25);
        return datos;
    }
	

	@GetMapping("/export/all")
	public ResponseEntity<InputStreamResource> exportAllData() throws Exception {
		ByteArrayInputStream stream = personaServiceAPI.exportAllData();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=personas.xls");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	

	@GetMapping("/invee")
	public String invee(Model model) {
		List<Inventario> inventario = serviceInventario.listarr();
		model.addAttribute("inventario", inventario);
		return "inventario";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona> personas = servicePersona.listar();
		model.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/registrar")
	public String registrar(Model model) {
		List<Persona> personas = servicePersona.listar();
		model.addAttribute("personas", personas);
		return "registrarUsuario";
	}

	@GetMapping("/com")
	public String listarCompra(Model model) {
		List<compras> compras = serviceCompras.listarr();
		model.addAttribute("compras", compras);
		return "compras";
	}
	
	@GetMapping("/commpras")
	public String listarCompras(Model model) {
		List<compras> compras = serviceCompras.listarr();
		model.addAttribute("compras", compras);
		return "registrar3";
	}
	@GetMapping("/grafica")
	public String graficos(Model model) {
		return "chart";
	}
	@GetMapping("/listarr")
	public String listarUsuarios(Model model) {
		List<Login> usuarios = servicelogin.listarr();
		model.addAttribute("usuarios", usuarios);
		return "index2";
	}

	@GetMapping("/paggin")
	public String agregarpa(Model model) {
		List<Login> usuarios = servicelogin.listarr();
		model.addAttribute("usuarios", usuarios);
		return "pagina";
	}

	@GetMapping("/caata")
	public String cataa(Model model) {

		return "catalogo";
	}
	@GetMapping("/regist")
	public String regist(Model model) {

		return "registro";
	}


	@GetMapping("/carito")
	public String carito(Model model) {
	
		return "compra";
	}

   
	@GetMapping("/contac")
	public String contac(Model model) {
	
		return "contacto";
	}

	@GetMapping("/exee")
	public String exee(Model model) {
	
		return "exel";
	}

	@GetMapping("/caritos")
	public String caritos(Model model) {
	
		return "carrito";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	@GetMapping("/loginn")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {

		return "index";
	}



	@GetMapping("/pagin")
	public String agregarpag(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@GetMapping("/newLogin")
	public String agregarLogin(Model model) {
		model.addAttribute("login", new Login());
		return "registrar";
	}
	@GetMapping("/agregacom")
	public String agregacom(Model model) {
		model.addAttribute("compras", new compras());
		return "registrar3";
	}


	@GetMapping("/newCompra")
	public String agregarCompra(Model model) {
		model.addAttribute("compras", new compras());
		return "registrar2";
	}
	


	@GetMapping("/newCompras")
	public String agregarCompras(Model model) {
		model.addAttribute("inventario", new Inventario());
		return "inventar";
	}
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model) {
		model.addAttribute("personas", new Persona());
		servicePersona.save(p);
		return "redirect:/listar";
	}

	@PostMapping("/saveregis")
	public String saveRegis(@Validated Login r, Model model) {
		model.addAttribute("login", new Login());
		servicelogin.save(r);
		return "redirect:/registrar";
	}

	@PostMapping("/saveregiss")
	public String saveRegiss(@Validated Login r, Model model) {
		model.addAttribute("login", new Login());
		servicelogin.save(r);
		return "redirect:/paggin";
	}

	@PostMapping("/savelogin")
	public String saveLogin(@Validated Login r, Model model) {
		model.addAttribute("login", new Login());
		servicelogin.save(r);
		return "redirect:/listarr";
	}
	@PostMapping("/savecompra")
	public String savecompra(@Validated compras r, Model model) {
		model.addAttribute("compras", new compras(0, null, null, null));
		serviceCompras.save(r);
		return "redirect:/caritos";
	}
	@PostMapping("/savecompras")
	public String savecompras(@Validated compras r, Model model) {
		model.addAttribute("compras", new compras(0, null, null, null));
		serviceCompras.save(r);
		return "redirect:/com";
	}
	@PostMapping("/saveinven")
	public String saveinven(@Validated Inventario r, Model model) {
		model.addAttribute("inventario", new Inventario());
		serviceInventario.save(r);
		return "redirect:/invee";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Persona>persona=servicePersona.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	@GetMapping("/editarr/{id}")
	public String editarr(@PathVariable int id, Model model){
		Optional<compras>compras=serviceCompras.listarId(id);
		model.addAttribute("compras", compras);
		return "formu";
	}

	@GetMapping("/registrarse")
	public String registrarse (Model model) {
		model.addAttribute("registrarse", new Login());
		return "registrarUsuario";
	}

	@GetMapping("/iniciar")
	public String agregarp(Model model) {
		List<Login>usuarios=servicelogin.listarr();
		model.addAttribute("usuarios", usuarios);
		return "catalogo";
	}

	@GetMapping("/editarLogin/{id}")
	public String editarLogin(@PathVariable int id, Model model){
		Optional<Login>empleado=servicelogin.listarId(id);
		model.addAttribute("login", empleado);
		return "registrar";
	}
	@GetMapping("/editarcompra/{id}")
	public String editarcompra(@PathVariable int id, Model model){
		Optional<compras>producto=serviceCompras.listarId(id);
		model.addAttribute("compras", producto);
		return "registrar2";
	}
	@GetMapping("/eliminarr/{id}")
	public String deletee(Model model, @PathVariable int id){
		serviceCompras.delete(id);
		return "redirect:/com";
	}
	@GetMapping("/eliminaar/{id}")
	public String deleteer(Model model, @PathVariable int id){
		serviceInventario.delete(id);
		return "redirect:/invee";
	}
	
	@GetMapping("/editarinve/{id}")
	public String editarinve(@PathVariable int id, Model model){
		Optional<Inventario>inventario=serviceInventario.listarId(id);
		model.addAttribute("inventario", inventario);
		return "inventar";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id){
		servicePersona.delete(id);
		return "redirect:/listar";
	}
	@GetMapping("/buscar/{id}")
	public String search(Model model, @PathVariable int id){
		serviceCompras.search(id);
		return "redirect:/com";
	}

	public IinventarioService getServiceinventario() {
		return serviceInventario;
	}

}


