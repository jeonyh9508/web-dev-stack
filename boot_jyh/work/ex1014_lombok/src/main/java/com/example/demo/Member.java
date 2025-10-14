package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private long id;
    private String name;
    private String email;
    private int age;

    public String toString() {
        return "id=" + id + ", name=" + name + ", email=" + email + ", age=" + age;
    }
}
