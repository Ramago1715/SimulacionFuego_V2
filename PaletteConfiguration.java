package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class PaletteConfiguration extends JPanel{
   private JTable palettetargets;
   private JFormattedTextField temperaturetarget;
   private JFormattedTextField ARGBtarget;
   private JButton palettebutton;

   private DefaultTableModel defaultTableModel;

   public PaletteConfiguration(){
        NumberFormatter formatter = new NumberFormatter();
        formatter.setMinimum(0);
        formatter.setMaximum(255);
        formatter.setValueClass(Integer.class);
        this.setLayout(new GridBagLayout());
        this.defaultTableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Color.class : Integer.class;
            }

        };

        defaultTableModel.addColumn("Temperature");
        defaultTableModel.addColumn("Color");
        defaultTableModel.addColumn("DeleteButton");
        this.palettetargets = new JTable(this.defaultTableModel);
        this.temperaturetarget = new JFormattedTextField(formatter);
        this.ARGBtarget = new JFormattedTextField();
        this.palettebutton = new JButton("ADD");
       class ColorChooserRenderer extends DefaultTableCellRenderer {
           @Override
           public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
               Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
               if (value instanceof Color) {
                   component.setBackground((Color) value);
                   component.setForeground(new Color(255,255,255,0));
               }
               return component;
           }
       }

        styleconfig();
        addelementstopanel();
   }
   private void styleconfig(){
       this.temperaturetarget.setPreferredSize(new Dimension(15,15));
       this.temperaturetarget.setText("0");
       this.ARGBtarget.setPreferredSize(new Dimension(35,15));
       this.ARGBtarget.setText("Color");;
       this.setMinimumSize(new Dimension(200,500));
       this.temperaturetarget.setPreferredSize(new Dimension(100,20));
       this.ARGBtarget.setPreferredSize(new Dimension(100,20));
   }
   private void addelementstopanel(){
       GridBagConstraints c = new GridBagConstraints();
       c.anchor = GridBagConstraints.NORTHWEST;
       c.fill = GridBagConstraints.HORIZONTAL;
       c.gridy = 0;
       this.add(this.palettetargets,c);
       addpanelb();
   }
    private void addpanelb(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        c.gridx = 0;
        JPanel panelb = new JPanel();
        panelb.setLayout(new GridBagLayout());
        panelb.setMinimumSize(new Dimension(100,100));
        panelb.setBorder(new CompoundBorder(new LineBorder(Color.WHITE),new EmptyBorder(15,0,15,0)));
        this.add(panelb,c);
        c.gridy = 0;
        panelb.add(this.temperaturetarget,c);
        c.gridy = 1;
        panelb.add(this.ARGBtarget,c);
        c.gridy = 2;
        c.gridx = 0;
        panelb.add(this.palettebutton,c);
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

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    public JFormattedTextField getARGBtarget() {
        return ARGBtarget;
    }

    public void setARGBtarget(JFormattedTextField ARGBtarget) {
        this.ARGBtarget = ARGBtarget;
    }
}
