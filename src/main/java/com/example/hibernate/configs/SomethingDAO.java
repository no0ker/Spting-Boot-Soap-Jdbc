package com.example.hibernate.configs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SomethingDAO
{
    private SessionFactory sessionFactory;

    @Autowired
    public SomethingDAO(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Something something) {
        getSession().save(something);
        return;
    }

    public void delete(Something something) {
        getSession().delete(something);
        return;
    }

    public void update(Something something) {
        getSession().update(something);
        return;
    }

}
