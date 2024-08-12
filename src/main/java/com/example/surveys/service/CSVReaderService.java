package com.example.surveys.service;

import com.example.surveys.model.*;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CSVReaderService {

    @Autowired
    private ResourceLoader resourceLoader;

    private List<Member> members;
    private List<Survey> surveys;
    private List<Status> statuses;
    private List<Participation> participations;

    @PostConstruct
    public void init() throws IOException {
        this.members = readCSV("classpath:data/Members.csv", Member.class);
        this.surveys = readCSV("classpath:data/Surveys.csv", Survey.class);
        this.statuses = readCSV("classpath:data/Statuses.csv", Status.class);
        this.participations = readCSV("classpath:data/Participation.csv", Participation.class);
    }

    private <T> List<T> readCSV(String resourcePath, Class<T> type) throws IOException {
        Resource resource = resourceLoader.getResource(resourcePath);
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            return new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .build()
                    .parse();
        }
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }
    public List<Participation> getParticipations() {
        return participations;
    }
}
