import java.util.*;

public class eventParticipants {
    static Scanner sc = new Scanner(System.in);
    static List<Participants> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            switch (dashboard()) {
                case 1:
                    addParticipants();
                    break;
                case 2:
                    displayAllParticipants();
                    break;
                default:
                    System.out.println("Exiting the program.");
                    return;
            }
        }
    }

    public static int dashboard() {
        System.out.println("EventParticipants");
        System.out.println("[1] Add Participants: ");
        System.out.println("[2] Display All 18 y/o above Participants: ");
        System.out.print("Please Enter a number: ");
        return sc.nextInt();
    }

    public static void addParticipants() {
        sc.nextLine();
        System.out.print("Enter a Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age >= 18) {
            list.add(new Participants(name, age));
            System.out.println("Participant added.\n");
            System.out.println("Participant is 18 y/o above.");
        } else {
            System.out.println("Participant cannot be added because they are under 18.\n");
        }
    }

    public static void displayAllParticipants() {
        System.out.println(" Participants (18 and older):");
        boolean hasEligible = false;

        for (Participants participant : list) {
            if (participant.getAge() >= 18) {
                System.out.println("Name: " + participant.getName() + ", Age: " + participant.getAge());
                hasEligible = true;
            }
        }

        if (!hasEligible) {
            System.out.println("No 18 y/o above participants.\n");
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

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
