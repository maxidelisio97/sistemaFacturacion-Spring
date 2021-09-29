package ar.maxidelisio.app.jpa.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ar.maxidelisio.app.jpa.models.domain.Cliente;
import ar.maxidelisio.app.jpa.service.IClienteService;

@Controller
@SessionAttributes(value = "cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;

	//METODO PARA OBTENER TODOS LOS REGISTROS
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.getClientes());
		return "listar";
	}
	
	
	//METODO PARA CARGAR EL FORMULARIO 
	@RequestMapping(value = "/form" , method = RequestMethod.GET)
	public String form(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("titulo","Formulario de cliente");
		model.addAttribute("cliente",cliente);
		return "form";
	}
	
	//METODO PARA ACTUALIZAR UN REGISTRO
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value ="id") Long id,Model model) {
		
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findOne(id);
			
		}else {
			return "redirect:listar";
		}
		
		model.addAttribute("cliente",cliente);
		model.addAttribute("titulo", "Editar cliente");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			clienteService.delete(id);
		}
		
		return "redirect:/listar";
	}
	
	//METODO PARA GUARDAR UN REGISTRO
	@RequestMapping(value = "/form" , method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result,Model model,SessionStatus status ) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de cliente");
			return "form";
		}
		
		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listar";
	}
	
}
