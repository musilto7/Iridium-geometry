package Komponenty;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.*;
import java.util.Observable;

import Iridium_Geometry.Iridium_Geometry;
import Konstanty.Konstanty;
import Konstanty._2Dsouradnice;
import Obrazovka.KontrolniVypis;
import Tlacitka.VyberModu;
import ZmenaVykresleni.Zmena;


public class VsechnyKomponenty implements MouseListener {
	
	public Bod[] body = new Bod[0]; 
	public Usecka[] usecka = new Usecka[0];
	public Primka[] primka = new Primka[0];
	public Poloprimka[] poloprimka = new Poloprimka[0];
	public Kolmice[] kolmice = new Kolmice[0];
	public Rovnobezka[] rovnobezka = new Rovnobezka[0];
	public static OsaX osaX;
	public static OsaY osaY;
	public MrizoveBody mrizoveBody;
	public Predek predek;
	
	public static KteryKomponent kteryKomponent;
	public static Prusecik prusecik;
	public static PopupMenu popupMenu;
	public static Zmena zmena;
	public static int pocetVolaniUsecky = 0;
	public static _2Dsouradnice point;
	public static boolean ZobrazSkryteKomponenty;
	
	public VsechnyKomponenty(){
		zmena = new Zmena();		
		osaX = new OsaX();
		osaY = new OsaY();
		mrizoveBody = new MrizoveBody();
		ZobrazSkryteKomponenty = false;
	}
	
	public void poleBoduPlus(){
		Bod[] pomocnyBod;			
		pomocnyBod = new Bod[body.length];
					
		for(int i = 0; i < body.length; i++){
			pomocnyBod[i] = body[i];
		}
		body = new Bod[body.length + 1];
		
		for(int i = 0; i < body.length - 1; i++){
			body[i] = pomocnyBod[i];
		}
	}
	
	public void poleUsecekPlus(){
		Usecka[] pomocnaUsecka = new Usecka[usecka.length];
		for(int i = 0; i < usecka.length; i++){
			pomocnaUsecka[i] = usecka[i];
		}
		usecka = new Usecka[usecka.length + 1];
		for(int i = 0; i < usecka.length - 1; i++){
			usecka[i] = pomocnaUsecka[i];
		}
	}
	public void polePrimekPlus(){
		Primka[] pomocnaPrimka = new Primka[primka.length];
		for(int i = 0; i < primka.length; i++){
			pomocnaPrimka[i] = primka[i];
		}
		primka = new Primka[primka.length + 1];
		for(int i = 0; i < primka.length - 1; i++){
			primka[i] = pomocnaPrimka[i];
		}
	}
	public void polePoloprimekPlus(){
		Poloprimka[] pomocnaPoloprimka = new Poloprimka[poloprimka.length];
		for(int i = 0; i < poloprimka.length; i++){
			pomocnaPoloprimka[i] = poloprimka[i];
		}
		poloprimka = new Poloprimka[poloprimka.length + 1];
		for(int i = 0; i < poloprimka.length - 1; i++){
			poloprimka[i] = pomocnaPoloprimka[i];
		}
	}
	
	public void poleKolmicePlus(){
		Kolmice[] pomocnaKolmice = new Kolmice[kolmice.length];
		for(int i = 0; i < kolmice.length; i++){
			pomocnaKolmice[i] = kolmice[i];
		}
		kolmice = new Kolmice[kolmice.length + 1];
		for(int i = 0; i < kolmice.length - 1; i++){
			kolmice[i] = pomocnaKolmice[i];
		}
	}
	
	public void poleRovnobezkaPlus(){
		Rovnobezka[] pomocnaRovnobezka = new Rovnobezka[rovnobezka.length];
		for(int i = 0; i < rovnobezka.length; i++){
			pomocnaRovnobezka[i] = rovnobezka[i];
		}
		rovnobezka = new Rovnobezka[rovnobezka.length + 1];
		for(int i = 0; i < rovnobezka.length - 1; i++){
			rovnobezka[i] = pomocnaRovnobezka[i];
		}
	}
	public Predek[] polePredekPlus(Predek[] pole){
		Predek[] pomocny = new Predek[pole.length + 1];
		for(int i = 0; i < pole.length; i++){
			pomocny[i] = pole[i];
		}
		return pomocny;
	}
	
