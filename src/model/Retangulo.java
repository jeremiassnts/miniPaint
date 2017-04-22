package model;
import java.awt.Color;
import java.io.Serializable;

public class Retangulo extends Shape implements Serializable, Comparable<Shape>{
	
	private float base;
	private float altura;
	
	public Retangulo(Color Cor, float Base, float Altura){
		super("Retângulo", Cor);
		base = Base;
		altura = Altura;
	}
	
	public void setCor(Color Cor){
		cor = Cor;
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
	public Color getCor(){
		return cor;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void setBase(float base){
		this.base = base;
	}
	public void setAltura(float altura){
		this.altura = altura;
	}
	
	public float getBase(){
		return base;
	}
	public float getAltura(){
		return altura;
	}
	public int getID(){
		return id;
	}
	/*public int compareTo(Shape shape){
		if(this.getID() > shape.getID()) return -1;
		else if(this.getID() < shape.getID()) return 1;
		return 0;
	}*/
}
