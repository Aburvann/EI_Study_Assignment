public class Rover {
    private Position position;
    private Grid grid;

    public Rover(Position position, Grid grid) {
        this.position = position;
        this.grid = grid;
    }

    // Move the rover forward and check for obstacles or out-of-bounds conditions
    public void move() {
        Position newPosition = new Position(position.getX(), position.getY(), position.getDirection());
        newPosition.moveForward();

        if (!grid.hasObstacle(newPosition) && grid.isWithinBounds(newPosition)) {
            this.position = newPosition;
        } else if (grid.hasObstacle(newPosition)) {
            System.out.println("Obstacle detected! Can't move forward.");
        } else {
            System.out.println("Out of bounds! Can't move forward.");
        }
    }

    // Turn the rover left
    public void turnLeft() {
        position.turnLeft();
    }

    // Turn the rover right
    public void turnRight() {
        position.turnRight();
    }

    // Get the rover's current position
    public Position getPosition() {
        return position;
    }

    // Print the rover's status (position and direction)
    public void reportStatus() {
        System.out.println("Rover is at (" + position.getX() + ", " + position.getY() + ") facing " + position.getDirection());
    }
}
