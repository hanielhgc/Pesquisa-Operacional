package beans;

import java.util.ArrayList;

public class Cromossomo {
	
	//conjunto de pe�as que forma uma solu��o
	ArrayList <Pe�a> pe�asCrom = new ArrayList<>();
	
	//armazena o qu�o eficiente foi a solu��o
	double fitness;
	
	
	public ArrayList<Pe�a> getPe�asCrom() {
		return pe�asCrom;
	}
	public void setPe�asCrom(ArrayList<Pe�a> pe�asCrom) {
		this.pe�asCrom = pe�asCrom;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public Cromossomo(ArrayList<Pe�a> pe�asCrom, double fitness) {
		super();
		this.pe�asCrom = pe�asCrom;
		this.fitness = fitness;
	}
	public Cromossomo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
