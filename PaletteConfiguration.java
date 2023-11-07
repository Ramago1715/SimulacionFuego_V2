package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class PaletteConfiguration extends JPanel{
   private JTable palettetargets;
   private JFormattedTextField temperaturetarget;
   private JFormattedTextField ARGBtarget;
   private JButton palettebutton;

   public PaletteConfiguration(){
        NumberFormatter formatter = new NumberFormatter();
        formatter.setMinimum(0);
        formatter.setMaximum(255);
        formatter.setValueClass(Integer.class);
        this.setLayout(new GridBagLayout());
        this.palettetargets = new JTable();
        this.temperaturetarget = new JFormattedTextField(formatter);
        this.ARGBtarget = new JFormattedTextField();
        this.palettebutton = new JButton("ADD");
        styleconfig();
        addelementstopanel();
   }
   public void styleconfig(){
       this.temperaturetarget.setPreferredSize(new Dimension(15,15));
       this.temperaturetarget.setText("Temp");
       this.ARGBtarget.setPreferredSize(new Dimension(35,15));
       this.ARGBtarget.setText("Color");;
       this.setPreferredSize(new Dimension(200,200));
   }
   public void addelementstopanel(){
       GridBagConstraints c = new GridBagConstraints();
       c.anchor = GridBagConstraints.NORTHWEST;
       c.fill = GridBagConstraints.HORIZONTAL;
       c.gridy = 0;
       this.add(this.palettetargets,c);
       c.gridy = 1;
       c.gridx = 0;
       this.add(this.temperaturetarget,c);
       c.gridy = 2;
       this.add(this.ARGBtarget,c);
       c.gridy = 3;
       c.gridx = 0;
       this.add(this.palettebutton,c);
   }

    public JButton getPalettebutton() {
        return palettebutton;
    }

    public void setPalettebutton(JButton palettebutton) {
        this.palettebutton = palettebutton;
    }

    public JTable getPalettetargets() {
        return palettetargets;
    }

    public void setPalettetargets(JTable palettetargets) {
        this.palettetargets = palettetargets;
    }

    public JFormattedTextField getTemperaturetarget() {
        return temperaturetarget;
    }

    public void setTemperaturetarget(JFormattedTextField temperaturetarget) {
        this.temperaturetarget = temperaturetarget;
    }

    public JFormattedTextField getARGBtarget() {
        return ARGBtarget;
    }

    public void setARGBtarget(JFormattedTextField ARGBtarget) {
        this.ARGBtarget = ARGBtarget;
    }
}
