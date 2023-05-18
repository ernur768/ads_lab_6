//import java.util.Scanner;
//
//public class J_P1
//{
//
//    public void solution()
//    {
//        Scanner sc = new Scanner(System.in);
//        MyGraph<Integer> graph = getGraph(sc);
//
//        for (int node : graph.depthFirstSearch(0)) {
//            System.out.printf("%d ", node);
//        }
//    }
//
//    private MyGraph<Integer> getGraph(Scanner sc)
//    {
//        MyGraph<Integer> graph = new MyGraph<>();
//        int conn;
//
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++)
//        {
//            for (int j = 0; j < n; j++)
//            {
//                conn = sc.nextInt();
//                if (conn == 1)
//                {
//                    graph.add(i, j);
//                }
//            }
//        }
//
//        return graph;
//    }
//}