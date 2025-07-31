package problems.carrentalsystem.models;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    private static volatile Cache cacheInstance;
    private ConcurrentHashMap<String, String> map;

    private Cache() {
        this.map = new ConcurrentHashMap<>();
    }

    public static Cache getInstance() {
        if(cacheInstance == null) {
            synchronized (Cache.class) {
                if(cacheInstance == null) {
                    cacheInstance = new Cache();
                }
            }
        }
        return cacheInstance;
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.getOrDefault(key, null);
    }

}
