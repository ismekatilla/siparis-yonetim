package com.uniyaz.ui.component;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class SearchComponent extends HorizontalLayout {

    private HorizontalLayout mainLayout;
    private TextField searchField;
    private Button searchButton;

    public SearchComponent() {
        setSizeFull();

        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildMainLayout() {

        mainLayout = new HorizontalLayout();

        searchField = new TextField();
        searchField.setInputPrompt("Ürün Adı ve Kodunu giriniz");
        mainLayout.addComponent(searchField);

        searchButton = new Button();
        searchButton.setIcon(FontAwesome.SEARCH);
        mainLayout.addComponent(searchButton);
    }
}