package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.service.MusteriService;
import com.uniyaz.ui.component.CinsiyetCombobox;
import com.uniyaz.ui.component.SySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class MusteriPage extends VerticalLayout {

    @PropertyId("id")
    private TextField id;

    @PropertyId("adi")
    private TextField adi;

    @PropertyId("cinsiyet")
    private CinsiyetCombobox cinsiyet;

    private FormLayout mainLayout;

    private BeanItem<Musteri> musteriBeanItem;
    private FieldGroup binder;
    private SySaveButton sySaveButton;

    public MusteriPage() {
        this(new Musteri());
    }
    
    public MusteriPage(Musteri musteri) {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        musteriBeanItem = new BeanItem<Musteri>(musteri);
        binder = new FieldGroup(musteriBeanItem);
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

        cinsiyet = new CinsiyetCombobox();
        cinsiyet.setCaption("Cinsiyet");
        mainLayout.addComponent(cinsiyet);

        sySaveButton = new SySaveButton();
        sySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Musteri musteri = musteriBeanItem.getBean();
                    MusteriService musteriService = new MusteriService();
                    musteriService.saveMusteri(musteri);
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