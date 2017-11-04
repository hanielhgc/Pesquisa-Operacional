package gui;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import beans.Cromossomo;
import beans.Pe�a;

public class Main {
	
	public static void main(String[] args) {
		
		
		Pe�a pe�a = new Pe�a();
		ArrayList <Pe�a> pe�as = new ArrayList<>(); 
		int populacao = 80;
		Scanner scanner = new Scanner(System.in);
		int escolha;
		int qtde;
		double [] vertices = new double[8];
		int cont = 0;
		int largura;
		
		
		//teste do shuffle
		/*
		Collections.shuffle(pe�as);
		
		double [] vertices = {1,2,3,4,5,6,7,8};
		
		Pe�a pe�a1 = new Pe�a(20,vertices,90,1);
		Pe�a pe�a2 = new Pe�a(21,vertices,0,2);
		Pe�a pe�a3 = new Pe�a(22,vertices,0,3);
		
		pe�as.add(pe�a1);
		pe�as.add(pe�a2);
		pe�as.add(pe�a3);
		
		
		Collections.shuffle(pe�as);
		
		for (int i = 0; i < pe�as.size(); i++) {
			System.out.println(pe�as.get(i).getVe());
		}
		
		*/
		

		System.out.println("Informe a largura:");
		largura=scanner.nextInt();
		
		
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
					Pe�a p = new Pe�a(vertices,0, vertices[0], vertices[1],cont);
					p.setArea(vertices);
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
		
		/*
		System.out.println();
		
		for (int i = 0; i < pe�as.size(); i++) {
			System.out.println(pe�as.get(i).getId());
		}
		
		*/
		
		
		
		
		
		//Array de cromossomos. Cromossomo = conjunto de pe�as em uma ordem que resulta em uma solu��o
		ArrayList<Cromossomo> cromossomos = new ArrayList<>();
		
		
		//cria 80 (popula��o) cromossomos diferentes de ordem rand�mica
		for (int i = 0; i < populacao; i++) {
		
			Cromossomo cromossomo = new Cromossomo();
			pe�as2 = (ArrayList<Pe�a>)pe�as.clone();
			Collections.shuffle(pe�as2);
			
			
			//torna a rota��o da pe�a aleat�ria (se o random for par, a rota��o ser� 90. Se for �mpar, 0)
			for (int j = 0; j < pe�as2.size(); j++) {
				int aux = (int) Math.random();
				if(aux%2 == 0){
					pe�as2.get(j).setRota�ao(90);
				}else{
					pe�as2.get(j).setRota�ao(0);
			}
			}
			
			
			//cromossomo recebe pe�as (solu��o) e o cromossomo � adicionado ao Array de cromossomos
			cromossomo.setPe�asCrom(pe�as2);
			cromossomos.add(cromossomo);
			
			
		
		}
		
	
		//exibir todas as pe�as (solu��es) de cada cromossomo
		/*
		for (int i = 0; i < cromossomos.size(); i++) {
			
			System.out.println("------");
			ArrayList<Pe�a> p9 = new ArrayList<>();
			p9=cromossomos.get(i).getPe�asCrom();
			for (int j = 0; j < p9.size(); j++) {
				System.out.println(p9.get(j).getId());
					
				
			}
			
		}
		
		*/
		
		//"desenhando" o pol�gono na matriz
		int altura=10;
		int [][] matriz = new int[largura][altura];
		
		vertices = pe�as.get(0).getVertices();
		
		matriz[(int) vertices[0]][(int) vertices[1]] = 1;
		
		for (int i = (int) vertices[4]; i <= (int) vertices[0]; i++) {
		
			for (int j = (int) vertices[1]; j <= (int) vertices[3]; j++) {
			
				matriz[i][j] = 1;
				
				
				
			}
			
		}
		
		
		/*
		for (int i = (int) vertices[6]; i <= vertices[0]; i++) {
			int j = (int) (vertices[1] - 1);
			int count = (int) (vertices[3]);
			
			matriz[i][j] = 1;
			matriz[i][count] = 0;
			count--;
		}
		*/
		
		
		//fazendo o pol�gono "caminhar" para a esquerda
		for (int i = (int) vertices[6]; i <= vertices[0]; i++) {
			int j =(int) (vertices[1] -1);
			if(matriz[i][j] == 1){
				break;
			}else{
				for (int k1 = (int) vertices[6]; k1 <= vertices[0]; k1++) {
					int k2 = (int) (vertices[1] - 1);
					int count = (int) (vertices[3]);
					
					matriz[i][k2] = 1;
					matriz[i][count] = 0;
					count--;
				}
			}
		}
		
		
		//exibindo a matriz
		 System.out.println("Agora, apresentando a matriz\n\n");
	        for (int i = 0; i < largura; i++) {
	            for (int j = 0; j < 10; j++) {
	                System.out.print(matriz[i][j] + "   ");
	            }
	            System.out.println("");
	        }
		
		
		
	}

}
