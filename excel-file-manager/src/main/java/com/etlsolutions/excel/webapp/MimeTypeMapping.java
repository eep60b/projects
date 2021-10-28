package com.etlsolutions.excel.webapp;

import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MimeTypeMapping implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("eot#iefix", "application/vnd.ms-fontobject");
        mappings.add("svg#JLREmericWeb-ExtraLight", "image/svg+xml");        
        mappings.add("svg#JLREmericWeb-Regular", "image/svg+xml");        
        mappings.add("svg#JLREmericWeb-SemiBold", "image/svg+xml");    
        factory.setMimeMappings(mappings);
    }
}