package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMainForum {

    public List<ForumUser> getManAtLeast20YearsGotPosts(){
        Forum theForum = new Forum();
        List<ForumUser> theResultMaleListForum = theForum.getList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthDate(),LocalDate.now()).getYears()>20)
                .filter(forumUser -> forumUser.getNumberOfPosts() > 0)
                .collect(Collectors.toList());
        return theResultMaleListForum;
    }
    public static void main(String[] args) {
        StreamMainForum streamMainForum = new StreamMainForum();
        streamMainForum.getManAtLeast20YearsGotPosts().forEach(System.out::println);
    }

}