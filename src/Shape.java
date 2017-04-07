import java.awt.Color;

public abstract class Shape {

	protected String nome;
	protected Color cor;
	protected int x;
	protected int y;
	
	public Shape(String nm, Color Cor){
		nome = nm;
		cor = Cor;
	}
	
	public abstract void setCor(Color Cor);
	public abstract void setX(int X);
	public abstract void setY(int Y);

	public abstract String getNome();
	public abstract Color getCor();
	public abstract int getX();
	public abstract int getY();
	
	public abstract float getHeight();
	public abstract float getWidth();
}
