package Komponenty;

import java.awt.Dimension;
import java.awt.Point;

import Konstanty._2Dsouradnice;

public class Rovnobezka extends Kolmice{
	
	public Rovnobezka(_2Dsouradnice bod, Double aa, Double bb, Dimension PlatnoSize, String jmeno){
		super(bod, bb, -aa, PlatnoSize, jmeno);
	}

}
