package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.domain.MusteriUrun;
import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.MusteriUrunService;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.component.SySaveButton;
import com.uniyaz.ui.component.UrunKart;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 15.3.2021.
 */
public class SiparisPage extends VerticalLayout {

    private SySaveButton saveButton;
    private VerticalLayout mainLayout;
    private List<UrunKart> urunKartList;

    public SiparisPage() {

        buildMainLayout();
        addComponent(mainLayout);
        setMargin(true);
        setSpacing(true);

        fillPage();

        buildSaveButton();
        addComponent(saveButton);
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setSpacing(true);
    }

    private void fillPage() {
        UrunService urunService = new UrunService();
        List<Urun> urunList = urunService.findAllHql();
        urunKartList = new ArrayList<>();
        int i = 0;
        HorizontalLayout horizontalLayout = null;
        for (Urun urun : urunList) {
            if (i % 3 == 0) {
                horizontalLayout = new HorizontalLayout();
                horizontalLayout.setSizeFull();
                horizontalLayout.setSpacing(true);
                mainLayout.addComponent(horizontalLayout);
            }
            UrunKart urunKart = new UrunKart(urun);
            horizontalLayout.addComponent(urunKart);
            urunKartList.add(urunKart);
            i++;
        }
    }

    private void buildSaveButton() {

        saveButton = new SySaveButton();
        saveButton.setWidth(100, Unit.PERCENTAGE);
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SyUI syUI = (SyUI) SyUI.getCurrent();
                Musteri musteri = syUI.getMusteri();
                if (musteri == null) {
                    Notification.show("Müşteri Seçmelisiniz", Notification.Type.ERROR_MESSAGE);
                    return;
                }

                List<MusteriUrun> musteriUrunList = new ArrayList<>();
                for (UrunKart urunKart : urunKartList) {
                    Boolean secimValue = urunKart.getSecimValue();
                    if (Boolean.TRUE.equals(secimValue)) {
                        Urun urun = urunKart.getUrun();

                        MusteriUrun musteriUrun = new MusteriUrun();
                        musteriUrun.setUrun(urun);
                        musteriUrun.setMusteri(musteri);
                        musteriUrunList.add(musteriUrun);
                    }
                }

                MusteriUrunService musteriUrunService = new MusteriUrunService();
                musteriUrunService.saveMusteriUrun(musteriUrunList);
            }
        });
    }
}