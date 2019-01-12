package Komponenty;

import java.awt.Graphics;
import java.awt.Toolkit;

import Konstanty._2Dsouradnice;

public class MrizoveBody {
	public Bod[][] body;
	private Toolkit t;
	private double pocetBodunaCm;
	public int pocetRad, pocetSloupcu; 
	public boolean viditelnost = false;
	public boolean vykresleno = false;
	
	public MrizoveBody(){
		t = t.getDefaultToolkit();
		pocetBodunaCm = t.getScreenResolution()/2.54;
		pocetRad = (int)(t.getScreenSize().getHeight()/pocetBodunaCm*3 +1);
		pocetSloupcu = (int)(t.getScreenSize().getWidth()/pocetBodunaCm*3 + 1);
		body = new Bod[pocetRad][pocetSloupcu];				
		body[pocetRad/2-1][pocetSloupcu/2-1] = new Bod(new _2Dsouradnice(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*3/2, Toolkit.getDefaultToolkit().getScreenSize().getHeight()*3/2), "stred");
		
		_2Dsouradnice Origo =  new _2Dsouradnice(body[pocetRad/2-1][pocetSloupcu/2 -1].x, body[pocetRad/2-1][pocetSloupcu/2 -1].y);
		int xOrigo = pocetSloupcu/2-1, yOrigo = pocetRad/2 - 1;
		
		
		for(int rada = 0; rada < pocetRad; rada++){
			for(int sloupec = 0; sloupec < pocetSloupcu; sloupec++){
				
				body[rada][sloupec] = new Bod(new _2Dsouradnice(Origo.x + (sloupec - xOrigo)*pocetBodunaCm, Origo.y +(rada - yOrigo)*pocetBodunaCm ),"[" + (rada - xOrigo)+"][" +(yOrigo - sloupec)+ "]" );
			}			
		}
	}
	
	public void vykresli(Graphics g){
		vykresleno = true;
		for(int rad = 0; rad < pocetRad; rad++){
			for(int sloup = 0; sloup < pocetSloupcu; sloup++){
				if(body[rad][sloup] != null)
					body[rad][sloup].vykresli(g, true);
			}
		}
	}
}
