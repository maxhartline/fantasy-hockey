import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Declare variables
        String teamName;
        String playerName;
        int numberOfGoals;
        int numberOfAssists;
        double teamBudget;

        // Print headers
        System.out.println("Welcome to Fantasy Hockey!\n");
        System.out.println("Team Entry");
        System.out.println("-".repeat(30));

        // Create an array of 3 Team objects
        Team[] teams = new Team[3];

        // Input team names
        for (int i = 0; i < 3; i++) {
            while (true) {  // While loop to ensure valid data is entered
                System.out.print("Enter name for team #" + (i + 1) + ": ");
                teamName = scanner.nextLine();
                if (teamName.length() < 3) {
                    System.out.println("Team name is too short. Enter a team name at least 3 characters long.");
                } else {
                    break; // Exit while loop once valid data is entered
                }
            }

            // Assign random budget to each team
            teamBudget = random.nextDouble() * 100000; // Generate a random number (double) between 0 and 100000
            teams[i] = new Team(teamName);
            teams[i].setTeamBudget(teamBudget); // Assign budget to the team object
        }

        // Print header
        System.out.println("\nPlayer Entry");
        System.out.println("-".repeat(30));

        // Loop through each team and input player details
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter players for " + teams[i].getTeamName() + ":");

            for (int j = 0; j < 3; j++) { // Nested loop for 3 players per team
                while (true) {
                    System.out.print("Enter name for player #" + (j + 1) + ": ");
                    playerName = scanner.nextLine();

                    if (playerName.length() < 3) {
                        System.out.println("Player name is too short. Enter a player name at least 3 characters long.");
                    } else {
                        break;
                    }
                }

                while (true) { // While loop to ensure valid data is entered
                    System.out.print("Enter number of goals for " + playerName + ": ");
                    numberOfGoals = scanner.nextInt();
                    scanner.nextLine();

                    if (numberOfGoals < 0) {
                        System.out.println("Number of goals cannot be less than 0. Please enter a valid number.");
                    } else {
                        break; // Exit loop once valid data is entered
                    }
                }

                while (true) { // While loop to ensure valid data is entered
                    System.out.print("Enter number of assists for " + playerName + ": ");
                    numberOfAssists = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\n");

                    if (numberOfAssists < 0) {
                        System.out.println("Number of assists cannot be less than 0. Please enter a valid number.");
                    } else {
                        break; // Exit loop once valid data is entered
                    }
                }

                // Add player to the team
                teams[i].addPlayer(new Player(playerName, numberOfGoals, numberOfAssists));
            }
        }

        // Print header
        System.out.println("\nReport: Stats Per Team");
        System.out.println("-".repeat(30));

        // Invoke method for stats per team
        for (int i = 0; i < teams.length; i++) {
            teams[i].outputStatsPerTeam(); // Call the method to output team stats
        }

        // Print header
        System.out.println("\nReport: Stats Per Player");
        System.out.println("-".repeat(30));

        // Invoke method for stats per player
        for (int i = 0; i < teams.length; i++) {
            for (Player player : teams[i].getPlayers()) { // Loop through players in the current team
                player.outputStatsPerPlayer(teams[i].getTeamName()); // Pass team name to the method
            }
        }
    }
}