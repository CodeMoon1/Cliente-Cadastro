package br.com.souza.factory;

import java.util.HashMap;
import java.util.Map;

public class SingletonMap {
    private static SingletonMap singletonMap;

    protected Map<Class, Map<Long, ?>> map;

    private SingletonMap(){
       map = new HashMap<>();
    }

    public static SingletonMap getInstance() {
        if(singletonMap == null){
            return singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    public Map<Class, Map<Long, ?>> getMap() {
        return this.map;
    }
}