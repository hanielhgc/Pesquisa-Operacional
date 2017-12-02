package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import beans.Cromossomo;
import beans.Peça;
import comparators.Comparador;

public class MainFinal {

public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double [] vertices = new double[8];
		int escolha;
		int cont =0;
		int qtde;
		ArrayList <Peça> peças = new ArrayList<>(); 
		int populacao = 80;
		
		Cromossomo melhorResultado = new Cromossomo();
		melhorResultado.setFitness(99999);
		boolean melhorMudou=false;
		
		
		while (true) {
			System.out.println("Informe a peça a ser inserida: (nova peça = 1, concluir = 0)");
			escolha = scanner.nextInt();
			
			if(escolha == 0){
				break;
			}else{
				System.out.println("Informe a quantidade de peças desse tipo:");
				qtde = scanner.nextInt();
			
				System.out.println("Informe o ponto x1 (x,y)");
				vertices[0]=scanner.nextDouble();
				System.out.println("Informe o ponto y1 (x,y)");
				vertices[1]=scanner.nextDouble();
				System.out.println("Informe o ponto x2 (x,y)");
				vertices[2]=scanner.nextDouble();
				System.out.println("Informe o ponto y2 (x,y)");
				vertices[3]=scanner.nextDouble();
				System.out.println("Informe o ponto x3 (x,y)");
				vertices[4]=scanner.nextDouble();
				System.out.println("Informe o ponto y3 (x,y)");
				vertices[5]=scanner.nextDouble();
				System.out.println("Informe o ponto x4 (x,y)");
				vertices[6]=scanner.nextDouble();
				System.out.println("Informe o ponto y4 (x,y)");
				vertices[7]=scanner.nextDouble();
				
				
				//for para criar o nçmero de peças fornecido pelo usuçrio
				for (int i = 0; i < qtde; i++) {
					
					//cria uma nova instçncia de peça com ID çnico, faz o cçlculo da çrea e a adiciona ao Array
					Peça p = new Peça(vertices,90, vertices[0], vertices[1],cont);
					p.setArea(vertices);
					p.setRotaçao(90);
					peças.add(p);
					//incrementa o contador de ID
					cont++;
					
				}
				
				
				
			}
		
		}
		
		
		
		
		ArrayList <Peça> peças2 = new ArrayList<>(); 

		//clone do Array que nço modifica o Array original
		peças2 = (ArrayList<Peça>)peças.clone();
		
		//embaralhando as peças do array
		Collections.shuffle(peças2);
		
		//exibir as peças do Array
		for (int i = 0; i < peças2.size(); i++) {
			System.out.println(peças2.get(i).getId());
		}
		
		//Array de cromossomos. Cromossomo = conjunto de peças em uma ordem que resulta em uma soluçço
				ArrayList<Cromossomo> cromossomos = new ArrayList<>();
				
				
				//cria 80 (populaçço) cromossomos diferentes de ordem randçmica
				for (int i = 0; i < populacao; i++) {
				
					Cromossomo cromossomo = new Cromossomo();
					peças2 = (ArrayList<Peça>)peças.clone();
					Collections.shuffle(peças2);
					
					
					//torna a rotaçço da peça aleatçria (se o random for par, a rotaçço serç 90. Se for çmpar, 0)
					for (int j = 0; j < peças2.size(); j++) {
						double aux = Math.random();
						if(aux > 0.5){
							peças2.get(j).setRotaçao(90);
						}else{
							peças2.get(j).setRotaçao(0);
					}
					}
					
					
					
					
					//cromossomo recebe peças (soluçço) e o cromossomo ç adicionado ao Array de cromossomos
					cromossomo.setPeçasCrom(peças2);
					//recebendo fitness
					cromossomo.setFitness(aleatoriar(5, 7));
					cromossomos.add(cromossomo);
					
					
				
				}
		
				
				
				
		
				//rotacionar o poligono baseado no angulo
				
				for (int k = 0; k < cromossomos.size(); k++) {
					
					ArrayList<Peça> peças3 = new ArrayList();
					
					peças3 = cromossomos.get(k).getPeçasCrom();
					
				
				
				for (int l = 0; l < peças3.size(); l++) {
					
					
					
					if(peças3.get(l).getRotaçao() == 0){
						
					}else{
						double aux;
						double aux2;
						double [] vert = new double[8];
						double [] ref = new double[2];
						double base;
						double altura;
						
						
						
						vert = peças3.get(l).getVertices();
						
						base =  Math.abs((vert[1]-vert[3]));
						altura =  Math.abs((vert[0]-vert[4]));
						
						vert[2] = vert[0];
						vert[3] = vert[1]+altura;
						vert[4] = vert[0]-base;
						vert[5] = vert[1]+altura;
						vert[6] = vert[0]-base;
						vert[7] = vert[1];
								
						 peças3.get(l).setVertices(vert);
						 
						 cromossomos.get(k).setPeçasCrom(peças3);
						 
						 
					}
					
				}	
				}
					
				
				/*
				//exibir todos os resultados de cada cromossomo com o fitness
				for (int i = 0; i < cromossomos.size(); i++) {
					
					System.out.println("------");
					System.out.println("Fitness: "+ cromossomos.get(i).getFitness());
					ArrayList<Peça> p9 = new ArrayList<>();
					p9=cromossomos.get(i).getPeçasCrom();
					for (int j = 0; j < p9.size(); j++) {
						System.out.println(p9.get(j).getId());
							
						
					}
					
				}
				
				*/
				
