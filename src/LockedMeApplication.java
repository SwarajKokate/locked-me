public class LockedMeApplication {

    public static void main(String[] args) {
        FileOperationsImplementation fileOperationsImplementation = new FileOperationsImplementation();
        String output = fileOperationsImplementation.addFile("A.txt");
        System.out.println(output);
    }

}
