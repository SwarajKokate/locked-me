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

    @Override
    public String addFile(String fileName) {
        FileOperationsImplementation.createMainFolderIfNotExist();
        Path filePath = Path.of("./main/" + fileName);

        try {
            File file = new File(String.valueOf(filePath));

            if(file.exists()) {
                return "File " + fileName + " already exists";
            } else {
                Files.createFile(filePath);
                return "File " + fileName + "created successfully";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
