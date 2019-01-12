package Komponenty;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import Iridium_Geometry.Iridium_Geometry;
import Konstanty.Konstanty;
import Konstanty._2Dsouradnice;
import Tlacitka.VyberModu;
import Vlastnosti_komponentu.Vlastnosti;
import Vlastnosti_komponentu.VlastnostiKomponentu;

public class Bod extends Predek{
	
	public double x, y;
	public static int rozliseni = Iridium_Geometry.t.getScreenResolution();
	public double polomer, polomer2;
	
	
	
	
	public Bod(_2Dsouradnice e, String jmeno){
		super(jmeno);
		x = e.getX();
		y = e.getY();
		polomer =0.072 / 2.54 * rozliseni;// 0.083 / 2.54 * rozliseni;    //prevod 0.1 cm na pixely
		polomer2 = 0.083/2.54*rozliseni;
		
		
	}
	
	public void vykresli(Graphics g){				 		
		//g.fillRect(Konstanty.Zaokrouhli((x) - (polomer)+1), Konstanty.Zaokrouhli(y - (polomer)+1), Konstanty.Zaokrouhli(polomer*2),Konstanty.Zaokrouhli(polomer*2));
		if(vlastnosti == null)	
		g.setColor(Vlastnosti.vlastnosti[0].getBarva());
		for(int radky = -Konstanty.Zaokrouhli(polomer) - 1; radky < Konstanty.Zaokrouhli(polomer) + 1; radky++){
			for(int sloupce = - Konstanty.Zaokrouhli(polomer) - 1; sloupce < Konstanty.Zaokrouhli(polomer) + 1; sloupce++){
			if(Math.pow(radky, 2) + Math.pow(sloupce, 2) < polomer * polomer)
				g.drawLine(Konstanty.Zaokrouhli(x) + sloupce,Konstanty.Zaokrouhli(y) + radky, Konstanty.Zaokrouhli(x) + sloupce, Konstanty.Zaokrouhli(y)+ radky);
			}
		}
	}
	public void vykresli(Graphics g, boolean pretizeni){				 		
		Color color = g.getColor();	
		g.setColor(new Color(200,200, 200));
		for(int radky = -Konstanty.Zaokrouhli(polomer) - 1; radky < Konstanty.Zaokrouhli(polomer) + 1; radky++){
			for(int sloupce = - Konstanty.Zaokrouhli(polomer) - 1; sloupce < Konstanty.Zaokrouhli(polomer) + 1; sloupce++){
			if(Math.pow(radky, 2) + Math.pow(sloupce, 2) < polomer * polomer)
				g.drawLine(Konstanty.Zaokrouhli(x) + sloupce,Konstanty.Zaokrouhli(y) + radky, Konstanty.Zaokrouhli(x) + sloupce, Konstanty.Zaokrouhli(y)+ radky);
			}
		}
		g.setColor(color);
	}
	
	
	
	public boolean klikNaBod(Point souradnice){
		if((Math.abs(x-souradnice.x)) <= (polomer2) && (Math.abs(y - souradnice.y)) <= polomer2 && (vykresli == true || VsechnyKomponenty.ZobrazSkryteKomponenty == true)){
			
			return true;
		}
		else
			return false;
	}
}
