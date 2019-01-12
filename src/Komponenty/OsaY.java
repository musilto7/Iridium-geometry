package Komponenty;

import java.awt.Dimension;
import java.awt.Toolkit;

import Konstanty._2Dsouradnice;

public class OsaY extends Primka{

	
public boolean viditelnost = false;	
	
	public OsaY(){
		
		super(new _2Dsouradnice( Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2*3,0), new _2Dsouradnice(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2*3, Toolkit.getDefaultToolkit().getScreenSize().getHeight()*3 - 1), new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*3),(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*3)), "osaY");

	}
}
