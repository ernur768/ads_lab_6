import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class J_P4
{
    private class Coordinate
    {
        private final int x;
        private final int y;

        public Coordinate(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public boolean equals(int x, int y)
        {
            return this.x == x && this.y == y;
        }

        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }

        @Override
        public String toString()
        {
            return "[" + x + ", " + y + "]";
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(x, y);
        }
    }

    public void solution()
    {
        Scanner sc = new Scanner(System.in);
        int[][] map = getMap(sc);
        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();
        Coordinate start = new Coordinate(x, y);
        x = sc.nextInt();
        y = sc.nextInt();
        Coordinate end = new Coordinate(x, y);


        DirectedGraph<Coordinate> graph = buildGraph(map);
        graph.printGraph();

//        List<Coordinate> road = graph.breadthFirstSearch(start, end);
//        System.out.println(road);

    }

    private DirectedGraph<Coordinate> buildGraph(int[][] map)
    {
        DirectedGraph<Coordinate> graph = new DirectedGraph<>();
        int n = map.length - 1;
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map.length - 1; j++)
            {
                if (map[i][j] == 0 && map[i][j + 1] == 0)
                {
                    Coordinate node = new Coordinate(i, j);
                    Coordinate neighbor = new Coordinate(i, j + 1);
                    graph.add(node, neighbor);

                }
            }
        }
        for (int i = 0; i < map.length - 1; i++)
        {
            for (int j = 0; j < map.length; j++)
            {
                if (map[i][j] == 0 && map[i + 1][j] == 0)
                {
                    Coordinate node = new Coordinate(i, j);
                    Coordinate neighbor = new Coordinate(i + 1, j);
                    graph.add(node, neighbor);
                }
            }
        }

        return graph;
    }

    private int[][] getMap(Scanner sc)
    {
        int n = sc.nextInt();
        int[][] map = new int[n][];
        for (int i = 0; i < n; i++)
        {
            map[i] = new int[n];
            for (int j = 0; j < n; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }

        return map;
    }
}
