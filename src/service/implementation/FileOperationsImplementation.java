package service.implementation;

import service.FileOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of FileOperations interface
 *
 * @author Swaraj Kokate
 */
public class FileOperationsImplementation implements FileOperations {

    /**
     * A method used to create main directory
     * @return created or not
     */
    private static boolean createMainFolderIfNotExist() {
        File file = new File("main");

        if(!file.exists()) {
            file.mkdirs();
            return true;
        }

        return false;
    }

    /**
     * A method to check whether file exists or not
     *
     * @param filePath
     * @return file exists or not
     */
    private static boolean checkIfFileExists(Path filePath) {
        FileOperationsImplementation.createMainFolderIfNotExist();

        return Files.exists(filePath);
    }

    /**
     * A method to create user-specified file
     *
     * @param fileName
     * @return output
     */
    @Override
    public String addFile(String fileName) {
        boolean fileExists = FileOperationsImplementation.checkIfFileExists(Path.of("./main/" + fileName));

        try {
            if(fileExists) {
                return "File " + fileName + " already exists";
            } else {
                Files.createFile(Path.of("./main/" + fileName));
                return "File " + fileName + " created successfully";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * A method to delete user-specified file
     *
     * @param fileName
     * @return output
     */
    @Override
    public String deleteFile(String fileName) {
        createMainFolderIfNotExist();

        try {
               boolean fileDeleted = Files.deleteIfExists(Path.of("./main/" + fileName));
                return (fileDeleted) ? "File " + fileName + " deleted successfully!!" : "File " + fileName + " does not exists";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * A method to search user-specified file
     *
     * @param fileName
     * @return output
     */
    @Override
    public String searchFile(String fileName) {
        createMainFolderIfNotExist();

        List<String> fileLocations = new ArrayList<>();
        getAbsoluteFilePath("main", fileName, fileLocations);

        if(!fileLocations.isEmpty()) {
           return "File " + fileName + "found at :" + "\n" + fileLocations;
        } else {
            return "File with name " + fileName + " not found";
        }

    }

    /**
     * A method to display files in both sorted and unsorted order
     *
     * @param sortingEnabled
     * @return output
     */
    @Override
    public String displayFiles(boolean sortingEnabled) {
        createMainFolderIfNotExist();

        File file = new File("main");
        List<File> files = Arrays.asList(file.listFiles());

        if(!files.isEmpty() && files != null) {
            if (sortingEnabled) {
                Collections.sort(files);
                return "Files in main directory in ascending order :" + "\n" + files;
            } else {
                return "Files in main directory :" + "\n" + files;
            }
        } else {
            return "The folder is empty !!";
        }
    }

    /**
     * A method to retrieve absolute file paths for the files created
     *
     * @param path
     * @param fileName
     * @param fileLocations
     */
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
