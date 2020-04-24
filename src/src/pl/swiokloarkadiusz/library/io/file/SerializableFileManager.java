package pl.swiokloarkadiusz.library.io.file;


import pl.swiokloarkadiusz.library.exeption.DataExportException;
import pl.swiokloarkadiusz.library.exeption.DataImportException;
import pl.swiokloarkadiusz.library.model.Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableFileManager implements FileManager {
    public static final String FILE_NAME = "Library.o";

    @Override
    public void exportData(Library library) {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("blad zapisu danych do pliku " + FILE_NAME);
        }
    }

    @Override
    public Library importData() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Library) ois.readObject();
        } catch(FileNotFoundException e) {
            throw new DataImportException("brak pliku " + FILE_NAME);
        }catch (IOException e){
            throw new DataImportException("bral odczytu pliku "+FILE_NAME);
        } catch(ClassNotFoundException e){
            throw new DataImportException("Niezgodny typ danych w pliku "+FILE_NAME);
        }
    }
}
