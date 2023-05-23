public class LockedMeApplication {

    public static void main(String[] args) {
        FileOperationsImplementation fileOperationsImplementation = new FileOperationsImplementation();
        String output = null;
        output = fileOperationsImplementation.addFile("C.txt");
        System.out.println(output);
        output = fileOperationsImplementation.deleteFile("C.txt");
        System.out.println(output);

    }

}
