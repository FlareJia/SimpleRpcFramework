package com.github.flarejia.rpc.spi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * classloader helper.
 */
public class ServiceSupport {
    private final static Map<String, Object> singletonService = new HashMap<>();
    public synchronized static <S> S load(Class<S> service){
        return StreamSupport.stream(ServiceLoader.load(service).spliterator(), false)
                .map(ServiceSupport::singletonFilter)
                .findFirst().orElseThrow(ServiceLoadException::new);
    }

    public synchronized static <S> Collection<S> loadAll(Class<S> service){
        return StreamSupport.
                stream(ServiceLoader.load(service).spliterator(), false)
                .map(ServiceSupport::singletonFilter)
                .collect(Collectors.toList());
    }

    private static <S> S singletonFilter(S service){
        if (service.getClass().isAnnotationPresent(Singleton.class)){
            String className = service.getClass().getCanonicalName();
            Object singletonInstance = singletonService.putIfAbsent(className, service);
            return singletonInstance == null ? service : (S) singletonInstance;
        }else {
            return service;
        }
    }
}
