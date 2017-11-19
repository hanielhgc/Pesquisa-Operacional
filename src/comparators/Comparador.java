package comparators;
import java.util.Comparator;

import beans.Cromossomo;

public class Comparador implements Comparator<Cromossomo> {
 
	
	//ordem crescente
	public int compare(Cromossomo o1, Cromossomo o2) {
        if (o1.getFitness() > o2.getFitness()) return +1;
        else if (o1.getFitness() < o2.getFitness()) return -1;
        else return 0;
    }

}