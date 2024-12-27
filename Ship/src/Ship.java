/*
Every time your spies see a new ship enter the dock, they will create a new ship object
based on their observations:
draft - an estimate of the ship's weight based on how low it is in the water
crew - the count of crew on board.
Each crew member adds 1.5 units to the ship draft. If after removing the weight of the crew,
the draft is still more than 20, then the ship is worth looting.
Any ship weighing that much must have a lot of booty!
 */


public class Ship {
    private final double draft;
    private final int crew;

    public Ship(double draft, int crew) {
        this.draft = draft;
        this.crew = crew;

    }

    public boolean isWorthIt() {
        return draft - crew * 1.5 > 20;
    }
}
