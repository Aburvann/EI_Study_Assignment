public class Position {
    private int x, y;
    private char direction;

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public char getDirection() { return direction; }

    public void moveForward() {
        switch (direction) {
            case 'N': y += 1; break;
            case 'S': y -= 1; break;
            case 'E': x += 1; break;
            case 'W': x -= 1; break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N': direction = 'W'; break;
            case 'S': direction = 'E'; break;
            case 'E': direction = 'N'; break;
            case 'W': direction = 'S'; break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N': direction = 'E'; break;
            case 'S': direction = 'W'; break;
            case 'E': direction = 'S'; break;
            case 'W': direction = 'N'; break;
        }
    }
}
