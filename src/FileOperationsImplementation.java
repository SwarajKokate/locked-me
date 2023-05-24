import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileOperationsImplementation implements FileOperations {

    private static boolean createMainFolderIfNotExist() {
        File file = new File("main");

        if(!file.exists()) {
            file.mkdirs();
            return true;
        }

        return false;
    }

    private static boolean checkIfFileExists(Path filePath) {
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

    @Override
    public String searchFile(String fileName) {
        List<String> fileLocations = new ArrayList<>();
        getAbsoluteFilePath("main", fileName, fileLocations);

        if(!fileLocations.isEmpty()) {
           return "File " + fileName + "found at " + fileLocations;
        } else {
            return "File with name " + fileName + " not found";
        }

    }

    @Override
    public String displayFiles(boolean sortingEnabled) {
        if(sortingEnabled == true) {
            File file = new File("main");
            List<File> files = Arrays.asList(file.listFiles());
            Collections.sort(files);
            return "Files in main directory in ascending order :" + files;
        } else {
            File file = new File("main");
            List<File> files = Arrays.asList(file.listFiles());
            return "Files in main directory :" + files;
        }
    }

    private void getAbsoluteFilePath(String path, String fileName, List<String> fileLocations) {
        File file = new File(path);
        List<File> fileList = Arrays.asList(file.listFiles());

        if(!fileList.isEmpty() && fileList != null) {
            for(File indexFile : fileList) {
                if(indexFile.getName().equals(fileName)) {
                    fileLocations.add(indexFile.getAbsolutePath());
                }
            }
        }
    }

}
