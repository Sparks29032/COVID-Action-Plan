package Diagnosis;

import java.io.*;
import java.util.*;

public class DataCrunch {
	Scanner reader = new Scanner(System.in);
	FindLevel f = new FindLevel();
	BufferedReader br;
	StringTokenizer st;
	int entAge=0;
	
	public int getPeak() throws IOException{
		System.out.println("What is your sex?\n1. Male\n2. Female\n3. Other");
		int sex = reader.nextInt();
		if (sex == 2) {
			br = new BufferedReader(new FileReader("female.in"));
		}
		else {
			br = new BufferedReader(new FileReader("male.in"));
		}
		st = new StringTokenizer(br.readLine());
		double[] hm = new double[5];
		for (int i = 0; i < 5; i++) {
			hm[i] = Double.parseDouble(st.nextToken());
		}
		System.out.println("Please enter your height in meters.");
		double height = reader.nextDouble();
		int hc = 0;
		if (height > hm[4]) {
			hc = 4;
		}
		else {
			for (int i = 0; i < 5; i++) {
				if (height <= hm[i]) {
					hc = i;
					break;
				}
			}
		}
		int[] age = {15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85};
		double[][] vals = new double[15][5];
		for (int i = 0; i < 15; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for (int j = 0; j < 5; j++) {
				vals[i][j] = Double.parseDouble(st.nextToken());
			}
		}
		System.out.println("Please enter your age.");
		entAge = reader.nextInt();
		int ac = 0;
		if (entAge < 40) {
			for (int i = 0; i < 6; i++) {
				if (entAge < age[i]) {
					ac = i;
					break;
				}
			}
		}
		else {
			for (int i = 5; i < 15; i++) {
				if (entAge <= age[i]) {
					ac = i;
					break;
				}
			}
		}
		
		return (int) vals[ac][hc];
	}
}