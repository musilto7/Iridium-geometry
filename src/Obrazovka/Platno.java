package Obrazovka;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.text.StyledEditorKit.BoldAction;

import Komponenty.VsechnyKomponenty;
import Vlastnosti_komponentu.Vlastnosti;


public class Platno extends Canvas implements Observer{
	private Toolkit tol;
	
	public VsechnyKomponenty komponents;
	public Vlastnosti vlastnosti;
	
	
	public Platno(Toolkit t){		
		this.setSize((int)((t.getScreenSize().getWidth())*3), (int)((t.getScreenSize().getHeight()))*3);
		tol = t;
		
		komponents = new VsechnyKomponenty();
		
		this.addMouseListener(komponents);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(((Boolean)arg) == true)
		repaint();
		else
			if(((Boolean)arg) == false)
			repaint(true);
		
	}
	
	public void repaint(){
		boolean prikresli = true;
		paint(this.getGraphics(), prikresli);		
	}
	public void repaint(boolean bol){
		super.repaint();
	}
	
	public void paint(Graphics g, boolean prikresli){
		
		
		if(komponents.mrizoveBody.viditelnost && komponents.mrizoveBody.vykresleno == false){
			komponents.mrizoveBody.vykresli(g);
			komponents.mrizoveBody.vykresleno = true;
		}			
		
		for(int i = 0; i < komponents.body.length; i++){
			if(komponents.body[i].vykresli && komponents.body[i].vykresleno == false || VsechnyKomponenty.ZobrazSkryteKomponenty){
			komponents.body[i].vykresli(g);
			komponents.body[i].vykresleno = true;
			}			
		}
		for(int i = 0; i < komponents.usecka.length; i++){
			if(komponents.usecka[i].vykresli && komponents.usecka[i].vykresleno == false|| VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.usecka[i].vykresli(g);
				komponents.usecka[i].vykresleno = true;
			}
			
		}
		for(int i = 0; i < komponents.primka.length; i++){
			if(komponents.primka[i].vykresli && komponents.primka[i].vykresleno == false|| VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.primka[i].vykresli(g);
				komponents.primka[i].vykresleno = true;
			}				
		}
		for(int i = 0; i < komponents.poloprimka.length; i++){
			if(komponents.poloprimka[i].vykresli && komponents.poloprimka[i].vykresleno == false|| VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.poloprimka[i].vykresli(g);
				komponents.poloprimka[i].vykresleno = true;
			}					
		}
		for(int i = 0; i < komponents.kolmice.length; i++){
			if(komponents.kolmice[i].vykresli && komponents.kolmice[i].vykresleno == false|| VsechnyKomponenty.ZobrazSkryteKomponenty){
			komponents.kolmice[i].vykresli(g);
			komponents.kolmice[i].vykresleno = true;
			}
		}
		for(int i = 0; i < komponents.rovnobezka.length; i++){
			if(komponents.rovnobezka[i].vykresli && komponents.rovnobezka[i].vykresleno == false|| VsechnyKomponenty.ZobrazSkryteKomponenty){
			komponents.rovnobezka[i].vykresli(g);
			komponents.rovnobezka[i].vykresleno = true;
			}
		}
		if(komponents.osaX.viditelnost && komponents.osaX.vykresleno == false){			
			komponents.osaX.vykresli(g, true);
			komponents.osaX.vykresleno = true;
		}		
		if(komponents.osaY.viditelnost && komponents.osaY.vykresleno == false){			
			komponents.osaY.vykresli(g, true);
			komponents.osaY.vykresleno = true;
		}	
		                       
	}
	
public void paint(Graphics g){		
		
		if(komponents.mrizoveBody.viditelnost){
			komponents.mrizoveBody.vykresli(g);
			komponents.mrizoveBody.vykresleno = true;
		}
		else			
			komponents.mrizoveBody.vykresleno = false;
		
		for(int i = 0; i < komponents.body.length; i++){
			if(komponents.body[i].vykresli || VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.body[i].vykresli(g);
				komponents.body[i].vykresleno = true;
			}
			else
				komponents.body[i].vykresleno = false;
		}
		for(int i = 0; i < komponents.usecka.length; i++){
			if(komponents.usecka[i].vykresli || VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.usecka[i].vykresli(g);
				komponents.usecka[i].vykresleno = true;
			}
			else
				komponents.usecka[i].vykresleno = false;
		}
		for(int i = 0; i < komponents.primka.length; i++){
			if(komponents.primka[i].vykresli || VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.primka[i].vykresli(g);
				komponents.primka[i].vykresleno = true;
			}
			else
				komponents.primka[i].vykresleno = false;
		}
		for(int i = 0; i < komponents.poloprimka.length; i++){
			if(komponents.poloprimka[i].vykresli || VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.poloprimka[i].vykresli(g);
				komponents.poloprimka[i].vykresleno = true;
			}
			else
				komponents.poloprimka[i].vykresleno = false;
		}
		for(int i = 0; i < komponents.kolmice.length; i++){
			if(komponents.kolmice[i].vykresli || VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.kolmice[i].vykresli(g);
				komponents.kolmice[i].vykresleno = true;
			}
			else
				komponents.kolmice[i].vykresleno = false;
		}
		for(int i = 0; i < komponents.rovnobezka.length; i++){
			if(komponents.rovnobezka[i].vykresli || VsechnyKomponenty.ZobrazSkryteKomponenty){
				komponents.rovnobezka[i].vykresli(g);
				komponents.rovnobezka[i].vykresleno = true;
			}
			else
				komponents.rovnobezka[i].vykresleno = false;
		}
		if(komponents.osaX.viditelnost){			
			komponents.osaX.vykresli(g, true);
			komponents.osaX.vykresleno = true;
		}
		else		
			komponents.osaX.vykresleno = false;
		
		if(komponents.osaY.viditelnost){			
			komponents.osaY.vykresli(g, true);
			komponents.osaY.vykresleno = true;
		}
		else		
			komponents.osaY.vykresleno = false;		
		                       
	}
	
	

}
