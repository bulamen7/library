package pl.swiokloarkadiusz.io.file;

import pl.swiokloarkadiusz.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}