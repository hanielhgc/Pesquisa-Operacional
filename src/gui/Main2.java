package gui;

import java.util.ArrayList;
import java.util.Scanner;

import beans.Pe�a;

public class Main2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double [] vertices = new double[8];
		int escolha;
		int cont =0;
		int qtde;
		ArrayList <Pe�a> pe�as = new ArrayList<>(); 
		
		
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
		
		
		vertices = pe�as.get(0).getVertices();
		
		

			for (int l = 0; l < pe�as.size(); l++) {
				
			
		
			if(pe�as.get(l).getRota�ao() == 0){
				
			}else{
				double aux;
				double aux2;
				double [] vert = new double[8];
				double [] ref = new double[2];
			vert = pe�as.get(l).getVertices();
				aux = vert[6];
				 aux2 = vert[7];
				 
				 vert[6] = vert[4];
				 vert[7] = vert[5];
				 
				 vert[4] = vert[2];
				 vert[5] = vert[3];
				 
				 vert[2] = vert[0];
				 vert[3] = vert[1];
				 
				 vert[0] = aux;
				 vert[1] = aux2;
				 
				 ref[0] = aux;
				 ref[1] = aux2;
				 
				 pe�as.get(l).setVertices(vert);
				 pe�as.get(l).setReferencia(ref);
				 
			}
			
		}
			
			
			
			int [][] matriz = new int[5][10];
			
			vertices = pe�as.get(0).getVertices();
			
			matriz[(int) vertices[0]][(int) vertices[1]] = 1;
			
			for (int i = (int) vertices[4]; i <= (int) vertices[0]; i++) {
			
				for (int j = (int) vertices[1]; j <= (int) vertices[3]; j++) {
				
					matriz[i][j] = 1;
					
					
					
				}
				
			}
			
			
			
		}
		
		
	
			
		
	}




