import java.util.ArrayList;

public class Tabou extends Method {

    private final static int MAX_TABU_SIZE = 1000;
    private static final int MAX_ITERATION = 10000;
    private ArrayList<int[]> tabuList = new ArrayList<>(MAX_TABU_SIZE);

    public Tabou(Graph graph) {
        super(graph);
    }

    protected ArrayList<int[]> getNeighboors(int[] path, ArrayList<int[]> tabuList) {
        ArrayList<int[]> neighboors = new ArrayList<>();
        for (int i = 1; i < numberOfNodes; i++){
            int[] neighboor = opt2(path, 0, i);
            if (!tabuList.contains(neighboor))
                neighboors.add(opt2(path, 0, i));
        }
        return neighboors;
    }

    @Override
    public int[] solve() {
        int[] solution = getAribitrarySolution();
        int solutionCost = getCost(solution);
        tabuList.add(solution);


        int iteration = 0;
        while (iteration++ < MAX_ITERATION){
            ArrayList<int[]> neighboors = getNeighboors(solution, tabuList);
            int[] minCostNeighboor = getMinimumCostPath(neighboors);
            int minCost = getCost(minCostNeighboor);

            tabuList.add(minCostNeighboor);
            if ( tabuList.size() >= MAX_TABU_SIZE)
                tabuList.remove(0);

            if ( minCost < solutionCost ) {
                solution = minCostNeighboor;
                solutionCost = minCost;
            }
        }
        return solution;
    }
}
