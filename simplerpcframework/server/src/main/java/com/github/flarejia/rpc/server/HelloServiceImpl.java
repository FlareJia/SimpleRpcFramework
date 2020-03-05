package com.github.flarejia.rpc.server;

import com.github.flarejia.rpc.helloapi.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(String name) {
         logger.info("HelloServiceImpl get {}", name);
         String re = "Hello " + name;
         logger.info("HelloServiceImpl response {}", re);
         return re;
    }
}