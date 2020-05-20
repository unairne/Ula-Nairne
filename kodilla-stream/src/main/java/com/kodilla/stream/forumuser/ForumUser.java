package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class ForumUser {
    private final int ID;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int numberOfPosts;

    public ForumUser(final int ID, final String userName, final char sex, final LocalDate birthDate, final int numberOfPosts){
        this.ID=ID;
        this.userName=userName;
        this.sex=sex;
        this.birthDate=birthDate;
        this.numberOfPosts=numberOfPosts;
    }
    public int getID() {
        return ID;
    }
    public String getUserName() {
        return userName;
    }
    public char getSex() {
        return sex;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public int getNumberOfPosts() {
        return numberOfPosts;
    }
    @Override
    public String toString() {
        return "ForumUser{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
    public int getAge(){
        Period period = Period.between(birthDate, LocalDate.now());
        int years = period.getYears();
        return years;
    }
}