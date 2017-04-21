package model;
import java.awt.Color;

public abstract class Shape {
	
	protected static int idIncrement;
	protected int id;
	protected String nome;
	protected Color cor;
	protected int x;
	protected int y;
	
	public Shape(String nm, Color Cor){
		Shape.idIncrement++;
		this.id = Shape.idIncrement;
		this.nome = nm;
		this.cor = Cor;
	}
	
	public abstract void setCor(Color Cor);
	public abstract void setX(int X);
	public abstract void setY(int Y);

	public abstract String getNome();
	public abstract Color getCor();
	public abstract int getX();
	public abstract int getY();
	public abstract int getID();
	public String toString(){
		return this.id + " - " + this.nome;
	}
}
