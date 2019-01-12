package Komponenty;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import Konstanty._2Dsouradnice;
import Iridium_Geometry.Iridium_Geometry;

public class OsaX extends Primka{
	public boolean viditelnost = false;
	
	
	public OsaX(){
		
		super(new _2Dsouradnice(0, Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2*3), new _2Dsouradnice(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*3 - 1, Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2*3), new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*3),(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*3)), "osaX");

	}
	}
