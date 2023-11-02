package SimulacionFuego;

import javax.swing.*;
import java.util.Arrays;

public class DTOTemperatureParameters {
    private double newCoolPixelsPercentage;
    private double newHotPixelsPercentage;
    private double[][] cellsponderation;
    private double cellsDivider;
    private double fixAtenuationFactor;
    private boolean bottonUpTemps;

    public DTOTemperatureParameters(){
        this.newCoolPixelsPercentage= 15;
        this.newHotPixelsPercentage = 10;
        this.cellsDivider = 5.98569;
        this.fixAtenuationFactor =1.8;
        this.bottonUpTemps = false;
        this.cellsponderation = new double[2][3];
        valoresdefaulttable();
    }
    private void valoresdefaulttable(){
        this.cellsponderation[0][0] = 1.2D;
        this.cellsponderation[0][1] = 1.50;
        this.cellsponderation[0][2] = 1.2D;
        this.cellsponderation[1][0] = 0.7D;
        this.cellsponderation[1][1] = 0.7D;
        this.cellsponderation[1][2] = 0.7D;
        /*valorestemp += this.matriztemperatures[x][y]* 1.5D ;
					valorestemp += this.matriztemperatures[x+1][y]* 0.7D;
					valorestemp += this.matriztemperatures[x+1][y+1]* 0.7D;
					valorestemp += this.matriztemperatures[x+1][y-1]* 0.7D;
					valorestemp += this.matriztemperatures[x][y+1]* 1.2D;
					valorestemp += this.matriztemperatures[x][y-1]* 1.2D;*/
    }
    public double getCellsponderationvalue(int x, int y) {
        double cel = this.cellsponderation[x][y];
        return cel;
    }

    public void setCellsponderation(int x,int y,double value) {
        this.cellsponderation[x][y] = value;
    }

    public double getNewCoolPixelsPercentage() {
        return newCoolPixelsPercentage;
    }

    public void setNewCoolPixelsPercentage(double newCoolPixelsPercentage) {
        this.newCoolPixelsPercentage = newCoolPixelsPercentage;
    }

    public double getNewHotPixelsPercentage() {
        return newHotPixelsPercentage;
    }

    public void setNewHotPixelsPercentage(double newHotPixelsPercentage) {
        this.newHotPixelsPercentage = newHotPixelsPercentage;
    }

    public double getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(double cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public double getFixAtenuationFactor() {
        return fixAtenuationFactor;
    }

    public void setFixAtenuationFactor(double fixAtenuationFactor) {
        this.fixAtenuationFactor = fixAtenuationFactor;
    }

    public boolean isBottonUpTemps() {
        return bottonUpTemps;
    }

    public void setBottonUpTemps(boolean bottonUpTemps) {
        this.bottonUpTemps = bottonUpTemps;
    }
}
