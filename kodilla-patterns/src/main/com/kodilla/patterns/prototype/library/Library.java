package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board [" + name + "]\n");
        for(Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book: books) {
            Book clonedBook = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
            clonedLibrary.getBooks().add(clonedBook);
        }
        return clonedLibrary;
    }
}