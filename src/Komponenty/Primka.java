package Komponenty;
import Iridium_Geometry.Iridium_Geometry;
import Konstanty.Konstanty;
import Konstanty._2Dsouradnice;
import Tlacitka.VyberModu;
import Vlastnosti_komponentu.Vlastnosti;

import java.awt.*;

public class Primka extends Predek{
	
	public _2Dsouradnice prv, dru, zacatek, konec;
	public double a, b, c, vektorx;
	private double pomocny;
	
	
	
	public Primka(_2Dsouradnice e, _2Dsouradnice ee, Dimension PlatnoSize, String jmeno){
		super(jmeno);		
		prv = e;
		dru = ee;
		a = dru.y - prv.y;
		b = prv.x - dru.x;
		pomocny = Math.pow((Math.pow(a, 2) + Math.pow(b,2)), 0.5);
		a /= pomocny;
		b /= pomocny;
		vektorx = -b;
		c = -(a*prv.x + b*prv.y);
		zacatek = new _2Dsouradnice(0,0);
		konec = new _2Dsouradnice(PlatnoSize.getWidth() - 1, PlatnoSize.getHeight() - 1);
		
		if(Math.abs(b) > 0.3){
			for(int x = 0; x < PlatnoSize.getWidth(); x++){
				zacatek.y = (-a*x  - c)/b;
				if(jeVRozmezi(PlatnoSize.getHeight(), zacatek.y)){
					zacatek.x = x;
					break;
				}					
			}
			for(int x = (int) (PlatnoSize.getWidth() - 1); x >= 0; x--){
				konec.y =  ((-a*x  - c)/b);
				if(jeVRozmezi(PlatnoSize.getHeight(), konec.y)){
					konec.x = x;
					break;
				}
			}
		}
		else{
			for(int y = 0; y < PlatnoSize.getHeight(); y++){
				zacatek.x = ((-b*y - c)/a );
				if(jeVRozmezi(PlatnoSize.getWidth(),zacatek.x)){
					zacatek.y = y;
					break;
				}				
			}
			for(int y = (int) (PlatnoSize.getHeight() - 1); y >=0; y--){
				konec.x = ((-b*y - c)/a);
				if(jeVRozmezi(PlatnoSize.getWidth(), konec.x)){
					konec.y = y;
					break;
				}
			}
			
		}
		
			
	}
	
	public void vykresliDotted(Graphics g){
		_2Dsouradnice vektor;
		double konstanta;
		double cmNaJednotku = 0.8;
		
		vektor= new _2Dsouradnice(konec.x -zacatek.x, konec.y-zacatek.y);
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
				g.drawLine(Konstanty.Zaokrouhli(zacatek.x + i*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + i*pomocny*vektor.y), Konstanty.Zaokrouhli(zacatek.x + (i + 1.6)*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (i + 1.6)*pomocny*vektor.y));
			else
				g.drawLine(Konstanty.Zaokrouhli(zacatek.x + i*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + i*pomocny*vektor.y), Konstanty.Zaokrouhli(zacatek.x + (i + 2)*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (i + 2)*pomocny*vektor.y));
		}
	}
	public void vykresliCerchovana(Graphics g){
		_2Dsouradnice vektor;
		double konstanta1;
		double cmNaJednotku = 1.3;
		
		vektor= new _2Dsouradnice(konec.x -zacatek.x, konec.y-zacatek.y);
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
			
				
			g.drawLine(Konstanty.Zaokrouhli(zacatek.x + i*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + i*pomocny*vektor.y), Konstanty.Zaokrouhli(zacatek.x + ( 1.5 +i)*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (1.5 + i)*pomocny*vektor.y));
			if(i+2 < konstanta1)
				g.drawLine(Konstanty.Zaokrouhli(zacatek.x + (i + 1.5 +2*0.5/5)*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (i + 1.5+2*0.5/5)*pomocny*vektor.y), Konstanty.Zaokrouhli(zacatek.x + ( 1.5 +i + 3*0.5/5)*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (1.5 + i + 3*0.5/5)*pomocny*vektor.y));
			else
				g.drawLine(Konstanty.Zaokrouhli(zacatek.x + (i + 1.5 +2*0.5/5)*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (i + 1.5+2*0.5/5)*pomocny*vektor.y), Konstanty.Zaokrouhli(zacatek.x + (2 +i )*pomocny*vektor.x) , Konstanty.Zaokrouhli(zacatek.y + (2 + i)*pomocny*vektor.y));
		}	
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
		
				
		g.drawLine(Konstanty.Zaokrouhli(zacatek.x),Konstanty.Zaokrouhli(zacatek.y), Konstanty.Zaokrouhli(konec.x),Konstanty.Zaokrouhli(konec.y));		
	}
	
	public void vykresli(Graphics g, boolean b){
		
		if(name.contains(VsechnyKomponenty.osaX.name) ||name.contains(VsechnyKomponenty.osaY.name)){
			for(int i = 0; i < Vlastnosti.vlastnosti.length; i++){
			if(name.contains(Vlastnosti.vlastnosti[i].getJmeno()))
				g.setColor(Vlastnosti.vlastnosti[i].getBarva());
			
			}			
		}
		
		g.drawLine(Konstanty.Zaokrouhli(zacatek.x),Konstanty.Zaokrouhli(zacatek.y), Konstanty.Zaokrouhli(konec.x),Konstanty.Zaokrouhli(konec.y));
		if(zacatek.x < 5){
		g.drawLine(Konstanty.Zaokrouhli(zacatek.x),Konstanty.Zaokrouhli(zacatek.y)+1, Konstanty.Zaokrouhli(konec.x),Konstanty.Zaokrouhli(konec.y)+1);
		g.drawLine(Konstanty.Zaokrouhli(zacatek.x),Konstanty.Zaokrouhli(zacatek.y)-1, Konstanty.Zaokrouhli(konec.x),Konstanty.Zaokrouhli(konec.y)-1);	
		}
		else{
			g.drawLine(Konstanty.Zaokrouhli(zacatek.x)+1,Konstanty.Zaokrouhli(zacatek.y), Konstanty.Zaokrouhli(konec.x)+1,Konstanty.Zaokrouhli(konec.y));
			g.drawLine(Konstanty.Zaokrouhli(zacatek.x)-1,Konstanty.Zaokrouhli(zacatek.y), Konstanty.Zaokrouhli(konec.x)-1,Konstanty.Zaokrouhli(konec.y));
		}
		}
	
	public boolean klikNaPrimku(Point e){		
		if(Math.abs(a*(e.getX()) + b*(e.getY()) + c) < Konstanty.KliknaPrimku && (vykresli == true || VsechnyKomponenty.ZobrazSkryteKomponenty == true))			
			if(Math.abs(vektorx) >= Math.pow(0.5, 0.5)){
				if((zacatek.x <= e.getX() && konec.x >= e.getX()) || (zacatek.x >= e.getX() && konec.x <= e.getX()))
				return true;
			}
			else{
				if((zacatek.y <= e.getY() && konec.y >= e.getY())||(zacatek.y >= e.getY() && konec.y <= e.getY()))
					return true;
			}
				
		return false;
	}
	
	public _2Dsouradnice bodZPrimky(Point e){
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
	
	public boolean jeVRozmezi(double max, double souradnice){
	
		if(souradnice >= 0 && souradnice <  max)
			return true;
		else return false;
	}
	
}