				ArrayList<Cromossomo> pais = new ArrayList();
				ArrayList<Cromossomo> maes = new ArrayList();
				
				
				int acum = 0;
				while (acum < 40) {
					
					for (int i = 0; i < populacao/2; i++) {
						
						pais.add(roleta(cromossomos, populacao));
						maes.add(roleta(cromossomos, populacao));
						
					}
					
					
					for (int i = 0; i < pais.size(); i++) {
						
						//pais viram filhos
						pais.get(i).setPeçasCrom(Crossover(pais.get(i).getPeçasCrom(), maes.get(i).getPeçasCrom()));
						
						//aqui precisa ser mudado quando encontrar o metodo para obter o fitness
						pais.get(i).setFitness(aleatoriar(5,7));
						
					}
					
					
					for (int i = 0; i < pais.size(); i++) {
						
						cromossomos.add(pais.get(i));
						
					}
					
					//limpar a populaçço
					
					Collections.sort(cromossomos, new Comparador());
					
					for (int i = populacao; i < cromossomos.size(); i++) {
						cromossomos.remove(cromossomos.size()-1);
						
					}
					
					
					
					for (int i = 0; i < cromossomos.size(); i++) {
						
						if(cromossomos.get(i).getFitness()<melhorResultado.getFitness()){
							melhorResultado=cromossomos.get(i);
							melhorMudou=true;
						}
						
					}
					
					
					
					//condiçço que afeta o while
					if(melhorMudou==true){
						melhorMudou=false;
						acum=0;
					}else{
						acum++;
					}
				}
				
				
				System.out.println("MELHOR RESULTADO:");
				System.out.println("FITNESS:"+melhorResultado.getFitness());
			for (int i = 0; i < melhorResultado.getPeçasCrom().size(); i++) {
				System.out.println(melhorResultado.getPeçasCrom().get(i).getId()+" "+ melhorResultado.getPeçasCrom().get(i).getRotaçao());
				
			}
				
				
				
	}
	
	public static Peça buscaId (ArrayList<Peça> ps, int id) {
		Peça encontrada = new Peça();
		
		for (int i = 0; i < ps.size(); i++) {
			if(ps.get(i).getId() == id){
				
				encontrada= ps.get(i);
			
			
			}
		}
		return encontrada;
		
	}
	
public static ArrayList<Peça> Crossover(ArrayList<Peça> peças4, ArrayList<Peça> peças5){
		
		//clonando os pais
		ArrayList<Peça> peças= (ArrayList<Peça>) peças4.clone();
		ArrayList<Peça> outraspeças= (ArrayList<Peça>) peças5.clone();
		
		
		//aleatorio que selecionará um ponto do pai e a partir dele será copiado o resto
		int aleatorio;
		aleatorio=aleatoriar(0, peças.size());
		ArrayList<Peça> novaspeças = new ArrayList();
		ArrayList<Peça> novaspeças2 = new ArrayList();
		ArrayList<Peça> aux = new ArrayList();
		
		for (int i = aleatorio; i < peças.size(); i++) {
			
			novaspeças.add(peças.get(i));
			
			
		}
		
		
		for (int i = 0; i < novaspeças.size(); i++) {
			peças.remove(peças.size()-1);
			
		}
		
	
		for (int i = 0; i < peças.size(); i++) {
			novaspeças.add(buscaId(outraspeças, peças.get(i).getId()));
			
		}
		
				
		
		int aleatorio2;
		aleatorio2=aleatoriar(0, 100);
		if(aleatorio2<=10){
			
			Collections.reverse(novaspeças);
		}
		
		
		
		return novaspeças;
	}
	
	
	
	public static Cromossomo roleta(ArrayList<Cromossomo> cromos, int populacao){

		for (int i = 0; i < cromos.size(); i++) {
			if(cromos.get(i).getFitness() == 0){
				cromos.remove(i);
			}
		}
		Collections.sort(cromos, new Comparador());
		
		double probSum=0;
		double prob;
		ArrayList<Double>probs = new ArrayList();
		ArrayList<Peça> novaspeças = new ArrayList();
		Cromossomo CromPai = new Cromossomo();
		
		
		for (int i = 0; i < cromos.size(); i++) {
			
			probSum = probSum + (1/cromos.get(i).getFitness());
			
			
		}
		
	
		
		for (int i = 0; i < cromos.size(); i++) {
			
			prob = (100*(1/cromos.get(i).getFitness()))/probSum;
			probs.add(prob);
			
			
		}
		
		probSum=0;
		
		for (int i = 0; i < populacao/2; i++) {
			
			novaspeças.clear();
			
			int random = aleatoriar(0, 100);
			double acumulador=0;
			int contador=0;
			
			
		//	System.out.println(random);
			while (acumulador<random) {
				acumulador= acumulador+probs.get(contador);
				contador++;
				
			
				if(contador >= probs.size()){
					contador--;
					break;
				}
			}
			
			//aqui ç
			//cromossomos.get(contador) serç reproduzido (array de peças)
			int aleatorio;
			aleatorio =aleatoriar(0, cromos.get(contador).getPeçasCrom().size());
			try {
				CromPai = cromos.get(contador).clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
				
				
				
				
				
			}
			
		}
		return CromPai;

		
	}
	
	
	

	public static int aleatoriar(int minimo, int maximo) {
	    Random random = new Random();
	    return random.nextInt((maximo - minimo) + 1) + minimo;
	}
	
}