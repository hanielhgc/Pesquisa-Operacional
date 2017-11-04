package beans;

public class Peça {
	
	double area;
	//pontos para os vertices (0,1), (2,3), (4,5), (6,7)
	double [] vertices = new double[8];
	int rotaçao;
	//ponto para referências. São os primeiros pontos inseridos pelo usuário (0,1)
	double [] referencia = new double[2];
	int id;
	
	
	public Peça() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Peça(double[] vertices, int rotaçao, double ref1, double ref2, int id) {
		super();
		this.vertices = vertices;
		this.rotaçao = rotaçao;
		this.referencia[0] = ref1;
		this.referencia[1] = ref2;
		this.id = id;
	}
	
	


	public double getArea() {
		return area;
	}


	//faz o cálculo da área
	public void setArea(double [] vertices) {
		this.area = Math.abs(vertices[0] - vertices[2]) * Math.abs(vertices[0] - vertices[4]);
	}


	public double[] getVertices() {
		return vertices;
	}


	public void setVertices(double[] vertices) {
		this.vertices = vertices;
	}


	public int getRotaçao() {
		return rotaçao;
	}


	public void setRotaçao(int rotaçao) {
		this.rotaçao = rotaçao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double[] getReferencia() {
		return referencia;
	}


	public void setReferencia(double[] referencia) {
		this.referencia = referencia;
	}


	public void setArea(double area) {
		this.area = area;
	}
	
	
	
	

}
