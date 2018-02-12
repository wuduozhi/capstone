package com.app;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
    public Application() {
        packages(true, "com.controllers");

        //注册数据转换器
        register(JacksonJsonProvider.class);

        //依赖注入
        register(new ApplicationBinder());

        // Logging.
        register(LoggingFilter.class);
    }
}
