import java.util.*;

public class J_C3
{
    public void solution()
    {
        Scanner sc = new Scanner(System.in);

        WeightedGraph<Integer> graph = getGraph(sc);
        int start = sc.nextInt();
        int end = sc.nextInt();
        Map<Integer, Integer> costs = getCost(graph, start);
        Map<Integer, Integer> parentTable = getCompleteParentTable(graph, costs, start);

        List<Integer> road = getRoad(parentTable, start, end);

        System.out.printf("Shortest distance: %d%n", costs.get(end));
        System.out.print("Shortest path: ");
        for (int node : road) {
            System.out.printf("%d ", node);
        }
        System.out.println();
    }

    private List<Integer> getRoad(Map<Integer, Integer> parentTable, int start, int end)
    {
        List<Integer> road = new ArrayList<>();
        int node = end;

        while (node != start)
        {
            road.add(node);
            node = parentTable.get(node);
        }
        road.add(start);

        Collections.reverse(road);
        return road;
    }

    private Map<Integer, Integer> getCompleteParentTable(WeightedGraph<Integer> graph,
                                                         Map<Integer, Integer> costs,
                                                         int start)
    {
        Map<Integer, Integer> parent = getParentTable(graph, start);
        List<Integer> visited = new ArrayList<>();


        Integer node = findMinCostNode(costs);
        int cost;
        int newCost;

        while (node != null)
        {
            cost =  costs.get(node);
            for (int n : graph.getNeighbors(node)) {
                newCost =  cost + graph.getWeight(node, n);
                if (costs.get(n) > newCost)
                {
                    costs.put(n, newCost);
                    parent.put(n, node);
                }
            }
            visited.add(node);
            node = findMinCostNode(costs, visited);
        }

        return parent;
    }

    private Integer findMinCostNode(Map<Integer, Integer> cost, List<Integer> visited)
    {
        return cost
                .entrySet()
                .stream()
                .filter(e -> !visited.contains(e.getKey()))
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

    private Integer findMinCostNode(Map<Integer, Integer> cost)
    {
        return cost
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

    private Map<Integer, Integer> getParentTable(WeightedGraph<Integer> graph, int start)
    {
        Map<Integer, Integer> table = new HashMap<>();

        for (int child : graph.getNeighbors(start)) {
            table.put(child, start);
        }

        return table;
    }

    private Map<Integer, Integer> getCost(WeightedGraph<Integer> graph, int start)
    {
        Map<Integer, Integer> cost = new HashMap<>();

        for (Integer  vert : graph.getAllNods()) {
            cost.put(vert, Integer.MAX_VALUE);
        }

        for (int vert : graph.getNeighbors(start)) {
            cost.put(vert, graph.getWeight(start, vert));
        }

        cost.remove(start);

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
            graph.computeIfAbsent(end, k -> new HashMap<>());
        }

        return graph;
    }
}
