package com.uniyaz.core.service;

import com.uniyaz.core.dao.MenuDao;
import com.uniyaz.core.domain.Menu;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class MenuService extends BaseService<Menu, MenuDao> {

    public MenuService() {
        super(MenuDao.class);
    }
}