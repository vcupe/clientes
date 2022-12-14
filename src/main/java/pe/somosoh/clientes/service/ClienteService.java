package pe.somosoh.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.somosoh.clientes.model.Cliente;
import pe.somosoh.clientes.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
    	List<Cliente> clientes = (List<Cliente>) repository.findAll();
        return clientes;
    }
    
    @Override
    public Cliente findById(Long clienteId){
    	return repository.findById(clienteId).get();
    }
    
    @Override
    public Cliente save(Cliente request) {
    	Cliente saved = repository.save(request);
        return saved;
    }
    
    @Override
    public void delete(Cliente request) {
    	repository.delete(request);
    }
    
    
}