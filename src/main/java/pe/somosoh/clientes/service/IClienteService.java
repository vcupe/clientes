package pe.somosoh.clientes.service;


import java.util.List;
import pe.somosoh.clientes.model.Cliente;

public interface IClienteService {

    List<Cliente> findAll();
    Cliente findById(Long clienteId);
    Cliente save(Cliente request);
    void delete(Cliente request);
}