import java.util.ArrayList;
import java.util.Random;

public class Method {

    protected final Graph graph;
    protected final int numberOfNodes;
    protected int solution[];

    public Method(Graph graph) {
        this.graph = graph;
        this.numberOfNodes = graph.getNumberOfNodes();
    }

    /**
     * Generer une solution initiale.
     * trier les arêtes par ordre des coûts croissants, sélectionner dans l&#39;ordre les arrêtes
     * autorisées.
     * @return tableau des indice des sommets
     */
    int[] getInitialSolution(){
        return null;
    }

    /**
     * Generer une solution Arbitraire (aleatoire)
     * choisir un sommet de départ arbitraire,  à chaque étape, choisir le plus « proche »
     * voisin.
     * @return tableau des indice des sommets
     */
    int[] getAribitrarySolution(){
        int[] arbitrarySolution = new int[numberOfNodes];
        arbitrarySolution[0] = (new Random()).nextInt(numberOfNodes - 1);
        int pos = 0;

        ArrayList<Integer> takenNodes = new ArrayList<>();
        takenNodes.add(arbitrarySolution[0]);

        do {
            int currentNode = arbitrarySolution[pos];
            int minIndex =  (currentNode + 1 ) %  numberOfNodes;
            int minWeight = 99999999;

            // check all neighbours for minimum
            for (int i = 0; i < numberOfNodes; i++){
                if (i != currentNode && graph.getWeight(currentNode, i) < minWeight && !takenNodes.contains(i)){
                    minWeight = graph.getWeight(currentNode, i);
                    minIndex = i;
                }
            }
            
            takenNodes.add(minIndex);
            arbitrarySolution[++pos] = minIndex;
        } while ( pos < arbitrarySolution.length - 1);

        return arbitrarySolution;
    }


}
