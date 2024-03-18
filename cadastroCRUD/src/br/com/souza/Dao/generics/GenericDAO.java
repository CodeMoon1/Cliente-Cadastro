package br.com.souza.Dao.generics;
import br.com.souza.anotation.TipoChave;
import br.com.souza.domain.Persistente;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    public abstract Class<T> tipo();

    public abstract void alterarDados(T entity, T e);
    protected Map <Class, Map<Long , T>> map;

    public Long getChave(T entity){
        Field[] filds = entity.getClass().getDeclaredFields();
        for(Field f : filds){
            if(f.isAnnotationPresent(TipoChave.class)){
                TipoChave chave = f.getAnnotation(TipoChave.class);
                String nomeMetodo = chave.value();
                try {
                    Method metodo =  entity.getClass().getMethod(nomeMetodo);
                    Long value = (Long) metodo.invoke(entity);
                    return value;
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e1) {
                    throw new RuntimeException(e1);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return null;
    }

    public GenericDAO(){
        if(this.map == null){
            this.map = new HashMap<>();
        }
    }

    @Override
    public Boolean cadastrar(T entity) {

        Map<Long, T> interno = this.map.get(tipo());
        Long key = getChave(entity);
        if(interno.containsKey(key))
            return false;
        else
            interno.put(key, entity);
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
        Long key = getChave(entity);
        Map<Long, T> interno = this.map.get(tipo());
        T e = interno.get(key);
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
