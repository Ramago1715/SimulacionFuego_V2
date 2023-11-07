package SimulacionFuego;

import java.awt.*;
import java.util.ArrayList;

public class DTOPaletteParameters {
    private ArrayList<Colortargets> colortargets;
    public DTOPaletteParameters(){
        this.colortargets = new ArrayList<>();
        this.colortargets.add(new Colortargets(0,0,0,0,0));
        this.colortargets.add(new Colortargets(255,255,255,255,255));
        this.colortargets.add(new Colortargets(55,100,0,0,0));
        this.colortargets.add(new Colortargets(60,110,155,0,0));
        this.colortargets.add(new Colortargets(72,180,200,100,0));
        this.colortargets.add(new Colortargets(112,250,235,235,40));
        this.colortargets.add(new Colortargets(130,255,255,255,200));
    }

    public  void addtarget(int temperature,Color color){
        this.colortargets.add(new Colortargets(temperature,color));
    }
    public ArrayList<Colortargets> getColortargets() {
        return colortargets;
    }

    public void setColortargets(ArrayList<Colortargets> colortargets) {
        this.colortargets = colortargets;
    }
}
