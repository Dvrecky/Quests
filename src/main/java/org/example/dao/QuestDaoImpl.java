package org.example.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Quest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuestDaoImpl implements QuestDao{

    private List<Quest> quests;

    public QuestDaoImpl() {
        this.quests = new ArrayList<>();
        this.quests = fetchQuestsFromFile();
    }

    private List<Quest> fetchQuestsFromFile() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(
                    new File("src/main/java/org/example/data/quests.json"),
                    new TypeReference<List<Quest>>() {}
            );
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public List<Quest> getAll() {
        return this.quests.stream()
                .sorted(Comparator.comparing( q -> q.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }
}
