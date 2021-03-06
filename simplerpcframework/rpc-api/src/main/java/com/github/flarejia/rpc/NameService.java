package com.github.flarejia.rpc;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;

/**
 * 注册中心
 */
public interface NameService {
    /**
     * 所有支持的协议
     * @return
     */
    Collection<String> supportedSchemes();

    /**
     * 连接注册中心
     * @param nameServiceUri 注册中心地址
     */
    void connect(URI nameServiceUri);

    /**
     * 注册服务
     * @param serviceName 服务名称
     * @param uri 服务地址
     * @throws IOException
     */
    void registerService(String serviceName, URI uri) throws IOException;


    /**
     * 查询服务额地址
     * @param serviceName 服务名称
     * @return
     * @throws IOException
     */
    URI lookupService(String serviceName) throws IOException;
}
