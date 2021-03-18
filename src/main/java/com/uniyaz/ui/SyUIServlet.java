package com.uniyaz.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@WebServlet(urlPatterns = "/*", name = "SyUIServlet", asyncSupported = true, loadOnStartup = 1)
@VaadinServletConfiguration(ui = SyUI.class, productionMode = false)
public class SyUIServlet extends VaadinServlet {
}