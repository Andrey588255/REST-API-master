package org.example.utils;

import lombok.Getter;
import org.example.model.Event;
import org.example.model.File;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    private static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            sessionFactory = new Configuration().addAnnotatedClass(Event.class)
                    .addAnnotatedClass(File.class)
                    .addAnnotatedClass(User.class).buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
