package org.example.model;

public class CollectItemsQuest extends Quest{

    private int numberOfItemsToCollect;
    private int collectedItems;

    public CollectItemsQuest(){}

    public CollectItemsQuest(long id, QuestStatus status, String questName, int numberOfItemsToCollect, int collectedItems) {
        super(id, status, questName);
        this.numberOfItemsToCollect = numberOfItemsToCollect;
        this.collectedItems = collectedItems;
    }

    @Override
    public boolean upgradeProgress(int value) {
        collectedItems+=value;
        if (collectedItems < numberOfItemsToCollect)
            return false;
        return true;
    }

    @Override
    public String getResultsDetails() {
        return "number of items to collect: " + this.numberOfItemsToCollect +
                ", number of collected items: " + this.collectedItems;
    }


    public int getNumberOfItemsToCollect() {
        return numberOfItemsToCollect;
    }

    public void setNumberOfItemsToCollect(int numberOfItemsToCollect) {
        this.numberOfItemsToCollect = numberOfItemsToCollect;
    }

    public int getCollectedItems() {
        return collectedItems;
    }

    public void setCollectedItems(int collectedItems) {
        this.collectedItems = collectedItems;
    }

    @Override
    public String toString() {
        return "CollectItemsQuest {" +
                "id: " + getId() +
                ", status: " + getStatus() +
                ", questName: " + getQuestName() + '\'' +
                ", numberOfItemsToCollect: " + numberOfItemsToCollect +
                ", collectedItems: " + collectedItems +
                " }";
    }
}
