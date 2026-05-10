public class Game {

    // Data Fields
     private int GameID;
     private double temp;
     private Team awayTeam;
     private Team homeTeam;
     private int awayScore;
     private int homeScore;

    // Constructor
    public Game(int gameID, double temp, Team awayTeam, Team homeTeam, int awayScore, int homeScore) {
        GameID = gameID;
        this.temp = temp;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.awayScore = awayScore;
        this.homeScore = homeScore;
    }

    // Getters and Setters
    public int getGameID() {
        return GameID;
    }

    public void setGameID(int gameID) {
        GameID = gameID;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    // Methods
    public void print_stats() {
        System.out.println("Game #" + GameID);
        System.out.printf("Temperature: %.2f°F\n", temp);
        System.out.println("Away Team: " + awayTeam.getName() + ", " + awayScore + " goals");
        System.out.println("Home Team: " + homeTeam.getName() + ", " + homeScore + " goals");
        System.out.println("\n");
    }
}