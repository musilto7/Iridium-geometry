package Tlacitka;
import java.awt.*;

public class Tlacitko extends Button{
	public int poradi;
	
	public Tlacitko(String s, int poradi){
		this.setLabel(s);
		this.poradi = poradi;
	}

}
