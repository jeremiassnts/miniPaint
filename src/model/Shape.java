package model;
import java.awt.Color;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Shape implements Serializable, Comparable<Shape>{
	
	//protected static int idIncrement;
	protected int id;
	protected String nome;
	protected Color cor;
	protected int x;
	protected int y;
	private Date dataCriado;
	
	public Shape(String nm, Color Cor){
		this.id = ThreadLocalRandom.current().nextInt(100000, 999999);
		this.nome = nm;
		this.cor = Cor;
		this.dataCriado = new Date();
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
	public Date getDate(){
		return this.dataCriado;
	}
	public int compareTo(Shape shape){
		if(this.getDate().before(shape.getDate())) return -1;
		else if(this.getDate().after(shape.getDate())) return 1;
		return 0;
	}
}
