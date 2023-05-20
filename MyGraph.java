import java.util.*;

public class MyGraph<T>
{
    private final Map<T, Set<T>> graph;

    public MyGraph()
    {
        this.graph = new HashMap<>();
    }

    public List<Set<T>> getConnectedComponents()
    {
        List<Set<T>> list = new ArrayList<>();

        boolean contains;

        for (T node : graph.keySet()) {
            contains = false;
            for (Set<T> set : list) {
                if (set.contains(node))
                {
                    contains = true;
                    set.addAll(graph.get(node));
                    break;
                }
            }

            if (!contains)
            {
                Set<T> newSet = new HashSet<>();
                newSet.addAll(graph.get(node));
                list.add(newSet);
            }
        }

        return list;
    }

    public List<T> breadthFirstSearch(T start)
    {
        List<T> visited = new ArrayList<>();
        if (!graph.containsKey(start)) return visited;

        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            T vert = queue.poll();
            if (!visited.contains(vert))
            {
                visited.add(vert);
                queue.addAll(graph.get(vert));
            }
        }
        return visited;
    }

    public List<T> breadthFirstSearch(T start, T end)
    {
        List<T> visited = new ArrayList<>();
        if (!graph.containsKey(start) || !graph.containsKey(end)) return visited;

        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            T vert = queue.poll();
            if (!visited.contains(vert))
            {
                visited.add(vert);
                if (vert.equals(end)) break;
                queue.addAll(graph.get(vert));
            }
        }
        return visited;
    }

    public List<T> depthFirstSearch(T start)
    {
        List<T> arr = new ArrayList<>();
        if (graph.containsKey(start))
        {
            dfs(start, arr);
        }
        return arr;
    }

    private void dfs(T start, List<T> arr)
    {
        arr.add(start);
        for (T neighbor : graph.get(start))
        {
            if (!arr.contains(neighbor))
            {
                dfs(neighbor, arr);
            }
        }
    }

    public void add(T vertex1, T vertex2)
    {
        addOneVertex(vertex1, vertex2);
        addOneVertex(vertex2, vertex1);
    }

    private void addOneVertex(T vertex1, T vertex2)
    {
        Set<T> vertices = graph.computeIfAbsent(vertex1, k -> new HashSet<>());
        vertices.add(vertex2);
    }


    public void printGraph()
    {
        Set<T> vertices;
        for (T key : graph.keySet())
        {
            vertices = graph.get(key);
            System.out.print(key + " : ");
            System.out.println(vertices);
        }
    }


}
