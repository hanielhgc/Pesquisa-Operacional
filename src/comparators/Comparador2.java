package comparators;
import java.util.Comparator;

public class Comparador2 implements Comparator<Pe�a>{
	//ordem decrescente
		public int compare(Pe�a o1, Pe�a o2) {
	        if (o1.getId() > o2.getId()) return -1;
	        else if (o1.getId() < o2.getId()) return +1;
	        else return 0;
	    }

	}