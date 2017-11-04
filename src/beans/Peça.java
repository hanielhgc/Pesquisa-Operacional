package beans;

public class Pe�a {
	
	double area;
	//pontos para os vertices (0,1), (2,3), (4,5), (6,7)
	double [] vertices = new double[8];
	int rota�ao;
	//ponto para refer�ncias. S�o os primeiros pontos inseridos pelo usu�rio (0,1)
	double [] referencia = new double[2];
	int id;
	
	
	public Pe�a() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pe�a(double[] vertices, int rota�ao, double ref1, double ref2, int id) {
		super();
		this.vertices = vertices;
		this.rota�ao = rota�ao;
		this.referencia[0] = ref1;
		this.referencia[1] = ref2;
		this.id = id;
	}
	
	


	public double getArea() {
		return area;
	}


	//faz o c�lculo da �rea
	public void setArea(double [] vertices) {
		this.area = Math.abs(vertices[0] - vertices[2]) * Math.abs(vertices[0] - vertices[4]);
	}


	public double[] getVertices() {
		return vertices;
	}


	public void setVertices(double[] vertices) {
		this.vertices = vertices;
	}


	public int getRota�ao() {
		return rota�ao;
	}


	public void setRota�ao(int rota�ao) {
		this.rota�ao = rota�ao;
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
