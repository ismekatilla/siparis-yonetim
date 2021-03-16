package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class MusteriDao extends BaseDao<Musteri> {

    public MusteriDao() {
        super(Musteri.class);
    }
}