package SimulacionFuego;

public class DTOTemperatureParameters {
    private double newCoolPixelsPercentage;
    private double newHotPixelsPercentage;
    private double cellsDivider;
    private double fixAtenuationFactor;
    private boolean bottonUpTemps;

    public DTOTemperatureParameters(){

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
