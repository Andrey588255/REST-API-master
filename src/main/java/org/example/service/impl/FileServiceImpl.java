package org.example.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.Event;
import org.example.model.File;
import org.example.model.User;
import org.example.repository.FileRepository;
import org.example.service.EventService;
import org.example.service.FileService;
import org.example.service.UserService;
import org.example.utils.GetFileNameUtil;

import javax.servlet.annotation.MultipartConfig;
import java.io.InputStream;
import java.util.List;


@MultipartConfig
@NoArgsConstructor
@AllArgsConstructor

public class FileServiceImpl implements FileService {

    private UserService userService;
    private EventService eventService;
    private FileRepository fileRepository;

    @Override
    public File uploadFile(InputStream inputStream, Integer userId) {
        String fileName = GetFileNameUtil.getFileName(inputStream);
        File file = new File();
        file.setFileName(fileName);
        file.setFilePath("C:\\Soft\\TestT\\" + fileName);
        User user = userService.getById(userId);
        Event event = new Event();
        event.setUser(user);
        event.setFile(file);
        eventService.create(event);
        return file;
    }

    @Override
    public File getById(Integer id) {
        return fileRepository.getByID(id);
    }

    @Override
    public List<File> getAll() {
        return fileRepository.getAll();
    }

    @Override
    public File create(File file) {
        return fileRepository.create(file);
    }

    @Override
    public File update(File file) {
        return fileRepository.update(file);
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
