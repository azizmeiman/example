package com.Aziz.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="person")
public class Person  {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="age")
    private String age;


    public Person(@NotNull String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

    public Person(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age +
                '}';
    }
}
