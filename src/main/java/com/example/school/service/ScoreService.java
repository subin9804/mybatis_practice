package com.example.school.service;

import com.example.school.domain.Score;
import com.example.school.repository.ScoreRepository;
import com.example.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public Score getStudentScore(int id){
        return scoreRepository.findById(id);
    }

    public int addStudentScore(Score score){
        return scoreRepository.addScore(score);
    }
}