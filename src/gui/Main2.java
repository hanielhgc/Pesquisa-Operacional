package gui;

import java.util.ArrayList;
import java.util.Scanner;

import beans.Peça;

public class Main2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double [] vertices = new double[8];
		int escolha;
		int cont =0;
		int qtde;
		ArrayList <Peça> peças = new ArrayList<>(); 
		
		
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
				
				
				//for para criar o número de peças fornecido pelo usuário
				for (int i = 0; i < qtde; i++) {
					
					//cria uma nova instância de peça com ID único, faz o cálculo da área e a adiciona ao Array
					Peça p = new Peça(vertices,0, vertices[0], vertices[1],cont);
					p.setArea(vertices);
					peças.add(p);
					//incrementa o contador de ID
					cont++;
					
				}
				
				
				
			}
		
		}
		
		
		vertices = peças.get(0).getVertices();
		
		

			for (int l = 0; l < peças.size(); l++) {
				
			
		
			if(peças.get(l).getRotaçao() == 0){
				
			}else{
				double aux;
				double aux2;
				double [] vert = new double[8];
				double [] ref = new double[2];
			vert = peças.get(l).getVertices();
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
				 
				 peças.get(l).setVertices(vert);
				 peças.get(l).setReferencia(ref);
				 
			}
			
		}
			
			
			
			int [][] matriz = new int[5][10];
			
			vertices = peças.get(0).getVertices();
			
			matriz[(int) vertices[0]][(int) vertices[1]] = 1;
			
			for (int i = (int) vertices[4]; i <= (int) vertices[0]; i++) {
			
				for (int j = (int) vertices[1]; j <= (int) vertices[3]; j++) {
				
					matriz[i][j] = 1;
					
					
					
				}
				
			}
			
			
			
		}
		
		
	
			
		
	}




