package Komponenty;
import Iridium_Geometry.Iridium_Geometry;
import Konstanty.Konstanty;
import Konstanty._2Dsouradnice;
import Vlastnosti_komponentu.Vlastnosti;
import Vlastnosti_komponentu.VlastnostiKomponentu;

import java.awt.*;

public class Usecka extends Predek{

	public _2Dsouradnice prv, dru;
	public double a, b, c;
	private double pomocny, vektorx;
	
	
	
	
	public Usecka(_2Dsouradnice e, _2Dsouradnice ee, String jmeno){
		super(jmeno);
		prv = e;
		dru = ee;
		name = jmeno;		
		
		a = dru.getY() - prv.getY();
		b = prv.getX() - dru.getX();		
		pomocny = Math.pow((Math.pow(a, 2) + Math.pow(b,2)), 0.5);
		vektorx = (-b)/pomocny;
		a /= pomocny;
		b /= pomocny;
		c = -(a*prv.x + b*prv.y);
		
		
	}
	
	public void vykresli(Graphics g){
		int i;
		
		if(vlastnosti == null){			
			for(i = 0; i < Vlastnosti.vlastnosti.length; i++){
				if(name.contains(Vlastnosti.vlastnosti[i].getJmeno())){
					g.setColor(Vlastnosti.vlastnosti[i].getBarva());
					break;
				}
			}
			if(Vlastnosti.vlastnosti[i].getCaraStyl() == Vlastnosti.typyCarStyl[2]){
				vykresliDotted(g);
				return;
			}
			else
			if(Vlastnosti.vlastnosti[i].getCaraStyl() == Vlastnosti.typyCarStyl[3]){
				vykresliCerchovana(g);
				return;
			}
			
		}
		g.drawLine(Konstanty.Zaokrouhli(prv.x),Konstanty.Zaokrouhli(prv.y),Konstanty.Zaokrouhli(dru.x),Konstanty.Zaokrouhli(dru.y));
	}
	
	public void vykresliDotted(Graphics g){
		_2Dsouradnice vektor;
		double konstanta;
		double cmNaJednotku = 0.8;
		
		vektor= new _2Dsouradnice(dru.x -prv.x, dru.y-prv.y);
		pomocny = Math.pow((Math.pow(vektor.x,2) + Math.pow(vektor.y, 2)), 0.5);
		
		cmNaJednotku /= 2.54;	//prevedeno na palce;
		cmNaJednotku *= (Iridium_Geometry.t.getScreenResolution());	//prevedeno na obrazove body;
		konstanta = Konstanty.Zaokrouhli(pomocny / cmNaJednotku)*2;
		
		if(konstanta < 2)
			konstanta = 2;		
		
		vektor.x /= pomocny;
		vektor.y /= pomocny;
		pomocny /= konstanta;
		
		for(int i = 0; i < konstanta; i += 2){
			if(i +2 < konstanta)
				g.drawLine(Konstanty.Zaokrouhli(prv.x + i*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + i*pomocny*vektor.y), Konstanty.Zaokrouhli(prv.x + (i + 1.6)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (i + 1.6)*pomocny*vektor.y));
			else
				g.drawLine(Konstanty.Zaokrouhli(prv.x + i*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + i*pomocny*vektor.y), Konstanty.Zaokrouhli(prv.x + (i + 2)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (i + 2)*pomocny*vektor.y));				
		}
	}
	public void vykresliCerchovana(Graphics g){
		_2Dsouradnice vektor;
		double konstanta1;		
		double cmNaJednotku = 1.3;
		
		vektor= new _2Dsouradnice(dru.x -prv.x, dru.y-prv.y);
		pomocny = Math.pow((Math.pow(vektor.x,2) + Math.pow(vektor.y, 2)), 0.5);
		
		cmNaJednotku /= 2.54;	//prevedeno na palce;
		cmNaJednotku *= (Iridium_Geometry.t.getScreenResolution());	//prevedeno na obrazove body;
		konstanta1 = Konstanty.Zaokrouhli(pomocny / cmNaJednotku)*2;
		
		if(konstanta1 < 2)
			konstanta1 = 2;		
		
		vektor.x /= pomocny;
		vektor.y /= pomocny;		
		pomocny /= konstanta1;	
		
		for(int i = 0; i < konstanta1; i += 2){			
				
			g.drawLine(Konstanty.Zaokrouhli(prv.x + i*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + i*pomocny*vektor.y), Konstanty.Zaokrouhli(prv.x + ( 1.5 +i)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (1.5 + i)*pomocny*vektor.y));
			if(i + 2 <konstanta1)
			g.drawLine(Konstanty.Zaokrouhli(prv.x + (i + 1.5 +2*0.5/5)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (i + 1.5+2*0.5/5)*pomocny*vektor.y), Konstanty.Zaokrouhli(prv.x + ( 1.5 +i + 3*0.5/5)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (1.5 + i + 3*0.5/5)*pomocny*vektor.y));
			else
				g.drawLine(Konstanty.Zaokrouhli(prv.x + (i + 1.5 +2*0.5/5)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (i + 1.5+2*0.5/5)*pomocny*vektor.y), Konstanty.Zaokrouhli(prv.x + ( 2 +i)*pomocny*vektor.x) , Konstanty.Zaokrouhli(prv.y + (2 + i)*pomocny*vektor.y));
		
		}	
	}
	
	public boolean klikNaUsecku(Point e){		
		if(Math.abs(a*(e.getX()) + b*(e.getY()) + c) < Konstanty.KliknaPrimku && (vykresli == true || VsechnyKomponenty.ZobrazSkryteKomponenty == true))			
			if(Math.abs(vektorx) >= Math.pow(0.5, 0.5)){
				if((prv.x <= e.getX() && dru.x >= e.getX()) || (prv.x >= e.getX() && dru.x <= e.getX()))
				return true;
			}
			else{
				if((prv.y <= e.getY() && dru.y >= e.getY())||(prv.y >= e.getY() && dru.y <= e.getY()))
					return true;
			}
				
		return false;
	}
	public _2Dsouradnice bodZUsecky(Point e){
		double aa, bb, cc, c1, pomocny;
		aa = -b;
		bb = a;
		cc = (aa*e.x + bb*e.y);
		c1 = -c;
		if(a != 0){
		pomocny = aa/a;
		aa -= pomocny*a;
		bb -= pomocny*b;
		cc -= pomocny*c1;
		}
		else{
			return (new _2Dsouradnice(((cc-bb*(c1/b))/aa),(c1/b)));
		}
		return (new _2Dsouradnice(((c1 - b*(cc/bb))/a),(cc/bb)));
	}
}
