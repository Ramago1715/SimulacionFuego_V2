package SimulacionFuego;

import java.awt.Color;
public class Colortargets {
	int temperature;
	Color color;
	
	public Colortargets() {
		
	}
	public Colortargets(int temperature,Color color) {
		setTemperature(temperature);
		setColor(color);
		
	}
	public Colortargets(int temperature, int alpha, int red, int green, int blue) {
		setTemperature(temperature);
		setColor(new Color(red, green, blue, alpha));
	}
	
	
	
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public void setColor(Color color) {
		this.color = new Color(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
	}
	public Color getColor() {
		return new Color(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
	}
	
	public int getAlpha() {
		return this.color.getAlpha();
	}
	public int getRed() {
		return this.color.getRed();
	}
	
	public int getGreen() {
		return this.color.getGreen();
	}
	public int getBlue() {
		return this.color.getBlue();
	
	}
	public int getARGB() {
		
		return this.color.getRGB();
	}
	@Override
	public String toString() {
		return "Colortargets [temperature=" + temperature + ", color=" + color +" "+color.getAlpha() + "]";
	}
	
	
}
	
	

