package com.uniyaz.ui.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class SyDeleteButton extends Button {

    public SyDeleteButton() {
        setIcon(FontAwesome.TRASH);
        addStyleName(ValoTheme.BUTTON_DANGER);
    }
}