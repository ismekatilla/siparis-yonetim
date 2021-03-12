package com.uniyaz.core.service;

import com.uniyaz.core.dao.UrunDao;
import com.uniyaz.core.domain.Urun;

import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class UrunService {

    UrunDao urunDao = new UrunDao();

    public void saveUrun(Urun urun) {
        validateSaveUrun(urun);
        urunDao.saveUrun(urun);
    }

    private void validateSaveUrun(Urun urun) {

        if (!urun.getKodu().startsWith("U")) throw new RuntimeException("Ürün Kodu U ile başlamak zorunda");
    }

    public List<Urun> findAllHql() {
        return urunDao.findAllHql();
    }
}
