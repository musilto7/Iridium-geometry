package Obrazovka;

import java.awt.*;

import Iridium_Geometry.Iridium_Geometry;
import Komponenty.Predek;
import Tlacitka.VyberModu;

public class KontrolniVypis extends Canvas{
	private String[] texty = new String[]{"","Bod", "Bod 1", "Bod 2", "Pøímka", "Pøímka 1", "Pøímka 2", "Kliknìte na polopøímku", "Zadejte vzdálenost od poèátku polopøímky"};
	private FontMetrics fMetrics;
	private String zprava;
	
	public KontrolniVypis(){
		this.setSize(Iridium_Geometry.okno.getWidth() - Iridium_Geometry.okno.getInsets().left - Iridium_Geometry.okno.getInsets().right, Iridium_Geometry.okno.getHeight()/15);
		zprava = texty[0];		
	}
	
	public void paint(Graphics g){	
	g.setColor(new Color(80, 80, 80));
	g.drawLine(0, 0, 0, this.getHeight());
	g.setFont(new Font("Serif", Font.PLAIN, 16));
	fMetrics =  g.getFontMetrics();
	g.drawString(zprava, 3, fMetrics.getAscent());
}
	public void nastavText(int i){
		zprava =texty[i];
		repaint();
	}
	
	public static void resetvypisu(){
		for(int i = 0; i < VyberModu.nazvyTlacitek.length; i++){
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[i]) == 0){
		if(i == 0){
			Iridium_Geometry.vypis.nastavText(i);
		}
		if(i == 1){
			Iridium_Geometry.vypis.nastavText(i);
		}
		if(i > 1 && i < 5)
			Iridium_Geometry.vypis.nastavText(2);
		if(i == 5 || i == 6)
			Iridium_Geometry.vypis.nastavText(1);
		if(i == 7)
			Iridium_Geometry.vypis.nastavText(i);
		if(i == 8)
			Iridium_Geometry.vypis.nastavText(5);
		break;
		}
	}}
	public static void nastavVypis(){
		for(int i = 2; i < 5; i++){
			if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[i]) == 0  ){
				Iridium_Geometry.vypis.nastavText(3);
				break;
			}
			}
		
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[5]) == 0){
			Iridium_Geometry.vypis.nastavText(4);			
		}
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[6]) == 0){
			Iridium_Geometry.vypis.nastavText(4);
		}
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[7]) == 0){
			Iridium_Geometry.vypis.nastavText(8);
		}
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[8]) == 0){
			Iridium_Geometry.vypis.nastavText(6);
		}
	}
	
}