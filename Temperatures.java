package SimulacionFuego;

import java.util.Arrays;

public class Temperatures {
	public int[][] matriztemperatures;
	private int width;
	private int heigth;
	private int porcentajefrio;
	private int porcenajecaliente;
	public Temperatures() {
		
	}
	public Temperatures(int heigth ,int width ,int probabilidadfrio,int probabilidadcaliente) {
		setHeigth(heigth);
		setWidth(width);
		setMatriztemperatures(heigth,width);
		setPorcentajefrio(probabilidadfrio);
		setPorcentajecaliente(probabilidadcaliente);
		
	}
	
	public void next() {
		sparks();
		cold();
		calc();
	
		}
	
	public int getTemp(int x,int y) {
		int temp = this.matriztemperatures[x][y];
		
		return temp;
	}
	
	
	private void sparks() {
		for(int x=0;x<= getWidth()-1;x++) {
			 double probabilidad = Math.random()*101;
			 if(getPorcentajecaliente() >= probabilidad) {
				 this.matriztemperatures[heigth-1][x] = 255;
			 }
		}
	}
	private void cold() {
		for(int x=0;x<= getWidth()-1;x++) {
			 double probabilidad = Math.random()*101;
			 if(getPorcentajefrio() >= probabilidad) {
				 this.matriztemperatures[heigth-1][x] = 0;
			 }
		}
	}
	private void calc() {

		for(int x = 1;x<=getHeigth()-2;x++) {
			for(int y = 1; y<=getWidth()-2;y++) {
				int valorestemp = 0;
					valorestemp += this.matriztemperatures[x][y]* 1.5D ; 
					valorestemp += this.matriztemperatures[x+1][y]* 0.7D; 
					valorestemp += this.matriztemperatures[x+1][y+1]* 0.7D; 
					valorestemp += this.matriztemperatures[x+1][y-1]* 0.7D; 
					valorestemp += this.matriztemperatures[x][y+1]* 1.2D; 
					valorestemp += this.matriztemperatures[x][y-1]* 1.2D; 
					valorestemp = (int) (valorestemp/5.98569-1.8D);
					this.matriztemperatures[x][y] = valorestemp;
					
					
					if(valorestemp>255) {
						this.matriztemperatures[x][y] = 255;
					}
					else if(valorestemp<0) {
						this.matriztemperatures[x][y] = 0;
					}
					
				}
			}
		}
	
	
	public int[][] getMatriztemperatures() {
		return this.matriztemperatures;
	}
	public void setMatriztemperatures(int heigth,int width) {
		this.matriztemperatures = new int[heigth][width];
		for(int x = 0; x<=heigth-1;x++) {
			for(int y = 0; y<=width-1;y++) {
				this.matriztemperatures[x][y] = 0;
				
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public int getPorcentajefrio() {
		return porcentajefrio;
	}
	public void setPorcentajefrio(int porcentajefrio) {
		this.porcentajefrio = porcentajefrio;
	}
	public int getPorcentajecaliente() {
		return porcenajecaliente;
	}
	public void setPorcentajecaliente(int porcenajecaliente) {
		this.porcenajecaliente = porcenajecaliente;
	}
	@Override
	public String toString() {
		return "Temperatures [matriztemperatures=" + Arrays.toString(matriztemperatures) + ", width=" + width
				+ ", heigth=" + heigth + ", porcentajefrio=" + porcentajefrio + ", porcenajecaliente="
				+ porcenajecaliente + "]";
	}
	
	
}
