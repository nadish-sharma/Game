package gameobjects;

import enums.rl;

public class Room2 extends Room {
    public Room2(String nm, String descr, rl north, rl south, rl west, rl east, ThingList room1List) {
        super(nm, descr, north, south, west, east, room1List);
    }
}
