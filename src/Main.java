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

        Graph graph = new Graph(37);
        System.out.println(graph);

        // methode descente
        System.out.println("==========Methode Descente==========");
        Descente descente = new Descente(graph);

        int[] descenteInitSolution = descente.getInitialSolution();
        int descenteInitCost = descente.getCost(descenteInitSolution);
        System.out.println("Initial Solution: " + displayArray(descenteInitSolution));
        System.out.println("Initial Cost:" + descenteInitCost);

        int[] descenteSolution = descente.solve();
        int descenteSolutionCost = descente.getCost(descenteSolution);
        System.out.println("Final Solution: " + displayArray(descenteSolution));
        System.out.println("Final Cost: " + descenteSolutionCost);


        // methode tabou
        System.out.println("==========Methode Tabou==========");
        Tabou tabou = new Tabou(graph);

        int[] tabouInitSolution = tabou.getInitialSolution();
        int tabouInitCost = tabou.getCost(tabouInitSolution);
        System.out.println("Initial Solution: " + displayArray(tabouInitSolution));
        System.out.println("Initial cost: " + tabouInitCost);

        int[] tabouSolution = tabou.solve();
        int tabouCost = tabou.getCost(tabouSolution);
        System.out.println("Final Solution: " + displayArray(tabouSolution));
        System.out.println("Final Cost: " + tabouCost);

        // methode recuit simule
        System.out.println("==============Methode Recuit Simule==================");
        RecuitSimule recuitSimule = new RecuitSimule(graph);
        int[] recuitInitsolution = recuitSimule.getInitialSolution();
        int recuitInitCost = recuitSimule.getCost(recuitInitsolution);
        System.out.println("Initial Solution: " + displayArray(recuitInitsolution));
        System.out.println("Initial cost: " + recuitInitCost);

        int[] recuitSolution = recuitSimule.solve();
        int recuitCost = recuitSimule.getCost(recuitSolution);
        System.out.println("Final Solution: " + displayArray(recuitSolution));
        System.out.println("Final Cost: " + recuitCost);
    }

    public static void tester(int n){

        HashMap<String, Integer> testResult = new HashMap<String, Integer>();
        testResult.put("Descente", 0);
        testResult.put("Tabou", 0);
        testResult.put("equality", 0);

        for (int i = 0; i < n; i++){

            Graph grap = new Graph(30);
            Method descente = new Descente(grap);
            Method tabou = new Tabou(grap);

            int[] descenteSol = descente.solve();
            int descenteCost = descente.getCost(descenteSol);

            int[] tabouSol = tabou.solve();
            int tabouCost = tabou.getCost(tabouSol);

            if (tabouCost > descenteCost)
                testResult.put("Descente", testResult.get("Descente") + 1);
            else if ( tabouCost < descenteCost)
                testResult.put("Tabou", testResult.get("Tabou") + 1);
            else
                testResult.put("equality", testResult.get("equality") + 1);
        }

        System.out.println("+=============================================================+");
        System.out.printf("Descente: %d, Tabou: %d, Equality: %d\n",
                testResult.get("Descente"),
                testResult.get("Tabou"),
                testResult.get("equality"));

        System.out.println("+=============================================================+");

    }
}
