package com.uniyaz.rest;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = {"/api/*" }, asyncSupported = true, loadOnStartup = 0, initParams = {
        @WebInitParam(name = "com.sun.jersey.config.property.packages", value = "com.uniyaz.rest"),
        @WebInitParam(name = "com.sun.jersey.api.json.POJOMappingFeature", value = "true")
})
public class RestServlet extends ServletContainer {
}