package com.example.persistence;

public class Student {
    String name;
    String program;
    Integer age;


    public Student(String name, String program, Integer age) {
        this.name = name;
        this.program = program;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public Integer getAge() {
        return age;
    }
}
