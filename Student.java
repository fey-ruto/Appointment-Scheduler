import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    Appointment appointment = new Appointment();
    private int studentID;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void bookAppointment(String date, String time, String specialistName, String studentName, String type) {
        try {
            File file = new File("Appointments.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> appointmentList = new ArrayList<>();

            // Read appointments into ArrayList
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                appointmentList.add(line);
            }
            scanner.close();

            // Check if the appointment slot is available
            boolean appointmentBooked = false;
            for (int i = 0; i < appointmentList.size(); i++) {
                String[] appointmentData = appointmentList.get(i).split(",");
                if (appointmentData[0].equals(date) && appointmentData[1].equals(specialistName) && appointmentData[2].equals(type)) {
                    for (int j = 3; j < appointmentData.length; j++) {
                        String[] timeAndStatus = appointmentData[j].split("-");
                        if (timeAndStatus[0].equals(time) && timeAndStatus[1].equals("empty")) {
                    
                            appointmentData[j] = time + "-" + studentName;
                            appointmentList.set(i, String.join(",", appointmentData));
                            appointmentBooked = true;
                            break;
                        }
                    }
                }
                if (appointmentBooked) {
                    break;
                }
            }

            // Write updated appointments back to file
            FileWriter writer = new FileWriter("Appointments.txt");
            for (String line : appointmentList) {
                writer.write(line + "\n");
            }
            writer.close();

            if (appointmentBooked) {
                System.out.println("Appointment booked successfully.");
            } else {
                System.out.println("Failed to book appointment. The slot may be already taken or doesn't exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while booking the appointment.");
            e.printStackTrace();
        }
    }

    public void rescheduleAppointment(String date, String time, String specialistName, String studentName, String type) {
        try {
            File file = new File("Appointments.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> appointmentList = new ArrayList<>();

            // Read appointments into ArrayList
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                appointmentList.add(line);
            }
            scanner.close();


            // Check if the appointment slot is available
            boolean appointmentRescheduled = false;
            for (int i = 0; i < appointmentList.size(); i++) {
                String[] appointmentData = appointmentList.get(i).split(",");
                if (appointmentData[0].equals(date) && appointmentData[1].equals(specialistName) && appointmentData[2].equals(type)) {
                    for (int j = 3; j < appointmentData.length; j++) {
                        String[] timeAndStatus = appointmentData[j].split("-");
                        if (timeAndStatus[0].equals(time) && !timeAndStatus[1].equals("empty") && timeAndStatus[1].equals(studentName)) {
                            appointmentData[j] = time + "-" + studentName;
                            appointmentList.set(i, String.join(",", appointmentData));
                            appointmentRescheduled = true;
                            break;
                        }
                    }
                }
                if (appointmentRescheduled) {
                    break;
                }
            }

            // Write updated appointments back to file
            FileWriter writer = new FileWriter("Specialists.txt");
            for (String line : appointmentList) {
                writer.write(line + "\n");
            }
            writer.close();

            if (appointmentRescheduled) {
                System.out.println("Appointment rescheduled successfully.");
            } else {
                System.out.println("Failed to reschedule appointment. The slot may be already taken by another student or doesn't exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while rescheduling the appointment.");
            e.printStackTrace();
        }
    }

    public void cancelAppointment(String date, String time, String specialistName, String studentName, String type) {
        try {
            File file = new File("Appointments.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> appointmentList = new ArrayList<>();

            // Read appointments into ArrayList
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                appointmentList.add(line);
            }
            scanner.close();


            // Check if the appointment exists and cancel it
            boolean appointmentCancelled = false;
            for (int i = 0; i < appointmentList.size(); i++) {
                String[] appointmentData = appointmentList.get(i).split(",");
                if (appointmentData[0].equals(date) && appointmentData[1].equals(specialistName) && appointmentData[2].equals(type)) {
                    for (int j = 3; j < appointmentData.length; j++) {
                        String[] timeAndStatus = appointmentData[j].split("-");
                        if (timeAndStatus[0].equals(time) && timeAndStatus[1].equals(studentName)) {
                            // Cancel the appointment by setting status to "empty"
                            appointmentData[j] = time + "-empty";
                            appointmentList.set(i, String.join(",", appointmentData));
                            appointmentCancelled = true;
                            break;
                        }
                    }
                }
                if (appointmentCancelled) {
                    break;
                }
            }

            // Write updated appointments back to file
            FileWriter writer = new FileWriter("Appointments.txt");
            for (String line : appointmentList) {
                writer.write(line + "\n");
            }
            writer.close();

            if (appointmentCancelled) {
                System.out.println("Appointment cancelled successfully.");
            } else {
                System.out.println("Failed to cancel appointment. The specified appointment may not exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while cancelling the appointment.");
            e.printStackTrace();
        }
    }





}