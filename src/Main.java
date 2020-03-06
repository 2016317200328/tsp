import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        Descente solver = new Descente(graph);

        int[] initSolution = solver.getInitialSolution();
        int intCost = solver.getCost(initSolution);

        int[] solution = solver.solve();
        int solutionCost = solver.getCost(solution);

        System.out.println("Initial Solution: ");
        for (int i = 0; i < initSolution.length; i++) System.out.printf(" %d", initSolution[i]);
        System.out.println("initial cost: " + intCost);

        System.out.println("Final Solution: ");
        for (int i = 0; i < solution.length; i++) System.out.printf(" %d", solution[i]);
        System.out.println("initial cost: " + solutionCost);

    }
}
