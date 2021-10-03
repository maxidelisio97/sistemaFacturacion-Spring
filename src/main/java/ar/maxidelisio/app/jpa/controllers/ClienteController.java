package ar.maxidelisio.app.jpa.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.maxidelisio.app.jpa.models.domain.Cliente;
import ar.maxidelisio.app.jpa.paginator.PageRender;
import ar.maxidelisio.app.jpa.service.IClienteService;

@Controller
@SessionAttributes(value = "cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	//Metodo para obtener el detalle cliente con foto
	@GetMapping("/ver/{id}")
	public String ver (@PathVariable(value = "id") Long id,Map<String,Object> model, RedirectAttributes flash) {
		
		Cliente cliente = clienteService.findOne(id);
		
		if(cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "Detalle cliente : " + cliente.getNombre());
		
		return "ver";
	}
	
		
	

	// METODO PARA OBTENER TODOS LOS REGISTROS
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page,Model model) {

		Pageable pageRequest = PageRequest.of(page, 10);
		
		Page<Cliente> listaPaginadaClientes = clienteService.findAll(pageRequest);
		PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", listaPaginadaClientes);
		
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", listaPaginadaClientes);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	// METODO PARA CARGAR EL FORMULARIO
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("titulo", "Formulario de cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}

	// METODO PARA ACTUALIZAR UN REGISTRO
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El cliente no existe en la base de datos!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}

		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar cliente");
		return "form";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado exitosamente!");
		}

		return "redirect:/listar";
	}

	// METODO PARA GUARDAR UN REGISTRO
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status,@RequestParam(name="file") MultipartFile foto, RedirectAttributes flash) {

		//va a entrar al if si en el objeto result de tipo BindingResult viene algun error 
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente");
			return "form";
		}
		
		//Si la foto no es nula, sube la foto a la carpeta upload.
		if(foto != null) {
			
			String rootPath = "C://Temp//uploads";
			
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "La foto '" + foto.getOriginalFilename() + "' se ha subido correctamente");
				
				cliente.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String mensajeInformativo = (cliente.getId() != null) ? "Cliente editado exitosamente" : "Cliente creado exitosamente";

		clienteService.save(cliente);
		flash.addFlashAttribute("success", mensajeInformativo);
		status.setComplete();
		return "redirect:/listar";
	}

}
