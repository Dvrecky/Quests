package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    public List<User> getWithActiveQuest() {
        List<User> users = this.userDao.getWithActiveQuests();
        if (users.isEmpty()) {
//            throw new RuntimeException("There are no users with active quests");
            throw new RuntimeException("There are no active quests. No quest is assigned to any user");
        }
        return users;
    }

    @Override
    public User checkIfUserCanBeAssigned(long id) {
        Optional<User> optionalUser = getAll().stream()
                .filter( (u) -> u.getId() == id)
                .findFirst();

        User user = optionalUser.orElseThrow(
                () -> new NoSuchElementException("The user with id: " + id + " doesn't exist")
        );

        if (user.getQuest() != null) {
            throw new IllegalStateException("The user with id: " + id + " has already assigned a quest. Assigned quest id: " + user.getQuest().getId());
        }
        return user;
    }

    @Override
    public User findUserWithQuestById(long id) {

        Optional<User> optionalUser = getWithActiveQuest().stream()
                .filter( (u) -> u.getId() == id)
                .findFirst();

        return optionalUser.orElseThrow(
                () -> new NoSuchElementException("The user with id: " + id + " doesn't exist")
        );
    }
}
