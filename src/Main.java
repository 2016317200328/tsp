import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static String displayArray(int[] array){
        String result = "";
        for (int i = 0; i < array.length; i++)
            result += array[i] + " ";
        return result;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(100);
        System.out.println(graph);

        // methode descente
        System.out.println("==========Methode Descente==========");
        Descente descente = new Descente(graph);
        descente.solve();

        // methode tabou
        System.out.println("==========Methode Tabou==========");
        Tabou tabou = new Tabou(graph);
        tabou.solve();

//         methode recuit simule
        System.out.println("==============Methode Recuit Simule==================");
        RecuitSimule recuitSimule = new RecuitSimule(graph);
        recuitSimule.solve();

        // methode VNS
        System.out.println("==============Methode VNS==================");
        VNS vns = new VNS(graph);
        vns.solve();

    }

}
