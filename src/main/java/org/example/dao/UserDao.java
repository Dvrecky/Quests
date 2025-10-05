package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    List<User> getWithActiveQuests();
}
