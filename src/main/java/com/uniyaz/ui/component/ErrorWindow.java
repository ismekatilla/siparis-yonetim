package com.uniyaz.ui.component;

import com.uniyaz.common.exceptions.SyException;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Created by AKARTAL on 16.3.2021.
 */
public class ErrorWindow extends Window {

    private VerticalLayout mainLayout;
    private Label message;

    public ErrorWindow() {
        setWidth(45, Unit.PERCENTAGE);
        setHeight(150, Unit.PIXELS);
        center();
    }

    public ErrorWindow(Throwable throwable) {

        this();
        buildMainLayout();
        setContent(mainLayout);

        fillByThrowable(throwable);
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setMargin(true);

        message = new Label();
        message.setSizeUndefined();
        mainLayout.addComponent(message);

        mainLayout.setComponentAlignment(message, Alignment.MIDDLE_CENTER);
    }

    private void fillByThrowable(Throwable throwable) {
        setCaption("UYARI");
        setIcon(FontAwesome.WARNING);
        addStyleName("sywarning");

        for (Throwable t = throwable; t != null; t = t.getCause()) {
            if (t instanceof SyException) {
                fillBySyException((SyException) t);
                break;
            }

            if (t.getCause() != null) {
                message.setValue("Beklenmeyen bir hata oluştu. " + t.getCause().toString());
            }
        }
        if ("".equals(message.getValue())) message.setValue(throwable.toString());
    }

    private void fillBySyException(SyException syException) {
        message.setValue(syException.getMessage());

        SyException.EnumExceptionType exceptionType = syException.getExceptionType();
        if (SyException.EnumExceptionType.ERROR.equals(exceptionType)) {
            setCaption("HATA");
            setIcon(FontAwesome.WARNING);
            addStyleName("sywarning");
        } else {
            setCaption("UYARI");
            setIcon(FontAwesome.INFO);
            addStyleName("syinfo");
        }
        return;
    }
}
