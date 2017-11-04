package beans;

import java.util.ArrayList;

public class Cromossomo {
	
	//conjunto de peças que forma uma solução
	ArrayList <Peça> peçasCrom = new ArrayList<>();
	
	//armazena o quão eficiente foi a solução
	double fitness;
	
	
	public ArrayList<Peça> getPeçasCrom() {
		return peçasCrom;
	}
	public void setPeçasCrom(ArrayList<Peça> peçasCrom) {
		this.peçasCrom = peçasCrom;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public Cromossomo(ArrayList<Peça> peçasCrom, double fitness) {
		super();
		this.peçasCrom = peçasCrom;
		this.fitness = fitness;
	}
	public Cromossomo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
