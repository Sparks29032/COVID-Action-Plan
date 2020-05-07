package Diagnosis;

import java.util.*;

public class FindLevel {
	Scanner reader = new Scanner(System.in);
	public int giveLevel(int max) {
		System.out.println("Your max peak flow should be " + max + ".");
		System.out.println("What value did you read on your peak flow meter?");
		double read = reader.nextDouble();
		double percent = read / max;
		if (percent >= .80) {
			return 1;
		}
		else if (percent >= .50) {
			return 2;
		}
		else {
			return 3;
		}
	}
}