package org.example.service;

import org.example.model.Quest;
import org.example.model.User;

import java.util.List;

public interface QuestService {

    List<Quest> getAll();

    void assignQuestToUser(User user, long questId) throws RuntimeException;

    boolean updateProgress(User user, Quest quest, int val);
}
