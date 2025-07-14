import java.util.Scanner;

public class ElevatorSim {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(1); // Start at floor 1
        Scanner scanner = new Scanner(System.in);
        boolean isInsideElevator = false;

        System.out.println("\n Elevator Simulation");
        printHelp();

        while (true) {
            System.out.print("\nEnter command (H for help): ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "E": // request made from outside of elevator
                    if (isInsideElevator) {
                        System.out.println("Cannot make an external request from inside the elevator.");
                        break;
                    }

                    System.out.print("Enter floor number (1–20): ");
                    int floor = readFloor(scanner);
                    elevator.addRequest(floor);
                    System.out.println("External request added for floor " + floor);
                    break;

                case "I": // request made from inside elevator
                    isInsideElevator = true;

                    System.out.print("Enter floor number to go to (1–20): ");
                    int internalFloor = readFloor(scanner);
                    elevator.addRequest(internalFloor);
                    System.out.println("Internal request added for floor " + internalFloor);
                    break;

                case "P": // Process next move
                    elevator.processNextRequest();

                    // Reset inside flag if no more requests are pending
                    if (!elevator.hasRequests()) {
                        isInsideElevator = false;
                    }
                    break;

                case "S": // Status
                    System.out.println("Current floor: " + elevator.getCurrentFloor());
                    break;

                case "H": // Help
                    printHelp();
                    break;

                case "Q": // Quit
                    System.out.println("Simulation ended.Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println( "Unknown command.Type H for help.");
            }
        }
    }

 // Prints available commands and their descriptions
    private static void printHelp() {
        System.out.println("\nCommands:");
        System.out.println("  E - Add external request (from outside elevator)");
        System.out.println("  I - Add internal request (from inside elevator)");
        System.out.println("  P - Process next elevator move");
        System.out.println("  S - Show elevator status");
        System.out.println("  H - Show help menu");
        System.out.println("  Q - Quit simulation");
    }

 // Reads and validates a floor number between 1 and 20
    private static int readFloor(Scanner scanner) {
        while (true) {
            try {
                int floor = Integer.parseInt(scanner.nextLine().trim());
                if (floor >= 1 && floor <= 20) return floor;
                System.out.print("Invalid floor. Enter 1–20: ");
            } catch (NumberFormatException e) {
                System.out.print(" Not a number. Enter floor (1–20): ");
            }
        }
    }
}
