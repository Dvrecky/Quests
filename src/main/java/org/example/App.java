package org.example;

import org.example.controller.ApplicationController;
import org.example.dao.QuestDao;
import org.example.dao.QuestDaoImpl;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.service.QuestService;
import org.example.service.QuestServiceImpl;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.example.view.ApplicationView;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {

        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDao);
        QuestDao questDao = new QuestDaoImpl();
        QuestService questService = new QuestServiceImpl(questDao);

        Scanner scanner = new Scanner(System.in);

        ApplicationView applicationView = new ApplicationView(scanner);

        ApplicationController app = new ApplicationController(userService, questService, applicationView);
        app.run();
        scanner.close();

    }
}
