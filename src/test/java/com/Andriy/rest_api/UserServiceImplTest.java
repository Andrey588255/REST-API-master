package com.Andriy.rest_api;

import junit.framework.TestCase;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest extends TestCase {

    private UserRepository userRepository = Mockito.mock(UserRepositoryImpl.class);
    private UserService serviceUnderTest = new UserServiceImpl(userRepository);

    private List<User> getUsers() {
        return List.of(
                new User(1, "name_1", new ArrayList<>()),
                new User(2, "name_2", new ArrayList<>()),
                new User(3, "name_3", new ArrayList<>()),
                new User(4, "name_4", new ArrayList<>())
        );
    }

    private User getUser() {
        return new User(1, "name", new ArrayList<>());
    }

    @Test
    public void testGetById() {
        doReturn(getUser()).when(userRepository).getByID(anyInt());
        User user = serviceUnderTest.getById(1);
        assertEquals(user, getUser());

    }

    @Test
    public void testGetAll() {
        doReturn(getUsers()).when(userRepository).getAll();
        List<User> user = serviceUnderTest.getAll();
        assertEquals(user, getUsers());
    }

    @Test
    public void testCreate() {
        doReturn(getUser()).when(userRepository).create(getUser());
        User user = serviceUnderTest.create(getUser());
        assertEquals(user, userRepository.create(getUser()));
    }

    @Test
    public void testUpdate() {
        doReturn(getUser()).when(userRepository).update(getUser());
        User user = serviceUnderTest.update(getUser());
        assertEquals(user, userRepository.update(getUser()));
    }

    @Test
    public void testDeleteById() {
        userRepository.deleteById(anyInt());
        verify(userRepository).deleteById(anyInt());
    }
}
