package com.Andriy.rest_api;

import org.example.model.Event;
import org.example.model.File;
import org.example.model.User;
import org.example.repository.EventRepository;
import org.example.repository.impl.EventRepositoryImpl;
import org.example.service.EventService;
import org.example.service.impl.EventServiceImpl;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class EventServiceImplTest extends TestCase {
    private EventRepository eventRepository = Mockito.mock(EventRepositoryImpl.class);
    private EventService serviceUnderTest = new EventServiceImpl(eventRepository);

    private List<Event> getEvents() {
        return List.of(
                new Event(1, new User(), new File()),
                new Event(2, new User(), new File()),
                new Event(2, new User(), new File()),
                new Event(2, new User(), new File())
        );
    }

    private Event getEvent() {
        return new Event(1, new User(), new File());
    }

    @Test
    public void testGetById() {
        doReturn(getEvent()).when(eventRepository).getByID(anyInt());
        Event developer = serviceUnderTest.getById(1);
        assertEquals(developer, getEvent());
    }

    @Test
    public void testGetAll() {
        doReturn(getEvents()).when(eventRepository).getAll();
        List<Event> events = serviceUnderTest.getAll();
        assertEquals(events.size(), getEvents().size());
    }

    @Test
    public void testCreate() {
        doReturn(getEvent()).when(eventRepository).create(getEvent());
        Event event = serviceUnderTest.create(getEvent());
        assertEquals(event, eventRepository.create(getEvent()));

    }

    @Test
    public void testUpdate() {
        doReturn(getEvent()).when(eventRepository).update(getEvent());
        Event event = serviceUnderTest.update(getEvent());
        assertEquals(event, eventRepository.update(getEvent()));

    }

    @Test
    public void testDeleteById() {
        eventRepository.deleteById(anyInt());
        verify(eventRepository).deleteById(anyInt());
    }
}
