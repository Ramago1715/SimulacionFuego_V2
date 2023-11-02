package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class TemperatureConfiguration extends JPanel {
    private JSlider newCoolPixelsPercentage;
    private JSlider newHotPixelsPercentage;
    private JTable cellsPonderation;
    private  JFormattedTextField cellsDivider;
    private JFormattedTextField fixAtenuationFactor;
    private JToggleButton bottonUpTemps;

    public TemperatureConfiguration(){
        NumberFormatter formatter = new NumberFormatter();
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        this.setLayout(new GridBagLayout());
        newCoolPixelsPercentage = new JSlider(JSlider.HORIZONTAL,0,100,15);
        newHotPixelsPercentage = new JSlider(JSlider.HORIZONTAL,0,100,10);
        cellsPonderation = new JTable();
        cellsDivider = new JFormattedTextField(formatter);
        fixAtenuationFactor = new JFormattedTextField(formatter);
        bottonUpTemps = new JToggleButton("Up Temps");
        styleconfiguration();
        addbuttonstopanel();

    }

    private void addbuttonstopanel(){
        JPanel empty = new JPanel();

        JLabel Label;
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        Label =  new JLabel("%Pixeles Frios: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);
        c.gridy = 1;
        this.add(this.newCoolPixelsPercentage,c);
        c.gridy =2;
        Label =  new JLabel("%Pixeles Calientes: ");
        Label.setFont(new Font("Italic", Font.ITALIC,13));
        this.add(Label,c);
        c.gridy = 3;
        this.add(this.newHotPixelsPercentage,c);
        c.gridy = 4;
        Label =  new JLabel("Division Celdas: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);
        c.gridy = 5;
        this.add(this.cellsDivider,c);
        c.gridy = 6;
        Label =  new JLabel("Atenuation Factor: ");
        Label.setFont(new Font("Italic", Font.ITALIC,15));
        this.add(Label,c);
        c.gridy = 7;
        this.add(this.fixAtenuationFactor,c);
        c.gridy = 9;
        this.add(empty,c);
        c.gridy = 10;
        this.add(this.bottonUpTemps,c);

    }

    private void styleconfiguration(){
        Border compound = new CompoundBorder(new LineBorder(Color.white),new EmptyBorder(50,2,50,2));
        this.cellsDivider.setColumns(10);
        this.fixAtenuationFactor.setColumns(10);
        getBottonUpTemps().setBorder(compound);
        getBottonUpTemps().setPreferredSize(new Dimension(115,35));
        getBottonUpTemps().setForeground(Color.white);
        getBottonUpTemps().setBackground(new Color(249,199,132));
        this.setBorder(compound = new CompoundBorder(new LineBorder(Color.WHITE),new EmptyBorder(15,0,15,0)));
        this.newHotPixelsPercentage.setPreferredSize(new Dimension(120,20));
        this.newCoolPixelsPercentage.setPreferredSize(new Dimension(120,20));
        this.newCoolPixelsPercentage.setMajorTickSpacing(10);
        this.newCoolPixelsPercentage.setPaintTicks(true);
        this.newHotPixelsPercentage.setMajorTickSpacing(10);
        this.newHotPixelsPercentage.setPaintTicks(true);

    }





    public JSlider getNewCoolPixelsPercentage() {
        return newCoolPixelsPercentage;
    }

    public void setNewCoolPixelsPercentage(JSlider newCoolPixelsPercentage) {
        this.newCoolPixelsPercentage = newCoolPixelsPercentage;
    }

    public JSlider getNewHotPixelsPercentage() {
        return newHotPixelsPercentage;
    }

    public void setNewHotPixelsPercentage(JSlider newHotPixelsPercentage) {
        this.newHotPixelsPercentage = newHotPixelsPercentage;
    }

    public JTable getCellsPonderation() {
        return cellsPonderation;
    }

    public void setCellsPonderation(JTable cellsPonderation) {
        this.cellsPonderation = cellsPonderation;
    }

    public JFormattedTextField getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(JFormattedTextField cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public JFormattedTextField getFixAtenuationFactor() {
        return fixAtenuationFactor;
    }

    public void setFixAtenuationFactor(JFormattedTextField fixAtenuationFactor) {
        this.fixAtenuationFactor = fixAtenuationFactor;
    }

    public JToggleButton getBottonUpTemps() {
        return bottonUpTemps;
    }

    public void setBottonUpTemps(JToggleButton bottonUpTemps) {
        this.bottonUpTemps = bottonUpTemps;
    }
}
