package pe.somosoh.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.somosoh.clientes.dto.Primos;
import pe.somosoh.clientes.model.Cliente;
import pe.somosoh.clientes.service.IClienteService;
import pe.somosoh.clientes.util.Util;

@RestController
public class ClientesController {
	
	@Autowired
    private IClienteService clienteService;
	
	public ClientesController() {
	}

	@GetMapping(value = "clientes")
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> clientes = clienteService.findAll();
		
		return ResponseEntity.ok(clientes); 
	}
	
	@GetMapping(value = "clientes/{clienteId}")
	public ResponseEntity<Cliente> detail(@PathVariable("clienteId") Long clienteId){
		
		Cliente cliente = clienteService.findById(clienteId);
		
		return ResponseEntity.ok(cliente); 
	}

	@PostMapping(value = "clientes")
	public ResponseEntity<Cliente> create(Cliente request){
		
		Cliente nuevo = new Cliente();
		nuevo.setNombres(request.getNombres());
		nuevo.setApellidos(request.getApellidos());
		nuevo.setDireccion(request.getDireccion());
		nuevo.setEmail(request.getEmail());
		nuevo.setCelular(request.getCelular());
	
		Cliente saved = clienteService.save(nuevo);
		
		return ResponseEntity.ok(saved);
	}
	
	@PutMapping(value = "clientes")
	public ResponseEntity<Cliente> update(Cliente request){
		List<Cliente> clientes = clienteService.findAll();
		
		Cliente cliente = clientes.stream()
				.filter(currentUser -> currentUser.getId() == request.getId())
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No existe el cliente"));
		
		cliente.setNombres(request.getNombres());
		cliente.setApellidos(request.getApellidos());
		cliente.setDireccion(request.getDireccion());
		cliente.setEmail(request.getEmail());
		cliente.setCelular(request.getCelular());
		Cliente updated = clienteService.save(cliente);
		
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping(value = "clientes/{clienteId}")
	public ResponseEntity<?> delete( @PathVariable("clienteId") Long clienteId ) {
		List<Cliente> clientes = clienteService.findAll();
		
		Cliente cliente = clientes.stream()
				.filter(currentUser -> currentUser.getId() == clienteId)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No existe el cliente"));
		
		clienteService.delete(cliente);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping(value = "primos")
	public ResponseEntity<Integer> total(Primos primos){		
		Integer total = 0;
		Integer numCarateres = 0;
		
		for(String nombre:primos.getNombres()){
			if(nombre!=null && !nombre.equals("") && nombre.length()>0){
				numCarateres = nombre.length();
				if(Util.esPrimo(numCarateres)){
					total++;
				}
			}			
		}		
		
		return ResponseEntity.ok(total);
	}
	
	
	
}
