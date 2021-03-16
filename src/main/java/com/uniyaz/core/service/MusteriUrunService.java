package com.uniyaz.core.service;

import com.uniyaz.core.dao.MusteriUrunDao;
import com.uniyaz.core.domain.MusteriUrun;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@Transactional
public class MusteriUrunService extends BaseService<MusteriUrun, MusteriUrunDao> {

    public MusteriUrunService() {
        super(MusteriUrunDao.class);
    }

    public void saveMusteriUrun(List<MusteriUrun> musteriUrunList) {
        getDao().saveMusteriUrun(musteriUrunList);
    }

    public List<MusteriUrun> findByMusteriId(Long musteriId) {
        return getDao().findByMusteriId(musteriId);
    }
}