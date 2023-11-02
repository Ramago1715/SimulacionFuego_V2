package SimulacionFuego;

import javax.swing.*;
import java.util.Arrays;

public class DTOTemperatureParameters {
    private double newCoolPixelsPercentage;
    private double newHotPixelsPercentage;
    private double[] cellsponderation;
    private double cellsDivider;
    private double fixAtenuationFactor;
    private boolean bottonUpTemps;

    public DTOTemperatureParameters(){
        this.newCoolPixelsPercentage= 15;
        this.newHotPixelsPercentage = 10;
        this.cellsDivider = 5.98569;
        this.fixAtenuationFactor =1.8D;
        this.bottonUpTemps = false;
        this.cellsponderation = new double[6];
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
