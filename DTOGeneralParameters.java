package SimulacionFuego;

import javax.swing.*;

public class DTOGeneralParameters {
   private int fireWidth;
   private int fireHeigth;
   private int fireXPosition;
   private int fireYPosition;
   private int calcFramesPerSecond;
   private int showFramesPerSecond;



    public DTOGeneralParameters(){
        this.fireWidth = 220;
        this.fireHeigth = 200;
        this.fireXPosition = 220;
        this.fireYPosition = 240;

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


}
