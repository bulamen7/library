package pl.swiokloarkadiusz.library.app;

import pl.swiokloarkadiusz.library.io.DataReader;
import pl.swiokloarkadiusz.library.model.Book;
import pl.swiokloarkadiusz.library.model.Library;
import pl.swiokloarkadiusz.library.model.Magazine;

import java.util.Optional;

public class LibraryControl {
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        Option option;
        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZIN:
                    addMagazin();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZIN:
                    printMagazin();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        } while (option != Option.EXIT);
    }

    private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void printMagazin() {
        library.printMagazines();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazin() {
        Magazine magazin = dataReader.readAndCreateMagazin();
        library.addMagazine(magazin);
    }

    private void printOptions() {
        System.out.println("Wybierz opcje");
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }
}
