package com.example.school.controller;

import com.example.school.domain.Score;
import com.example.school.domain.Student;
import com.example.school.domain.StudentInquiryDto;
import com.example.school.service.ScoreService;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final ScoreService scoreService;

    @Autowired
    public StudentController(StudentService studentService,
                             ScoreService scoreService) {
        this.studentService = studentService;
        this.scoreService = scoreService;
    }

    @GetMapping
    public String getAllStudents(Model model){
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("students",allStudents);
        return "student/studentList";
    }

    @GetMapping("/studentInfo/{id}")
    public String getAllStudents(@PathVariable int id,  Model model){
        Student studentInfo = studentService.getStudentInfo(id);
        model.addAttribute("student",studentInfo);
        return "student/studentInfo";
    }

    @GetMapping("/studentUpdate/{id}")
    public String updateScore(@PathVariable int id,  Model model){
        Student studentInfo = studentService.getStudentInfo(id);
        Score score = scoreService.getStudentScore(id);  // 점수 없는 경우만 입력한다
        System.out.println("score null ? " + score);
        if(score == null) {
            model.addAttribute("student", studentInfo);
            return "student/studentUpdateForm";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/updateScore/{id}")
    public String updateScore(@PathVariable int id,
                              @ModelAttribute Score score){
        Student studentInfo = studentService.getStudentInfo(id);
        System.out.println(score.getId() + ":" + score.getSPoint());
        scoreService.addStudentScore(score);
        studentService.updateStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/addStudent")
    public String addNewStudent(){
        return "student/studentForm";
    }

    @PostMapping("/addStudent")
    public String addNewStudent(@ModelAttribute Student student){
        studentService.addNewStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/inquiry")
    public String getStudentsInquiry(@ModelAttribute StudentInquiryDto studentInquiryDto,
                                     Model model){
        List<Student> students = studentService.getStudentInquiry(studentInquiryDto);
        model.addAttribute("students", students);
        return "student/studentList";
    }
}