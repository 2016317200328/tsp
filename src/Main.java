import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        System.out.println(graph);
        TreeSet<Link> links = graph.getSortedLinks();
        for (Link link: links)
            System.out.println(link);

        Method method = new Method(graph);
        int[] foo = method.getAribitrarySolution();
        for (int i = 0; i < foo.length; i++) System.out.println(foo[i]);
    }
}
