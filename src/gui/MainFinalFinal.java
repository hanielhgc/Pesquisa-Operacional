package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import beans.Cromossomo;
import beans.Peça;
import comparators.Comparador;

public class MainFinalFinal {

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
				
				
				//torna a rotaçço da peça aleatoria (se o random for par, a rotaçço serç 90. Se for çmpar, 0)
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
				
				
				//cromossomo.setFitness(aleatoriar(5, 7));
				cromossomos.add(cromossomo);
				
				
			
			}
			
			
			for (int i = 0; i < cromossomos.size(); i++) {
				ObterFitness(cromossomos.get(i));
				System.out.println(cromossomos.get(i).getFitness());
				
				
				
				
			}
	
			
			
			
	
			//rotacionar o poligono baseado no angulo
			
			for (int k = 0; k < cromossomos.size(); k++) {
				
				ArrayList<Peça> peças3 = new ArrayList();
				
				peças3 = (ArrayList<Peça>) cromossomos.get(k).getPeçasCrom().clone();
				
			
			
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
			
			
			
			int acum = 0;
			while (acum < 40) {
			
				ArrayList<Cromossomo> pais = new ArrayList();
				ArrayList<Cromossomo> maes = new ArrayList();
				ArrayList<Cromossomo> parents = new ArrayList();
				Cromossomo cromoVazio = new Cromossomo();
				
				
				
				for (int i = 0; i < populacao/2; i++) {
					
					pais.add(roleta(cromossomos, populacao));
					maes.add(roleta(cromossomos, populacao));
					
					parents.add(cromoVazio);
					
				}
				
				
				for (int i = 0; i < pais.size(); i++) {
					
					//pais viram filhos?
					parents.get(i).setPeçasCrom((ArrayList<Peça>) (Crossover(pais.get(i).getPeçasCrom(), maes.get(i).getPeçasCrom())).clone());
					
					//aqui precisa ser mudado quando encontrar o metodo para obter o fitness
					
					//pais.get(i).setFitness(aleatoriar(5,7));
					ObterFitness(parents.get(i));
					
				}
				
				
				for (int i = 0; i < pais.size(); i++) {
					
					cromossomos.add(parents.get(i));
					
				}
				
				
				for (int i = 0; i < cromossomos.size(); i++) {
					
					System.out.println("------");
					System.out.println("Fitness: "+ cromossomos.get(i).getFitness());
					ArrayList<Peça> p9 = new ArrayList<>();
					p9=cromossomos.get(i).getPeçasCrom();
					for (int j = 0; j < p9.size(); j++) {
						System.out.println(p9.get(j).getId());
							
						
					}
					
				}
				
				
				
				//limpar a populaçço
				
				Collections.sort(cromossomos, new Comparador());
			
				
				/*
				for (int i = populacao; i < cromossomos.size(); i++) {
					cromossomos.remove(cromossomos.size()-1);
					
				}
				
				*/
				
				while(cromossomos.size() > populacao){
					piorFitness(cromossomos);
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
			
			
			
			ObterFitness(melhorResultado);
			
			System.out.println("MELHOR RESULTADO:");
			System.out.println("FITNESS:"+melhorResultado.getFitness());
		for (int i = 0; i < melhorResultado.getPeçasCrom().size(); i++) {
			System.out.println(melhorResultado.getPeçasCrom().get(i).getId()+" "+ melhorResultado.getPeçasCrom().get(i).getRotaçao());
			
		}
		
		for (int i = 0; i < cromossomos.size(); i++) {

			System.out.println("Fitness: "+cromossomos.get(i).getFitness());
			for (int j = 0; j < peças.size(); j++) {
				System.out.println(cromossomos.get(i).getPeçasCrom().get(j).getRotaçao());
			
		}
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
			CromPai = cromos.get(contador);
			
			
			
			
			
			
			
		
		
	}
	return CromPai;

	
}

public static void bottomLeftPrint(double v[],int m[][]){
	int countLeft = 0;
	int countUp = 0;

	while(
			checarColuna((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[0] - countUp) != true ||
			checarLinha((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft) != true){
		while((int)v[7] - countLeft > 0){
			
			if(checarColuna((int)v[6] - countUp,(int)v[7] - countLeft,m,(int)v[0] - countUp))
				break;
				
			coluna0((int)v[4] - countUp,(int)v[5] - countLeft,m,(int)v[2] - countUp);
			coluna1((int)v[6] - countUp,(int)v[7] - countLeft,m,(int)v[0] - countUp);
			countLeft++;

			imprimirMatriz(5,m);
		}
			
		
		while((int)v[6] - countUp > 0){
				
			if(checarLinha((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft))
				break;
				
			linha0((int)v[0] - countUp,(int)v[1] - countLeft, m, (int)v[3] - countLeft);
			linha1((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft);
			countUp++;
			
			
				
			
		}
		
	}
	imprimirMatriz(5,m);
	
}



public static void coluna0(int linha, int coluna, int m[][], int linhaL){
	for (int i = linha; i <= linhaL ; i++) {
		m[i][coluna] = 0;
	}
}

public static void coluna1(int linha, int coluna, int m[][], int linhaL){
	for (int i = linha; i <= linhaL ; i++) {
		m[i][coluna - 1] = 1;
	}
}

public static boolean checarColuna(int linha, int coluna, int m[][], int linhaL){
	boolean a = false;
	if(coluna - 1 < 0 )
		return true;
	for (int i = linha; i <= linhaL ; i++) {
		if(m[i][coluna - 1] == 0){
			a = false;
		}else{
			a = true;
			return a;
		}
	}
	return a;
}

public static void linha0(int linha, int coluna, int m[][], int colunaL){
	for (int i = coluna; i <= colunaL ; i++) {
		m[linha][i] = 0;
	}
}

public static void linha1(int linha, int coluna, int m[][], int colunaL){
	for (int i = coluna; i <= colunaL ; i++) {
		m[linha - 1][i] = 1;
	}
}

public static boolean checarLinha(int linha, int coluna, int m[][], int colunaL){
	boolean a = false;
	if(linha - 1 < 0 )
		return true;
	for(int j = coluna; j <= colunaL; j++){
		if(m[linha - 1][j] == 0){
			a = false;
		}else{
			a = true;
			return a;
		}
	}
	return a;
}

public static void bottomLeft(double v[],int m[][]){
	int countLeft = 0;
	int countUp = 0;

	while(
			checarColuna((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[0] - countUp) != true ||
			checarLinha((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft) != true){
		while((int)v[7] - countLeft > 0){
			
			if(checarColuna((int)v[6] - countUp,(int)v[7] - countLeft,m,(int)v[0] - countUp))
				break;
				
			coluna0((int)v[4] - countUp,(int)v[5] - countLeft,m,(int)v[2] - countUp);
			coluna1((int)v[6] - countUp,(int)v[7] - countLeft,m,(int)v[0] - countUp);
			countLeft++;

		imprimirMatriz(5,m);
		}
			
		
		while((int)v[6] - countUp > 0){
				
			if(checarLinha((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft))
				break;
				
			linha0((int)v[0] - countUp,(int)v[1] - countLeft, m, (int)v[3] - countLeft);
			linha1((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft);
			countUp++;
			
			
				
			
		}
		
	}
imprimirMatriz(5,m);
	
}


public static void imprimirMatriz(int largura, int m[][]){
 System.out.println("Agora, apresentando a matriz\n\n");
 for (int i = 0; i < largura; i++) {
    for (int j = 0; j < 10; j++) {
    	System.out.print(m[i][j] + "   ");
    }
    System.out.println("");
 }
 System.out.println("--------------------");

}

public static void zerarMatriz(int m[][]){
	for (int i = 0; i < m.length; i++) {
		for (int j = 0; j < m[i].length; j++) {
			m[i][j] = 0;
		}
	}
}



public static int ObterFitness(Cromossomo novocrom){
	ArrayList<Integer> fitnesses = new ArrayList<>();
	
	
	int [][] matriz2 = new int[5][10];
	double [] vertices2 = new double[8];
			
			

				for (int l = 0; l < novocrom.getPeçasCrom().size(); l++) {
					vertices2 = novocrom.getPeçasCrom().get(l).getVertices();
					
				
			
				if(novocrom.getPeçasCrom().get(l).getRotaçao() == 0){
					
				}else{
					double aux;
					double aux2;
					double [] vert = new double[8];
					double [] ref = new double[2];
					int base;
					int altura;
					
					
					
					vert = novocrom.getPeçasCrom().get(l).getVertices();
					
					base = (int) Math.abs((vert[1]-vert[3]));
					altura = (int) Math.abs((vert[0]-vert[4]));
					
					vert[2] = vert[0];
					vert[3] = vert[1]+ altura;
					vert[4] = vert[0]- base;
					vert[5] = vert[1]+ altura;
					vert[6] = vert[0]- base;
					vert[7] = vert[1];
							
					 
					 novocrom.getPeçasCrom().get(l).setVertices(vert);
				//	 novocrom.getPeçasCrom().get(l).setRotaçao(0);
					 

						
						
						vertices2 = novocrom.getPeçasCrom().get(l).getVertices();
						
						matriz2[(int) vertices2[0]][(int) vertices2[1]] = 1;
						
						for (int i2 = (int) vertices2[4]; i2 <= (int) vertices2[0]; i2++) {
						
							for (int j = (int) vertices2[1]; j <= (int) vertices2[3]; j++) {
							
								matriz2[i2][j] = 1;
								
								
								
							}
							
						}
					 
				}
				
				
				bottomLeft(vertices2, matriz2);
			//aqui
				imprimirMatriz(5, matriz2);
				
				//System.out.println(fitness(matriz2));
				fitnesses.add(fitness(matriz2));
				
			}
				
				int fitnessFinal=0;
				for (int j = 0; j < fitnesses.size(); j++) {
					//if(fitnesses.get(j) > fitnessFinal){
						fitnessFinal = fitnesses.get(j);
						
					//}
				}
				
				
				
				
				novocrom.setFitness(fitnessFinal);
				
				

			
			
		//	cromossomos.add(novocrom);
			
			fitnesses.clear();
			
			
			/*
			for (int j = 0; j < cromossomos.size(); j++) {
				if(cromossomos.get(j).getFitness()!=0){
				
				System.out.println(cromossomos.get(j).getFitness());
				}
				}
			*/

	return fitnessFinal;
	
}

public static int fitness(int m[][]){
	int fit=0;
	for (int j = 0; j < m[0].length; j++) {
	for (int i = 0; i < m.length; i++) {
			if(m[i][j] == 1){
				fit=j;
			}
			
		}
	}
	return fit;
}


public static void piorFitness(ArrayList<Cromossomo> cromossomos){
	Cromossomo piorCrom = new Cromossomo();
	piorCrom.setFitness(0);
	for (int i = 0; i < cromossomos.size(); i++) {
		if(cromossomos.get(i).getFitness() > piorCrom.getFitness()){
			piorCrom=cromossomos.get(i);
		}
	}
	
	cromossomos.remove(piorCrom);
}



public static int aleatoriar(int minimo, int maximo) {
    Random random = new Random();
    return random.nextInt((maximo - minimo) + 1) + minimo;
}

}