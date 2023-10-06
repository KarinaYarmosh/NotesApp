package com.notesapp.service;

import com.notesapp.model.Users;
import com.notesapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findById(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }

    public void deleteAll() {
        usersRepository.deleteAll();
    }

    public void deleteById(int id) {
        usersRepository.deleteById(id);
    }
}
