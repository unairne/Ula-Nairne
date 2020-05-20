package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum(){
        theForumUserList.add(new ForumUser(1, "Miki", 'M', LocalDate.of(1987,11,20), 1));
        theForumUserList.add(new ForumUser(2, "Diana", 'F', LocalDate.of(1988,10,4), 0));
        theForumUserList.add(new ForumUser(3, "Roxana", 'F', LocalDate.of(1986, 3,16), 0));
        theForumUserList.add(new ForumUser(4, "Jordan", 'M', LocalDate.of(2000, 2, 15), 0));
        theForumUserList.add(new ForumUser(5, "Pipen", 'M', LocalDate.of(1999, 1, 18), 1));
        theForumUserList.add(new ForumUser(6, "Zaroslinska", 'F', LocalDate.of(2002, 3, 17), 1));
        theForumUserList.add(new ForumUser(7, "Derocco", 'M', LocalDate.of(1998, 1, 31), 0));
        theForumUserList.add(new ForumUser(8, "Kitana", 'F', LocalDate.of(2003, 5, 27), 0));
        theForumUserList.add(new ForumUser(9, "Lucky Luck", 'M', LocalDate.of(2005, 7, 13), 0));
        theForumUserList.add(new ForumUser(10, "Storm", 'F', LocalDate.of(1995, 4, 25), 0));
        theForumUserList.add(new ForumUser(11, "Wolverine", 'M', LocalDate.of(1990, 5, 17), 1));
        theForumUserList.add(new ForumUser(12, "Rouge", 'F', LocalDate.of(1991, 3, 7), 0));
    }

    public List<ForumUser> getList(){
        return new ArrayList<>(theForumUserList);
    }
}