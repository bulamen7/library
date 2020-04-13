package pl.swiokloarkadiusz.library.app;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}