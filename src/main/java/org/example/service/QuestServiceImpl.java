package org.example.service;

import org.example.dao.QuestDao;
import org.example.model.Quest;
import org.example.model.QuestStatus;
import org.example.model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class QuestServiceImpl implements QuestService{

    private final QuestDao questDao;

    public QuestServiceImpl(QuestDao questDao) {
        this.questDao = questDao;
    }

    @Override
    public List<Quest> getAll() {
        return this.questDao.getAll();
    }

    @Override
    public void assignQuestToUser(User user, long questId) throws RuntimeException{

        Optional<Quest> optionalQuest = getAll().stream()
                .filter( (q) -> q.getId() == questId)
                .findFirst();

        Quest quest = optionalQuest.orElseThrow(
                () -> new NoSuchElementException("Quest with id: " + questId + " doesn't exist")
        );

        if (!quest.getStatus().equals(QuestStatus.NEW)) {
            throw new RuntimeException("This quest is already completed or pending so you can't assign it.");
        }

        user.setQuest(quest);
        quest.setStatus(QuestStatus.PENDING);
    }

    @Override
    public boolean updateProgress(User user, Quest quest, int val) {

        if (quest.upgradeProgress(val)) {
            quest.setStatus(QuestStatus.COMPLETED);
            user.setQuest(null);
            return true;
        }
        return false;
    }
}
