package util;

import screens.MainScreen;
import service.FileOperations;
import service.implementation.FileOperationsImplementation;

import java.util.List;
import java.util.Scanner;

/**
 * A class to handle user-option input
 *
 * @author Swaraj Kokate
 */
public class HandleMenuOptions {

    static String output;

    public static void handleWelcomeScreenInput() {
        FileOperations fileOperations = new FileOperationsImplementation();

        boolean executionStatus = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                MainScreen.displayMenu();
                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        output = fileOperations.displayFiles(true);
                        System.out.println(output);
                        break;
                    case 2:
                        handleFileMenuOptions();
                        break;
                    case 3:
                        System.out.println("Program exited successfully.");
                        executionStatus = false;
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please select a valid option from above.");
                }
            } catch (Exception e) {
                System.out.println(e.getClass().getName());
                handleWelcomeScreenInput();
            }
        } while (executionStatus == true);
    }

    public static void handleFileMenuOptions() {
        FileOperations fileOperations = new FileOperationsImplementation();

        boolean executionStatus = true;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                MainScreen.displayFileMenuOptions();
                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        // File Add
                        System.out.println("Enter the name of the file to be added to the \"main\" folder");
                        String fileToAdd = scanner.next();

                        output = fileOperations.addFile(fileToAdd);
                        System.out.println(output);

                        break;
                    case 2:
                        // File delete
                        output = fileOperations.displayFiles(false);
                        System.out.println(output);

                        if(!output.equals("The folder is empty !!")) {
                            System.out.println("Enter the name of the file to be deleted from \"main\" folder");
                            String fileToDelete = scanner.next();

                            output = fileOperations.deleteFile(fileToDelete);
                            System.out.println(output);
                        }

                        break;
                    case 3:
                        // File Search
                        System.out.println("Enter the name of the file to be searched from \"main\" folder");
                        String fileName = scanner.next();

                        output = fileOperations.searchFile(fileName);
                        System.out.println(output);
                        break;
                    case 4:
                        // Go to Previous menu
                        return;
                    default:
                        System.out.println("Please select a valid option from above.");
                }
            } catch (Exception e) {
                System.out.println(e.getClass().getName());
                handleFileMenuOptions();
            }
        } while (executionStatus == true);
    }

}
