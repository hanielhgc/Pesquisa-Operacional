package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import beans.Cromossomo;
import beans.Pe�a;
import comparators.Comparador;

public class MainFinal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double [] vertices = new double[8];
		int escolha;
		int cont =0;
		int qtde;
		ArrayList <Pe�a> pe�as = new ArrayList<>(); 
		int populacao = 80;
		
		Cromossomo melhorResultado = new Cromossomo();
		melhorResultado.setFitness(99999);
		boolean melhorMudou=false;
		
		
		while (true) {
			System.out.println("Informe a pe�a a ser inserida: (nova pe�a = 1, concluir = 0)");
			escolha = scanner.nextInt();
			
			if(escolha == 0){
				break;
			}else{
				System.out.println("Informe a quantidade de pe�as desse tipo:");
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
				
				
				//for para criar o n�mero de pe�as fornecido pelo usu�rio
				for (int i = 0; i < qtde; i++) {
					
					//cria uma nova inst�ncia de pe�a com ID �nico, faz o c�lculo da �rea e a adiciona ao Array
					Pe�a p = new Pe�a(vertices,90, vertices[0], vertices[1],cont);
					p.setArea(vertices);
					p.setRota�ao(90);
					pe�as.add(p);
					//incrementa o contador de ID
					cont++;
					
				}
				
				
				
			}
		
		}
		
		
		
		
		ArrayList <Pe�a> pe�as2 = new ArrayList<>(); 

		//clone do Array que n�o modifica o Array original
		pe�as2 = (ArrayList<Pe�a>)pe�as.clone();
		
		//embaralhando as pe�as do array
		Collections.shuffle(pe�as2);
		
		//exibir as pe�as do Array
		for (int i = 0; i < pe�as2.size(); i++) {
			System.out.println(pe�as2.get(i).getId());
		}
		
		//Array de cromossomos. Cromossomo = conjunto de pe�as em uma ordem que resulta em uma solu��o
				ArrayList<Cromossomo> cromossomos = new ArrayList<>();
				
				
				//cria 80 (popula��o) cromossomos diferentes de ordem rand�mica
				for (int i = 0; i < populacao; i++) {
				
					Cromossomo cromossomo = new Cromossomo();
					pe�as2 = (ArrayList<Pe�a>)pe�as.clone();
					Collections.shuffle(pe�as2);
					
					
					//torna a rota��o da pe�a aleat�ria (se o random for par, a rota��o ser� 90. Se for �mpar, 0)
					for (int j = 0; j < pe�as2.size(); j++) {
						double aux = Math.random();
						if(aux > 0.5){
							pe�as2.get(j).setRota�ao(90);
						}else{
							pe�as2.get(j).setRota�ao(0);
					}
					}
					
					
					
					
					//cromossomo recebe pe�as (solu��o) e o cromossomo � adicionado ao Array de cromossomos
					cromossomo.setPe�asCrom(pe�as2);
					//recebendo fitness
					cromossomo.setFitness(aleatoriar(5, 7));
					cromossomos.add(cromossomo);
					
					
				
				}
		
				
				
				
		
				//rotacionar o poligono baseado no angulo
				
				for (int k = 0; k < cromossomos.size(); k++) {
					
					ArrayList<Pe�a> pe�as3 = new ArrayList();
					
					pe�as3 = cromossomos.get(k).getPe�asCrom();
					
				
				
				for (int l = 0; l < pe�as3.size(); l++) {
					
					
					
					if(pe�as3.get(l).getRota�ao() == 0){
						
					}else{
						double aux;
						double aux2;
						double [] vert = new double[8];
						double [] ref = new double[2];
						double base;
						double altura;
						
						
						
						vert = pe�as3.get(l).getVertices();
						
						base =  Math.abs((vert[1]-vert[3]));
						altura =  Math.abs((vert[0]-vert[4]));
						
						vert[2] = vert[0];
						vert[3] = vert[1]+altura;
						vert[4] = vert[0]-base;
						vert[5] = vert[1]+altura;
						vert[6] = vert[0]-base;
						vert[7] = vert[1];
								
						 pe�as3.get(l).setVertices(vert);
						 
						 cromossomos.get(k).setPe�asCrom(pe�as3);
						 
						 
					}
					
				}	
				}
				
				
				
				
				//inserir aqui bottom left e calculo do fitness
					
				
				/*
				//exibir todos os resultados de cada cromossomo com o fitness
				for (int i = 0; i < cromossomos.size(); i++) {
					
					System.out.println("------");
					System.out.println("Fitness: "+ cromossomos.get(i).getFitness());
					ArrayList<Pe�a> p9 = new ArrayList<>();
					p9=cromossomos.get(i).getPe�asCrom();
					for (int j = 0; j < p9.size(); j++) {
						System.out.println(p9.get(j).getId());
							
						
					}
					
				}
				
				*/
				
				ArrayList<Cromossomo> pais = new ArrayList();
				
				
				int acum = 0;
				while (acum < 40) {
					
					for (int i = 0; i < populacao/2; i++) {
						
						pais.add(roleta(cromossomos, populacao));
						
					}
					
					
					for (int i = 0; i < pais.size(); i++) {
						
						//pais viram filhos
						pais.get(i).setPe�asCrom(Crossover(pais.get(i).getPe�asCrom()));
						
						//aqui precisa ser mudado quando encontrar o metodo para obter o fitness
						pais.get(i).setFitness(aleatoriar(5,7));
						
					}
					
					
					for (int i = 0; i < pais.size(); i++) {
						
						cromossomos.add(pais.get(i));
						
					}
					
					//limpar a popula��o
					
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
					
					
					
					//condi��o que afeta o while
					if(melhorMudou==true){
						melhorMudou=false;
						acum=0;
					}else{
						acum++;
					}
				}
				
				
				System.out.println("MELHOR RESULTADO:");
				System.out.println("FITNESS:"+melhorResultado.getFitness());
			for (int i = 0; i < melhorResultado.getPe�asCrom().size(); i++) {
				System.out.println(melhorResultado.getPe�asCrom().get(i).getId()+" "+ melhorResultado.getPe�asCrom().get(i).getRota�ao());
				
			}
				
				
				
	}
	
	public static Pe�a buscaId (ArrayList<Pe�a> ps, int id) {
		Pe�a encontrada = new Pe�a();
		
		for (int i = 0; i < ps.size(); i++) {
			if(ps.get(i).getId() == id){
				
				encontrada= ps.get(i);
			
			
			}
		}
		return encontrada;
		
	}
	
	public static ArrayList<Pe�a> Crossover(ArrayList<Pe�a> pe�as4, ArrayList<Pe�a> pe�as5){
		
		//clonando os pais
		ArrayList<Pe�a> pe�as= (ArrayList<Pe�a>) pe�as4.clone();
		ArrayList<Pe�a> outraspe�as= (ArrayList<Pe�a>) pe�as5.clone();
		
		
		//aleatorio que selecionar� um ponto do pai e a partir dele ser� copiado o resto
		int aleatorio;
		aleatorio=aleatoriar(0, pe�as.size());
		ArrayList<Pe�a> novaspe�as = new ArrayList();
		ArrayList<Pe�a> novaspe�as2 = new ArrayList();
		ArrayList<Pe�a> aux = new ArrayList();
		
		for (int i = aleatorio; i < pe�as.size(); i++) {
			
			novaspe�as.add(pe�as.get(i));
			
			
		}
		
		
		for (int i = 0; i < novaspe�as.size(); i++) {
			pe�as.remove(pe�as.size()-1);
			
		}
		
	
		for (int i = 0; i < pe�as.size(); i++) {
			novaspe�as.add(buscaId(outraspe�as, pe�as.get(i).getId()));
			
		}
		
				
		
		int aleatorio2;
		aleatorio2=aleatoriar(0, 100);
		if(aleatorio2<=10){
			
			Collections.reverse(novaspe�as);
		}
		
		
		
		return novaspe�as;
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
		ArrayList<Pe�a> novaspe�as = new ArrayList();
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
			
			novaspe�as.clear();
			
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
			
			//aqui �
			//cromossomos.get(contador) ser� reproduzido (array de pe�as)
			int aleatorio;
			aleatorio =aleatoriar(0, cromos.get(contador).getPe�asCrom().size());
			
				CromPai = (Cromossomo) cromos.get(contador);
			
			
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
	
	public static int aleatoriar(int minimo, int maximo) {
	    Random random = new Random();
	    return random.nextInt((maximo - minimo) + 1) + minimo;
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

		//		imprimirMatriz(5,m);
			}
				
			
			while((int)v[6] - countUp > 0){
					
				if(checarLinha((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft))
					break;
					
				linha0((int)v[0] - countUp,(int)v[1] - countLeft, m, (int)v[3] - countLeft);
				linha1((int)v[6] - countUp,(int)v[7] - countLeft, m, (int)v[5] - countLeft);
				countUp++;
				
				
					
				
			}
			
		}
//		imprimirMatriz(5,m);
		
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

	
	
	
}