	public Predek[] klikNaPrimku(Point e){
		Predek[] poleKomponentu = new Predek[0];
		for(int i = 0; i < usecka.length; i++){
			if(usecka[i].klikNaUsecku(e)){
				poleKomponentu = polePredekPlus(poleKomponentu);
				poleKomponentu[poleKomponentu.length - 1] = usecka[i];		
			}
		}
		for(int i = 0; i < primka.length; i++){			
			if(primka[i].klikNaPrimku(e)){
				poleKomponentu = polePredekPlus(poleKomponentu); 
				poleKomponentu[poleKomponentu.length - 1] =  primka[i];
			}
		}
		for(int i = 0; i < poloprimka.length; i++){
			
			if(poloprimka[i].klikNaPoloprimku(e)){
				
				poleKomponentu = polePredekPlus(poleKomponentu); 
				poleKomponentu[poleKomponentu.length - 1] =	poloprimka[i];
			}
		}
		for(int i = 0; i < kolmice.length; i++){
			if(kolmice[i].klikNaKolmici(e)){
				poleKomponentu = polePredekPlus(poleKomponentu); 
			poleKomponentu[poleKomponentu.length - 1] = kolmice[i];
			}
		}
		for(int i = 0; i < rovnobezka.length; i++){
			if(rovnobezka[i].klikNaKolmici(e)){
				poleKomponentu = polePredekPlus(poleKomponentu); 
			poleKomponentu[poleKomponentu.length - 1] = rovnobezka[i];
		
			}}
		if(osaX.klikNaPrimku(e) && osaX.viditelnost){
			poleKomponentu = polePredekPlus(poleKomponentu);
			poleKomponentu[poleKomponentu.length - 1] = osaX;
		}
		if(osaY.klikNaPrimku(e) && osaY.viditelnost){
			poleKomponentu = polePredekPlus(poleKomponentu);
			poleKomponentu[poleKomponentu.length - 1] = osaY;
		}
		return poleKomponentu;
	}
	public _2Dsouradnice  getSouradniceBodu(Predek cara, Point e){
		_2Dsouradnice souradnice = new _2Dsouradnice(1, 1);
		if(cara.name != osaX.name && cara.name != osaY.name){
		for(int i = 0; i < VyberModu.nazvyTlacitek.length; i++){
		if(cara.name.substring(0, cara.name.indexOf(" ")).compareTo(VyberModu.nazvyTlacitek[i]) == 0){
			switch(i){
			case 2:
				souradnice = ((Usecka) cara).bodZUsecky(e);
				break;
			case 3:
				souradnice = ((Primka) cara).bodZPrimky(e);
				break;
			
			case 4:
				souradnice = ((Poloprimka) cara).bodZPrimky(e);
				break;
			case 5:
				souradnice = ((Rovnobezka) cara).bodZKolmice(e);
				break;
			case 6:
				souradnice = ((Kolmice) cara).bodZKolmice(e);
				break;
			
			}
			break;
			}}}
		if(cara.name.compareTo(osaX.name) == 0){
			souradnice = ((OsaX) cara).bodZPrimky(e);
		}
		if(cara.name.compareTo(osaY.name) == 0){
			souradnice = ((OsaY) cara).bodZPrimky(e);
		}
		return souradnice;
		
	}
	public class NVektor{
		private double a;
		private double b;
		private _2Dsouradnice pocatek, konec;
		
		private int i;
		public NVektor(Predek predek){
			if(predek.name != osaX.name && predek.name != osaY.name){
			for(i = 2; i < 7; i++){
				if((predek.name.substring(0, predek.name.indexOf(" "))).compareTo(VyberModu.nazvyTlacitek[i])== 0 ){
					break;
				}
			}
			switch(i){
				case 2:
					a = ((Usecka)predek).a;
					b = ((Usecka) predek).b;
					pocatek = ((Usecka) predek).prv;
					konec = ((Usecka) predek).dru;
					break;
				case 3:
					a = ((Primka) predek).a;
					b = ((Primka) predek).b;
					pocatek = ((Primka) predek).zacatek;
					konec = ((Primka) predek).konec;
					break;
				case 4:
					a = ((Poloprimka) predek).a;
					b = ((Poloprimka) predek).b;
					pocatek = ((Poloprimka) predek).zacatek;
					konec = ((Poloprimka) predek).konec;
					break;
				case 5:
					a = ((Rovnobezka) predek).a;
					b = ((Rovnobezka) predek).b;
					pocatek = ((Rovnobezka) predek).zacatek;
					konec = ((Rovnobezka) predek).konec;
					break;
				case 6:
					a = ((Kolmice) predek).a;
					b = ((Kolmice) predek).b;
					pocatek = ((Kolmice) predek).zacatek;
					konec = ((Kolmice) predek).konec;
					break;
			}
			}
			if(predek.name.compareTo(osaX.name) == 0){
				a = ((OsaX) predek).a;
				b = ((OsaX) predek).b;
				pocatek = ((OsaX) predek).zacatek;
				konec = ((OsaX) predek).konec;
			}
			if(predek.name.compareTo(osaY.name) == 0){
				a = ((OsaY) predek).a;
				b = ((OsaY)predek).b;
				pocatek = ((OsaY) predek).zacatek;
				konec = ((OsaY) predek).konec;
			}
		}
		public double getA(){
			return a;
		}
		public double getB(){
			return b;
		}
		public _2Dsouradnice getPocatek(){
			return pocatek;
		}
		public _2Dsouradnice getKonec(){
			return konec;
		}
	}
	
	public class KteryKomponent{
		private Predek[] predekPole;
		public Dialog dialog;
		private Panel pan;
		private Point poziceKliknuti;
		private int ridici;
		private Point absolutniPozice;
		
