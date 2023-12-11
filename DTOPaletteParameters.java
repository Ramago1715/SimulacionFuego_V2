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
        sort();
    }

    public  void addtarget(int temperature,Color color){
        this.colortargets.add(new Colortargets(temperature,color));
        sort();
    }
    public ArrayList<Colortargets> getColortargets() {
        return colortargets;
    }
    private void sort() {

        boolean ordenar = true;
        while (ordenar == true) {
            ordenar = false;
            for (int i = 0; i < this.colortargets.size() - 1; i++) {
                if (this.colortargets.get(i).getTemperature() < this.colortargets.get(i + 1).getTemperature()) {
                    ordenar = true;
                    Colortargets aux = this.colortargets.get(i);
                    this.colortargets.set(i, this.colortargets.get(i + 1));
                    this.colortargets.set(i + 1, aux);
                }
            }
        }
    }

    public void setColortargets(ArrayList<Colortargets> colortargets) {
        this.colortargets = colortargets;
    }
}
