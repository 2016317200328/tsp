import java.util.ArrayList;
import java.util.Random;

public class Descente extends Method {
    private final int NB_VOISIN;

    public Descente(Graph graph) {
        super(graph);
        this.NB_VOISIN = graph.getNumberOfNodes() / 2;
    }

    @Override
    public int[] solve() {
        int[] initialSolution = getInitialSolution();
        int cost = getCost(initialSolution);

        while (true){
            ArrayList<int[]> neighboors = getNeighboors(initialSolution);
            int[] minCostNeighboor = getMinimumCostPath(neighboors);
            int minCost = getCost(minCostNeighboor);

            if ( cost < minCost )
                break;
            else {
                initialSolution = minCostNeighboor;
                cost = minCost;
            }
        }

        return initialSolution;
    }

}