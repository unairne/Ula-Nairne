package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfIs0(){
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser userZero = new LibraryUser("Zero", "Ksiązek", "123");

        //czy to nie jest w tym przypadku zbędne?
        when(libraryDatabaseMock.listBooksInHandsOf(userZero)).thenReturn(userZero.myList);

        // When
        List<Book> userBooks = bookLibrary.listBooksInHandsOf(userZero);

        // Then
        Assert.assertEquals(0,userBooks.size());
        Assert.assertTrue(userBooks.isEmpty());
    }

    @Test
    public void testListBooksInHandsOfIs1(){
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser userOne = new LibraryUser("Jedna", "Książka", "111");
        Book book = new Book("Harry", "Piotrek", 1992);
        userOne.myList.add(book);

        //czy to nie jest w tym przypadku zbędne?
        when(libraryDatabaseMock.listBooksInHandsOf(userOne)).thenReturn(userOne.myList);

        // When
        List<Book> userBooks = bookLibrary.listBooksInHandsOf(userOne);

        // Then
        Assert.assertEquals(1,userBooks.size());
        Assert.assertTrue(userBooks.contains(book));
    }

    @Test
    public void testListBooksInHandsOfIs5(){
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser userFive = new LibraryUser("Jedna", "Książka", "555");
        Book book = new Book("Harry", "Piotrek", 1991);
        Book book2 = new Book("Harry", "Piotrek", 1993);
        Book book3 = new Book("Harry", "Piotrek", 1994);
        Book book4 = new Book("Harry", "Piotrek", 1995);
        Book book5 = new Book("Harry", "Piotrek", 1996);
        userFive.myList.add(book);
        userFive.myList.add(book2);
        userFive.myList.add(book3);
        userFive.myList.add(book4);
        userFive.myList.add(book5);

        //czy to nie jest w tym przypadku zbędne?
        when(libraryDatabaseMock.listBooksInHandsOf(userFive)).thenReturn(userFive.myList);

        // When
        List<Book> userBooks = bookLibrary.listBooksInHandsOf(userFive);

        // Then
        Assert.assertEquals(5,userBooks.size());
        Assert.assertTrue(userBooks.contains(book4));
    }
}

