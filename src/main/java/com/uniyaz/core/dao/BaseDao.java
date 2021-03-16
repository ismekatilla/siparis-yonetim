package com.uniyaz.core.dao;

import com.uniyaz.core.domain.BaseEntity;
import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by AKARTAL on 16.3.2021.
 */
public class BaseDao<J extends BaseEntity> {

    private Class<J> clazz;

    public BaseDao(Class<J> clazz) {
        this.clazz = clazz;
    }

    public void save(J entity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    public void delete(J entity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<J> findAll() {
        String entityClassName = clazz.getSimpleName();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     entity " +
                    "From       " + entityClassName + " entity ";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<J> findAllCriteria() {
        String entityClassName = clazz.getSimpleName();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(entityClassName);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public J findById(Long id) {
        String entityClassName = clazz.getSimpleName();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     entity " +
                    "From       " + entityClassName + " entity " +
                    "Where      entity.id = :id ";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            return (J) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public void findById();
//
}
