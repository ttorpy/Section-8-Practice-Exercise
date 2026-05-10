import java.util.ArrayList;
import java.util.Random;

public class Main {
    static void main(String[] args) {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Team team3 = new Team("Team 3");
        Team team4 = new Team("Team 4");

        Team[] teams = {team1, team2, team3, team4};
        ArrayList<Game> games_played = new ArrayList<Game>();

        // Schedule Start
        Random rand = new Random();
        int winter_weeks = 0;
        int GameID = 1;

        while (winter_weeks < 3) {

            // Generate random temp
            double temp = rand.nextDouble(100);

            // Decide if game is played or not
            if (temp <= 32.0) {
                winter_weeks ++;
                if (winter_weeks == 3) {
                    System.out.println("Too cold to play.");
                    System.out.println("Too cold to play.");
                    System.out.println("Too cold to play.");
                }
                continue;
            }
            else {
                // Game is played

                // reset winter_weeks
                winter_weeks = 0;

                // Select Team 4 first
                Team homeTeam1 = teams[3];

                // Randomly select another team [team1, team2, team3]
                int awayTeam = rand.nextInt(3);
                Team awayTeam1 = teams[awayTeam];

                // Select the other two teams for Game 2
                Team homeTeam2 = null;
                Team awayTeam2 = null;
                Game game1 = null;
                Game game2 = null;

                switch (awayTeam) {
                    case 0:
                        homeTeam2 = teams[1];
                        awayTeam2 = teams[2];
                        break;
                    case 1:
                        homeTeam2 = teams[0];
                        awayTeam2 = teams[2];
                        break;
                    case 2:
                        homeTeam2 = teams[0];
                        awayTeam2 = teams[1];
                        break;
                }

                // Randomly select scores
                if (temp <= 49) {
                    game1 = new Game(GameID, temp, awayTeam1, homeTeam1, rand.nextInt(6), rand.nextInt(6));
                    game2 = new Game(GameID + 1, temp, awayTeam2, homeTeam2, rand.nextInt(6), rand.nextInt(6));
                }
                else if (temp <= 66) {
                    game1 = new Game(GameID, temp, awayTeam1, homeTeam1, rand.nextInt(11), rand.nextInt(11));
                    game2 = new Game(GameID + 1, temp, awayTeam2, homeTeam2, rand.nextInt(11), rand.nextInt(11));
                }
                else if (temp <= 83) {
                    game1 = new Game(GameID, temp, awayTeam1, homeTeam1, rand.nextInt(16), rand.nextInt(16));
                    game2 = new Game(GameID + 1, temp, awayTeam2, homeTeam2, rand.nextInt(16), rand.nextInt(16));
                }
                else {
                    game1 = new Game(GameID, temp, awayTeam1, homeTeam1, rand.nextInt(21), rand.nextInt(21));
                    game2 = new Game(GameID + 1, temp, awayTeam2, homeTeam2, rand.nextInt(21), rand.nextInt(21));
                }

                GameID +=2;

                // Game 1 Total goals
                awayTeam1.setTotal_goals_scored(awayTeam1.getTotal_goals_scored() + game1.getAwayScore());
                awayTeam1.setTotal_goals_allowed(awayTeam1.getTotal_goals_allowed() + game1.getHomeScore());
                homeTeam1.setTotal_goals_scored(homeTeam1.getTotal_goals_scored() + game1.getHomeScore());
                homeTeam1.setTotal_goals_allowed(homeTeam1.getTotal_goals_allowed() + game1.getAwayScore());

                // Game 2 Total goals
                awayTeam2.setTotal_goals_scored(awayTeam2.getTotal_goals_scored() + game2.getAwayScore());
                awayTeam2.setTotal_goals_allowed(awayTeam2.getTotal_goals_allowed() + game2.getHomeScore());
                homeTeam2.setTotal_goals_scored(homeTeam2.getTotal_goals_scored() + game2.getHomeScore());
                homeTeam2.setTotal_goals_allowed(homeTeam2.getTotal_goals_allowed() + game2.getAwayScore());

                games_played.add(game1);
                games_played.add(game2);

                record_WLT(game1);
                record_WLT(game2);
            }
        }

        System.out.println("Season is over.\n\n");
        System.out.println("*********RESULTS*********\n\n\n");

        for (Team team : teams) {
            team.print_stats();
        }

        for (Game game : games_played) {
            game.print_stats();
        }
    }

    public static void record_WLT(Game game) {
        if (game.getAwayScore() > game.getHomeScore()) {
            game.getAwayTeam().setWin_total(game.getAwayTeam().getWin_total() + 1);
            game.getHomeTeam().setLoss_total(game.getHomeTeam().getLoss_total() + 1);
        }
        else if (game.getHomeScore() > game.getAwayScore()) {
            game.getHomeTeam().setWin_total(game.getHomeTeam().getWin_total() + 1);
            game.getAwayTeam().setLoss_total(game.getAwayTeam().getLoss_total() + 1);
        }
        else {
            game.getHomeTeam().setTie_total(game.getHomeTeam().getTie_total() + 1);
            game.getAwayTeam().setTie_total(game.getAwayTeam().getTie_total() + 1);
        }
    }
}
