package com.uniyaz.core.service;

import com.uniyaz.common.exceptions.SyException;
import com.uniyaz.core.dao.UrunDao;
import com.uniyaz.core.domain.Urun;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class UrunService extends BaseService<Urun, UrunDao> {

    public UrunService() {
        super(UrunDao.class);
    }

    @Override
    public void save(Urun urun) {
        validateSaveUrun(urun);
        super.save(urun);
    }

    private void validateSaveUrun(Urun urun) {

        if (!urun.getKodu().startsWith("U")) {
            String message = "Ürün Kodu U ile başlamak zorunda";
            throw new SyException(message, SyException.EnumExceptionType.WARNING);
        }
    }
}
