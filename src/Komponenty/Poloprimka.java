package Komponenty;

import java.awt.Dimension;
import java.awt.Point;

import Konstanty.Konstanty;
import Konstanty._2Dsouradnice;

public class Poloprimka extends Primka{
		public _2Dsouradnice vektor;
		private double pomocny;
	
	public Poloprimka(_2Dsouradnice e, _2Dsouradnice ee, Dimension PlatnoSize, String jmeno){
		super(e, ee, PlatnoSize, jmeno);
		vektor = new _2Dsouradnice(dru.x -prv.x, dru.y - prv.y);
		pomocny =Math.pow(Math.pow(vektor.x,2) + Math.pow(vektor.y, 2), 0.5);
		vektor.x /= pomocny;
		vektor.y /= pomocny;
			
		
		if(zacatek.x < konec.x){
			if(vektor.x > 0){
				zacatek = prv;
			}
			if(vektor.x < 0){
				konec = zacatek;
				zacatek = prv;
			}
		}
		else
		if(zacatek.x > konec.x){
			if(vektor.x > 0){
				konec = zacatek;
				zacatek = prv;
			}
			if(vektor.x < 0){
				zacatek = prv;
			}
		}
		if(vektor.x == 0){
			if(zacatek.y < konec.y){
				if(vektor.y > 0){
					zacatek = prv;
				}
				if(vektor.y < 0){
					konec = zacatek;
					zacatek = prv;
				}
			}
			else
			if(zacatek.y > konec.y){
				if(vektor.y > 0){
					konec = zacatek;
					zacatek = prv;
				}
				if(vektor.y < 0)
					zacatek = prv;
			}
		}
			
	}
	
	public boolean klikNaPoloprimku(Point e){		
		
		if(Math.abs(a*(e.getX()) + b*(e.getY()) + c) < Konstanty.KliknaPrimku && (vykresli == true || VsechnyKomponenty.ZobrazSkryteKomponenty == true)){			
			
			if(Math.abs(vektor.x) >= Math.pow(0.5, 0.5)){
				
				if((zacatek.x <= e.getX() && konec.x >= e.getX()) || (zacatek.x >= e.getX() && konec.x <= e.getX()))
				return true;
			}
			else{
				if((zacatek.y <= e.getY() && konec.y >= e.getY())||(zacatek.y >= e.getY() && konec.y <= e.getY()))
					return true;
			}
			}
				
		return false;
	}

}
