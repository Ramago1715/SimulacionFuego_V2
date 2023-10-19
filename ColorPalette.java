package SimulacionFuego;
import java.util.ArrayList;
import java.awt.Color;
public class ColorPalette {
	ArrayList<Colortargets> palette = new ArrayList<Colortargets>();
	 ArrayList<Colortargets> target = new ArrayList<Colortargets>();
	 
	 
	 public ColorPalette() {
		 this.target.add(new Colortargets(255,new Color(255,255,255,255)));
		 this.target.add(new Colortargets(0,new Color(0,0,0,0)));
		 
	 }
	 public void addcolortotarget(int temperature,Color color) {
		 this.target.add(new Colortargets(temperature,color));

		 
	 }
	 
	 private void sortpalette() {
		boolean ordenar = true;
		 while(ordenar == true) {
			 ordenar = false;
			 for(int i=0;i<this.target.size()-1;i++) {
				 if(this.target.get(i).getTemperature() > this.target.get(i+1).getTemperature()) {
					 ordenar = true;
					 Colortargets aux = this.target.get(i);
					 this.target.set(i,this.target.get(i+1));
					 this.target.set(i+1, aux);
				 }
			 }
		 }
	 }
	 
	 public void calc() {
		 sortpalette();
		 for(int i=0;i<this.target.size()-1;i++) {
			 this.palette.add(this.target.get(i));
			 int temp_now = this.target.get(i).temperature;
			 int temp_then = this.target.get(i+1).temperature;
			 double diff_temp = temp_then - temp_now;
			 
			 int alpha_now = this.target.get(i).getAlpha();
			 int alpha_then = this.target.get(i+1).getAlpha();
			 double diff_alpha = Math.abs(alpha_now - alpha_then)/diff_temp; 
			 
			 int red_now = this.target.get(i).getRed();
			 int red_then = this.target.get(i+1).getRed();
			 double	diff_red =Math.abs(red_now - red_then)/diff_temp;
			 
			 int green_now = this.target.get(i).getGreen();
			 int green_then = this.target.get(i+1).getGreen();
			 double diff_green = Math.abs(green_now - green_then)/diff_temp;
			 
			 int blue_now = this.target.get(i).getBlue();
			 int blue_then = this.target.get(i+1).getBlue();
			 double diff_blue = Math.abs(blue_now - blue_then)/diff_temp ;
			 int count = 1;
			 for(int x = (this.target.get(i).temperature)+1;x<=target.get(i+1).temperature-1;x++) {
				 double ralpha,rred,rgreen,rblue;
				 if(alpha_now < alpha_then) {ralpha=alpha_now+diff_alpha*count;}else{ralpha=alpha_now-diff_alpha*count;}
				 if(red_now < red_then) {rred=red_now+diff_red*count;}else{rred=red_now-diff_red*count;}
				 if(green_now < green_then) {rgreen=green_now+diff_green*count;}else{rgreen=green_now-diff_green*count;}
				 if(blue_now < blue_then) {rblue=blue_now+diff_blue*count;}else{rblue=blue_now-diff_blue*count;}
				 
				 this.palette.add(new Colortargets(x,(int)ralpha,(int)rred,(int)rgreen,(int)rblue));
				 count+=1;	 
			 }
			
			 }
		 this.palette.add(this.target.get(this.target.size()-1));
		 }
	 }
	 



