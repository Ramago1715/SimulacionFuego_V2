package SimulacionFuego;

import javax.swing.*;

public class DTOGeneralParameters {
   private int fireWidth;
   private int fireHeigth;
   private int fireXPosition;
   private int fireYPosition;
   private int calcFramesPerSecond;
   private int showFramesPerSecond;

   private String resolucion;
   private String nombrebackground;
   private String carpetapadre;

    public DTOGeneralParameters(){
        this.fireWidth = 200;
        this.fireHeigth = 210;
        this.fireXPosition = 110;
        this.fireYPosition = 100;
        this.resolucion = "512x512";
        this.nombrebackground = "ChimeneaDefault";
        this.carpetapadre = "SimulacionFuegoV2";
    }

    public int getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(int fireWidth) {
        this.fireWidth = fireWidth;
    }

    public int getFireHeigth() {
        return fireHeigth;
    }

    public void setFireHeigth(int fireHeigth) {
        this.fireHeigth = fireHeigth;
    }

    public int getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(int fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public int getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(int fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public int getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(int calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public int getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(int showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getNombrebackground() {
        return nombrebackground;
    }

    public void setNombrebackground(String nombrebackground) {
        this.nombrebackground = nombrebackground;
    }

    public String getCarpetapadre() {
        return carpetapadre;
    }

    public void setCarpetapadre(String carpetapadre) {
        this.carpetapadre = carpetapadre;
    }
}
