package by.javacourse.se.homework7_bonus;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    public static Queue<Coordinate> queue = new LinkedList<>();

    static class Coordinate {
        int x;
        int y;
        int z;
        int counter;
        boolean ready;
        char ch;

        public Coordinate() {
        }

        public Coordinate(
                int x,
                int y,
                int z,
                int counter,
                boolean ready,
                char ch
        ) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.counter = counter;
            this.ready = ready;
            this.ch = ch;
        }
    }

    static class Position {
        int x;
        int y;
        int z;
    }

    public static void processPosition(Coordinate[][][] coordinates, int x, int y, int z, int counter) {

        int h = coordinates.length;
        int m = coordinates[0].length;
        int n = coordinates[0][0].length;
        coordinates[z][x][y].ready = true;

        if (
                x - 1 > -1
                        && x - 1 < m
                        && coordinates[z][x - 1][y].ch != 'x'
                        && !coordinates[z][x - 1][y].ready
                        && coordinates[z][x - 1][y].counter > counter + 1
        ) {
            coordinates[z][x - 1][y].counter = counter + 1;
            queue.add(coordinates[z][x - 1][y]);
        }
        if (
                x + 1 < m
                        && coordinates[z][x + 1][y].ch != 'x'
                        && !coordinates[z][x + 1][y].ready
                        && coordinates[z][x + 1][y].counter > counter + 1
        ) {
            coordinates[z][x + 1][y].counter = counter + 1;
            queue.add(coordinates[z][x + 1][y]);
        }
        if (
                y - 1 > -1
                        && y - 1 < n
                        && coordinates[z][x][y - 1].ch != 'x'
                        && !coordinates[z][x][y - 1].ready
                        && coordinates[z][x][y - 1].counter > counter + 1
        ) {
            coordinates[z][x][y - 1].counter = counter + 1;
            queue.add(coordinates[z][x][y - 1]);
        }
        if (
                y + 1 < n
                        && coordinates[z][x][y + 1].ch != 'x'
                        && !coordinates[z][x][y + 1].ready
                        && coordinates[z][x][y + 1].counter > counter + 1
        ) {
            coordinates[z][x][y + 1].counter = counter + 1;
            queue.add(coordinates[z][x][y + 1]);
        }
        if (
                z + 1 < h
                        && coordinates[z + 1][x][y].ch != 'x'
                        && !coordinates[z + 1][x][y].ready
                        && coordinates[z + 1][x][y].counter > counter + 1
        ) {
            coordinates[z + 1][x][y].counter = counter + 1;
            queue.add(coordinates[z + 1][x][y]);
        }
    }

    public static void main(String[] args) throws IOException {

        File inFile = new File("src/by/javacourse/se/homework7_bonus/INPUT.txt");
        File outFile = new File("src/by/javacourse/se/homework7_bonus/OUTPUT.txt");

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(inFile)
                        )
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(outFile)
                        )
                )
        ) {
            String[] arguments = reader.readLine().split(" ");
            int h = Integer.parseInt(arguments[0]);
            int m = Integer.parseInt(arguments[1]);
            int n = Integer.parseInt(arguments[2]);

            Coordinate[][][] coordinates = new Coordinate[h][m][n];
            Coordinate start = new Coordinate();
            Position end = new Position();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < m; j++) {
                    String[] line = reader.readLine().split("");
                    for (int k = 0; k < n; k++) {
                        coordinates[i][j][k] = new Coordinate(
                                j,
                                k,
                                i,
                                Integer.MAX_VALUE,
                                false,
                                line[k].charAt(0)
                        );
                        if (line[k].equals("1")) {
                            start.z = i;
                            start.x = j;
                            start.y = k;
                            start.counter = 0;
                            start.ready = false;
                        }
                        if (line[k].equals("2")) {
                            end.z = i;
                            end.x = j;
                            end.y = k;
                        }
                    }
                }
                reader.readLine();
            }
            queue.add(start);
            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.poll();
                processPosition(
                        coordinates,
                        coordinate.x,
                        coordinate.y,
                        coordinate.z,
                        coordinate.counter
                );
            }
            writer.write(coordinates[end.z][end.x][end.y].counter * 5 + "");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

