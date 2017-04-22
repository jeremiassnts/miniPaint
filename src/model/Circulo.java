package model;
import java.awt.Color;
import java.io.Serializable;

public class Circulo extends Shape implements Serializable, Comparable<Shape>{
	
	private float raio;
	
	public Circulo(Color Cor, float Raio){
		super("Círculo", Cor);
		raio = Raio;
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
	
	public void setRaio(float raio){
		this.raio = raio;
	}
	public float getRaio(){
		return raio;
	}
	public int getID(){
		return id;
	}
	public String toString(){
		return this.id+" - Círculo";
	}
	/*public int compareTo(Shape shape){
    	if(this.getID() > shape.getID()) return -1;
    	else if(this.getID() < shape.getID()) return 1;
    	return 0;
    }*/
}
