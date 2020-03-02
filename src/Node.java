public class Node implements Comparable{
    private int index;
    private boolean isVisited;
    private int timeVisited = 0;

    public Node(int index) {
        this.index = index;
        this.isVisited = false;
    }

    public boolean isVisited(){
        return timeVisited > 2;
    }

    public void setVisited(){
        timeVisited = 3;
    }

    public void setNotVisite(){
        timeVisited = 0;
    }

    public void visit(){
        timeVisited++;
    }

    @Override
    public boolean equals(Object obj) {
       return index == ((Node)obj).index;
    }

    public int getIndex() {
        return index;
    }

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
