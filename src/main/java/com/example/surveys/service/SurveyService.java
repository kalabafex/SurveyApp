package com.example.surveys.service;

import com.example.surveys.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class SurveyService {

    @Autowired
    private CSVReaderService csvReaderService;

    public List<Member> getCompletedRespondents(String surveyId) {
        return csvReaderService.getParticipations().stream()
                .filter(p -> surveyId.equals(p.getSurveyId()) && p.getStatusId() == 4)
                .map(p -> csvReaderService.getMembers().stream()
                        .filter(m -> m.getMemberId().equals(p.getMemberId()))
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Survey> getCompletedSurveys(String memberId) {
        return csvReaderService.getParticipations().stream()
                .filter(p -> memberId.equals(p.getMemberId()) && p.getStatusId() == 4)
                .map(p -> csvReaderService.getSurveys().stream()
                        .filter(s -> s.getSurveyId().equals(p.getSurveyId()))
                        .findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Participation> getMemberPoints(String memberId) {
        List<Survey> surveys = csvReaderService.getSurveys();
        return csvReaderService.getParticipations().stream()
                .filter(p -> memberId.equals(p.getMemberId()) && (p.getStatusId() == 3 || p.getStatusId() == 4))
                .map(p -> {
                    int points = surveys.stream()
                            .filter(s -> s.getSurveyId().equals(p.getSurveyId()))
                            .findFirst()
                            .map(s -> p.getStatusId() == 4 ? s.getCompletionPoints() : s.getFilteredPoints())
                            .orElse(0);
                    p.setPoints(points);
                    return p;
                })
                .collect(Collectors.toList());
    }


    public List<Member> getInvitableMembers(String surveyId) {
        return csvReaderService.getMembers().stream()
                .filter(Member::isActive)
                .filter(m -> csvReaderService.getParticipations().stream()
                        .noneMatch(p -> surveyId.equals(p.getSurveyId()) && p.getMemberId().equals(m.getMemberId())))
                .collect(Collectors.toList());
    }

    public List<SurveyStatistics> getSurveyStatistics() {
        return csvReaderService.getSurveys().stream()
                .filter(survey -> survey.getSurveyId() != null)
                .map(survey -> {
                    List<Participation> participations = csvReaderService.getParticipations().stream()
                            .filter(p -> survey.getSurveyId().equals(p.getSurveyId()))
                            .collect(Collectors.toList());

                    long completedCount = participations.stream().filter(p -> p.getStatusId() == 4).count();
                    long filteredCount = participations.stream().filter(p -> p.getStatusId() == 3).count();
                    long rejectedCount = participations.stream().filter(p -> p.getStatusId() == 2).count();
                    double averageLength = participations.stream().mapToInt(Participation::getLength).average().orElse(0);

                    return new SurveyStatistics(
                            survey.getSurveyId(),
                            survey.getSurveyName(),
                            completedCount,
                            filteredCount,
                            rejectedCount,
                            averageLength
                    );
                })
                .collect(Collectors.toList());
    }
}
