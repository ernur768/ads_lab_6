import java.util.Scanner;
import java.util.Set;

public class J_P3
{
    public void solution()
    {
        MyGraph<Integer> graph = getGraph();

        for (Set<Integer> set : graph.getConnectedComponents()) {
            for (int node : set) {
                System.out.printf("%d ", node);
            }
            System.out.println();
        }
    }

    private MyGraph<Integer> getGraph()
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        MyGraph<Integer> graph = new MyGraph<>();
        int v1;
        int v2;
        for (int i = 0; i < m; i++)
        {
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            graph.add(v1, v2);
        }

        return graph;
    }
}
