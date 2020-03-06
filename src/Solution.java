public class Solution {
    private int[] solution;
    private int pos = 0;
    private int cost = 0;
    private final Graph graph;

    public Solution(Graph graph){
        this.graph = graph;
        this.solution = new int[graph.getNumberOfNodes()];
    }

    /**
     * calculer le cout d'un solution
     * @return cout d'un solution
     */
    public int getCost(){
        int cost = 0;
        for (int i = 0; i < solution.length -1; i++)
            cost += graph.getWeight(solution[i], solution[i+1]);
        return cost;
    }

    /**
     * generer un voisin avec 2-opt
     * @return
     */
    public int[] getNeighbors(){
        return null;
    }

    /**
     * ajouter un sommet a la solution
     * @param i indice du sommet
     */
    public void addNode(int i){
        solution[pos++] = i;
    }

    @Override
    public String toString() {
        String representation = "";
        for (int i = 0; i < solution.length; i++)
            representation += solution[i] + " ";
        return representation;
    }

    public int getNodeIndex(int i) {
        return solution[i];
    }
}
