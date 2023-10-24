package SimulacionFuego;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GeneralConfiguration {
    JTextField fireWidth;
    JTextField fireHeigth;
    JTextField fireXPosition;
    JTextField fireYPosition;
    BufferedImage backgroundImage;
    JTextField calcFramesPerSecond;
    JTextField showFramesPerSecond;

    public GeneralConfiguration(){
        fireWidth = new JTextField();
        fireHeigth = new JTextField();
        fireXPosition = new JTextField();
        fireYPosition = new JTextField();
        /*
        backgroundImage = new BufferedImage();
        JTextField calcFramesPerSecond = new JTextField();
        JTextField showFramesPerSecond = new JTextField();
        */

    }

    public JTextField getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(JTextField fireWidth) {
        this.fireWidth = fireWidth;
    }

    public JTextField getFireHeigth() {
        return fireHeigth;
    }

    public void setFireHeigth(JTextField fireHeigth) {
        this.fireHeigth = fireHeigth;
    }

    public JTextField getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(JTextField fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public JTextField getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(JTextField fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public JTextField getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(JTextField calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public JTextField getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(JTextField showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }
}
