
public class Shape {

	private String nome;
	private String red;
	private String green;
	private String blue;
	private int x;
	private int y;
	
	public Shape(String nm, String r, String g, String b, int X, int Y){
		nome = nm;
		red = r;
		green = g;
		blue = b;
		x = X;
		y = Y;
	}
	
	public void setNome(String nm){
		nome = nm;
	}
	public void setRed(String r){
		red = r;
	}
	public void setGreen(String g){
		green = g;
	}
	public void setBlue(String b){
		blue = b;
	}
	public void setX(int X){
		x = X;
	}
	public void setY(int Y){
		y = Y;
	}
	
	public String getNome(){
		return nome;
	}
	public String getRed(){
		return red;
	}
	public String getGreen(){
		return green;
	}
	public String getBlue(){
		return blue;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
