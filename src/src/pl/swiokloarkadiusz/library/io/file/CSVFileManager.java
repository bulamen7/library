package pl.swiokloarkadiusz.library.io.file;

import com.sun.media.sound.InvalidDataException;
import pl.swiokloarkadiusz.library.exeption.DataExportException;
import pl.swiokloarkadiusz.library.exeption.DataImportException;
import pl.swiokloarkadiusz.library.model.Book;
import pl.swiokloarkadiusz.library.model.Library;
import pl.swiokloarkadiusz.library.model.Magazine;
import pl.swiokloarkadiusz.library.model.Publication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVFileManager implements FileManager {
    public static final String FILE_NAME = "library.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        try (Scanner fileReader = new Scanner(new File(FILE_NAME))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Publication publication = createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("brak pliku " + FILE_NAME);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        return library;
    }

    private Publication createObjectFromString(String line) throws InvalidDataException {
        String[] split = line.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)) {
            return createBook(split);

        } else if (Magazine.TYPE.equals(type)) {
            createMagazin(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji " + type);
    }

    private Magazine createMagazin(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];

        return new Magazine(title, publisher, language, year, month, day);
    }

    private Book createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];

        return new Book(title, author, year, pages, publisher, isbn);
    }

    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        File file;
        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Blad zapisu danych do pliku" + FILE_NAME);
        }
    }
}
