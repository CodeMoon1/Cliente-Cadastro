package br.com.souza.Dao;

import br.com.souza.Dao.generics.GenericDAO;
import br.com.souza.domain.Produto;

import java.util.HashMap;
import java.util.Map;


public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {
    public ProdutoDAO(){
        super();

        Map<Long, Produto>  interno = this.map.get(tipo());
        if(interno == null){
            interno = new HashMap<>();
            this.map.put(tipo() ,interno);
        }

    }

    @Override
    public Class<Produto> tipo() {
        return Produto.class;
    }

    @Override
    public void alterarDados(Produto entity, Produto e) {
        e.setNome(entity.getNome());
        e.setCod(entity.getCod());
    }

}
