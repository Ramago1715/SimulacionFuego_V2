package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GeneralConfiguration extends JPanel {
    JFormattedTextField fireWidth;
    JFormattedTextField fireHeigth;
    JFormattedTextField fireXPosition;
    JFormattedTextField fireYPosition;
    JFormattedTextField calcFramesPerSecond;
    JFormattedTextField showFramesPerSecond;


    public GeneralConfiguration(){
        NumberFormatter formatter = new NumberFormatter();
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        this.setLayout(new GridBagLayout());
        fireWidth = new JFormattedTextField(formatter);
        fireHeigth = new JFormattedTextField(formatter);
        fireXPosition = new JFormattedTextField(formatter);
        fireYPosition = new JFormattedTextField(formatter);

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


        this.fireHeigth.setPreferredSize(new Dimension(115,20));
        this.fireHeigth.setText("200");
        this.fireWidth.setPreferredSize(new Dimension(115,20));
        this.fireWidth.setText("220");
        this.fireXPosition.setPreferredSize(new Dimension(115,20));
        this.fireXPosition.setText("220");
        this.fireYPosition.setPreferredSize(new Dimension(115,20));
        this.fireYPosition.setText("310");
        this.setBorder(new CompoundBorder(new LineBorder(Color.WHITE),new EmptyBorder(15,0,15,0)));
     
    }







    public JTextField getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(JFormattedTextField fireWidth) {
        this.fireWidth = fireWidth;
    }

    public JTextField getFireHeigth() {
        return fireHeigth;
    }

    public void setFireHeigth(JFormattedTextField fireHeigth) {
        this.fireHeigth = fireHeigth;
    }

    public JTextField getFireXPosition() {
        return fireXPosition;
    }

    public void setFireXPosition(JFormattedTextField fireXPosition) {
        this.fireXPosition = fireXPosition;
    }

    public JTextField getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(JFormattedTextField fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

   /* public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }*/

    public JTextField getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(JFormattedTextField calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public JTextField getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(JFormattedTextField showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }

}
