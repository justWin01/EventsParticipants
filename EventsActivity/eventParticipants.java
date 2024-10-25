package EventsActivity;

import java.util.*;
import java.lang.Exception;

// Custom Exceptions

/*class NameRestrictionException extends Exception {
    public NameRestrictionException(String message) {
        super(message);
    }
}*/

class AgeRestrictionException extends Exception {
    public AgeRestrictionException(String message) {
        super(message);
    }
}

// Duplicating if pareha ang name sa gi input sa user
class DuplicateRegistrationException extends Exception {
    public DuplicateRegistrationException(String message) {
        super(message);
    }
}

// Main Class
public class eventParticipants {
    static Scanner sc = new Scanner(System.in);
    static List<Participants> list = new ArrayList<>();
    static int MaximumParticipants = 2;

    // 30: Black [] 31: Red [] 32: Green [] 33: Yellow [] 34: Blue [] 35: Magenta
    // []36: Cyan []37: White
    static String EP_YELLOW = "\u001B[33m" + "\u001B[1m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String reset = "\u001B[0m"; // Reset na niya ang dating color

    public static void main(String[] args) {
        while (true) {
            try {
                switch (dashboard()) {
                    case 1:
                        addParticipants();
                        break;
                    case 2:
                        displayAllParticipants();
                        break;
                    default:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("-----------------------------------------------");
                System.out.println("Invalid input. Please enter a number.");
                System.out.println("-----------------------------------------------");
                sc.nextLine(); // i clear ang na invalid
            } catch (AgeRestrictionException | DuplicateRegistrationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // dashboar
    public static int dashboard() {
        System.out.println(EP_YELLOW + "\t\t\tEvent Participants" + reset);
        System.out.println("[1] Add Participants");
        System.out.println("[2] Display All 18 y/o Above Participants");
        System.out.println("----------------------------------------------");
        System.out.print("Please Enter a number: ");
        return sc.nextInt();
    }

    // age duplicate error //name duplicate error
    public static void addParticipants() throws AgeRestrictionException, DuplicateRegistrationException {
        if (list.size() >= MaximumParticipants) {
            System.out.println(
                    RED + "Cannot add participant: maximum limit reached (" + MaximumParticipants + ")." + reset);
            System.out.println("-----------------------------------------------------");
            return;
        }

        sc.nextLine(); // i nextline
        System.out.print("Enter a Fullname: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // i next line
        System.out.println("-------------------------------------------------------------");

        if (age < 18) {
            throw new AgeRestrictionException(
                    RED + "Participant cannot be added because they are under 18\n---------------------------------------------"
                            + reset);
        }

        // Check for duplicate registration
        for (Participants participant : list) {
            if (participant.getName() == name && participant.getAge() == age) {
                throw new DuplicateRegistrationException(EP_YELLOW + "Participant is already registered." + reset);
            }
        }

        list.add(new Participants(name, age));
        System.out.println(GREEN + "\nParticipant added.\n" + reset);
        System.out.print("--------------------------------------------------\n");
        System.out.println(EP_YELLOW + "Participant is 18 y/o above." + reset);
        System.out.println("---------------------------------------------------\n");
    }

    public static void displayAllParticipants() {
        System.out.println("Participants (18 and older)LIST:");
        boolean hasEligible = false;

        for (Participants participant : list) {
            if (participant.getAge() >= 18) {
                System.out.println("Name: " + participant.getName() + ", Age: " + participant.getAge());
                hasEligible = true;
            }
        }

        if (!hasEligible) {
            System.out.println("No 18 y/o or above participants.\n");
        } else {
            System.out.println();
        }
    }

    public static class Participants {
        String name;
        int age;

        public Participants(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
