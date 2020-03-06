import java.util.Random;
import java.util.*;

public class Graph {
    private int size;
    private int[][] matrix;

    /**
     * consturcteur qui va generer une matrice de deux dimension representant le graphe
     * @param size le nombre des sommets
     */
    public Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++){
            for (int j = i; j < size; j++){
                if ( i == j )
                    matrix[i][j] = 0;
                else{
                    int randomInt = random.nextInt(40) + 1;
                    matrix[i][j] = randomInt;
                    matrix[j][i] = randomInt;
                }
            }
        }
    }

    /**
     * renvoyer le poids de l'arete liant le sommet i et j
     * @param i un sommet
     * @param j un sommet
     * @return poid entre deux sommets
     */
    public int getWeight(int i, int j){
        return matrix[i][j];
    }

    @Override
    public String toString() {
        String representation = "";
        for (int i = 0; i < this.size; i++){
            for (int j = 0 ; j < this.size; j++){
                representation += " " + matrix[i][j];
            }
            representation += "\n";
        }
        return representation;
    }

    /**
     * renvoyer une arbre de des arete non duplique (trie par defaut)
     * @return arbre des arete triee
     */
    TreeSet<Link> getSortedLinks(){
        TreeSet<Link> sortedLinks = new TreeSet<>((l1, l2) -> l1.compareTo(l2));
        TreeSet<Node> visiteNodes = new TreeSet<>((n1, n2) -> n1.compareTo(n2));

        for (int i = 0; i < this.size; i++){
            for (int j = i + 1; j < this.size; j++){
                Node start = new Node(i);
                Node end = new Node(j);
                Link link = new Link(start, end, matrix[i][j]);

                // filter 1-2 and 2-1
                if (visiteNodes.contains(start) || visiteNodes.contains(end))
                    continue;
                else{
                    sortedLinks.add(link);
                    start.visit();
                    end.visit();

                    if (start.isVisited())
                        visiteNodes.add(start);
                    if (end.isVisited())
                        visiteNodes.add(end);
                }
            }
        }
        return sortedLinks;
    }


    /**
     * renvoyer le nombre des sommets
     * @return
     */
    public int getNumberOfNodes() {
        return this.size;
    }
}
