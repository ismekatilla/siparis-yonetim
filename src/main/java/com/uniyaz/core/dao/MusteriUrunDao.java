package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.domain.MusteriUrun;
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
public class MusteriUrunDao extends BaseDao<MusteriUrun> {

    public MusteriUrunDao() {
        super(MusteriUrun.class);
    }

    public void saveMusteriUrun(List<MusteriUrun> musteriUrunList) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            for (MusteriUrun musteriUrun : musteriUrunList) {
                session.merge(musteriUrun);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MusteriUrun> findByMusteriId(Long musteriId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     musteriUrun " +
                    "From       MusteriUrun musteriUrun " +
                    "Left Join Fetch musteriUrun.musteri musteri " +
                    "Left Join Fetch musteriUrun.urun urun " +
                    "where      musteri.id = :musteriId ";
            Query query = session.createQuery(hql);
            query.setParameter("musteriId", musteriId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}