public class Player {
    // Properties
    private String playerName;
    private int playerGoals;
    private int playerAssists;

    // Constructor
    public Player (String playerName, int playerGoals, int playerAssists) {
        this.playerName = playerName;
        this.playerGoals = playerGoals;
        this.playerAssists = playerAssists;
    }

    // Getters
    public int getPlayerGoals() {
        return playerGoals;
    }

    public int getPlayerAssists() {
        return playerAssists;
    }

    // Method
    public void outputStatsPerPlayer(String teamName) {
        int playerTotal = playerGoals + playerAssists;
        System.out.println(teamName);
        System.out.println(this.playerName + ": G - " + this.playerGoals + "   A - " + this.playerAssists + "   Total - " + playerTotal);
    };

}
