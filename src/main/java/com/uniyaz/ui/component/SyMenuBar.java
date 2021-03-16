package com.uniyaz.ui.component;

import com.uniyaz.core.domain.Menu;
import com.uniyaz.core.service.MenuService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.page.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class SyMenuBar extends MenuBar {

    private ContentComponent contentComponent;

    public SyMenuBar() {
        setSizeFull();
        addStyleName("syMenuBar");

        SyUI syUI = (SyUI) UI.getCurrent();
        contentComponent = syUI.getContentComponent();

        findAllMenu();
    }

    private void findAllMenu() {

        MenuService menuService = new MenuService();
        List<Menu> menuList = menuService.findAll();

        List<Menu> ustMenuList = menuList.stream()
                .filter(menu -> menu.getMenuUst() == null)
                .collect(Collectors.toList());

        for (Menu ustMenu : ustMenuList) {
            MenuItem ustMenuItem = addItem(ustMenu.getBaslik(), null);
            List<Menu> altMenuList = menuList.stream()
                    .filter(menu -> menu.getMenuUst() != null)
                    .filter(menu -> menu.getMenuUst().getId().equals(ustMenu.getId()))
                    .collect(Collectors.toList());
            for (Menu menu : altMenuList) {
                ustMenuItem.addItem(menu.getBaslik(), new Command() {
                    @Override
                    public void menuSelected(MenuItem menuItem) {
                        String classPath = menu.getClassPath();
                        try {
                            Class<?> clazz = Class.forName(classPath);
                            Layout layout = (Layout) clazz.newInstance();
                            contentComponent.addComponent(layout);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}