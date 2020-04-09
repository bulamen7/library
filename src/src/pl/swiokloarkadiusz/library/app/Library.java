package pl.swiokloarkadiusz.library.app;

import pl.swiokloarkadiusz.library.io.DataReader;
import pl.swiokloarkadiusz.library.model.Book;

import java.util.Scanner;


class Library {
    public static void main(String[] args) {
        Book[] books = new Book[1000];
        DataReader dataReader = new DataReader();
        books[0] = dataReader.readAndCreateBook();
        dataReader.close();
        books[0].printInfo();
    }
}
