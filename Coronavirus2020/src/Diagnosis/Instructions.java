package Diagnosis;

import java.util.*;
import java.awt.event.*;
import java.io.IOException;

public class Instructions implements KeyListener{
	Scanner reader = new Scanner(System.in);
	boolean cont;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Instructions in = new Instructions();
		in.giveInstructions();
		DataCrunch dc = new DataCrunch();
		int max = dc.getPeak();
		FindLevel fl = new FindLevel();
		fl.giveLevel(max);
	}
	
	public void giveInstructions() throws InterruptedException {
		System.out.println("Get your peak flow meter ready.\nPress enter to continue...");
		reader.nextLine();
		System.out.println("Blow when you see go.");
		Thread.sleep(1000);
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		Thread.sleep(1000);
		System.out.println("Go!");
		Thread.sleep(1000);
		System.out.println("Press enter to continue...");
		reader.nextLine();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		cont = true;
		System.out.println("hi");
	}
}