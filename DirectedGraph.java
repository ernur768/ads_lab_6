import java.util.*;

public class DirectedGraph<T>
{
    private final Map<T, Set<T>> graph;

    public DirectedGraph()
    {
        this.graph = new HashMap<>();
    }

    public List<T> breadthFirstSearch(T start, T end)
    {
        List<T> list = new ArrayList<>();
        Queue<T> queue = new LinkedList<>();
        T node;
        queue.add(start);
        while (!queue.isEmpty())
        {
            node = queue.poll();
            if (!list.contains(node))
            {
                list.add(node);
                if (node.equals(end)) break;
                queue.addAll(graph.get(node));
            }
        }

        return list;
    }

    public List<T> breadthFirstSearch(T start)
    {
        List<T> list = new ArrayList<>();
        Queue<T> queue = new LinkedList<>();
        T node;
        queue.add(start);
        while (!queue.isEmpty())
        {
            node = queue.poll();
            if (!list.contains(node))
            {
                list.add(node);
                queue.addAll(graph.get(node));
            }
        }

        return list;
    }

    public void add(T n1, T n2)
    {
        graph.computeIfAbsent(n1, k -> new HashSet<>());
        graph.get(n1).add(n2);
    }

    public void printGraph()
    {
        for (T set : graph.keySet()) {
            System.out.print(set + " : ");
            System.out.println(graph.get(set));
        }
    }
}
