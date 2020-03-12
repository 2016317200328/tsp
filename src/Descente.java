import java.util.ArrayList;
import java.util.Random;

public class Descente extends Method {

    public Descente(Graph graph) {
        super(graph);
    }

    /**
     * trouver un solution avec la methode descente.
     * @return la solution de probleme.
     */
    @Override
    public void solve() {
        int[] solution = getInitialSolution();
        int initialCost = getCost(solution);

        System.out.println("Initial Solution: " + Main.displayArray(solution));
        System.out.println("Initial Cost: " + initialCost);

        while (true){
            ArrayList<int[]> neighboors = getNeighboors(solution);
            int[] minCostNeighboor = getMinimumCostPath(neighboors);

            if ( getCost(solution) <= getCost(minCostNeighboor) )
                break;
            else
                solution = minCostNeighboor;
        }

        this.solution = solution;

        System.out.println("Final Solution: " + Main.displayArray(solution));
        System.out.println("Final Cost: " + getCost(solution));
        System.out.println("Solution ratio: " + getCost(solution) * 100 / (double)initialCost);
    }

}