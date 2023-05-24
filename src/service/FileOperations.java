package service;

/**
 * This interface provides a prototype for the application
 *
 * @author Swaraj Kokate
 */

public interface FileOperations {

    String addFile(String fileName);

    String deleteFile(String fileName);

    String searchFile(String fileName);

    String displayFiles(boolean sortingEnabled);
}
