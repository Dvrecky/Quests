package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    List<User> getWithActiveQuest();

    User checkIfUserCanBeAssigned(long id);

    User findUserWithQuestById(long id);
}
