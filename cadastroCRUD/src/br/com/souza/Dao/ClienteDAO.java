package br.com.souza.Dao;
import br.com.souza.generics.GenericDAO;
import br.com.souza.domain.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    public ClienteDAO(){
        super();
        Map<Long, Cliente>  interno = this.map.get(tipo());
        if(interno == null){
            interno = new HashMap<>();
            this.map.put(tipo() ,interno);
        }

    }

    @Override
    public Class<Cliente> tipo() {
        return Cliente.class;
    }

    @Override
    public void alterarDados(Cliente entity, Cliente e) {
        e.setNome(entity.getNome());
        e.setCpf(entity.getCpf());
        e.setTel(entity.getTel());
        e.setEndereco(entity.getEndereco());
        e.setNumero(entity.getNumero());
        e.setCidade(entity.getCidade());
        e.setEstado(entity.getEstado());
    }


}
