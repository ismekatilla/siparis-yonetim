package com.uniyaz.core.service;

import com.uniyaz.core.dao.BaseDao;
import com.uniyaz.core.domain.BaseEntity;

import java.util.List;

/**
 * Created by AKARTAL on 16.3.2021.
 */
public class BaseService<E extends BaseEntity, D extends BaseDao> {

    D dao;

    public BaseService(Class<D> dao) {
        try {
            Class<?> clazz = Class.forName(dao.getName());
            this.dao = (D) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void save(E entity) {
        dao.save(entity);
    }

    public List<E> findAll() {
        return dao.findAll();
    }

    public void delete(E entity) {
        dao.delete(entity);
    }

    public E findById(Long id) {
        return (E) dao.findById(id);
    }

    public D getDao() {
        return dao;
    }
}