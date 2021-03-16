package com.uniyaz.ui;

import com.uniyaz.common.exceptions.SyException;
import com.uniyaz.core.domain.Musteri;
import com.uniyaz.ui.component.ContentComponent;
import com.uniyaz.ui.component.ErrorWindow;
import com.uniyaz.ui.component.SyMenuBar;
import com.uniyaz.ui.component.SearchComponent;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.*;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class SyUI extends UI {

    private VerticalLayout mainLayout;
    private ContentComponent contentComponent;
    private Musteri musteri;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildMainLayout();
        setContent(mainLayout);

        setErrorHandler(new ErrorHandler() {
            @Override
            public void error(com.vaadin.server.ErrorEvent errorEvent) {
                ErrorWindow errorWindow = new ErrorWindow(errorEvent.getThrowable());
                getCurrent().addWindow(errorWindow);
            }
        });
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        contentComponent = new ContentComponent();

        SearchComponent searchComponent = new SearchComponent();
        mainLayout.addComponent(searchComponent);

        SyMenuBar syMenuBar = new SyMenuBar();

        mainLayout.addComponent(syMenuBar);
        mainLayout.addComponent(contentComponent);

        mainLayout.setExpandRatio(searchComponent, 1f);
        mainLayout.setExpandRatio(syMenuBar, 0.4f);
        mainLayout.setExpandRatio(contentComponent, 8.6f);
    }

    public ContentComponent getContentComponent() {
        return contentComponent;
    }

    public void setContentComponent(ContentComponent contentComponent) {
        this.contentComponent = contentComponent;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
}