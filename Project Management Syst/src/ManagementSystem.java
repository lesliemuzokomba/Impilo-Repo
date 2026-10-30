import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ManagementSystem {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("****** Management System******");

        System.out.print("Title (Mr/Mrs/Miss): ");
        String Title = scanner.nextLine();

        System.out.print("Forename: ");
        String Forename = scanner.nextLine();

        System.out.print("Surname: ");
        String Surname = scanner.nextLine();

        System.out.print("Address: ");
        String Address = scanner.nextLine();

        System.out.print("First Phone Number: ");
        String Tel1 = scanner.nextLine();

        System.out.print("Second Phone Number :mr");
        String Tel2 = scanner.nextLine();

        System.out.print("Date Of Birth (Format: dd-MM-yyyy): ");
        String DOB = scanner.nextLine();

        LocalDate dateOfBirth = LocalDate.parse(DOB, formatter);

        System.out.println("\n--- Processing Registration... ---");

        String patientInfo = createPatientData(Forename, Surname, Address, Tel1, Tel2, dateOfBirth, Title);

        System.out.println(patientInfo);

        scanner.close();
    }
    public static String createPatientData(String Forename, String Surname, String address,
                                           String Tel1, String Tel2, LocalDate dob, String Title) {
        int age = 0;
        if (dob != null) {
            age = Period.between(dob, LocalDate.now()).getYears();
        }
        return "Patient " + Forename + " " + Surname + " , who is " + age + " old .";
    }
}