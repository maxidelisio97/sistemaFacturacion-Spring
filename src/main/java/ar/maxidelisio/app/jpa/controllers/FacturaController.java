package ar.maxidelisio.app.jpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.maxidelisio.app.jpa.models.domain.Cliente;
import ar.maxidelisio.app.jpa.models.domain.Factura;
import ar.maxidelisio.app.jpa.models.domain.ItemFactura;
import ar.maxidelisio.app.jpa.models.domain.Producto;
import ar.maxidelisio.app.jpa.service.IClienteService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Long id,Model model,RedirectAttributes flash) {
		
		Factura factura = clienteService.findFacturaById(id);
		
		if(factura == null) {
			flash.addFlashAttribute("error", "No existe la factura en la base de datos");
			return "redirect:/listar";
		}
		
		model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));
		model.addAttribute("factura", factura);
		
		return "factura/ver";
	}
	
	@GetMapping("/form/{clienteId}")	
	public String crear(@PathVariable("clienteId") Long idCliente,Model model,RedirectAttributes flash) {
		
		Cliente cliente = clienteService.findOne(idCliente);
		
		if(cliente == null) {
			flash.addFlashAttribute("error","No existe el cliente en la base de datos");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Crear factura");
		
		return "factura/form";
		
	}
	
	@GetMapping(value = "/buscar-producto/{term}", produces = {"application/json"})
	 public @ResponseBody List<Producto> buscarProductoPorNombre(@PathVariable String term){		
		return clienteService.findByName(term);
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarFactura(@PathVariable Long id,RedirectAttributes flash) {
		
		Factura factura = clienteService.findFacturaById(id);
		
		if(factura == null) {
			
			flash.addFlashAttribute("error", "No existe la factura en la base de datos");
			return "redirect:/listar";
			
		}else {
		
		clienteService.deleteFacturaById(factura.getId());
		flash.addFlashAttribute("success", "Factura eliminada con exito!");		
		return "redirect:/ver/" + factura.getCliente().getId();
		}
	}
	
	@PostMapping("/form")
	public String guardarFactura(@Valid Factura factura,BindingResult result ,Model model,@RequestParam(name ="item_id[]" ,required = false) Long[] itemId,
			@RequestParam(name="cantidad[]", required = false) Integer[] cantidad,RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear factura: ");
			return "factura/form";
		}
		
		if(itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear factura: ");
			model.addAttribute("error", "Error: la factura debe contener productos");			
			return "factura/form";
		}
		
		
		for(int i=0;i<itemId.length;i++) {
			
			Producto producto = clienteService.findProductoById(itemId[i]);
			
			ItemFactura itemFactura = new ItemFactura();
			itemFactura.setProducto(producto);
			itemFactura.setCantidad(cantidad[i]);
			factura.addItemFactura(itemFactura);
		}
		
		clienteService.saveFactura(factura);		
		status.setComplete();
		flash.addFlashAttribute("success", "Factura almacenada con exito!");
		return "redirect:/ver/" + factura.getCliente().getId();
		
	}
}
