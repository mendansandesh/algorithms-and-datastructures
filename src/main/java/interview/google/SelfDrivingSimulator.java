package interview.google;

import java.util.*;

public class SelfDrivingSimulator {

    private static final int MAX_TANK_CAPACITY = 100;
    private static final int INITIAL_FUEL = 50;
    private static final int TOTAL_LANES = 3;

    /**
     * Runs the car simulation for a given map and command sequence.
     * Returns total time taken to reach the end,
     * or -1 if the car crashes, runs out of fuel, or gets stuck in a loop.
     */
    public static int runSimulation(String[] trackLayout, String commandSequence, int startingFuel) {
        int position = 0;         // x-axis: progress along the road
        int lane = 1;             // y-axis: start in the middle lane (0-indexed)
        int commandIndex = 0;     // index within the command sequence
        int fuel = startingFuel;
        int elapsedTime = 0;
        int lastCompletedCyclePosition = -1; // used for detecting stuck scenarios

        while (true) {

            // 🚫 Failure: ran out of fuel or left road boundaries
            if (fuel < 0 || lane < 0 || lane >= TOTAL_LANES) {
                return -1;
            }

            // ✅ Success: reached the end of the road
            if (position >= trackLayout[0].length()) {
                return elapsedTime;
            }

            // 💥 Failure: hit an obstacle
            if (trackLayout[lane].charAt(position) == 'O') {
                return -1;
            }

            // Execute the current command
            char action = commandSequence.charAt(commandIndex);
            switch (action) {
                case 'D': // Drive forward
                    position++;
                    break;
                case 'L': // Change to upper lane (left)
                    lane--;
                    break;
                case 'R': // Change to lower lane (right)
                    lane++;
                    break;
                case 'F': // Refuel if fuel cell present
                    if (trackLayout[lane].charAt(position) == 'F') {
                        fuel = Math.min(MAX_TANK_CAPACITY, fuel + 50);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid control command: " + action);
            }

            // One unit of time and fuel consumed
            elapsedTime++;
            fuel--;

            // Move to the next command cyclically
            commandIndex++;
            if (commandIndex >= commandSequence.length()) {
                // Finished one full command cycle — check if car made progress
                if (position == lastCompletedCyclePosition) {
                    return -1; // Stuck (no forward movement)
                }
                lastCompletedCyclePosition = position;
                commandIndex = 0; // restart from beginning of command sequence
            }
        }
    }

    /**
     * Generates all possible command strings of a given length
     * using the allowed commands D, L, R, and F.
     */
    private static void generateAllCommands(int commandLength, StringBuilder builder, List<String> allCommands) {
        if (builder.length() == commandLength) {
            allCommands.add(builder.toString());
            return;
        }
        for (char command : new char[] {'D', 'L', 'R', 'F'}) {
            builder.append(command);
            generateAllCommands(commandLength, builder, allCommands);
            builder.deleteCharAt(builder.length() - 1); // backtrack
        }
    }

    /**
     * Finds the optimal command sequence that allows the car to reach the end
     * of the given road layout in the minimum possible time.
     */
    public static String findOptimalCommand(String[] roadMap) {
        List<String> allCommands = new ArrayList<>();
        generateAllCommands(10, new StringBuilder(), allCommands);

        int bestTime = -1;
        String optimalCommand = "";

        for (String command : allCommands) {
            int timeTaken = runSimulation(roadMap, command, INITIAL_FUEL);
            if (timeTaken != -1 && (bestTime == -1 || timeTaken < bestTime)) {
                bestTime = timeTaken;
                optimalCommand = command;
            }
        }
        return optimalCommand;
    }

    public static void main(String[] args) {
        String[] roadLayout = {
                ".........",
                ".........",
                "........."
        };

        String optimalCommand = findOptimalCommand(roadLayout);
        System.out.println("Best Command: " + optimalCommand);

        System.out.println();
        String[] roadLayout1 = {
                ".........",
                "...O.....",
                "........."
        };

        String optimalCommand1 = findOptimalCommand(roadLayout1);
        System.out.println("Best Command: " + optimalCommand1);

        System.out.println();
        String[] roadLayout2 = {
                "....F....F.",
                "...........",
                "..........."
        };

        String optimalCommand2 = findOptimalCommand(roadLayout2);
        System.out.println("Best Command: " + optimalCommand2);

        System.out.println();
        String[] roadLayout3 = {
                ".........",
                ".........",
                "........."
        };

        String optimalCommand3 = findOptimalCommand(roadLayout3);
        System.out.println("Best Command: " + optimalCommand3);

        System.out.println();
        String[] roadLayout4 = {
                "....F....O..F",
                "..O.....F....",
                "....O........"
        };

        String optimalCommand4 = findOptimalCommand(roadLayout4);
        System.out.println("Best Command: " + optimalCommand4);

        System.out.println();
        String[] roadLayout5 = {
                "OOOOOOOOO",
                "OOOOOOOOO",
                "OOOOOOOOO"
        };

        String optimalCommand5 = findOptimalCommand(roadLayout5);
        System.out.println("Best Command: " + optimalCommand5);

        System.out.println();
        String[] roadLayout6 = {
                ".........",
                ".........",
                "........."
        };

        String optimalCommand6 = findOptimalCommand(roadLayout6);
        System.out.println("Best Command: " + optimalCommand6);

        System.out.println();
        String[] roadLayout7 = {
                ".",
                ".",
                "."
        };

        String optimalCommand7 = findOptimalCommand(roadLayout7);
        System.out.println("Best Command: " + optimalCommand7);
    }
}


