import java.util.ArrayList;
import java.util.Random;

public class Tabou extends Method {

    private final static int MAX_TABU_SIZE = 2000;
    private static final int MAX_ITERATION = 10000;
    private ArrayList<int[]> tabuList = new ArrayList<>(MAX_TABU_SIZE);

    public Tabou(Graph graph) {
        super(graph);
    }

    protected ArrayList<int[]> getNeighboors(int[] path, ArrayList<int[]> tabuList) {
        ArrayList<int[]> neighboors = new ArrayList<>();
        int iteration = 0;
        while ( iteration++ < path.length ){
            int i = new Random().nextInt(path.length);
            int j = new Random().nextInt(path.length);
            while ( j == i )
                j = new Random().nextInt(path.length);
            neighboors.add(opt2(path, i, j));
        }
        return neighboors;
    }

    @Override
    public void solve() {
        int[] solution = getInitialSolution();
        int initialCost = getCost(solution);
        tabuList.add(solution);

        System.out.println("Initial Solution: " + Main.displayArray(solution));
        System.out.println("Final Solution: " + initialCost);

        int iteration = 0;
        while (iteration++ < MAX_ITERATION){
            ArrayList<int[]> neighboors = getNeighboors(solution, tabuList);
            int[] minCostNeighboor = getMinimumCostPath(neighboors);

            tabuList.add(minCostNeighboor);
            if ( tabuList.size() >= MAX_TABU_SIZE)
                tabuList.remove(0);

            if ( getCost(minCostNeighboor) < getCost(solution) )
                solution = minCostNeighboor;

        }
        this.solution = solution;

        System.out.println("Final Solution: " + Main.displayArray(solution));
        System.out.println("Final Cost: " + getCost(solution));
        System.out.println("Solution Ratio: " + getCost(solution)*100 / (double)initialCost);
    }
}
