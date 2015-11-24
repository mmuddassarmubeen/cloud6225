package com.neu.cloud.dao;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO
{
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static final ThreadLocal sessionThread = new ThreadLocal();
	
    protected DAO() {
    }

    public static Session getSession()
    {
        Session session = (Session) DAO.sessionThread.get();
    
        if (session == null)
        {
            session = sessionFactory.openSession();
            DAO.sessionThread.set(session);
        }
        return session;
    }

    protected void begin()
    {
        getSession().beginTransaction();
    }

    protected void commit()
    {
        getSession().getTransaction().commit();
    }

    protected void rollback()
    {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.sessionThread.set(null);
    }

    public static void close()
    {
        getSession().close();
        DAO.sessionThread.set(null);
    }
    private static final Logger log = Logger.getAnonymousLogger();

    
}