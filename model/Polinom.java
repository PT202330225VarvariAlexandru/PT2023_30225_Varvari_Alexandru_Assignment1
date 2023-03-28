package model;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

import java.util.regex.*;



public class Polinom {
    private Map<Integer, Integer> terms;

    public Polinom() {
        this.terms = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        
    }

    public Polinom(Map<Integer, Integer> terms) {
        this.terms = terms;
    }

    public void adaugaMonom(Monom monom) {
        int exponent = monom.getExponent();
        int coeficient = monom.getCoeficient();

        if (terms.containsKey(exponent)) {
            int value = terms.get(exponent);
            terms.put(exponent, value + coeficient);
        } else {
            terms.put(exponent, coeficient);
        }
    }

    public Polinom aduna(Polinom p) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
            int exponent = entry.getKey();
            int coeficient = entry.getValue();

            rezultat.adaugaMonom(new Monom(coeficient, exponent));
        }

        for (Map.Entry<Integer, Integer> entry : p.terms.entrySet()) {
            int exponent = entry.getKey();
            int coeficient = entry.getValue();

            if (rezultat.terms.containsKey(exponent)) {
                int value = rezultat.terms.get(exponent);
                rezultat.terms.put(exponent, value + coeficient);
            } else {
                rezultat.terms.put(exponent, coeficient);
            }
        }

        return rezultat;
    }
    
    public Polinom scade(Polinom p) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
            int exponent = entry.getKey();
            int coeficient = entry.getValue();

            rezultat.adaugaMonom(new Monom(coeficient, exponent));
        }

        for (Map.Entry<Integer, Integer> entry : p.terms.entrySet()) {
            int exponent = entry.getKey();
            int coeficient = entry.getValue();

            if (rezultat.terms.containsKey(exponent)) {
                int value = rezultat.terms.get(exponent);
                rezultat.terms.put(exponent, value - coeficient);
            } else {
                rezultat.terms.put(exponent, coeficient);
            }
        }

        return rezultat;
    }
    
    public Polinom inmulteste(Polinom p) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
            int exponentp1 = entry.getKey();
            int coeficientp1 = entry.getValue();
            for (Map.Entry<Integer, Integer> entry2 : p.terms.entrySet()) {
                int exponentp2 = entry2.getKey();
                int coeficientp2 = entry2.getValue();

                int exponent = exponentp1 + exponentp2;
                int coeficient = coeficientp1 * coeficientp2;

                if (rezultat.terms.containsKey(exponent)) {
                    int value = rezultat.terms.get(exponent);
                    rezultat.terms.put(exponent, value + coeficient);
                } else {
                    rezultat.terms.put(exponent, coeficient);
            }
        }
        }

        return rezultat;
    }
    
    public Polinom deriveaza(Polinom p) {
        Polinom rezultat = new Polinom();

        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
           int exponent = entry.getKey();
           int coeficient = entry.getValue();
          if(exponent > 0) 
        rezultat.terms.put(exponent - 1, coeficient * exponent);	
        
        }
        

        return rezultat;
    }

    
    
   


     

    @Override
    public String toString() {
        String rezultat = "";

        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
            int exponent = entry.getKey();
            int coeficient = entry.getValue();

            if (coeficient != 0) {
                if (coeficient > 0 && !rezultat.isEmpty()) {
                    rezultat += "+";
                }

                if (exponent == 0) {
                    rezultat += coeficient;
                } else if (exponent == 1) {
                    rezultat += coeficient + "x";
                } else {
                    rezultat += coeficient + "x^" + exponent;
                }
            }
        }

        if (rezultat.isEmpty()) {
            rezultat = "0";
        }

        return rezultat;
    }
}