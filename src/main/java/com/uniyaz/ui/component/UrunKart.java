package com.uniyaz.ui.component;

import com.uniyaz.core.domain.Urun;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by AKARTAL on 15.3.2021.
 */
public class UrunKart extends Panel {

    private VerticalLayout mainLayout;
    private Image urunResmi;
    private Label fiyat;
    private CheckBox secim;
    private Urun urun;

    public UrunKart(Urun urun) {
        this.urun = urun;
        buildMainLayout();
        addStyleName("urunKart");
        setContent(mainLayout);

        setCaption(urun.getAdi());
        setWidth(100, Unit.PERCENTAGE);
        setHeight(null);

        fillByUrun(urun);
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();

        urunResmi = new Image();
        mainLayout.addComponent(urunResmi);

        fiyat = new Label();
        fiyat.setSizeUndefined();
        mainLayout.addComponent(fiyat);

        secim = new CheckBox();
        mainLayout.addComponent(secim);
    }

    private void fillByUrun(Urun urun) {
        urunResmi.setSource(new ExternalResource("https://www.eticaret.com/wp-content/uploads/2013/04/Satılacak-doğru-ürünü-nasıl-seçebilirsiniz.jpg"));
        fiyat.setValue(urun.getFiyat().toString());
    }

    public Boolean getSecimValue() {
        return secim.getValue();
    }

    public Urun getUrun() {
        return urun;
    }
}