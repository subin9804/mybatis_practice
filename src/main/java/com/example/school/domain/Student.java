package com.example.school.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Student {
private int id;
private String name;
private String univ;
private String birth;
private String email;
private float point;
}
