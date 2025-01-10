package org.example.repository.impl;

import org.example.model.Event;
import org.example.repository.EventRepository;
import org.example.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    private Transaction transaction;

    @Override
    public Event getByID(Integer id) {
        Event event = new Event();
        try (Session session = HibernateUtil.getSession()){
            event = session.get(Event.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public List<Event> getAll() {
        List<Event> eventList = new ArrayList<>();
        try ( Session session = HibernateUtil.getSession()){
            eventList = session.createQuery("FROM Event ORDER BY id", Event.class).list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    @Override
    public Event create(Event event) {
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(event);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public Event update(Event event){
        try ( Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.update(event);
            Event eventResult = (Event) session.merge(event);
            String hql = "Update Event"

                    + "SET user.id = :userId "
                    + " , file.id = :fileId"
                    + " where id = :eventId";
            session.createQuery(hql)
                    .setParameter("eventId", event.getId())
                    .setParameter("userId", event.getUser().getId())
                    .setParameter("filed", event.getFile().getId())
                    .executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Event WHERE id = :param")
                    .setParameter("param", id)
                    .executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();

        }
    }
}
