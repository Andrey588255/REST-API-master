package org.example.repository.impl;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {
    private Transaction transaction;
    @Override
    public User getByID(Integer id) {
        User user = new User();
        try (Session session = HibernateUtil.getSession()){
            user = session.get(User.class, id);
        }  catch (HibernateException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()){
            userList = session.createQuery("FROM User", User.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User create(User user) {
        try (Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
       try (Session session = HibernateUtil.getSession()){
           transaction = session.beginTransaction();
           session.update(user);
           transaction.commit();
       } catch (HibernateException e) {
           e.printStackTrace();
       }

        return user;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
