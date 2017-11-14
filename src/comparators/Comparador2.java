package comparators;
import java.util.Comparator;

public class Comparador2 implements Comparator<Peça>{
	//ordem decrescente
		public int compare(Peça o1, Peça o2) {
	        if (o1.getId() > o2.getId()) return -1;
	        else if (o1.getId() < o2.getId()) return +1;
	        else return 0;
	    }

	}