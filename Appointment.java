import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Appointment {
    //private ArrayList<AppointmentSlot> appointmentSlots;

    Specialist specialist = new Specialist();

    public Appointment() {
        //appointmentSlots = new ArrayList<>();
    }

    // Method to set availability for a specialist


    public void displayAppointments() {
        try {
            File file = new File("Appointments.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] appointmentData = line.split(",");

                // Assuming the format is: date, name, type, time1-empty, time2-empty, ...
                if (appointmentData.length >= 3) {
                    String date = appointmentData[0];
                    String name = appointmentData[1];
                    String type = appointmentData[2];
                    System.out.println("Date: " + date);
                    System.out.println("Name: " + name);
                    System.out.println("Type: " + type);

                    // Display appointment times and status
                    for (int i = 3; i < appointmentData.length; i++) {
                        String[] timeAndStatus = appointmentData[i].split("-");
                        String time = timeAndStatus[0];
                        String status = timeAndStatus[1];
                        System.out.println("Time: " + time);
                        System.out.println("Status: " + status);
                    }

                    System.out.println();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the appointments.");
            e.printStackTrace();
        }
    }

}
