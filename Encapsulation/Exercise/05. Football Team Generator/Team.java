package Encapsulation.Exercise.Football;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;


    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String player) {
        if (!players.removeIf(current -> current.getName().equals(player))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }
        players.removeIf(current -> current.getName().equals(player));
    }

    public int getRating() {
        return (int) Math.round(players.stream().mapToDouble(Player::overallSkillLevel).sum() / players.size());
    }
}
