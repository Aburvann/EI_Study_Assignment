import java.util.List;

public class Grid {
    private int width, height;
    private List<Position> obstacles;

    public Grid(int width, int height, List<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    // Check if there is an obstacle at the given position
    public boolean hasObstacle(Position position) {
        for (Position obstacle : obstacles) {
            if (obstacle.getX() == position.getX() && obstacle.getY() == position.getY()) {
                return true;
            }
        }
        return false;
    }

    // Check if the position is within the bounds of the grid
    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }
}
