import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Airplane[] airplanes;

        System.out.println("Use predefined data?");
        char ans = getAns();

        if(ans == 'y'){
            airplanes = new Airplane[]{
                    new Airplane("Boeing 747", 416, 570, 50000),
                    new Airplane("Airbus A380", 853, 560, 32000),
                    new Airplane("Cessna 172", 4, 150, 56),
                    new Airplane("Embraer E190", 114, 550, 20000),
                    new Airplane("Bombardier Learjet 75", 9, 464, 2040)
            };
        }
        else{

            airplanes = new Airplane[5];
            for (int i = 0; i < 5; i++){
                System.out.println("Enter data for airplane " + (i+1));
                airplanes[i] = getAirplaneData();
            }
        }

        System.out.println("Airplane data before sorting");
        printAirplaneData(airplanes);
        System.out.println("---------------------------------------");

        // Sort by maxSpeed in descending order
        Arrays.sort(airplanes, (a1, a2) -> Double.compare(a2.getMaxSpeed(), a1.getMaxSpeed()));

        System.out.println("Sorted by maxSpeed (Descending):");
        printAirplaneData(airplanes);
        System.out.println("---------------------------------------");

        // Sort by capacity in ascending order
        Arrays.sort(airplanes, Comparator.comparingInt(Airplane::getCapacity));

        System.out.println("Sorted by capacity (Ascending):");
        printAirplaneData(airplanes);
        System.out.println("---------------------------------------");
    }

    private static void printAirplaneData(Airplane[] airplanes){
        for (int i = 0; i < airplanes.length; i++) {
            System.out.println("Airplane " + (i + 1) + ":");
            System.out.println("Model: " + airplanes[i].getModel());
            System.out.println("Capacity: " + airplanes[i].getCapacity());
            System.out.println("Max Speed: " + airplanes[i].getMaxSpeed() + " km/h");
            System.out.println("Fuel Capacity: " + airplanes[i].getFuelCapacity() + " liters");
            System.out.println("Is Flying: " + (airplanes[i].isFlying() ? "Yes" : "No"));
            System.out.println();
        }
    }

    private static char getAns()
    {
        char ans = 0;
        boolean validInput;
        Scanner sc = new Scanner(System.in);
        do {
            validInput = true;
            try {
                System.out.print("Enter 'y' or 'n': ");
                ans = sc.nextLine().charAt(0);
                if (ans != 'y' && ans != 'n') {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    validInput = false;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Answer must not be empty");
                validInput = false;
            }
        } while (!validInput);

        return ans;
    }

    public static Airplane getAirplaneData() {
        Scanner scanner = new Scanner(System.in);

        String model;
        int capacity;
        double maxSpeed;
        int fuelCapacity;

        try {
            System.out.print("Enter Model: ");
            model = scanner.nextLine();

            System.out.print("Enter Capacity: ");
            capacity = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Speed (km/h): ");
            maxSpeed = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Fuel Capacity (liters): ");
            fuelCapacity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please try again and enter valid data.");
            scanner.next();
            return getAirplaneData();
        }

        return new Airplane(model, capacity, maxSpeed, fuelCapacity);
    }
}