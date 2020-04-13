package pl.swiokloarkadiusz.library.app;

enum Option {

    EXIT(1, "Wyjscie z programu"),
    ADD_BOOK(2, "Dodanie ksiazki"),
    ADD_MAGAZIN(3, "Dodanie magazynu"),
    PRINT_BOOKS(4, "Wyswietlenie ksiazek"),
    PRINT_MAGAZIN(5, "Wyswietlenie magazynu");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    static Option createFromInt(int number) {
        return Option.values()[number];
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
}