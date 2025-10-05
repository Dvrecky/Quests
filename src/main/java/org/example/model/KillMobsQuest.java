package org.example.model;

public class KillMobsQuest extends Quest{

    private int numberOfMobsToKill;
    private int killedMobs;

    public KillMobsQuest(){}

    public KillMobsQuest(long id, QuestStatus status, String questName, int numberOfMobsToKill, int killedMobs) {
        super(id, status, questName);
        this.numberOfMobsToKill = numberOfMobsToKill;
        this.killedMobs = killedMobs;
    }

    public int getNumberOfMobsToKill() {
        return numberOfMobsToKill;
    }

    public void setNumberOfMobsToKill(int numberOfMobsToKill) {
        this.numberOfMobsToKill = numberOfMobsToKill;
    }

    public int getKilledMobs() {
        return killedMobs;
    }

    public void setKilledMobs(int killedMobs) {
        this.killedMobs = killedMobs;
    }

    @Override
    public boolean upgradeProgress(int value) {
        killedMobs+=value;
        if (killedMobs < numberOfMobsToKill)
            return false;
        return true;
    }

    @Override
    public String getResultsDetails() {
        return "number of mobs to kill: " + this.numberOfMobsToKill +
                ", killed mobs: " + this.killedMobs;
    }

    @Override
    public String toString() {

        return "KillMobsQuest { " +
                "id: " + getId() +
                ", status: " + getStatus() +
                ", questName: " + getQuestName() + '\'' +
                ", numberOfMobsToKill: " + numberOfMobsToKill +
                ", killedMobs: " + killedMobs +
                " }";
    }
}
