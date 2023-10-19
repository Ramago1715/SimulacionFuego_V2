package SimulacionFuego;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static java.lang.Thread.sleep;

import javax.swing.JFrame;
import javax.swing.JToggleButton;


public class FireController extends JFrame implements ComponentListener, ActionListener, ItemListener {

  
    private JToggleButton tbPlay;
    private Viewer viewer;
    private FireModel animation;



    public static void main(String[] args) {
        FireController et = new FireController();
        et.playAnimation();
    }


   
    public FireController() {
        this.initClass();
        this.configureJFrame();
        this.addUIComponents();
        this.setVisible(true);
        this.pack();
    }


   
    public void playAnimation() {
        while (true) {
            if (this.tbPlay.isSelected()) {
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage();
            }
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }


   
    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.gridy =1;
        this.tbPlay = new JToggleButton("Play/Stop");
        this.tbPlay.addActionListener(this);
        panel.add(this.tbPlay, c);
    }


    public void addUIComponents() {
        Container panel;
        panel = this.getContentPane();
        this.addViewerToPane(panel);
        this.addButtonsToPane(panel);
    }


    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        this.viewer = new Viewer(512, 512, this.animation);
        panel.add(this.viewer, c);
    }

    private void initClass() {
        this.animation = new FireModel(255, 95);
    }

    private void configureJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
    }




    
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        int estado = itemEvent.getStateChange();
        if (estado == ItemEvent.SELECTED) {
        } else {
        }
    }


    @Override
    public void componentHidden(ComponentEvent ce) {
       
    }


    @Override
    public void componentMoved(ComponentEvent ce) {
        
    }


    @Override
    public void componentResized(ComponentEvent ce) {
       
    }


    @Override
    public void componentShown(ComponentEvent ce) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play/Stop":
                this.viewer.paintBackground();
                break;
            default:
                
        }
    }

}
