package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class UrunPage extends VerticalLayout {

    @PropertyId("id")
    private TextField id;

    @PropertyId("adi")
    private TextField adi;

    @PropertyId("kodu")
    private TextField kodu;

    @PropertyId("fiyat")
    private TextField fiyat;
    
    private FormLayout mainLayout;

    private BeanItem<Urun> urunBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;

    public UrunPage() {
        this(new Urun());
    }
    
    public UrunPage(Urun urun) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        urunBeanItem = new BeanItem<Urun>(urun);
        binder = new FieldGroup(urunBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {
    
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();
        
        id = new TextField();
        id.setCaption("ID");
        id.setEnabled(false);
        mainLayout.addComponent(id);
        
        adi = new TextField();
        adi.setCaption("Adı");
        mainLayout.addComponent(adi);

        kodu = new TextField();
        kodu.setCaption("Kodu");
        mainLayout.addComponent(kodu);

        fiyat = new TextField();
        fiyat.setCaption("Fiyat");
        mainLayout.addComponent(fiyat);

        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Urun urun = urunBeanItem.getBean();
                    UrunService urunService = new UrunService();
                    urunService.saveUrun(urun);
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Alanlar nesne ile uyumlu değil", Notification.Type.ERROR_MESSAGE);
                } catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(sySaveButton);
    }
}