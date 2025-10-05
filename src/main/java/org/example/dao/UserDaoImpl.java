package org.example.dao;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao{

    private List<User> users;

    public UserDaoImpl() {
        this.users = new ArrayList<>();
        this.users.add(new User(1, "John"));
        this.users.add(new User(2, "Mary"));
        this.users.add(new User(3, "Stan"));
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public List<User> getWithActiveQuests() {
        return this.users.stream()
                .filter( (user) -> user.getQuest() != null)
                .collect(Collectors.toList());
    }
}
