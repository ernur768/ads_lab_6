import java.util.*;

public class WeightedGraph<T>
{
    private final Map<T, Map<T, Integer>> graph;

    public WeightedGraph()
    {
        this.graph = new HashMap<>();
    }

    public Set<T> getKeys()
    {
        return graph.keySet();
    }

    public Set<T> getKeys(T vertex)
    {
        return graph.get(vertex).keySet();
    }

    public int getWeight(T v1, T v2)
    {
        return graph.get(v1).get(v2);
    }

    public void add(T v1, T v2, int weight)
    {
        Map<T, Integer> cost = graph.computeIfAbsent(v1, K -> new HashMap<>());
        cost.put(v2, weight);
    }
    
    public void printGraph()
    {
        for (T parent : graph.keySet()) {
            System.out.println(parent);
            Map<T, Integer> cost = graph.get(parent);
            for (T node : cost.keySet()) {
                System.out.println("\t" + node + " : " + cost.get(node));
            }

        }
    }
}
