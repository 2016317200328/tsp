import java.util.Random;

public class RecuitSimule extends Method {


    private final static int MAX_TEMPERATURE = 1000000000;
    private final static int MAX_ITERATION = 100;
    private static final double COOLING_RATE = 0.003;

    public RecuitSimule(Graph graph) {
        super(graph);
    }

    /**
     * check this website:https://fr.wikipedia.org/wiki/Recuit_simul%C3%A9#Pseudo-code
     * @return
     */
    @Override
    public void solve() {
        int[] currentSolution = getInitialSolution();
        int[] bestSolution = currentSolution;
        int initialCost = getCost(currentSolution);

        System.out.println("Initial solution: " + Main.displayArray(currentSolution));
        System.out.println("Initial cost: " + initialCost);

        double temperature = MAX_TEMPERATURE;
        while ( temperature > 1){
            int[] arbitraryNeighboor = generateAribtraryNeighboor(currentSolution);
            if ( boltezman(currentSolution, arbitraryNeighboor, temperature) > Math.random())
                currentSolution = arbitraryNeighboor;

            if (getCost(currentSolution) < getCost(bestSolution))
                bestSolution = currentSolution;
            temperature = updateTemperature(temperature);
        }
        this.solution = bestSolution;

        System.out.println("Final solution: " + Main.displayArray(bestSolution));
        System.out.println("Final solution: " + getCost(bestSolution));
        System.out.println("solution ratio: " + getCost(bestSolution)*100 / (double)initialCost);
    }

    private int[] generateAribtraryNeighboor(int[] path) {
        int i = new Random().nextInt(path.length);
        int j = new Random().nextInt(path.length);
        while (j == i)
            j = new Random().nextInt(path.length);

        return opt2(path, i, j);
    }

    private double updateTemperature(double temperature) {
        return temperature * ( 1- COOLING_RATE);
    }

    private double boltezman(int[] solutionCourant, int[] solutionAleatoire, double temperature) {
        if ( getCost(solutionCourant) > getCost(solutionAleatoire))
            return 1.0;
        else
            return Math.exp((getCost(solutionCourant) - getCost(solutionAleatoire)) / temperature);
    }
}
