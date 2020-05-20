package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMainForum {

    public List<ForumUser> getManAtLeast20YearsGotPosts(){
        Forum theForum = new Forum();
        List<ForumUser> theResultMaleListForum = theForum.getList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.isAtLeast20YearsOld())
                .filter(forumUser -> forumUser.getPosts() > 0)
                .collect(Collectors.toList());
        return theResultMaleListForum;
    }

    public static void main(String[] args) {
        StreamMainForum streamMainForum = new StreamMainForum();
        Map<Integer, ForumUser> TheResultMap = streamMainForum.getManAtLeast20YearsGotPosts().stream()
                .collect(Collectors.toMap(ForumUser::getUniCode, forumUser -> forumUser));
        TheResultMap.entrySet().stream()
                .map(entry -> "Map entry: key = " + entry.getKey() + ", value = " + entry.getValue())
                .forEach(System.out::println);
    }
}