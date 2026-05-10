# Soccer League
### Game Class
- The game class serves as the template for creating individual game objects
- The data fields for the game class are: the gameID, the temperature, the away and home teams, and the number of goals that each team scores in that game
- The constructor method for the game class allows individual game objects to be created; it requires each of the data fields as arguments since each will be known at the time of creation
- The getters and setters allow each of the data fields to be accessed and mutated while still allowing the data fields to be private
- The game class has a print_stats() method which prints out each of the data fields associated with a game object
### Team Class
- The team class serves as the template for each of the individual team objects
- The data fields for the team class are: the team name, the team's win, loss, and tie total, and the total goals scored and allowed by each team during the season
- The constructor method for the team class allows individual team objects to be created; the only data field required as an argument is the team name, since the others will not be known at the time of creation
- The getters and setters allow the data fields for each of the team objects to be accessed and mutated while still keeping the data fields private
- Similarly to the game class, the team class has a print_stats() method which prints out all of the data fields associated with a specific team object
### Main Method
- The main method serves as the entry point for the program
- It does the following:
1. Creates 4 team objects using the team class
2. Creates a primitive array for the team objects, since the number of teams in the array will never change
3. Uses the game class to create an arrayList for game objects
4. Creates a while loop that controls whether the season is still in progress or is over based on a counter variable that counts the number of consecutive weeks of the temperature being below freezing
5. Chooses a random temperature from 0 to 100 using a random object that was created outside of the loop
6. Uses an if statement inside the while loop to increase the counter variable and print out a message if the temperature is below freezing
7. Uses an else statement inside the while loop to reset the counter variable, set team 4 as the game 1 hometeam, randomly choose another team as the game 1 awayteam, and use a switch-case statement to set the remaining teams as the game 2 hometeam and awayteam
8. Uses else, else-if, and else statements, and the game class constructor to randomly choose each team's score based on the temperature during the game, and create game objects using that temperature
9. Uses the getter and setter methods from the team and game classes to update the total goals scored and allowed for each team object
10. Adds the games to the arrayList for games
11. Creates and calls a method with else, else-if, and if statements which updates the win, loss, and tie totals for each team object based on the game objects
12. Uses the array and arrayList for the game and team objects, and an enhanced for loop for each, to call the print_stats() methods in the game and team classes, which prints the stats of each game and team object

