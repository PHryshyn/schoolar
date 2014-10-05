package com.schoolar.modules.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "homework_id")
    private Integer homeworkId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "homework_date")
    private Date homeworkDate;

    @Column(name = "homework")
    @Pattern(regexp = "[a-zA-Z0-9,#-.,]*")
    private String homework;

    @OneToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public Homework() {
    }

    public Homework(Date homeworkDate, String homework, Discipline discipline) {
        this.homeworkDate = homeworkDate;
        this.homework = homework;
        this.discipline = discipline;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Date getHomeworkDate() {
        return homeworkDate;
    }

    public void setHomeworkDate(Date homeworkDate) {
        this.homeworkDate = homeworkDate;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
