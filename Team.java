import java.util.ArrayList;

public class Team {
    // Properties
    private String teamName;
    private double teamBudget;
    private ArrayList<Player> players;

    // Constructor
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        this.teamBudget = 0;
    }

    // Getters and setters
    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setTeamBudget(double teamBudget) {
        this.teamBudget = teamBudget;
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Method to generate team stats
    public void outputStatsPerTeam() {
        // Initialize variables
        int teamGoals = 0;
        int teamAssists = 0;

        // Loop through each player to sum goals and assists
        for (Player player : players) {
            teamGoals += player.getPlayerGoals();
            teamAssists += player.getPlayerAssists();
        }

        int teamTotal = teamGoals + teamAssists; // Total goals and assists

        // Determine the team rating as stars
        String teamRating;
        if (teamTotal > 20) {
            teamRating = "***"; // 3 stars
        } else if (teamTotal >= 10) {
            teamRating = "**"; // 2 stars
        } else if (teamTotal > 0) {
            teamRating = "*"; // 1 star
        } else {
            teamRating = "0"; // 0 stars
        }

        // Output
        System.out.println(this.teamName + ": G - " + teamGoals + "   A - " + teamAssists + "   Total - " + teamTotal + "   Budget - $" + String.format("%.2f", teamBudget) + "   Rating - " + teamRating + " stars");
    };
}
