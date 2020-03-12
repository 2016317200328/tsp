import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * une class abstrait representant les methode de base pour un implementation de solution du TSP
 * @author khalil
 */
public abstract class Method {

    /**
     * Graph du probleme a resoudre
     */
    protected final Graph graph;

    /**
     * nombre de sommets dans le graphe.
     */
    protected final int numberOfNodes;

    /**
     * Une solution sous format d'un tableau compose des indices des sommets.
     * eg: [1, 2, 6, 8, 4, 5]
     */
    protected int solution[];

    public Method(Graph graph) {
        this.graph = graph;
        this.numberOfNodes = graph.getNumberOfNodes();
    }

    /**
     * Generer un solution Initial en se basant sur l'ensemble des arrete triés.
     * Pour chaque arrete si le debut et fin ne sont pas deja pris, alors on les considere dans la solution.
     * Pour chaque arrete si le debut ou fin est visite, alors on neglige cette arrete.
     * Pour chaque sommet pris on le marque comme visite.
     * @return tableau des indice des sommets
     */
    int[] getInitialSolution(){
        int[] initialSolution = new int[numberOfNodes];
        ArrayList<Node> takenNode = new ArrayList<>();
        int pos = 0;

        Iterator<Link> sortedLinks = graph.getSortedLinks().iterator();
        while (sortedLinks.hasNext() && pos < numberOfNodes){
            Link link = sortedLinks.next();
            if (link.getEnd().isVisited() || link.getStart().isVisited())
                continue;
            else{
                link.getStart().visit();
                link.getEnd().visit();

                // le sommet de debut n'est pas deja prix, pour eviter la repition dans le tableau
                if (!takenNode.contains(link.getStart())){
                    initialSolution[pos++] = link.getStart().getIndex();
                    takenNode.add(link.getStart());
                }

                // le sommet des fin n'est pas deja pris
                if ( !takenNode.contains(link.getEnd())){
                    initialSolution[pos++] = link.getEnd().getIndex();
                    takenNode.add(link.getEnd());
                }
            }
        }

        return initialSolution;
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
            int closedNodeIndex = getClosedNode(arbitrarySolution[pos], takenNodes);

            takenNodes.add(closedNodeIndex);
            arbitrarySolution[++pos] = closedNodeIndex;
        } while ( pos < arbitrarySolution.length - 1);

        return arbitrarySolution;
    }

    /**
     * trouver le plus proche sommet avec un cout minimal
     * @param currentNode sommet actuel
     * @param takenNodes les sommets deja pris
     * @return l'indice du plus proche sommet.
     */
    private int getClosedNode(int currentNode, ArrayList<Integer> takenNodes) {
        int minIndex =  (currentNode + 1 ) %  numberOfNodes;
        int minWeight = 99999999;

        // check all neighbours for minimum
        for (int i = 0; i < numberOfNodes; i++){
            if (i != currentNode && graph.getWeight(currentNode, i) < minWeight && !takenNodes.contains(i)){
                minWeight = graph.getWeight(currentNode, i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * trouver tous les voisins possible d'un chemin quelconque
     * @param path un chemin quelconque
     * @return un AraryList des voisins (sous format de tableaux)
     */
    protected ArrayList<int[]> getNeighboors(int[] path){
        ArrayList<int[]> neighboors = new ArrayList<>();
        for (int i = 1; i < numberOfNodes; i++){
            neighboors.add(opt2(path, 0, i));
        }
        return neighboors;
    }

    /**
     * renvoyer le chemin avec le cout minimum a partir d'une liste de chemins
     * @param neighboors la liste des chemin a iterer
     * @return le chemin avec le cout minimum
     */
    protected int[] getMinimumCostPath(ArrayList<int[]> neighboors){
        int n = neighboors.size();
        int[] minimumCostNeighboor = neighboors.get(0);
        int minimumCost = getCost(minimumCostNeighboor);

        for (int i = 0; i < n; i++){
            if (getCost(neighboors.get(i)) < minimumCost ){
                minimumCostNeighboor = neighboors.get(i);
                minimumCost = getCost(minimumCostNeighboor);
            }
        }
        return minimumCostNeighboor;
    }

    /**
     * calculer le cout d'un solution quelconque
     * @param path une solution quelconque
     * @return le cout du chemin
     */
    protected int getCost(int[] path){
        int cost = 0;
        for (int i = 0; i < path.length -1; i++)
            cost += graph.getWeight(path[i], path[i+1]);
        cost += graph.getWeight(path[path.length-1], path[0]);
        return cost;
    }

    /**
     * echanger deux sommets dans une solution
     * @param path un solution quelconque
     * @param i position 1
     * @param j position 2
     * @return un tableau out deux sommets sont echange
     */
    public static int[] opt2(int[] path, int i , int j){
        int result[] = path.clone();
        int tmp = result[i];
        result[i] = result[j];
        result[j] = tmp;

//        i = i++ % path.length;
//        j = j++ % path.length;
//
//        tmp = result[i];
//        result[i] = result[j];
//        result[j] = tmp;
        return result;
    }

    public abstract void solve();

    public static void displaySolution(int[] solution){
        String representation = "";
        for (int i = 0; i< solution.length; i++)
            representation += solution[i] + " ";

        System.out.println(representation);
    }

}
