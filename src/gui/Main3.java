package gui;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import beans.Cromossomo;
import beans.Pe�a;

public class Main3 {
	
	public static void main(String[] args) {
		
Scanner scanner = new Scanner(System.in);
		
		double [] vertices = new double[8];
		int escolha;
		int cont =0;
		int qtde;
		ArrayList <Pe�a> pe�as = new ArrayList<>(); 
		Cromossomo cromossomo = new Cromossomo();
		ArrayList<Cromossomo> cromossomos = new ArrayList<>();
		int populacao = 80;
		
		
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
		
		
		for (int j = 0; j < pe�as.size(); j++) {
			double aux = Math.random();
			if(aux > 0.5){
				pe�as.get(j).setRota�ao(90);
			}else{
				pe�as.get(j).setRota�ao(0);
		}
		}
		
		ArrayList<Pe�a> pe�as2 = new ArrayList();
		for (int i = 0; i < populacao; i++) {
			
			cromossomo = new Cromossomo();
			
			pe�as2 = (ArrayList<Pe�a>)pe�as.clone();
			Collections.shuffle(pe�as2);

			cromossomo.setPe�asCrom(pe�as2);
			cromossomos.add(cromossomo);
			
		}
		
		
		
		
		
		
		//pare ta bom!!
		
		int [][] matriz = new int[5][10];
		
		for (int k = 0; k < cromossomos.size(); k++) {
		
		
			matriz = new int[5][10];
		

			for (int l = 0; l < pe�as.size(); l++) {
				vertices = cromossomos.get(k).getPe�asCrom().get(l).getVertices();
				
			
		
			if(cromossomos.get(k).getPe�asCrom().get(l).getRota�ao() == 0){
				
			}else{
				double aux;
				double aux2;
				double [] vert = new double[8];
				double [] ref = new double[2];
				int base;
				int altura;
				
				
				
				vert = cromossomos.get(k).getPe�asCrom().get(l).getVertices();
				
				base = (int) Math.abs((vert[1]-vert[3]));
				altura = (int) Math.abs((vert[0]-vert[4]));
				
				vert[2] = vert[0];
				vert[3] = vert[1]+ altura;
				vert[4] = vert[0]- base;
				vert[5] = vert[1]+ altura;
				vert[6] = vert[0]- base;
				vert[7] = vert[1];
						
				 
				 cromossomos.get(k).getPe�asCrom().get(l).setVertices(vert);
				 

					
					
					vertices = cromossomos.get(k).getPe�asCrom().get(l).getVertices();
					
					matriz[(int) vertices[0]][(int) vertices[1]] = 1;
					
					for (int i = (int) vertices[4]; i <= (int) vertices[0]; i++) {
					
						for (int j = (int) vertices[1]; j <= (int) vertices[3]; j++) {
						
							matriz[i][j] = 1;
							
							
							
						}
						
					}
				 
			}
			
			
			bottomLeft(vertices, matriz);
			imprimirMatriz(5, matriz);
			
		}
			
			cromossomos.get(k).setFitness(fitness(matriz));
			
			
			
		}
		
		//exibir todos os cromossomos com seus respectivos fitness
		for (int i = 0; i < cromossomos.size(); i++) {
			
			System.out.println("------");
			System.out.println("Fitness:"+ cromossomos.get(i).getFitness());
			ArrayList<Pe�a> p9 = new ArrayList<>();
			p9=cromossomos.get(i).getPe�asCrom();
			for (int j = 0; j < p9.size(); j++) {
				System.out.println(p9.get(j).getId());
					
				
			}
			
		}
			
			
			
			 System.out.println("Agora, apresentando a matriz\n\n");
		     for (int i = 0; i < 5; i++) {
		        for (int j = 0; j < 10; j++) {
		        	System.out.print(matriz[i][j] + "   ");
		        }
		        System.out.println("");
		      
		     }
		        
			
			
			
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
		
	}




