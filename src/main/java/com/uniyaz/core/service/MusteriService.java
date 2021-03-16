package com.uniyaz.core.service;

import com.uniyaz.core.dao.MusteriDao;
import com.uniyaz.core.domain.Musteri;

import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class MusteriService extends BaseService<Musteri, MusteriDao> {

    public MusteriService() {
        super(MusteriDao.class);
    }
}