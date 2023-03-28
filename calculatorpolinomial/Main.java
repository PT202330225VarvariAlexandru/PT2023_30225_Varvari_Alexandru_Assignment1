package calculatorpolinomial;

import java.util.HashMap;

import model.Polinom;
import modelinterf.InterfataCalculator;



public class Main {
    public static void main(String[] args) {
      
        HashMap<Integer, Integer> p1 = new HashMap<Integer, Integer>();
        p1.put(2, 3);
       p1.put(4, 2);
       p1.put(1, 7);
        p1.put(3, 4);
        p1.put(0, 5);

      HashMap<Integer, Integer> p2 = new HashMap<Integer, Integer>();
        p2.put(3, 3);
     
        p2.put(0, 2);

       
       Polinom polinom1 = new Polinom(p1);
        Polinom polinom2 = new Polinom(p2);
        

        
        Polinom rezultat = polinom1.aduna(polinom2);
        Polinom rezultat1 = polinom1.scade(polinom2);
       Polinom rezultat2 = polinom1.inmulteste(polinom2);
       Polinom rezultat3 = polinom1.deriveaza(polinom2);
       Polinom rezultat4 = polinom1.deriveaza(polinom1);
       
       System.out.println("Polinom 1: " + polinom1);
       System.out.println("Polinom 2: " + polinom2);
       
        System.out.println("Rezultatul adunarii: " + rezultat);
        System.out.println("Rezultatul scaderii: " + rezultat1);
       System.out.println("Rezultatul inmultirii: " + rezultat2);
       System.out.println("Rezultatul derivarii: " + rezultat3);


//  System.out.println(p.toString()); // va afișa: "2x^-1 + 3x^2"
//        String input = "2x^3+x";
//       Polinom p = polinom1.parsePolynomial(input);
//       if (p != null) {
//            System.out.println(p.toString());
//        } else {
//            System.out.println("Input invalid!");
//        }
        
      InterfataCalculator calculator = new InterfataCalculator();
      
      
    }
}
