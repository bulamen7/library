package pl.swiokloarkadiusz.library.app;

import pl.swiokloarkadiusz.library.io.DataReader;
import pl.swiokloarkadiusz.library.model.Book;
import pl.swiokloarkadiusz.library.model.Library;

public class LibraryControl {
    private final int exit = 1;
    private final int addBook = 2;
    private final int printBooks = 3;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();
    
    public void controlLoop() {
        int option;
        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        } while (option != exit);
    }
    
    private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }
    
    private void printBooks() {
        library.printBooks();
    }
    
    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
    
    private void printOptions() {
        System.out.println("Wybierz opcje:");
        System.out.println("1 - wyjscie z programu:");
        System.out.println("2 - dodanie nowej ksiazki: ");
        System.out.println("3 - wyswietl dostepne ksiazki");
    }
}
