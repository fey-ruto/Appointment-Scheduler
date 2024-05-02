import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Passwords {
    private Scanner input;

    public Passwords() {
        input = new Scanner(System.in);
    }

    public boolean setPassword() {
        long newID = 0;
        System.out.println("What is your ID?");
        try {
            newID = input.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID entry, exiting");
            System.exit(0);
        }
        input.nextLine();

        System.out.println("What is your password?");
        String newPassword = input.nextLine();

        try {
            FileWriter writer = new FileWriter("Password.txt", true);
            writer.write(newID + "," + newPassword + "\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean checkID(long searchID) {
        try {
            File myObj = new File("Password.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] identity = myReader.nextLine().split(",");
                long theID = Long.parseLong(identity[0]);
                if (theID == searchID) {
                    myReader.close();
                    return true;
                }
            }
            myReader.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void checkIDAndExit(long searchID) {
        if (!checkID(searchID)) {
            System.out.println("ID not found. Exiting program.");
            System.exit(0);
        }
    }

    public boolean checkPassword(long searchID, String password) {
        try {
            File myObj = new File("Password.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] identity = myReader.nextLine().split(",");
                long theID = Long.parseLong(identity[0]);
                String thePassword = identity[1];
                if (theID == searchID && password.equals(thePassword)) {
                    myReader.close();
                    return true; // Password matches
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // Password does not match or ID not found
    }

    public void checkPasswordAndExit(long searchID, String password) {
        if (!checkPassword( searchID, password)) {
            System.out.println("Wrong Password");
            System.exit(0);
        }
    }

    public boolean changePassword(long searchID){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new password");
        String newPassword = input.nextLine();

        try {
            File myObj = new File("Password.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> fileContent = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] identity = line.split(",");
                if (identity.length == 2 && identity[0].equals(String.valueOf(searchID))) {
                    fileContent.add(identity[0] + "," + newPassword);
                } else {
                    fileContent.add(line);
                }
            }
            myReader.close();

            FileWriter writer = new FileWriter("Password.txt", false);
            System.out.println("\n");
            for (String line : fileContent) {
                writer.write(line + "\n");
            }
            writer.close();

            System.out.println("Successfully wrote to the file.");
            return true;

        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
