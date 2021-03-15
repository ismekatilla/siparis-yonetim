package com.uniyaz.core.service;

import com.uniyaz.core.dao.MusteriDao;
import com.uniyaz.core.domain.Musteri;

import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class MusteriService {

    MusteriDao musteriDao = new MusteriDao();

    public void saveMusteri(Musteri musteri) {
        musteriDao.saveMusteri(musteri);
    }

    public List<Musteri> findAllHql() {
        return musteriDao.findAllHql();
    }
}
