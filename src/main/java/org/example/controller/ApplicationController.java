package org.example.controller;

import org.example.model.Quest;
import org.example.model.User;
import org.example.service.QuestService;
import org.example.service.UserService;
import org.example.view.ApplicationView;

import java.util.List;

public class ApplicationController {

    private final UserService userService;
    private final QuestService questService;
    private final ApplicationView applicationView;

    public ApplicationController(UserService userService, QuestService questService, ApplicationView applicationView) {
        this.userService = userService;
        this.questService = questService;
        this.applicationView = applicationView;
    }

    public void run() {

        while (true) {

            applicationView.showEnterPage();
            int choice = applicationView.getInput();

            switch (choice) {
                case 1:

                    try {
                        assignQuestToUser();
                    } catch (RuntimeException ex) {
                        applicationView.showErrorMessage(ex.getMessage());
                        break;
                    }
                    break;

                case 2:

                    try {
                        updateProgress();
                    } catch (RuntimeException ex) {
                        applicationView.showErrorMessage(ex.getMessage());
                        break;
                    }
                    break;

                case 3:

                    try {
                        showStatusesForActiveTasks();
                    } catch (RuntimeException ex) {
                        applicationView.showErrorMessage(ex.getMessage());
                        break;
                    }
                    break;
                case 4:
                    try {
                        showAllQuestsStatuses();
                    } catch (RuntimeException ex) {
                        applicationView.showErrorMessage(ex.getMessage());
                        break;
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void assignQuestToUser() throws RuntimeException {

        // fetching users and quests
        List<User> users = userService.getAll();
        List<Quest> quests = questService.getAll();

        applicationView.showUsersAndQuests(users, quests);
        long userId = applicationView.getUserIdToAssignQuest();

        User user = userService.checkIfUserCanBeAssigned(userId);

        long questId = applicationView.getQuestIdToAssignToUser();

        // assigning quest to a user with questService
        questService.assignQuestToUser(user, questId);

        applicationView.showCorrectTaskAssignment(questId, userId);
    }

    private void updateProgress() throws RuntimeException {

        // fetching quest users with active quest
        List<User> usersWithQuest = userService.getWithActiveQuest();

        applicationView.showUsersWithActiveQuests(usersWithQuest);

        long userId = applicationView.getUserIdToUpgradeProgress();

        User user = userService.findUserWithQuestById(userId);
        Quest quest = user.getQuest();

        applicationView.showQuestDetails(quest);

        int val = applicationView.getProgressUpdateValue();

        // updating quest progress with questService
        boolean isCompleted = questService.updateProgress(user, quest, val);

        applicationView.showSuccessfulProgressUpdate(quest);
        if (isCompleted) {
            applicationView.showQuestCompletion();
        }
    }

    public void showStatusesForActiveTasks() {

        List<User> usersWithQuest = userService.getWithActiveQuest();

        applicationView.showUserTaskStatuses(usersWithQuest);
    }

    public void showAllQuestsStatuses() {

        List<Quest> quests = questService.getAll();

        applicationView.showAllQuestsStatuses(quests);
    }
}
