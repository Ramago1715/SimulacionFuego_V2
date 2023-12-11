package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaletteConfiguration extends JPanel{
   private JTable palettetargets;
   private JFormattedTextField temperaturetarget;
   private JFormattedTextField ARGBtarget;
   private JButton palettebutton;

   private DefaultTableModel defaultTableModel;

    class ColorChooserButtonEditor extends DefaultCellEditor {
        protected JButton button;

        public ColorChooserButtonEditor(JCheckBox checkBox, JTable table) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.setText("ELIMINAR");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int modelRow = table.convertRowIndexToModel(table.getEditingRow());
                    ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            button.setText("ELIMINAR");
            return button;
        }
    }
    class ColorChooserButtonRenderer extends JButton implements TableCellRenderer {
        public ColorChooserButtonRenderer() {
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("ELIMINAR");
            return this;
        }
    }
    class ColorChooserEditor extends AbstractCellEditor implements TableCellEditor {
        private ColorChooserPanel colorChooserPanel;
        private Color selectedColor;

        ColorChooserEditor() {

        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.colorChooserPanel = new ColorChooserPanel();
            this.selectedColor = (Color) value;
            return colorChooserPanel;
        }

        @Override
        public Object getCellEditorValue() {
            return colorChooserPanel.getColor();
        }

    }
    class ColorChooserPanel extends JPanel {
        private Color selectedColor;

        public ColorChooserPanel(){
            selectedColor = JColorChooser.showDialog(ColorChooserPanel.this, "Elegir Color", selectedColor);
        }

        Color getColor() {
            return selectedColor;
        }

        void setColor(Color color) {
            selectedColor = color;
        }
    }
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

            @Override
            public boolean isCellEditable(int row, int column) {
                int tempvalue = (int) this.getValueAt(row,0);
                if (tempvalue == 255 | tempvalue == 0){
                    return false;
                } else if (row == getRowCount()) {
                    return false;
                }
                return true;
            }

        };


        defaultTableModel.addColumn("Temperature");
        defaultTableModel.addColumn("Color");
        defaultTableModel.addColumn("ELIMINAR");
        this.palettetargets = new JTable(this.defaultTableModel);
        TableColumn colorColumn = this.palettetargets.getColumn("Color");
        colorColumn.setCellEditor(new ColorChooserEditor());
        colorColumn.setCellRenderer(new ColorChooserRenderer());


       this.palettetargets.getColumn("ELIMINAR").setCellRenderer(new ColorChooserButtonRenderer());
        this.palettetargets.getColumn("ELIMINAR").setCellEditor(new ColorChooserButtonEditor(new JCheckBox(),palettetargets));


        this.temperaturetarget = new JFormattedTextField(formatter);
        this.ARGBtarget = new JFormattedTextField();
        this.palettebutton = new JButton("ADD");
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
       JLabel title = new JLabel("Configuracion de Paleta");
       title.setFont(new Font("Arial", Font.BOLD, 20));
       title.setHorizontalAlignment(SwingConstants.CENTER);
       c.gridy = 0;
       this.add(title,c);
       c.gridy = 1;
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
