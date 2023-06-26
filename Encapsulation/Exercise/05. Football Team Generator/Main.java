package Encapsulation.Exercise.Football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Map<String, Team> teamMap = new LinkedHashMap<>();

        String command = br.readLine();

        while (!"END".equals(command)) {

            String[] tokens = command.split(";");
            String currentCommand = tokens[0];
            String teamName = tokens[1];

            switch (currentCommand) {
                case "Team":
                    try {

                        Team currentTeam = new Team(teamName);
                        teamMap.put(teamName, currentTeam);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "Add":
                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }
                    try {
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        Player currentPlayer = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teamMap.get(teamName).addPlayer(currentPlayer);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "Remove":

                    String playerName = tokens[2];
                    try {
                        teamMap.get(teamName).removePlayer(playerName);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teamMap.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }

                    System.out.println(teamName + " - " + teamMap.get(teamName).getRating());

                    break;
            }



            command = br.readLine();
        }

    }
}
