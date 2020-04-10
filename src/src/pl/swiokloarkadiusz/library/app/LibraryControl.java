package pl.swiokloarkadiusz.library.app;

import pl.swiokloarkadiusz.library.io.DataReader;
import pl.swiokloarkadiusz.library.model.Book;
import pl.swiokloarkadiusz.library.model.Library;
import pl.swiokloarkadiusz.library.model.Magazin;

public class LibraryControl {
    private static final int EXIT = 1;
    private static final int ADD_BOOK = 2;
    private static final int ADD_MAGAZIN = 3;
    private static final int PRINT_BOOKS = 4;
    private static final int PRINT_MAGAZIN = 5;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();
    
    public void controlLoop() {
        int option;
        do {
            printOptions();
            option = dataReader.getInt();
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
        } while (option != EXIT);
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
        Magazin magazin = dataReader.readAndCreateMagazin();
        library.addMagazine(magazin);
    }
    
    private void printOptions() {
        System.out.println("Wybierz opcje:");
        System.out.println("1 - wyjscie z programu:");
        System.out.println("2 - dodanie nowej ksiazki: ");
        System.out.println("3 - dodanie magazynu: ");
        System.out.println("4 - wyswietl dostepne ksiazki");
        System.out.println("5 - wyswietl dostepne magazyny");
    }
}
