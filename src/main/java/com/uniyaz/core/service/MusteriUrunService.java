package com.uniyaz.core.service;

import com.uniyaz.core.dao.MusteriUrunDao;
import com.uniyaz.core.domain.MusteriUrun;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@Transactional
public class MusteriUrunService {

    MusteriUrunDao musteriUrunDao = new MusteriUrunDao();

    public void saveMusteriUrun(MusteriUrun musteriUrun) {
        musteriUrunDao.saveMusteriUrun(musteriUrun);
    }

    public void saveMusteriUrun(List<MusteriUrun> musteriUrunList) {
        musteriUrunDao.saveMusteriUrun(musteriUrunList);
    }

    public List<MusteriUrun> findAllHql() {
        return musteriUrunDao.findAllHql();
    }

    public List<MusteriUrun> findAllByMusteriId(Long musteriId) {
        return musteriUrunDao.findAllByMusteriId(musteriId);
    }
}