		public KteryKomponent(Predek[] pole, Point e, Point ee, int ridicii){
			predekPole = pole;
			poziceKliknuti = ee;
			ridici = ridicii;
			absolutniPozice = e;
			
		dialog = new Dialog(Iridium_Geometry.okno, "Vyberte komponent", true);
		pan = new Panel(new FlowLayout());
		
		
			Button[] poleTlacitek = new Button[pole.length]; 
						
			for(int i = 0; i < pole.length; i++){
				poleTlacitek[i] = new Button(pole[i].name);
				pan.add(poleTlacitek[i]);
				poleTlacitek[i].addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent arg0) {
						if(ridici ==0){
						poleBoduPlus();
						for(int i = 0; i < predekPole.length; i++){
							if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
							body[body.length - 1] = new Bod(getSouradniceBodu(predekPole[i], poziceKliknuti), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (body.length - 1)));
							break;
							}
						}
						}
						if(ridici == 1){
							pocetVolaniUsecky++;
							KontrolniVypis.nastavVypis();
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
								point = new _2Dsouradnice(((Bod)predekPole[i]).x, ((Bod)predekPole[i]).y);
								break;
								}
							}
						}
						if(ridici == 2){
							
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
									if(!(point.x == ((Bod) predekPole[i]).x && point.y == ((Bod) predekPole[i]).y)){
										poleUsecekPlus();
										pocetVolaniUsecky = 0;
										KontrolniVypis.resetvypisu();
									usecka[usecka.length - 1] = new Usecka(new _2Dsouradnice(((Bod) predekPole[i]).x,((Bod)predekPole[i]).y), point, VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (usecka.length - 1)));
									break;
									}
									else break;
								}
							}
						}
						if(ridici == 3){
							
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){									
									if(!(point.x == ((Bod) predekPole[i]).x && point.y == ((Bod) predekPole[i]).y)){
										polePrimekPlus();
										pocetVolaniUsecky = 0;
										KontrolniVypis.resetvypisu();
									primka[primka.length - 1] = new Primka(new _2Dsouradnice(((Bod) predekPole[i]).x,((Bod)predekPole[i]).y), point, Iridium_Geometry.platno.getSize(),VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (primka.length - 1)));
									break;
									}
									else break;
								}}
							
						}
						if(ridici == 4){
							
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
									if(!(point.x == ((Bod) predekPole[i]).x && point.y == ((Bod) predekPole[i]).y)){
										polePoloprimekPlus();
										pocetVolaniUsecky = 0;
										KontrolniVypis.resetvypisu();
									poloprimka[poloprimka.length - 1] = new Poloprimka(point, new _2Dsouradnice(((Bod) predekPole[i]).x,((Bod)predekPole[i]).y), Iridium_Geometry.platno.getSize(),VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (poloprimka.length - 1)));
									break;
									}
									else break;
								}}
							
						}
						if(ridici == 5){
							NVektor nVektor;
							poleRovnobezkaPlus();
							pocetVolaniUsecky = 0;
							KontrolniVypis.resetvypisu();
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
								nVektor = new NVektor(predekPole[i]);
								rovnobezka[rovnobezka.length - 1] = new Rovnobezka(point, nVektor.getA(), nVektor.getB(), Iridium_Geometry.GetPlatnoSize(), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (rovnobezka.length - 1)));
									break;
								}
								}
						}
						
						if(ridici == 6){
							NVektor nVektor;
							poleKolmicePlus();
							pocetVolaniUsecky = 0;
							KontrolniVypis.resetvypisu();
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
								nVektor = new NVektor(predekPole[i]);
								kolmice[kolmice.length - 1] = new Kolmice(point, nVektor.getA(), nVektor.getB(), Iridium_Geometry.GetPlatnoSize(), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (kolmice.length - 1)));
									break;
								}
								}
								
							
						}
						if(ridici == 7){
							for(int i = 0; i <predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
									dialog.setVisible(false);
									ZadejVzdalenost zadejVzdalenost = new ZadejVzdalenost(absolutniPozice, predekPole[i]);
									zadejVzdalenost.dialog.setVisible(true);
									break;
								}
							}
						}
						if(ridici == 8){
							pocetVolaniUsecky++;
							KontrolniVypis.nastavVypis();
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
								predek = predekPole[i];
								break;
								}
							}
							
						}
						if(ridici == 9){
							Predek predek22 = null;
							
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
								predek22 = predekPole[i];
								break;
								}
							}
							
							prusecik = new Prusecik(predek, predek22, absolutniPozice);
							if(prusecik.dialog != null)
								prusecik.dialog.setVisible(true);
							
						}
						
						if(ridici == 10){
							Predek predek22 = null;
							for(int i = 0; i < predekPole.length; i++){
								if(arg0.getActionCommand().compareTo(predekPole[i].name) == 0){
								predek22 = predekPole[i];
								break;
								}
						}
							 popupMenu = new PopupMenu(predek22, poziceKliknuti, absolutniPozice);
							 popupMenu.window.setVisible(true);
								
							
						}
						
						dialog.setVisible(false);
						dialog = null;
						zmena.Prekresli();
						}
					
				});
			}						
			dialog.add(pan);
			dialog.pack();
			if(e.getX() + dialog.getSize().width > Iridium_Geometry.t.getScreenSize().getWidth()){
				while(true){
					if(e.getX() + dialog.getSize().width > Iridium_Geometry.t.getScreenSize().getWidth()-1)
						(e.x)--;
					else break;
				}
				if(e.getX() < 0)
					e.x = 0;
			}
			dialog.setLocation(e);
			dialog.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					dialog.setVisible(false);
					dialog = null;
				}
			});
		}
	}
	
	public class Prusecik{
		ZiskejInformace primka1, primka2;
		public Dialog dialog = null;
		_2Dsouradnice bod;
		Button ok;
		
		 public Prusecik(Predek predek1,Predek predek2, Point bodNaObrz){
			 
			 primka1 = new ZiskejInformace(predek1);
			 primka2 = new ZiskejInformace(predek2);
			 
			 bod = getPrusecik(primka1, primka2);
			 
			 if((primka1.nVektor.getA() == primka2.nVektor.getA() && primka1.nVektor.getB() == primka2.nVektor.getB()) || bod.x == Double.POSITIVE_INFINITY || bod.y == Double.POSITIVE_INFINITY){
				 dialog = new Dialog(Iridium_Geometry.okno, "Vybrali jste nevhodné komponenty", true);
				 ok = new Button("OK");
				 dialog.add(ok);
					dialog.setSize(300, 70);
					
					if(bodNaObrz.getX() + dialog.getSize().width > Iridium_Geometry.t.getScreenSize().getWidth()){
						while(true){
							if(bodNaObrz.getX() + dialog.getSize().width > Iridium_Geometry.t.getScreenSize().getWidth()-1)
								(bodNaObrz.x)--;
							else break;
						}
						if(bodNaObrz.getX() < 0)
							bodNaObrz.x = 0;
					}
					dialog.setLocation(bodNaObrz);
					
					ok.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dialog.setVisible(false);
							dialog = null;
							pocetVolaniUsecky = 0;
						}
					});
					
					dialog.addWindowListener(new WindowAdapter(){
						public void windowClosing(WindowEvent e){
							dialog.setVisible(false);
							dialog = null;
							pocetVolaniUsecky = 0;
						}
					});
				 
			 }
			 else{
				 poleBoduPlus();
				 body[body.length - 1] = new Bod(bod, VyberModu.nazvyTlacitek[1].concat(" " + (body.length - 1)));
				 pocetVolaniUsecky = 0;
				 zmena.Prekresli();
			 }
			 
			
		 }
		 
		 public _2Dsouradnice getPrusecik(ZiskejInformace primka1, ZiskejInformace primka2){
			 
			 double a1, b1, c1;
			 double a2, b2, c2, pomocny;
			 double y, x;
			 
			 a1 = primka1.nVektor.a;
			 b1 = primka1.nVektor.b;
			 c1 = a1*primka1.pocatek.x +b1*primka1.pocatek.y;
			 
			 a2 = primka2.nVektor.a;
			 b2 = primka2.nVektor.b;
			 c2 = a2*primka2.pocatek.x +b2*primka2.pocatek.y;
			 
			 if(a1 != 0){
				 pomocny = a2/a1;
				 a2 -= a1*pomocny;
				 b2 -= b1*pomocny;
				 c2 -= c1*pomocny;
				 
				 if(b2 != 0)
					 y = c2/b2;
				 else y = Double.POSITIVE_INFINITY;
			 
				 if(a1 != 0)
				 x = (c1-b1*y)/a1;
				 else
					 x = Double.POSITIVE_INFINITY;
			 }
			 else{
				 y = c1/b1;
				 
				 if(a2 != 0)
					 x = (c2 -b2*y)/a2;
				 else
					 x = Double.POSITIVE_INFINITY;				 
			 }
			 
			 if(!((Konstanty.Zaokrouhli(primka1.pocatek.x) <= Konstanty.Zaokrouhli(x) && Konstanty.Zaokrouhli(primka1.konec.x) >= Konstanty.Zaokrouhli(x)) || (Konstanty.Zaokrouhli(primka1.pocatek.x) >= Konstanty.Zaokrouhli(x) && Konstanty.Zaokrouhli(primka1.konec.x) <= Konstanty.Zaokrouhli(x))))
				 x = Double.POSITIVE_INFINITY;
			 if(!((Konstanty.Zaokrouhli(primka2.pocatek.x) <= Konstanty.Zaokrouhli(x) && Konstanty.Zaokrouhli(primka2.konec.x) >= Konstanty.Zaokrouhli(x)) || (Konstanty.Zaokrouhli(primka2.pocatek.x) >= Konstanty.Zaokrouhli(x) && Konstanty.Zaokrouhli(primka2.konec.x) <= Konstanty.Zaokrouhli(x))))
				 x = Double.POSITIVE_INFINITY;
			 if(!((Konstanty.Zaokrouhli(primka1.pocatek.y) <= Konstanty.Zaokrouhli(y) && Konstanty.Zaokrouhli(primka1.konec.y) >= Konstanty.Zaokrouhli(y)) || (Konstanty.Zaokrouhli(primka1.pocatek.y) >= Konstanty.Zaokrouhli(y) && Konstanty.Zaokrouhli(primka1.konec.y) <= Konstanty.Zaokrouhli(y))))
				 y = Double.POSITIVE_INFINITY;
			 if(!((Konstanty.Zaokrouhli(primka2.pocatek.y) <= Konstanty.Zaokrouhli(y) && Konstanty.Zaokrouhli(primka2.konec.y) >= Konstanty.Zaokrouhli(y)) || (Konstanty.Zaokrouhli(primka2.pocatek.y) >= Konstanty.Zaokrouhli(y) && Konstanty.Zaokrouhli(primka2.konec.y) <= Konstanty.Zaokrouhli(y))))
				 y = Double.POSITIVE_INFINITY;
			 
			 return new _2Dsouradnice(x, y);
		 }
		 
		 public class ZiskejInformace{
			 NVektor nVektor;
			 _2Dsouradnice pocatek;
			 _2Dsouradnice konec;
			 String jmeno;
			 public ZiskejInformace(Predek predek){
				 nVektor = new NVektor(predek);
				 pocatek = nVektor.getPocatek();
				 konec = nVektor.getKonec();
				 jmeno = predek.name;
			 }
		 }
		
	}
	
	public class PopupMenu{
		Window window;
		Panel pan;
		GridBagLayout gbl;
		GridBagConstraints gbc;
		Button[] btn_nabidka;
		String[] nabidka= new String[]{"Popis", "Vlastnosti", "Skrýt","Zavøít"};		
		
		
		public PopupMenu(final Predek predek,Point poziceKliknuti,Point absolutniPozice){
			
			window = new Window(Iridium_Geometry.okno);
			gbl = new GridBagLayout();
			gbc = new GridBagConstraints();
			pan = new Panel(gbl);
			//pan.setBackground(new Color(0, 245,255));
			
			
			btn_nabidka = new Button[nabidka.length];
			
			gbc.weightx = 1.; gbc.weighty = 0; gbc.fill = 1;
			gbc.insets = new Insets(5, 5, 5, 5);
			for(int i =0; i < nabidka.length;i++){
				btn_nabidka[i] = new Button(nabidka[i]);				
				gbl.setConstraints(btn_nabidka[i],gbc);
				pan.add(btn_nabidka[i]);
				gbc.gridy = i+1;
				gbc.insets = new Insets(0, 5, 5, 5);
			}
			
			
			window.add(pan);
			window.pack();
			if(absolutniPozice.getX() + window.getSize().width > Iridium_Geometry.t.getScreenSize().getWidth()){
				while(true){
					if(absolutniPozice.getX() + window.getSize().width > Iridium_Geometry.t.getScreenSize().getWidth()-1)
						(absolutniPozice.x)--;
					else break;
				}
				if(absolutniPozice.getX() < 0)
					absolutniPozice.x = 0;
			}
			window.setLocation(absolutniPozice);
			
			for(int i = 0; i < btn_nabidka.length; i++){
				if (btn_nabidka[i].getLabel() == nabidka[2]){
					btn_nabidka[i].addActionListener(new ActionListener() {				
					
						public void actionPerformed(ActionEvent arg0) {
							predek.vykresli = false;
							new ZneviditelniKomponent(predek);
							zavritWindow();
						}
					});
					
				}
			}
			
			btn_nabidka[0].requestFocus();
			btn_nabidka[0].addFocusListener(new FocusAdapter() {			
				public void focusLost(FocusEvent e) {
					zavritWindow();
					
				}				
			});
			
			btn_nabidka[btn_nabidka.length-1].addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent arg0) {
					zavritWindow();
				}
			});
			
	}
		public void zavritWindow(){
			if(window != null)
				window.setVisible(false);
				window = null;
		}
	}
	
	public class ZneviditelniKomponent{
		int i;
		
		public ZneviditelniKomponent(Predek predek){
			
			for(i = 1; i < 7; i++){
				if(predek.name == osaX.name || predek.name == osaY.name){
					i =7;
					break;
				}
				else
				if((predek.name.substring(0, predek.name.indexOf(" "))).compareTo(VyberModu.nazvyTlacitek[i])== 0 ){
					break;
				}
			}
			switch(i){
				case 1:
					for(int k = 0; k < body.length; k++){
						if(predek.name == body[k].name){
							body[k].vykresli = false;
							zmena.Prekresli(true);
							break;
						}
					}
					break;
				case 2:
					for(int k = 0; k < usecka.length; k++){
						if(predek.name == usecka[k].name){
							usecka[k].vykresli = false;
							zmena.Prekresli(true);
							break;
						}
					}
					break;
				case 3:
					for(int k = 0; k < primka.length; k++){
						if(predek.name == primka[k].name){
							primka[k].vykresli = false;
							zmena.Prekresli(true);
							break;
						}
					}
					break;
				case 4:
					for(int k = 0; k < poloprimka.length; k++){
						if(predek.name == poloprimka[k].name){
							poloprimka[k].vykresli = false;
							zmena.Prekresli(true);
							break;
						}
					}						
					break;
				case 5:
					for(int k = 0; k < rovnobezka.length; k++){
						if(predek.name == rovnobezka[k].name){
							rovnobezka[k].vykresli = false;
							zmena.Prekresli(true);
							break;
						}
					}
				case 6:
					for(int k = 0; k < kolmice.length; k++){
						if(predek.name == kolmice[k].name){
							kolmice[k].vykresli = false;
							zmena.Prekresli(true);
							break;
						}		
					}
					break;
				
			}
		}
		
	}
	
	public class ZadejVzdalenost{
		public Dialog dialog;
		private TextField text; 
		private Double vzdalenost;
		private Poloprimka poloP;
		
		public ZadejVzdalenost(Point e, Predek predek){
			dialog = new Dialog(Iridium_Geometry.okno, "Zadejte vzdalenost",true);
			text = new TextField("Zadejte vzdalenost");
			text.setSelectionStart(0);
			text.setSelectionEnd((text.getText().length()));
			dialog.add(text);
			dialog.pack();
			dialog.setLocation(e);
			poloP = ((Poloprimka)predek);
			KontrolniVypis.nastavVypis();
			
			text.addTextListener(new TextListener(){

				@Override
				public void textValueChanged(TextEvent arg0) {
					
				String cislo = text.getText();
				
				
				for(int i = 0, poruseni = 0; i < cislo.length(); i++){
					if(cislo.charAt(i) == '.')
						poruseni++;
					
					if((cislo.charAt(i) <'0' || cislo.charAt(i) > '9') && cislo.charAt(i) != '.'){								
						
						cislo = cislo.substring(0, i) + cislo.substring(i + 1, cislo.length());
						text.setText(cislo);							
					}
					if(poruseni > 1){
						cislo = cislo.substring(0, i) + cislo.substring(i + 1, cislo.length());
						text.setText(cislo);
						poruseni = 1;
					}					
				}
				
				}
				
			});
			
			text.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					KontrolniVypis.resetvypisu();
					
					String cislo = text.getText();
					
					if(cislo.length() > 0){
						if(cislo.charAt(0) == '.')
						{
							cislo = "0" + cislo;
							text.setText(cislo);
						}
						if(text.getText().charAt(0) < '0' || text.getText().charAt(0) > '9')
							text.setText("0");
					}
					else {
						text.setText("0");
					}
					
					
					vzdalenost = Double.parseDouble(text.getText());
					
					dialog.setVisible(false);
					dialog = null;
					
					double rozliseni = (Iridium_Geometry.t.getScreenResolution())/2.54;
					double bodX, bodY;
					_2Dsouradnice vektor;
					double k;
					
					vektor = poloP.vektor;
					k = Math.pow(Math.pow(vektor.x,2)+Math.pow(vektor.y, 2), 0.5);
					
					
					bodX = rozliseni*vzdalenost*(vektor.x) + (poloP.zacatek.getX());
					bodY = rozliseni*vzdalenost*(vektor.y) + (poloP.zacatek.getY());
					
					
					
					poleBoduPlus();
					body[body.length - 1] = new Bod(new _2Dsouradnice(bodX, bodY), VyberModu.nazvyTlacitek[1].concat(" " +(body.length - 1)));
					zmena.Prekresli();
				}
				
			});
			
			dialog.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					dialog.setVisible(false);
					dialog = null;
					KontrolniVypis.resetvypisu();
				}

			
			});
		}
		
	}
	
	public Predek[] klikNaBod(Point e){
		Predek[] pole = new Predek[0]; 
		for(int i = 0; i < body.length; i++){
			if(body[i].klikNaBod(e)){
				pole = polePredekPlus(pole);
				pole[pole.length -1] = body[i];
			}
		}
		return pole;
	}
	public _2Dsouradnice klikNaMrizovyBod(Point e){
		for(int radek = 0; radek < mrizoveBody.pocetRad; radek++){
			if(Math.abs(mrizoveBody.body[radek][0].y -e.getY()) <=  mrizoveBody.body[radek][0].polomer2){
				for(int sloupec = 0; sloupec < mrizoveBody.pocetSloupcu; sloupec++){
					if(mrizoveBody.body[radek][sloupec].klikNaBod(e)){
						return new _2Dsouradnice(mrizoveBody.body[radek][sloupec].x, mrizoveBody.body[radek][sloupec].y);
					}
				}
			}
			if(mrizoveBody.body[radek][0].y > e.getY() +mrizoveBody.body[radek][0].polomer2 + 1)
				return new _2Dsouradnice(-1, -1);
		}
		return new _2Dsouradnice(-1, -1);
	}
	
	
	public void mouseClicked(MouseEvent e) {
		
		if((e.getModifiers() & e.BUTTON1_MASK) != 0){
		
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[1]) == 0){			
			
			Predek[] bodd;
			bodd = klikNaPrimku(e.getPoint());
			_2Dsouradnice mrizBod;
			
			if(mrizoveBody.viditelnost)
			mrizBod = klikNaMrizovyBod(e.getPoint());
			else
				mrizBod = new _2Dsouradnice(-1, -1);
			
			if(mrizBod.x != -1){
			poleBoduPlus();
			body[body.length - 1] = new Bod(mrizBod, VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " +(body.length - 1))); 
			}
			else
			if(bodd.length == 0){
				poleBoduPlus();
				body[body.length - 1] = new Bod(new _2Dsouradnice(e.getPoint().x, e.getPoint().y), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " +(body.length - 1))); 
			}
			else				
				if(bodd.length == 1){					 
					poleBoduPlus();
					body[body.length - 1] = new Bod(getSouradniceBodu(bodd[0], e.getPoint()), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (body.length - 1)));
				}
			else{				
				kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 0);
				kteryKomponent.dialog.setVisible(true);
			}					
			
			zmena.Prekresli();
		}
		else
			if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[2]) == 0){
				Predek[] bodd; 
				
				if(pocetVolaniUsecky != 0){
					bodd = klikNaBod(e.getPoint());
					if(bodd.length == 1){
						if(!(point.x == ((Bod) bodd[0]).x && point.y == ((Bod) bodd[0]).y)){
						poleUsecekPlus();
						usecka[usecka.length - 1] = new Usecka(new _2Dsouradnice(((Bod) bodd[0]).x,((Bod)bodd[0]).y), point, VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (usecka.length - 1)));
						pocetVolaniUsecky = 0;
						}
						
					}
					if(bodd.length > 1){
						kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 2);
						kteryKomponent.dialog.setVisible(true);	
					}
					
					zmena.Prekresli();
					
				
				
				}
				else{					
					bodd = klikNaBod(e.getPoint());
					if(bodd.length == 1){
						pocetVolaniUsecky++;
						point = new _2Dsouradnice(((Bod) bodd[0]).x,((Bod) bodd[0]).y );
					}
					else{
						if(bodd.length > 1){							
							kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 1);
							kteryKomponent.dialog.setVisible(true);							
						}
					
					}
				}
			}
		else 
			if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[3]) == 0){
				Predek[] bodd;
				if(pocetVolaniUsecky != 0){
					bodd = klikNaBod(e.getPoint());
					if(bodd.length == 1){
						if(!(point.x == ((Bod) bodd[0]).x && point.y == ((Bod) bodd[0]).y)){
						polePrimekPlus();
						primka[primka.length - 1] = new Primka(new _2Dsouradnice(((Bod) bodd[0]).x,((Bod)bodd[0]).y), point,Iridium_Geometry.platno.getSize(), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (primka.length - 1)));
						pocetVolaniUsecky = 0;
						}
					}
					if(bodd.length > 1){
						kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 3);
						kteryKomponent.dialog.setVisible(true);	
					}
					
					zmena.Prekresli();
					
				}
				else{
					bodd = klikNaBod(e.getPoint());
					if(bodd.length == 1){
						pocetVolaniUsecky++;
						point = new _2Dsouradnice(((Bod) bodd[0]).x,((Bod) bodd[0]).y );
					}
					else{
						if(bodd.length > 1){							
							kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 1);
							kteryKomponent.dialog.setVisible(true);							
						}
					
					}
				
			}
		}
		else
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[4]) == 0){
			Predek[] bodd;
			if(pocetVolaniUsecky != 0){
				bodd = klikNaBod(e.getPoint());
				if(bodd.length == 1){
					if(!(point.x == ((Bod) bodd[0]).x && point.y == ((Bod) bodd[0]).y)){
					polePoloprimekPlus();
					poloprimka[poloprimka.length - 1] = new Poloprimka(point,new _2Dsouradnice(((Bod) bodd[0]).x,((Bod)bodd[0]).y),Iridium_Geometry.platno.getSize(), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (poloprimka.length - 1)));
					pocetVolaniUsecky = 0;
					}
				}
				if(bodd.length > 1){
					kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 4);
					kteryKomponent.dialog.setVisible(true);	
				}				
				zmena.Prekresli();
				
								
			}
			else{
				bodd = klikNaBod(e.getPoint());
				if(bodd.length == 1){
					pocetVolaniUsecky++;
					point = new _2Dsouradnice(((Bod) bodd[0]).x,((Bod) bodd[0]).y );
				}
				else{
					if(bodd.length > 1){							
						kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 1);
						kteryKomponent.dialog.setVisible(true);							
					}				
				}			
			}
		}
		else 
			if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[6]) == 0){
				Predek[] bodd;
				if(pocetVolaniUsecky != 0){
					bodd = klikNaPrimku(e.getPoint());
					if(bodd.length == 1){
						NVektor nVektor = new NVektor(bodd[0]);
						pocetVolaniUsecky = 0;
						poleKolmicePlus();
						kolmice[kolmice.length - 1] = new Kolmice(point, nVektor.getA(), nVektor.getB(), Iridium_Geometry.GetPlatnoSize(), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (kolmice.length - 1)));
						zmena.Prekresli();
					}
					if(bodd.length > 1){
						kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 6);
						kteryKomponent.dialog.setVisible(true);	
						
					}
				
				}
				else{
				
					bodd = klikNaBod(e.getPoint());
					if(bodd.length == 1){
						pocetVolaniUsecky++;
						point = new _2Dsouradnice(((Bod) bodd[0]).x,((Bod) bodd[0]).y );
					}
					else{
						if(bodd.length > 1){							
							kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 1);
							kteryKomponent.dialog.setVisible(true);							
						}				
					}
					
				}
			}
			else 
				if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[5]) == 0){
					Predek[] bodd;
					if(pocetVolaniUsecky != 0){
						bodd = klikNaPrimku(e.getPoint());
						if(bodd.length == 1){
							NVektor nVektor = new NVektor(bodd[0]);
							pocetVolaniUsecky = 0;
							poleRovnobezkaPlus();
							rovnobezka[rovnobezka.length - 1] = new Rovnobezka(point, nVektor.getA(), nVektor.getB(), Iridium_Geometry.GetPlatnoSize(), VyberModu.vyberModu.getSelectedCheckbox().getLabel().concat(" " + (rovnobezka.length - 1)));
							zmena.Prekresli();
						}
						if(bodd.length > 1){
							kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 5);
							kteryKomponent.dialog.setVisible(true);	
							
						}
						
					}
					else{
						bodd = klikNaBod(e.getPoint());
						if(bodd.length == 1){
							pocetVolaniUsecky++;
							point = new _2Dsouradnice(((Bod) bodd[0]).x,((Bod) bodd[0]).y );
						}
						else{
							if(bodd.length > 1){							
								kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 1);
								kteryKomponent.dialog.setVisible(true);							
							}				
						}
						
					}					
				}
		else
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[7]) == 0){
			Predek []bodd = klikNaPrimku(e.getPoint());
			Predek []pomocny;
			int pocet = bodd.length;
			
			for(int i = 0; i < bodd.length; i++){
				if (bodd[i].name.substring(0,bodd[i].name.indexOf(" ")).compareTo(VyberModu.nazvyTlacitek[4]) != 0){
					bodd[i] = null;
					 pocet--;
				}
			}
			pomocny = new Predek[pocet];
			for(int i = 0, k = 0; i < bodd.length; i++){
				if(bodd[i] != null){
					pomocny[k] = bodd[i];
					k++;
				}
			}
			bodd = pomocny;
			
			if(bodd.length == 1){			
			ZadejVzdalenost zadejVzdalenost = new ZadejVzdalenost(e.getLocationOnScreen(), bodd[0]);
			zadejVzdalenost.dialog.setVisible(true);
			}
			if(bodd.length > 1){
				kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 7);
				kteryKomponent.dialog.setVisible(true);	
				
			}
			
		}
		if(VyberModu.vyberModu.getSelectedCheckbox().getLabel().compareTo(VyberModu.nazvyTlacitek[8]) == 0){
			Predek[] bodd;
			if(pocetVolaniUsecky != 0){
			bodd = klikNaPrimku(e.getPoint());
			if(bodd.length == 1){
				prusecik = new Prusecik(predek, bodd[0], e.getLocationOnScreen());
				if(prusecik.dialog != null)
					prusecik.dialog.setVisible(true);
				
				
			}
			else{
				kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 9);
				kteryKomponent.dialog.setVisible(true);	
			}
			
			}
			else{
				bodd = klikNaPrimku(e.getPoint());
				if(bodd.length == 1){
					pocetVolaniUsecky++;;
					predek =  bodd[0];
				}
				if(bodd.length > 1){
					kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 8);
					kteryKomponent.dialog.setVisible(true);	
				}
				
				
			}
		}
		
		if(pocetVolaniUsecky == 0)
		KontrolniVypis.resetvypisu();
		else
			KontrolniVypis.nastavVypis();
	}
	else
			
		if((e.getModifiers() & e.BUTTON3_MASK) != 0){
			Predek[] bodd, boddd, pomocny;
			
			pomocny = klikNaBod(e.getPoint());
			boddd =  klikNaPrimku(e.getPoint());
			bodd = new Predek[pomocny.length + boddd.length];
			
			for(int i = 0; i < pomocny.length; i++){
				bodd[i] = pomocny[i];
			}
			for(int i = 0; i < boddd.length; i++){
				bodd[i+ pomocny.length] = boddd[i];
			}
			
			if(bodd.length == 1){
				popupMenu = new PopupMenu(bodd[0], e.getPoint(),e.getLocationOnScreen());
				popupMenu.window.setVisible(true);
			}
			else 
				if(bodd.length > 1){
					kteryKomponent = new KteryKomponent(bodd, e.getLocationOnScreen(), e.getPoint(), 10);
					kteryKomponent.dialog.setVisible(true);	
			}
		}
			
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
