package pl.swiokloarkadiusz.library.model;

public class Library {
    
    private int maxBooks = 1000;
    private Book[] books = new Book[maxBooks];
    private int booksNumber = 0;
    
    public void addBook(Book book) {
        if (booksNumber < maxBooks) {
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("Nie ma miejsca");
        }
    }
    
    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("Brak ksiazek");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }
}

