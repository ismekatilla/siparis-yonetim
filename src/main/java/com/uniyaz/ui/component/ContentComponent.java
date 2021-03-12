package com.uniyaz.ui.component;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class ContentComponent extends VerticalLayout {

    public ContentComponent() {
        setSizeFull();
        buildLayout();
    }

    private void buildLayout() {

    }

    @Override
    public void addComponent(Component c) {
        removeAllComponents();
        super.addComponent(c);
    }
}
