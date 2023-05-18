import java.util.Scanner;

public class J_P2
{

    public void solution()
    {
        Scanner sc = new Scanner(System.in);
        DirectedGraph<Integer> graph = getGraph(sc);

        for (int node : graph.breadthFirstSearch(0)) {
            System.out.printf("%d ", node);
        }
    }

    private DirectedGraph<Integer> getGraph(Scanner sc)
    {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        int conn;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                conn = sc.nextInt();
                if (conn == 1)
                {
                    graph.add(i, j);
                }
            }
        }

        return graph;
    }
}
