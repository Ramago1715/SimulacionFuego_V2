package SimulacionFuego;

import java.util.Arrays;

public class Temperatures {
	private int[][] matriztemperatures;
	private int width;
	private int heigth;
	private double porcentajefrio;
	private double porcenajecaliente;
	private  DTOTemperatureParameters dtoTemperatureParameters;
	public Temperatures() {

	}
	public Temperatures(int width,int heigth,DTOTemperatureParameters dtoTemperatureParameters) {
		setHeigth(heigth);
		setWidth(width);
		setDtoTemperatureParameters(dtoTemperatureParameters);
		setMatriztemperatures(this.heigth,this.width);
		setPorcentajefrio(this.dtoTemperatureParameters.getNewCoolPixelsPercentage());
		setPorcentajecaliente(this.dtoTemperatureParameters.getNewHotPixelsPercentage());
		
	}
	
	public void next() {
		sparks();
		cold();
		if (!this.dtoTemperatureParameters.isBottonUpTemps()){
			calc();
		}else {
			calcUP();
		}}
	
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
					valorestemp += this.matriztemperatures[x][y]* this.dtoTemperatureParameters.getCellsponderationvalue(0,1) ;
					valorestemp += this.matriztemperatures[x+1][y]* this.dtoTemperatureParameters.getCellsponderationvalue(1,1);
					valorestemp += this.matriztemperatures[x+1][y+1]*this.dtoTemperatureParameters.getCellsponderationvalue(1,2);
					valorestemp += this.matriztemperatures[x+1][y-1]*this.dtoTemperatureParameters.getCellsponderationvalue(1,0);
					valorestemp += this.matriztemperatures[x][y+1]*this.dtoTemperatureParameters.getCellsponderationvalue(0,2);
					valorestemp += this.matriztemperatures[x][y-1]*this.dtoTemperatureParameters.getCellsponderationvalue(0,0);
					valorestemp = (int) (valorestemp/this.dtoTemperatureParameters.getCellsDivider());
					valorestemp = (int) (valorestemp - this.dtoTemperatureParameters.getFixAtenuationFactor());
					this.matriztemperatures[x][y] = valorestemp ;
					
					
					if(valorestemp>255) {
						this.matriztemperatures[x][y] = 255;
					}
					else if(valorestemp<0) {
						this.matriztemperatures[x][y] = 0;
					}
					
				}
			}
		}

	private void calcUP() {

		for (int x = getHeigth() - 2; x >= 1; x--) {
			for (int y = getWidth() - 2; y >= 1; y--) {
				int valorestemp = 0;
				valorestemp += this.matriztemperatures[x][y]* this.dtoTemperatureParameters.getCellsponderationvalue(0,1) ;
				valorestemp += this.matriztemperatures[x+1][y]* this.dtoTemperatureParameters.getCellsponderationvalue(1,1);
				valorestemp += this.matriztemperatures[x+1][y+1]*this.dtoTemperatureParameters.getCellsponderationvalue(1,2);
				valorestemp += this.matriztemperatures[x+1][y-1]*this.dtoTemperatureParameters.getCellsponderationvalue(1,0);
				valorestemp += this.matriztemperatures[x][y+1]*this.dtoTemperatureParameters.getCellsponderationvalue(0,2);
				valorestemp += this.matriztemperatures[x][y-1]*this.dtoTemperatureParameters.getCellsponderationvalue(0,0);
				valorestemp = (int) (valorestemp/this.dtoTemperatureParameters.getCellsDivider());
				valorestemp = (int) (valorestemp - this.dtoTemperatureParameters.getFixAtenuationFactor());
				if (valorestemp > 255) {
					this.matriztemperatures[x][y] = 255;
				} else if (valorestemp < 0) {
					this.matriztemperatures[x][y] = 0;
				} else {
					this.matriztemperatures[x][y] = valorestemp;
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

	public void initblack(){
		for(int x = 0; x<=heigth-1;x++) {
			for(int y = 0; y<=width-1;y++) {
				this.matriztemperatures[x][y] = 0;
			}
		}
	}

	public DTOTemperatureParameters getDtoTemperatureParameters() {
		return dtoTemperatureParameters;
	}

	public void setDtoTemperatureParameters(DTOTemperatureParameters dtoTemperatureParameters) {
		this.dtoTemperatureParameters = dtoTemperatureParameters;
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
	public double getPorcentajefrio() {
		return porcentajefrio;
	}
	public void setPorcentajefrio(double porcentajefrio) {
		this.porcentajefrio = porcentajefrio;
	}
	public double getPorcentajecaliente() {
		return porcenajecaliente;
	}
	public void setPorcentajecaliente(double porcenajecaliente) {
		this.porcenajecaliente = porcenajecaliente;
	}
	@Override
	public String toString() {
		return "Temperatures [matriztemperatures=" + Arrays.toString(matriztemperatures) + ", width=" + width
				+ ", heigth=" + heigth + ", porcentajefrio=" + porcentajefrio + ", porcenajecaliente="
				+ porcenajecaliente + "]";
	}
	
	
}
