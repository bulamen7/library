package pl.swiokloarkadiusz.library.io;

import pl.swiokloarkadiusz.library.model.Book;
import pl.swiokloarkadiusz.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public Book readAndCreateBook() {
        System.out.println("Tytul: ");
        String title = scanner.nextLine();
        System.out.println("Autor: ");
        String author = scanner.nextLine();
        System.out.println("Data publikacji: ");
        int releaseDate = scanner.nextInt();
        System.out.println("Ilosc stron: ");
        int pages = scanner.nextInt();
        System.out.println("Wydawnictwo: ");
        scanner.nextLine();
        String publisher = scanner.nextLine();
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();
        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazin() {
        System.out.println("Tytul: ");
        String title = scanner.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        System.out.println("Język: ");
        String language = scanner.nextLine();
        System.out.println("Rok wydania: ");
        int year = getInt();
        System.out.println("miesiac ");
        int month = getInt();
        System.out.println("dzien ");
        int day = getInt();
        return new Magazine(title, publisher, language, year, month, day);
    }

    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void close() {
        scanner.close();
    }
}
