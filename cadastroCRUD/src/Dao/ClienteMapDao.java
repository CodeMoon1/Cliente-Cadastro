package Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Dao.domain.Cliente;

public class ClienteMapDao implements IClienteDao {
    private Map<Long, Cliente> map;

    public ClienteMapDao() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente ClienteCadastrado = this.map.get(cpf);
        if (ClienteCadastrado != null) {
            this.map.remove(ClienteCadastrado.getCpf());
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente alterar = this.map.get(cliente.getCpf());
        if (alterar != null) {
            alterar.setNome(cliente.getNome());
            alterar.setCpf(cliente.getCpf());
            alterar.setTel(cliente.getTel());
            alterar.setEndereco(cliente.getEndereco());
            alterar.setNumero(cliente.getNumero());
            alterar.setCidade(cliente.getCidade());
            alterar.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarClientes() {
        return this.map.values();
    }

}
