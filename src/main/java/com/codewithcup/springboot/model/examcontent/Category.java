package com.codewithcup.springboot.model.examcontent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private String title;
    private String descripton;

//    One category contains many quizes
    @OneToMany(mappedBy = "category",fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quizzes = new LinkedHashSet<>();

//    Default Constructor
    public Category() {
    }

//    Parameterized Constructor

    public Category(Long cId, String title, String descripton, Set<Quiz> quizzes) {
        this.cId = cId;
        this.title = title;
        this.descripton = descripton;
        this.quizzes = quizzes;
    }

    //    Getter Setter

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    //    toString

    @Override
    public String toString() {
        return "Category{" +
                "cId=" + cId +
                ", title='" + title + '\'' +
                ", descripton='" + descripton + '\'' +
                ", quizzes=" + quizzes +
                '}';
    }
}