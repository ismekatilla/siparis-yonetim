package com.uniyaz.ui.page;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class UrunPage extends VerticalLayout {

    public UrunPage() {

        buildLayout();
    }

    private void buildLayout() {
        Label label = new Label();
        label.setCaption("TEST");
        addComponent(label);
    }
}
