
public class Node implements Comparable{
    /**
     * indice du sommet dans la matrice des poids
     */
    private int index;

    /**
     * un sommet est visite si on entre et on sorte par ce sommet.
     * a chaque entre on incremente cette variable, a chaque sortie on fait la meme chose.
     * un sommet est considere comme visite si ce variable vaut un valeu superieur a deux.
     */
    private int timeVisited = 0;

    public Node(int index) {
        this.index = index;
    }

    /**
     * verifier si le sommet est visite (on entre par lui et on sort aussi) plus qu'un seul fois
     * @return true s'il est visite plus qu'un seul fois, sinon faux
     */
    public boolean isVisited(){
        return timeVisited > 2;
    }


    /**
     * visite le sommet en changeant son etat, cela correspont a une entre ou une sortie.
     */
    public void visit(){
        timeVisited++;
    }

    /**
     * deux sommet sont eqaux s'ils ont le meme indice
     * @param obj un sommet
     * @return vrai si les deux sommet sont egaux, sinon faux
     */
    @Override
    public boolean equals(Object obj) {
       return index == ((Node)obj).index;
    }

    /**
     * renvoyer l'indice du sommet dans la matrice represantant le graphe
     * @return indice du sommet
     */
    public int getIndex() {
        return index;
    }

    /**
     * comparer deux sommet on comparant leurs indices.
     * @param o un sommet
     * @return la difference entre les indices des sommets
     */
    @Override
    public int compareTo(Object o) {
        return index - ((Node)o).index;
    }

    @Override
    public String toString() {
       return "Node(" + index + ")";
    }

}
