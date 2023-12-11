package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
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
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        this.setLayout(new GridBagLayout());
        newCoolPixelsPercentage = new JSlider(JSlider.HORIZONTAL,0,100,15);
        newHotPixelsPercentage = new JSlider(JSlider.HORIZONTAL,0,100,10);
        DefaultTableModel tableModel = new DefaultTableModel(2,3);
        cellsPonderation = new JTable(tableModel);
        cellsDivider = new JFormattedTextField();
        fixAtenuationFactor = new JFormattedTextField();
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
        Label.setFont(new Font("Italic", Font.ITALIC,13));
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
        Label.setFont(new Font("Italic", Font.ITALIC,13));
        this.add(Label,c);
        c.gridy = 5;
        this.add(this.cellsDivider,c);
        c.gridy = 6;
        Label =  new JLabel("Atenuation Factor: ");
        Label.setFont(new Font("Italic", Font.ITALIC,13));
        this.add(Label,c);
        c.gridy = 7;
        this.add(this.fixAtenuationFactor,c);
        c.gridy = 8;
        this.add(new JPanel(),c);
        c.gridy = 9;
        Label =  new JLabel("Cell Ponderation: ");
        Label.setFont(new Font("Italic", Font.ITALIC,13));
        this.add(Label,c);
        c.gridy = 10;
        this.add(this.cellsPonderation,c);
        c.gridy = 11;
        this.add(new JPanel(),c);
        c.gridy = 12;
        this.add(this.bottonUpTemps,c);

    }

    private void styleconfiguration(){
        Border compound = new CompoundBorder(new LineBorder(Color.white),new EmptyBorder(50,2,50,2));
        this.cellsDivider.setColumns(10);
        this.cellsDivider.setText("5.98569");
        this.fixAtenuationFactor.setText("0.5");
        this.fixAtenuationFactor.setColumns(10);

        getBottonUpTemps().setBorder(compound);
        getBottonUpTemps().setPreferredSize(new Dimension(115,35));
        getBottonUpTemps().setForeground(Color.white);
        getBottonUpTemps().setBackground(new Color(249,199,132));
        this.setBorder(compound = new CompoundBorder(new LineBorder(Color.WHITE),new EmptyBorder(15,0,15,0)));

        this.newCoolPixelsPercentage.setPreferredSize(new Dimension(115,35));
        this.newCoolPixelsPercentage.setMajorTickSpacing(10);
        this.newCoolPixelsPercentage.setPaintTicks(true);
        this.newCoolPixelsPercentage.setValue(15);

        this.newHotPixelsPercentage.setPreferredSize(new Dimension(115,35));
        this.newHotPixelsPercentage.setMajorTickSpacing(10);
        this.newHotPixelsPercentage.setPaintTicks(true);
        this.newHotPixelsPercentage.setValue(10);

        this.cellsPonderation.setSelectionBackground(new Color(126,180,136));
        this.cellsPonderation.setColumnSelectionAllowed(true);
        this.cellsPonderation.setPreferredSize(new Dimension(100,30));
        this.cellsPonderation.setBorder(compound = new CompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(15,0,15,0)));
        valorespordefecto();


    }

    private void valorespordefecto(){
        this.cellsPonderation.setValueAt(1.2D,0,0);
        this.cellsPonderation.setValueAt(1.5D,0,1);
        this.cellsPonderation.setValueAt(1.2D,0,2);
        this.cellsPonderation.setValueAt(0.7D,1,0);
        this.cellsPonderation.setValueAt(0.7D,1,1);
        this.cellsPonderation.setValueAt(0.7D,1,2);
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
