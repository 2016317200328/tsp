public class Link implements Comparable{
    private Node start;
    private Node end;
    private int weight;

    public Link(Node start, Node end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Link(int start, int end, int weight){
        this.start = new Node(start);
        this.end = new Node(end);
        this.weight = weight;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Link(" + start.getIndex() + ", " + end.getIndex() + ", w: " + weight + ")";
    }

    /**
     * Compare Linke by weight;
     * @param o
     * @return
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
