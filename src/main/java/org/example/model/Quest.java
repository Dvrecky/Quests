package org.example.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CollectItemsQuest.class, name = "collectItems"),
        @JsonSubTypes.Type(value = KillMobsQuest.class, name = "killMobs")
})
public abstract class Quest {
    private long id;
    private QuestStatus status;
    private String questName;

    protected Quest(){}

    protected Quest(long id, QuestStatus status, String questName) {
        this.id = id;
        this.status = status;
        this.questName = questName;
    }

    public abstract boolean upgradeProgress(int value);

    public abstract String getResultsDetails();

    public long getId() {
        return id;
    }

    public QuestStatus getStatus() {
        return status;
    }

    public void setStatus(QuestStatus status) {
        this.status = status;
    }

    public String getQuestName() {
        return questName;
    }
}
