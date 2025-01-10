package org.example.service.impl;

import org.example.model.Event;
import org.example.repository.EventRepository;
import org.example.repository.impl.EventRepositoryImpl;
import org.example.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventServiceImpl() {
        this.eventRepository = new EventRepositoryImpl();
    }

    @Override
    public Event getById(Integer id) {
        return eventRepository.getByID(id);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.getAll();
    }

    @Override
    public Event create(Event event) {
        return eventRepository.create(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.update(event);
    }

    @Override
    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }
}
