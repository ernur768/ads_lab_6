import java.util.*;
import java.util.function.Function;

public class WeightedGraph<T>
{
    private final Map<T, Map<T, Integer>> graph;

    public WeightedGraph()
    {
        this.graph = new HashMap<>();
    }

    public void computeIfAbsent(T node, Function<? super T, ? extends Map<T, Integer>> mappingFunction)
    {
        graph.computeIfAbsent(node, mappingFunction);
    }

    public Set<T> getAllNods()
    {
        Set<T> all = new HashSet<>(getNods());

        for (T node : getNods()) {
            all.addAll(getNeighbors(node));
        }

        return all;
    }

    public Set<T> getNods()
    {
        return graph.keySet();
    }

    public Set<T> getNeighbors(T node)
    {
        return graph.get(node).keySet();
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
