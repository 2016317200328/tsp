import java.util.Random;
import java.util.*;

/**
 * @author khalil
 */

public class Graph {
    /**
     * le nombre de sommets.
     */
    private int size;

    /**
     * matrice des pois des arretes.
     */
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

    /**
     * renvoyer une arbre de des arete non duplique (trie par defaut)
     * Deux arrete ayant le meme debut et fin (ou sommets echange) sont considere egaux
     * eg: 1-2 est egal a 2-1
     * @return arbre des arsetes triee
     */
    TreeSet<Link> getSortedLinks(){
        TreeSet<Link> sortedLinks = new TreeSet<>((l1, l2) -> l1.compareTo(l2));
        for (int i = 0; i < this.size; i++){
            for (int j = i + 1; j < this.size; j++){
                Node start = new Node(i);
                Node end = new Node(j);
                Link link = new Link(start, end, matrix[i][j]);
                sortedLinks.add(link);
            }
        }
        return sortedLinks;
    }


    /**
     * renvoyer le nombre des sommets
     * @return nombre de sommets
     */
    public int getNumberOfNodes() {
        return this.size;
    }

    @Override
    public String toString() {
        String representation = "";
        for (int i = 0; i < this.size; i++){
            for (int j = 0 ; j < this.size; j++){
                representation += matrix[i][j] + "\t";
            }
            representation += "\n";
        }
        return representation;
    }

}
