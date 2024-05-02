import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Specialist extends HealthWorker {

    public Specialist(){}

    public String getSpecialistName(Long ID){
        String theID = ""+ID;
        String specialistName= "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Specialists.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] specialistData = line.split(",");
                if(specialistData[0].equals(theID)){
                    specialistName = specialistData[2];
                }


            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading specialists: " + e.getMessage());
        }
        return specialistName;
    }

    public String getSpecialistType(Long ID){
        String theID = ""+ID;
        String specialistType= "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Specialists.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] specialistData = line.split(",");
                if(specialistData[0].equals(theID)){
                    specialistType = specialistData[2];
                }


            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading specialists: " + e.getMessage());
        }
        return specialistType;
    }

    public void setSpecialistAvailability(long specialistID, String date) {
        Scanner scanner = new Scanner(System.in);
        String availability;
        StringBuilder availabilityData = new StringBuilder();

        try {
            // Open file for appending
            FileWriter writer = new FileWriter("Appointments.txt", true);

            // Write specialist data
            writer.write(date);
            writer.write("," + getSpecialistName(specialistID));
            writer.write("," + getSpecialistType(specialistID));
            writer.write(",");

            // Prompt for availability input
            System.out.println("Enter availability for " + getSpecialistName(specialistID) + " (Enter 'done' to finish):");
            while (true) {
                availability = scanner.nextLine();
                if (availability.equalsIgnoreCase("done")) {
                    break;
                }
                availabilityData.append(availability).append("-empty").append(",");
            }

            writer.write(availabilityData.toString());
            writer.write("\n");

            // Close file
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }




}
