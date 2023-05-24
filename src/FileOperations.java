public interface FileOperations {

    String addFile(String fileName);

    String deleteFile(String fileName);

    String searchFile(String fileName);

    String displayFiles(boolean sortingEnabled);
}
