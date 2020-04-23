package pl.swiokloarkadiusz.library.io.file;

import pl.swiokloarkadiusz.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
