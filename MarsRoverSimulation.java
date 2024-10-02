import java.util.*;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input Grid Size
        System.out.println("Enter grid size (width height): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        // 2. Input Obstacles
        System.out.println("Enter the number of obstacles: ");
        int numObstacles = scanner.nextInt();
        List<Position> obstacles = new ArrayList<>();
        for (int i = 0; i < numObstacles; i++) {
            System.out.println("Enter obstacle " + (i + 1) + " position (x y): ");
            int ox = scanner.nextInt();
            int oy = scanner.nextInt();
            obstacles.add(new Position(ox, oy, 'N'));  // Direction 'N' is irrelevant for obstacles
        }

        // 3. Initialize Grid
        Grid grid = new Grid(width, height, obstacles);

        // 4. Input Rover Initial Position and Direction
        char roverDir;
        while (true) {
            System.out.println("Enter rover's initial position (x y) and direction (N/S/E/W): ");
            int roverX = scanner.nextInt();
            int roverY = scanner.nextInt();
            roverDir = scanner.next().charAt(0);

            // Validate direction input
            if (!"NSEW".contains(String.valueOf(roverDir))) {
                System.out.println("Invalid direction! Please enter a valid direction (N/S/E/W).");
                continue;
            }

            // Prevent the rover from starting at an obstacle
            if (grid.hasObstacle(new Position(roverX, roverY, roverDir))) {
                System.out.println("Rover cannot start at an obstacle. Please choose another starting position.");
            } else {
                Rover rover = new Rover(new Position(roverX, roverY, roverDir), grid);

                // 5. Input Commands (M = Move, L = Turn Left, R = Turn Right)
                System.out.println("Enter the sequence of commands (M/L/R): ");
                String commandsStr = scanner.next();
                
                if (commandsStr.isEmpty()) {
                    System.out.println("No commands provided. Rover stays in its initial position.");
                    rover.reportStatus();
                    break;
                }

                // Process each command and execute it
                List<Command> commands = new ArrayList<>();
                for (char command : commandsStr.toCharArray()) {
                    switch (command) {
                        case 'M': commands.add(new MoveCommand()); break;
                        case 'L': commands.add(new TurnLeftCommand()); break;
                        case 'R': commands.add(new TurnRightCommand()); break;
                        default: System.out.println("Invalid command '" + command + "' ignored."); break;
                    }
                }

                // Execute commands
                for (Command command : commands) {
                    command.execute(rover);
                }

                // Output Rover Final Status
                rover.reportStatus();
                break;
            }
        }
        scanner.close();
    }
}
