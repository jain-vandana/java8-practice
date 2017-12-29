package com.company.collection;

import java.util.Comparator;
import java.util.Objects;

class Book /*implements Comparable*/{
    String title;
    String auther;
    int year;

    public String getTitle() {
        return title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String title, String auther, int year) {
        this.title = title;
        this.auther = auther;
        this.year = year;
    }

    //@Override
    public int compareTo(Object book1) {

        return getTitle().compareTo(((Book)book1).getTitle());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(auther, book.auther);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, auther, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", year=" + year +
                '}';

    }
}

