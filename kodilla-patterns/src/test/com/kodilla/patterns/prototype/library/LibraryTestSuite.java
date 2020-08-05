package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("First Public Library");
        Book book1 = new Book("firstBook", "firstAuthor", LocalDate.of(2019,12,10));
        Book book2 = new Book("secondBook", "secondAuthor", LocalDate.of(2010,3,22));
        Book book3 = new Book("thirdBook", "thirdAuthor", LocalDate.of(2020,4,17));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Second Public Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Third Public Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        deepClonedLibrary.getBooks().remove(book1);
        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(3, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(2, deepClonedLibrary.getBooks().size());
        Assert.assertEquals("Second Public Library", shallowClonedLibrary.getName());
        Assert.assertEquals("Third Public Library", deepClonedLibrary.getName());
        Assert.assertEquals(shallowClonedLibrary.getBooks(),library.getBooks());
        Assert.assertNotEquals(shallowClonedLibrary.getBooks(),deepClonedLibrary.getBooks());
    }
}