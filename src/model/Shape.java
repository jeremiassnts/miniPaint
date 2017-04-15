package model;
import java.awt.Color;

public abstract class Shape {

	protected int id;
	protected String nome;
	protected Color cor;
	protected int x;
	protected int y;
	
	public Shape(int size, String nm, Color Cor){
		id = size;
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
	public abstract int getID();
	
	public abstract float getHeight();
	public abstract float getWidth();
}
