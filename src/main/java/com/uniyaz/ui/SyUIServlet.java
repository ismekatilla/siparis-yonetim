package com.uniyaz.ui;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@WebServlet(urlPatterns = "/*", name = "SyUIServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = SyUI.class, productionMode = false)
public class SyUIServlet extends VaadinServlet {
}