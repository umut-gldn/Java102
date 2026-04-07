package game.location;

import game.model.Player;

public abstract class Location {

    protected Player player;
    protected String name;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();

}
