import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import java.util.InputMismatchException;

public class AshCare {
    public static void main(String[] args) {
        String choice;
        String choice_1;
        String choice_2;
        String choice_3;
        long healthWorkerID = 0;
        String healthWorkerPassword;
        String specialistPassword;
        long specialistID = 0;
        long studentID = 0;
        String yesOrNo;
        Scanner input = new Scanner(System.in);
        Passwords password = new Passwords();
        HealthWorker healthworker = new HealthWorker();
        Appointment appointment = new Appointment();
        Specialist specialist = new Specialist();
        Student student = new Student();
        System.out.println("********************");
        System.out.println("WELCOME TO ASHCARE!");
        System.out.println("Enter your identity(1/2/3)");
        System.out.println("1.Health Worker");
        System.out.println("2.Specialist");
        System.out.println("3.Student");
        System.out.println("********************");
        choice = input.nextLine();
        ensureIntEntry(choice);
        int choices = Integer.parseInt(choice);
        switch (choices) {
            case 1: // healthWorker
                clearScreen();
                System.out.println("**********************************************");
                System.out.println("                   ASHCARE                    ");
                System.out.println("********************LOGIN*********************");
                System.out.println("Create a new account(yes/no)");
                yesOrNo = input.nextLine();
                checkYesOrNo(yesOrNo);
                // input.nextLine();
                if (yesOrNo.equalsIgnoreCase("yes")) {
                    password.setPassword();
                } else if (yesOrNo.equalsIgnoreCase("no")) {
                    System.out.println("Kindly enter your ID");
                    try {
                        healthWorkerID = input.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID entry, can only accept numbers");
                        System.exit(2);
                    }
                    input.nextLine();

                    System.out.println("Will you like to change your password(yes/no)");
                    yesOrNo = input.nextLine();
                    checkYesOrNo(yesOrNo);
                    if (yesOrNo.equalsIgnoreCase("yes")) {
                        password.changePassword(healthWorkerID);
                    } else if (yesOrNo.equalsIgnoreCase("no")) {
                        System.out.println("Kindly enter your password");
                        healthWorkerPassword = input.nextLine();
                        password.checkPasswordAndExit(healthWorkerID, healthWorkerPassword);
                    }
                }
                // while (true) { // while loop begins
                System.out.println("**********************************************");
                clearScreen();
                System.out.println("**********************************************");
                System.out.println("                   ASHCARE                    ");
                System.out.println("**********************************************");
                System.out.println("What do you want to do?");
                System.out.println("1.Create an account for a new specialist");
                System.out.println("2.Display all appointments");
                System.out.println("3.Exit");
                System.out.println("**********************************************");
                choice_1 = input.nextLine();
                ensureIntEntry(choice_1);
                int choices_1 = Integer.parseInt(choice_1);

                if (choices_1 == 1) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    System.out.println("**********************************************");
                    healthworker.setNewSpecialist();
                    System.out.println("**********************************************");
                } else if (choices_1 == 2) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    System.out.println("**********************************************");
                    appointment.displayAppointments();
                    System.out.println("**********************************************");
                } else if (choices_1 == 3) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("         THANK YOU FOR USING ASHCARE          ");
                    System.out.println("**********************************************");
                    System.exit(1);
                }
                 break;
                // }

            case 2: // specialist
                clearScreen();
                System.out.println("**********************************************");
                System.out.println("                   ASHCARE                    ");
                System.out.println("********************LOGIN*********************");
                System.out.println("Kindly enter your ID");
                try {
                    specialistID = input.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid ID entry, can only accept numbers");
                    System.exit(2);
                }
                // password.checkIDAndExit(specialistID);
                input.nextLine();

                System.out.println("Will you like to change your password(yes/no)");
                yesOrNo = input.nextLine();
                checkYesOrNo(yesOrNo);
                if (yesOrNo.equalsIgnoreCase("yes")) {
                    password.changePassword(specialistID);
                } else if (yesOrNo.equalsIgnoreCase("no")) {
                    System.out.println("Kindly enter your password");
                    specialistPassword = input.nextLine();
                    password.checkPasswordAndExit(specialistID, specialistPassword);
                }

                System.out.println("**********************************************");
                clearScreen();
                System.out.println("**********************************************");
                System.out.println("                   ASHCARE                    ");
                System.out.println("**********************************************");
                System.out.println("What do you want to do?");
                System.out.println("1.Create appointment schedules");
                System.out.println("2.Display all appointments");
                System.out.println("3.Exit");
                System.out.println("**********************************************");
                choice_2 = input.nextLine();
                ensureIntEntry(choice_2);
                int choices_2 = Integer.parseInt(choice_2);

                if (choices_2 == 1) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    System.out.println("**********************************************");
                    System.out.println("Kindly enter date of availability in the form yyyy-mm-dd");
                    String date = input.nextLine();
                    specialist.setSpecialistAvailability(specialistID, date);
                    System.out.println("**********************************************");
                } else if (choices_2 == 2) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    appointment.displayAppointments();
                    System.out.println("**********************************************");
                } else if (choices_2 == 3) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("         THANK YOU FOR USING ASHCARE          ");
                    System.out.println("**********************************************");
                    System.exit(1);
                }
                 break;
            case 3: // student
                clearScreen();
                System.out.println("**********************************************");
                System.out.println("                   ASHCARE                    ");
                System.out.println("********************LOGIN*********************");
                System.out.println();
                System.out.println("Kindly enter your ID");
                try {
                    studentID = input.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid ID entry, can only accept numbers");
                    System.exit(2);
                }
                // password.checkIDAndExit(studentID);
                input.nextLine();
                System.out.println("**********************************************");
                clearScreen();
                System.out.println("**********************************************");
                System.out.println("                   ASHCARE                    ");
                System.out.println("**********************************************");
                System.out.println("What do you want to do?");
                System.out.println("1.Book a specialist");
                System.out.println("2.Reschedule an appointment");
                System.out.println("2.Cancel an appointment");
                System.out.println("3.Exit");
                System.out.println("**********************************************");
                choice_3 = input.nextLine();
                ensureIntEntry(choice_3);
                int choices_3 = Integer.parseInt(choice_3);

                if (choices_3 == 1) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    System.out.println("**********************************************");
                    System.out.println("Have a look at the current appointment schedules");
                    appointment.displayAppointments();
                    System.out.println("Kindly enter the date you want an appointment (yyyy-mm-dd)");
                    String date = input.nextLine();
                    System.out.println("Kindly enter preferred time (hh:mm)");
                    String time = input.nextLine();
                    System.out.println("Kindly enter the name of the specialist you want to meet");
                    String specialistName = input.nextLine();
                    System.out.println("Kindly enter the type of specialist he or she is");
                    String type = input.nextLine();
                    System.out.println("Kindly enter your name");
                    String name = input.nextLine();
                    System.out.println("**********************************************");
                    student.bookAppointment(date, time, specialistName, name, type);
                } else if (choices_3 == 2) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    System.out.println("Have a look at the current appointment schedules");
                    appointment.displayAppointments();
                    System.out.println("Kindly enter the date you want an appointment (yyyy-mm-dd)");
                    String date = input.nextLine();
                    System.out.println("Kindly enter preferred time (hh:mm)");
                    String time = input.nextLine();
                    System.out.println("Kindly enter the name of the specialist you want to meet");
                    String specialistName = input.nextLine();
                    System.out.println("Kindly enter the type of specialist he or she is");
                    String type = input.nextLine();
                    System.out.println("Kindly enter your name");
                    String name = input.nextLine();
                    student.rescheduleAppointment(date, time, specialistName, name, type);
                    System.out.println("**********************************************");
                } else if (choices_3 == 3) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("                   ASHCARE                    ");
                    System.out.println("Have a look at the current appointment schedules");
                    appointment.displayAppointments();
                    System.out.println("Kindly enter the date you want an appointment (yyyy-mm-dd)");
                    String date = input.nextLine();

                    if (!validDateFormat(date)) {
                        System.out.println("Invalid format for the date, try again (yyyy-mm-dd)");
                    }

                    else {
                        System.out.println("Kindly enter preferred time (hh:mm)");
                        String time = input.nextLine();
                        System.out.println("Kindly enter the name of the specialist you want to meet");
                        String specialistName = input.nextLine();
                        System.out.println("Kindly enter the type of specialist he or she is");
                        String type = input.nextLine();
                        System.out.println("Kindly enter your name");
                        String name = input.nextLine();
                        student.cancelAppointment(date, time, specialistName, name, type);
                        System.out.println("**********************************************");
                    }
                } else if (choices_3 == 4) {
                    clearScreen();
                    System.out.println("**********************************************");
                    System.out.println("         THANK YOU FOR USING ASHCARE          ");
                    System.out.println("**********************************************");
                    System.exit(1);
                }
                 break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void clearScreen() {
        System.out.print("\033c");
        System.out.flush();
    }

    public static void ensureIntEntry(String choice) {
        if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")&& !choice.equals("4")) {
            System.out.println("Invalid input, exiting");
            System.exit(0);
        }
    }

    public static void checkYesOrNo(String input) {
        if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
            System.out.println("Invalid Input. Exiting...");
            System.exit(1);
        }
    }

    public static boolean validDateFormat(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
