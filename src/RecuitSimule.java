import com.sun.source.doctree.LiteralTree;

import java.lang.invoke.LambdaConversionException;
import java.util.Random;

public class RecuitSimule extends Method {


    private final static int MAX_TEMPERATURE = 10000;
    private final static int MAX_ITERATION = 100;
    private static final double LAMBDA = 0.99;

    public RecuitSimule(Graph graph) {
        super(graph);
    }

    /**
     * check this website:https://fr.wikipedia.org/wiki/Recuit_simul%C3%A9#Pseudo-code
     * @return
     */
    @Override
    public int[] solve() {
        int initialSolution[] = getAribitrarySolution();
        double temperature = (double)MAX_TEMPERATURE;
        int iteration = 0;

        while ( iteration++ < MAX_ITERATION && temperature > 0.1 ){
            boolean conditionEquilibre = false;
            do {
                int[] solutionAleatoire = generateNeighboor(initialSolution);
                double r = Math.random();

                if ( r < boltezman(initialSolution, solutionAleatoire, MAX_TEMPERATURE)){
                    initialSolution = solutionAleatoire;
                    conditionEquilibre = true;
                }
            } while (!conditionEquilibre);
            temperature = updateTemperature(temperature);
        }
        return initialSolution;
    }

    private int[] generateNeighboor(int[] path) {
        int i = new Random().nextInt(path.length);
        int j = new Random().nextInt(path.length);
        while (j == i)
            j = new Random().nextInt(path.length);

        return opt2(path, i, j);
    }

    private double updateTemperature(double temperature) {
        return temperature * LAMBDA;
    }

    private double boltezman(int[] solutionCourant, int[] solutionAleatoire, double temperature) {
        double tmp = - Math.abs(getCost((getInitialSolution())) - getCost(solutionCourant)) / temperature;
        return Math.exp(tmp);
    }
}
