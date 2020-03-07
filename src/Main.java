import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        Tabou tabouSolver = new Tabou(graph);
        Descente descenteSolver = new Descente(graph);


        System.out.println("Methode Tabou");
        int[] tabouInitSolution = tabouSolver.getInitialSolution();
        int tabouInitCost = tabouSolver.getCost(tabouInitSolution);


        int[] tabouSolution = tabouSolver.solve();
        int tabouSolutionCost = tabouSolver.getCost(tabouSolution);

        System.out.println("Initial Solution: ");
        for (int i = 0; i < tabouInitSolution.length; i++) System.out.printf(" %d", tabouInitSolution[i]);
        System.out.println("initial cost: " + tabouInitCost);

        System.out.println("Final Solution: ");
        for (int i = 0; i < tabouSolution.length; i++) System.out.printf(" %d", tabouSolution[i]);
        System.out.println("initial cost: " + tabouSolutionCost);


        System.out.println("Methode Descente");
        int[] descenteInitSolution = descenteSolver.getInitialSolution();
        int descenteInitCost = descenteSolver.getCost(descenteInitSolution);


        int[] descenteSolution = descenteSolver.solve();
        int descenteSolutionCost = descenteSolver.getCost(descenteInitSolution);

        System.out.println("Initial Solution: ");
        for (int i = 0; i < descenteInitSolution.length; i++) System.out.printf(" %d", descenteInitSolution[i]);
        System.out.println("initial cost: " + descenteInitCost);

        System.out.println("Final Solution: ");
        for (int i = 0; i < descenteSolution.length; i++) System.out.printf(" %d", descenteSolution[i]);
        System.out.println("initial cost: " + descenteSolutionCost);
    }
}
