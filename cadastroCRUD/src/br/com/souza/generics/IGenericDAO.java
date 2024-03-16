package br.com.souza.generics;

import br.com.souza.domain.Persistente;

import java.util.Collection;

public interface IGenericDAO<T extends Persistente>{

    public Boolean cadastrar(T entity );
    public void excluir(Long value);
    public void alterar(T entity);
    public T consultar(Long value);
    public Collection<T> buscarTodos();
}
