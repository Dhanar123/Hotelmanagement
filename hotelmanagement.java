import java.util.Scanner;

class Room {
    String customerName;
    boolean isBooked;

    Room() {
        this.customerName = "";
        this.isBooked = false;
    }
}

public class HotelManagement {
    static Room[] rooms = new Room[5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room();
        }

        int choice;
        do {
            System.out.println("\n🏨 Hotel Management System");
            System.out.println("1. Show Room Status");
            System.out.println("2. Book a Room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    checkoutRoom();
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void showRooms() {
        System.out.println("\nRoom Status:");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room " + (i + 1) + ": " + 
                (rooms[i].isBooked ? "Booked by " + rooms[i].customerName : "Available"));
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number (1-5): ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        if (roomNo < 1 || roomNo > 5) {
            System.out.println("Invalid room number!");
            return;
        }

        if (rooms[roomNo - 1].isBooked) {
            System.out.println("Room already booked!");
        } else {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            rooms[roomNo - 1].customerName = name;
            rooms[roomNo - 1].isBooked = true;
            System.out.println("Room booked successfully!");
        }
    }

    static void checkoutRoom() {
        System.out.print("Enter room number to checkout (1-5): ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        if (roomNo < 1 || roomNo > 5) {
            System.out.println("Invalid room number!");
            return;
        }

        if (!rooms[roomNo - 1].isBooked) {
            System.out.println("Room is not booked!");
        } else {
            rooms[roomNo - 1].customerName = "";
            rooms[roomNo - 1].isBooked = false;
            System.out.println("Checked out successfully!");
        }
    }
}
