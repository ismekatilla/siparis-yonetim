package com.uniyaz.ui.page;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 15.3.2021.
 */
public abstract class BasePage extends VerticalLayout {

    public BasePage() {
        setSizeFull();
        buildMainLayout();
    }

    public abstract void buildMainLayout();
}