package pl.swiokloarkadiusz.library.io.file;

import pl.swiokloarkadiusz.library.exeption.NoSuchFileTypeException;
import pl.swiokloarkadiusz.library.io.ConsolePrinter;
import pl.swiokloarkadiusz.library.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build() {
        printer.printLine("Wybierz format danych:");
        FileType fileType = getFileType();
        switch (fileType){
            case SERIAL:
                return new SerializableFileManager();
            case CSV:
                return new CSVFileManager();
            default:
                throw new NoSuchFileTypeException("Nieoslugiwany typ danych");
        }
    }

    private FileType getFileType() {
        boolean typeOk = false;
        FileType result = null;
        do {
            printTypes();
            String type = reader.getString().toUpperCase();
        try {
             result = FileType.valueOf(type);
             typeOk = true;
        }catch (IllegalArgumentException e){
            printer.printLine("Nieoblusgiwany typ danych, wybierz ponownie.");
        }
        }while (!typeOk);
        return result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());
        }
    }
}
