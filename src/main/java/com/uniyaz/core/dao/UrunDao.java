package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.dto.UrunDto;
import com.uniyaz.core.dto.UrunDtoNative;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class UrunDao {

    public void saveUrun(Urun urun) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(urun);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Urun> findAByIdCriteria(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Urun.class);
            criteria.add(Restrictions.eq("id", id));
            //criteria.add(Restrictions.like("kodu", "U", MatchMode.START));
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Urun> findAllHql() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     urunAlias " +
                    "From       Urun urunAlias ";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UrunDto> findAllHqlAliasToBean() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     urunAlias.id, urunAlias.kodu " +
                    "From       Urun urunAlias ";
            Query query = session.createQuery(hql);
            query.setResultTransformer(Transformers.aliasToBean(UrunDto.class));
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UrunDtoNative> findAllNative() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            NativeQuery sqlQuery = session.createSQLQuery("SELECT * FROM URUN");
            Query query = sqlQuery.setResultTransformer(Transformers.aliasToBean(UrunDtoNative.class));
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
