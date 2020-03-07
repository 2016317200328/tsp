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
    public int[] solve() {
        int[] solution = getInitialSolution();
        int solutionCost = getCost(solution);

        while (true){
            ArrayList<int[]> neighboors = getNeighboors(solution);
            int[] minCostNeighboor = getMinimumCostPath(neighboors);
            int minCost = getCost(minCostNeighboor);

            if ( solutionCost <= minCost )
                break;
            else {
                solution = minCostNeighboor;
                solutionCost = minCost;
            }
        }

        return solution;
    }

}