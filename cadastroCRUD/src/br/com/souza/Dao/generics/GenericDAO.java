package br.com.souza.Dao.generics;
import br.com.souza.domain.Persistente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    public abstract Class<T> tipo();

    public abstract void alterarDados(T entity, T e);
    protected Map <Class, Map<Long , T>> map;

    public GenericDAO(){
        if(this.map == null){
            this.map = new HashMap<>();
        }
    }

    @Override
    public Boolean cadastrar(T entity) {
        Map<Long, T> interno = this.map.get(tipo());

        if(interno.containsKey(entity.getCodigo()))
            return false;
        else
            interno.put(entity.getCodigo(), entity);
        return true;
    }

    @Override
    public void excluir(Long value) {
        Map<Long, T> interno = this.map.get(tipo());
        T entity = interno.get(value);
        if (entity != null) {
            interno.remove(value);
        }
    }

    @Override
    public void alterar(T entity) {
        Map<Long, T> interno = this.map.get(tipo());
        T e = interno.get(entity.getCodigo());
        if(e != null){
            alterarDados(entity, e);
        }
    }

    @Override
    public T consultar(Long value) {
        Map<Long, T>  interno = this.map.get(tipo());
        return interno.get(value);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T>  interno = this.map.get(tipo());
        return interno.values();
    }
}
