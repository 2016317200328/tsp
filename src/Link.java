public class Link implements Comparable{
    /**
     * le sommet de debut
     */
    private Node start;

    /**
     * le sommet de la fin
     */
    private Node end;

    /**
     * le poids (distance) entre les deux sommets.
     */
    private int weight;

    /**
     * construire une arrete a partir de deux sommets.
     * @param start sommet de debut
     * @param end sommet de fin
     * @param weight poids de l'arrete
     */
    public Link(Node start, Node end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    /**
     * construire une arrete a partir de deux indices (deux sommets)
     * @param start indice du sommet de depart
     * @param end indice du sommet de la fin
     * @param weight poids de l'arrete
     */
    public Link(int start, int end, int weight){
        this.start = new Node(start);
        this.end = new Node(end);
        this.weight = weight;
    }

    /**
     * getter
     * @return le sommet de depart
     */
    public Node getStart() {
        return start;
    }

    /**
     * getter
     * @return le sommet de fin
     */
    public Node getEnd() {
        return end;
    }


    @Override
    public String toString() {
        return "Link(" + start.getIndex() + ", " + end.getIndex() + ", w: " + weight + ")";
    }

    /**
     * Comparer deux arrete par leurs poids, sinon par leurs indices de debut.
     * sinon par leurs indice de fin
     * @param o une arrete
     * @return la difference entre les deux arrete(soit en poids ou indice de debut/fin)
     */
    @Override
    public int compareTo(Object o) {
        Link other = (Link)o;
        if ( weight != other.weight )
            return weight - other.weight;

        if ( !start.equals(other.start))
            return start.getIndex() - other.start.getIndex();

        if ( !end.equals(other.end))
            return end.getIndex() - other.end.getIndex();

        return 0;
    }
}
