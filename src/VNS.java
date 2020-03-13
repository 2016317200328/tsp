import com.sun.source.doctree.LiteralTree;

public class VNS extends Method {
    private static final int NB_MAX_ITERATION = 50;

    public VNS(Graph graph) {
        super(graph);
    }

    @Override
    public void solve() {

        int[] solution = getInitialSolution();
        int initialCost = getCost(solution);
        int iteration = 0;
        int n = 0;

        System.out.println("Initial Solution: " + Main.displayArray(solution));
        System.out.println("Initial Cost: " + getCost(solution));

        do {
            int k = 0;
            do {
                int[] randomSolution = neighboor(solution, k);
                int[] bestSolution = new Descente(this.graph).solve(randomSolution);
                if ( getCost(bestSolution) < getCost(solution)){
                    solution = bestSolution;
                    k = 0;
                } else
                    k++;
            } while (k <= n);
        } while (iteration++ < NB_MAX_ITERATION);

        this.solution = solution;

        System.out.println("Final Solution: " + Main.displayArray(solution));
        System.out.println("Final Cost: " + getCost(solution));
        System.out.println("Solution ratio: " + getCost(solution) * 100 / (double)initialCost);
    }

    private int[] neighboor(int[] solution, int k) {
            switch (k){
                case 1: return opt3(solution);
                case 2: return opt4(solution);
                default: return opt2(solution);
            }
    }
}
