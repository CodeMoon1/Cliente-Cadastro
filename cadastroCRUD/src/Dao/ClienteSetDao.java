package Dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import Dao.domain.Cliente;

public class ClienteSetDao implements IClienteDao {
    private Set<Cliente> set;

    public ClienteSetDao() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            return false;
        }
        this.set.add(cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        for (Cliente key : this.set) {
            if (key.getCpf().equals(cpf)) {
                this.set.remove(key);
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        for (Cliente key : set) {
            if (key.equals(cliente)) {
                key.setNome(cliente.getNome());
                key.setCpf(cliente.getCpf());
                key.setTel(cliente.getTel());
                key.setEndereco(cliente.getEndereco());
                key.setNumero(cliente.getNumero());
                key.setCidade(cliente.getCidade());
                key.setEstado(cliente.getEstado());
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente key : set) {
            if (key.getCpf().equals(cpf)) {
                return key;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarClientes() {
        return null;
    }

}
