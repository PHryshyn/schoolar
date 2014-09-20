package com.schoolar.modules.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "homework_id")
    private Integer homeworkId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "homework_date")
    private Date homeworkDate;

    @Column(name = "homework")
    private String homework;
/*
    @Column(name = "notes")
    private String notes;
*/
    @OneToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
/*
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;
*/
    public Homework() {
    }

    public Homework(Date homeworkDate, String homework, Discipline discipline) {
        this.homeworkDate = homeworkDate;
        this.homework = homework;
        this.discipline = discipline;
    }

    /*
    public Notes(Date noteDate, String homework, String notes, Discipline discipline, User user) {
        this.noteDate = noteDate;
        this.homework = homework;
        this.notes = notes;
        this.discipline = discipline;
        this.user = user;
    }
*/

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
