package Diagnosis;

import java.util.*;
import java.io.*;

public class FileRead {
	String[] sym = new String[30];
	double[] age1 = new double[30];
	double[] age2 = new double[30];
	double[] age3 = new double[30];
	
	public FileRead() {
		for (int i = 0; i < 30; i++) {
			sym[i] = "";
		}
	}
	
	
	public void ReadIn() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("symptoms.in"));
		StringTokenizer st;
		String temp = "";
		for (int i = 0; i < 30; i++) {
			st = new StringTokenizer(br.readLine());
			temp = st.nextToken();
			while(!temp.contains("0")&&!temp.contains("1")&&!temp.contains("2")&&!temp.contains("3")&&
					!temp.contains("4")&&!temp.contains("5")&&!temp.contains("6")&&!temp.contains("7")&&
					!temp.contains("8")&&!temp.contains("9")) {
				sym[i] += temp + " ";
				temp = st.nextToken();
			}
			
			st.nextToken();
			st.nextToken();
			
			temp = st.nextToken();
			temp = temp.substring(1, temp.length() - 1);
			age1[i] = Double.parseDouble(temp);
			
			st.nextToken();
			
			temp = st.nextToken();
			temp = temp.substring(1, temp.length() - 1);
			age2[i] = Double.parseDouble(temp);
			
			st.nextToken();
			
			temp = st.nextToken();
			temp = temp.substring(1, temp.length() - 1);
			age3[i] = Double.parseDouble(temp);
		}
	} 
}
