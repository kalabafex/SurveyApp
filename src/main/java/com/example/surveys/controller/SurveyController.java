package com.example.surveys.controller;

import com.example.surveys.model.*;
import com.example.surveys.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/respondents/completed/{surveyId}")
    public List<Member> getCompletedRespondents(@PathVariable String surveyId) {
        return surveyService.getCompletedRespondents(surveyId);
    }

    @GetMapping("/surveys/completed/{memberId}")
    public List<Survey> getCompletedSurveys(@PathVariable String memberId) {
        return surveyService.getCompletedSurveys(memberId);
    }

    @GetMapping("/points/{memberId}")
    public List<Participation> getMemberPoints(@PathVariable String memberId) {
        return surveyService.getMemberPoints(memberId);
    }

    @GetMapping("/members/invitable/{surveyId}")
    public List<Member> getInvitableMembers(@PathVariable String surveyId) {
        return surveyService.getInvitableMembers(surveyId);
    }

    @GetMapping("/surveys/statistics")
    public List<SurveyStatistics> getSurveyStatistics() {
        return surveyService.getSurveyStatistics();
    }
}
