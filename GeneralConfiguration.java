package SimulacionFuego;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GeneralConfiguration extends JPanel {
    JTextField fireWidth;
    JTextField fireHeigth;
    JTextField fireXPosition;
    JTextField fireYPosition;
    BufferedImage backgroundImage;
    JTextField calcFramesPerSecond;
    JTextField showFramesPerSecond;

    public GeneralConfiguration(){
        this.setLayout(new GridBagLayout());
        fireWidth = new JTextField();
        fireHeigth = new JTextField();
        fireXPosition = new JTextField();
        fireYPosition = new JTextField();
        addbuttonstopanel();
        stylebuttons();
        /*
        backgroundImage = new BufferedImage();
        JTextField calcFramesPerSecond = new JTextField();
        JTextField showFramesPerSecond = new JTextField();
        */

    }

    private void addbuttonstopanel(){
        JLabel Label;
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 1;

        Label =  new JLabel("Fire Width: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);

        c.gridy = 2;
        this.add(getFireWidth(),c);
        c.gridy = 3;

        Label =  new JLabel("Fire Height: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);

        c.gridy = 4;
        this.add(getFireHeigth(),c);
        c.gridy = 5;

        Label =  new JLabel("Fire Position X: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);

        c.gridy = 6;
        this.add(getFireXPosition(),c);
        c.gridy = 7;

        Label =  new JLabel("Fire Position Y: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);
        c.gridy = 8;
        this.add(getFireYPosition(),c);
    }
    private  void stylebuttons(){
        this.fireHeigth.setColumns(10);
        this.fireWidth.setColumns(10);
        this.fireXPosition.setColumns(10);
        this.fireYPosition.setColumns(10);
     
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
