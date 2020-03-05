package com.github.flarejia.rpc;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;

/**
 * rpc框架对外提供服务的接口
 */
public interface RpcAccessPoint extends Closeable {

    /**
     * 客户端获取远程服务的引用
     * @param uri 远程服务地址
     * @param serviceClass 服务的接口类的Class
     * @param <T> 服务接口的类型
     * @return
     */
    <T> T getRemoteService(URI uri, Class<T> serviceClass);


    /**
     * 服务端注册服务的实现实例
     * @param service 实现实例
     * @param serviceClass 服务的接口类的Class
     * @param <T> 服务接口的类型
     * @return
     */
    <T> URI addServiceProvider(T service, Class<T> serviceClass);


    /**
     * 服务端启动rpc框架，监听接口，开始提供远程服务
     * @return
     * @throws Exception
     */
    Closeable startService() throws Exception;

    default NameService getNameService(URI nameServiceUri){
        Collection<NameService> nameServices;
        return null;
    }
}
