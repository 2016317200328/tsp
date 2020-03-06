public class Node implements Comparable{
    private int index;
    private boolean isVisited;
    private int timeVisited = 0;

    public Node(int index) {
        this.index = index;
        this.isVisited = false;
    }

    /**
     * verifier si le sommet est visite (un arete entrant et un autre sortant) plus qu'un seul fois
     * @return true s'il est visite plus qu'un seul fois, sinon faux
     */
    public boolean isVisited(){
        return timeVisited > 2;
    }

    /**
     * changer l'etat du sommet a un sommet visite
     */
    public void setVisited(){
        timeVisited = 3;
    }

    /**
     * changer l'etat d'un sommet a un sommet non visite
     */
    public void setNotVisite(){
        timeVisited = 0;
    }

    /**
     * visite le sommet en changeant son etat
     */
    public void visit(){
        timeVisited++;
    }

    /**
     * deux sommet sont eqaux s'ils ont le meme indice
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
       return index == ((Node)obj).index;
    }

    /**
     * renvoyer l'indice du sommet dans la matrice represantant le graphe
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * comparer les indices des sommets
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return index - ((Node)o).index;
    }

    @Override
    public String toString() {
       return "Node(" + index + ")";
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
