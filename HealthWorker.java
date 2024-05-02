import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HealthWorker extends Person {
    private long healthWorkerID;

    public HealthWorker(long ID) {
        this.healthWorkerID = ID;
    }

    public HealthWorker() {}

    public long getHealthWorkerID() {
        return healthWorkerID;
    }

    public void setHealthWorkerID(long healthWorkerID) {
        this.healthWorkerID = healthWorkerID;
    }

    public boolean setNewSpecialist() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new specialist's name:");
        String newName = input.nextLine();

        System.out.println("Enter new specialist's type:");
        String newType = input.nextLine();

        System.out.println("Enter new specialist's password:");
        String newPassword = input.nextLine();

        System.out.println("Enter new Specialists ID");
        Long newID = input.nextLong();


        try {
            FileWriter writer = new FileWriter("Password.txt", true);
            writer.write(newID + "," + newPassword + "\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");

            try {
                FileWriter writers = new FileWriter("Specialists.txt", true);
                writers.write(newID + "," + newPassword +  "," + newName + "," + newType +"\n");
                writers.close();
                System.out.println("Successfully wrote to the file.");
                return true;
            } catch (IOException ex) {
                System.out.println("An error occurred while writing Specialists.txt: " + ex.getMessage());
                return false;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing Password.txt: " + e.getMessage());
            return false;
        }


    }

    public static void displayAppointments(){
        
    }
}
