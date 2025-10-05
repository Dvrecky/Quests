package org.example.view;

import org.example.model.Quest;
import org.example.model.User;

import java.util.List;
import java.util.Scanner;

public class ApplicationView {

    private final Scanner scanner;

    public ApplicationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showEnterPage() {

        System.out.println("\n-----------------------");
        System.out.println("Choose your action");
        System.out.println("1. Assign a quest to a user");
        System.out.println("2. Update active quest progress");
        System.out.println("3. Check active quests statuses");
        System.out.println("4. Show all quests statuses");
        System.out.println("5. Exit");
    }

    public int getInput() {
        return scanner.nextInt();
    }

    public void showUsersAndQuests(List<User> users, List<Quest> quests) {

        // printing users
        System.out.println("\n|List of users|");
        users.forEach( (u) -> {
                    String questInfo = (u.getQuest() == null) ? "No active quest" : "Active quest id: " + u.getQuest().getId();
                    System.out.println("id: " + u.getId() + ", name: " + u.getName() + ", Quest: " + questInfo);
                }
        );

        // printing quests
        System.out.println("\n|List of quests|");
        quests.forEach(System.out::println);
    }

    public int getUserIdToAssignQuest(){
        System.out.println("\nSelect the user (by his id) to whom you wish to assign the task");
        return getInput();
    }

    public int getQuestIdToAssignToUser() {
        System.out.println("\nSelect the task (by its id) you wish to assign to the selected user");
        return getInput();
    }

    public void showCorrectTaskAssignment(long questId, long userId) {
        System.out.println("\nThe quest with id: " + questId + " assigned to the user with id: " + userId + " successfully");
    }

    public void showUsersWithActiveQuests(List<User> users) {
        System.out.println("\n|Users with active quests|" );
        users.forEach(
                (u) -> System.out.println("id: " + u.getId() + ", name: " + u.getName() +
                        ", quest name: " + u.getQuest().getQuestName())
        );
    }

    public int getUserIdToUpgradeProgress() {
        System.out.println("\nSelect the user (by his id) whose quest progress you wish to update");
        return getInput();
    }

    public void showSuccessfulProgressUpdate(Quest quest) {
        System.out.println("\nProgress updated successfully");
        System.out.println(quest);
    }

    public void showQuestDetails(Quest quest) {
        System.out.println("\nUser quest details:\n" + quest);
    }

    public void showUserTaskStatuses(List<User> users) {
        System.out.println("\n|User task statuses|" );
        users.forEach( (u) -> System.out.println("User id: " + u.getId() +
                ", username: " + u.getName() + ", quest name: " + u.getQuest().getQuestName() +
                ", STATUS: " + u.getQuest().getStatus() + "\nDetails: " + u.getQuest().getResultsDetails()));
    }

    public int getProgressUpdateValue() {
        System.out.println("\nUpdate the progress count with given sum");
        return getInput();
    }

    public void showQuestCompletion() {
        System.out.println("Congratulations, you have completed your quest!!!");
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }

    public void showAllQuestsStatuses(List<Quest> quests) {
        System.out.println("\n|All task statuses|" );
        quests.forEach( (q) -> System.out.println("Quest id: " + q.getId() +
                ", quest name: " + q.getQuestName() +
                ", STATUS: " + q.getStatus() + "\nDetails: " + q.getResultsDetails()));
    }
}
