import java.util.*;

public class J_C3
{
    public void solution()
    {
        Scanner sc = new Scanner(System.in);

        WeightedGraph<Integer> graph = getGraph(sc);
        int start = sc.nextInt();
        Map<Integer, Integer> cost = getCost(graph, start);

//        Map<Integer, Integer> parent = new HashMap<>();
//        List<Integer> visited = new ArrayList<>();


        graph.printGraph();
        System.out.println();
        System.out.println(cost);

    }

    private Map<Integer, Integer> getCost(WeightedGraph<Integer> graph, int start)
    {
        Map<Integer, Integer> cost = new HashMap<>();

        for (Integer  vert : graph.getKeys()) {
            cost.put(vert, Integer.MAX_VALUE);
        }

        for (int vert : graph.getKeys(start)) {
            cost.put(vert, graph.getWeight(start, vert));
        }

        return cost;
    }

    private WeightedGraph<Integer> getGraph(Scanner sc)
    {
        WeightedGraph<Integer> graph = new WeightedGraph<>();
        int n = sc.nextInt();

        int start;
        int end;
        int weight;
        for (int i = 0; i < n; i++)
        {
            start = sc.nextInt();
            end = sc.nextInt();
            weight = sc.nextInt();
            graph.add(start, end, weight);
        }

        return graph;
    }
}
