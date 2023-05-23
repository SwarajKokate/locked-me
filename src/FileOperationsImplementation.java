import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperationsImplementation implements FileOperations {

    public static boolean createMainFolderIfNotExist() {
        File file = new File("main");

        if(!file.exists()) {
            file.mkdirs();
            return true;
        }

        return false;
    }

    public static boolean checkIfFileExists(Path filePath) {
        FileOperationsImplementation.createMainFolderIfNotExist();

        return Files.exists(filePath);
    }

    @Override
    public String addFile(String fileName) {
        boolean fileExists = FileOperationsImplementation.checkIfFileExists(Path.of("./main/" + fileName));

        try {
            if(fileExists) {
                return "File " + fileName + " already exists";
            } else {
                Files.createFile(Path.of("./main/" + fileName));
                return "File " + fileName + "created successfully";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String deleteFile(String fileName) {
        try {
               boolean fileDeleted = Files.deleteIfExists(Path.of("./main/" + fileName));
                return (fileDeleted) ? "File " + fileName + " deleted successfully!!" : "File " + fileName + " does not exists";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
