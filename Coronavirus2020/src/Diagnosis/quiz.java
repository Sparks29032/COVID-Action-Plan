package Diagnosis;
import java.io.IOException;
import java.util.Scanner;

public class quiz {
	
	Scanner reader = new Scanner(System.in);
	private double riskvalue = 0;
	private int agecat = 0;
	
	public void FindAgeCat(DataCrunch dc) {
		if (dc.entAge<=49)
			agecat = 1;
		else if(dc.entAge<=64)
			agecat = 2;
		else
			agecat = 3;
	}
	
	public void getRisk(int max) {
		System.out.println("What value did you read on your peak flow meter?");
		double read = reader.nextDouble();
		double percent=read / max*100;
		riskvalue+=100-percent;
		System.out.println("Your risk index was calculated to be "+riskvalue);
		if (riskvalue>=100)
			System.out.println("You may want to look into hospitalization based on the severity of your situation.");
		else
			System.out.println("Your condition does not seeem to be severe enough to recommend hospitalization right now, but be sure to stay wary.");
	}
	
	
	public void interrogate(FileRead fr, PerCalc pc) {
		
		String x="";
		
		//life-threatening symptoms
		System.out.println("How many (if any) of the following life-threatening symptoms have you experienced?");
		System.out.println("Blue colored lips or face; severe and constant pain or pressure in the chest;\n"
		+ "Severe and constant dizziness or lightheadedness; acting confused;\n"
		+ "Unconscious or very difficult to wake up; slurred speech;\n"
		+ "New seizures or seizures that won't stop" + 
		"");
		int y = reader.nextInt();
		riskvalue+=y*100;
		
		//serious symptoms
		System.out.println("Are you experiencing moderate to severe difficulty breathing (unable to speak full sentences)?");
		x=reader.nextLine(); 
		x=reader.nextLine();
		if (x.equals("yes")) 
			riskvalue+=30;

		System.out.println("Are you coughing up blood (more than about 1 teaspoon)?");
		x=reader.nextLine();
	    if (x.equals("yes")) 
	    	riskvalue+=30;

		System.out.println("Do you have signs of low blood pressure (feeling cold, pale, clammy skin, light-headed, too weak to stand)?");
		x=reader.nextLine();
	    if (x.equals("yes")) 
	    	riskvalue+=20;
		
		//risky symptoms
        //trouble breathing
        System.out.println("Are you experiencing trouble breathing?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=20;

        //fever
        System.out.println("Do you have a fever over 100.4 degrees?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=16;

        //cough
        System.out.println("Do you have a dry persistent cough?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=12;
        
        System.out.println("Do you have myalgia (muscle pain/ache), chest pain, or muscle pain?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=10;

        System.out.println("Do you have diarrhea?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=14;
        
        System.out.println("Do you have nausea/vomiting?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=14;
        
        //nursing home
        System.out.println("Do you live in a nursing home or long term care facility?");
        x=reader.nextLine();
        if (x.equals("yes")) 
            riskvalue+=14;
		
		//interrogating about the underlying conditions 
		for (int count=0; count<17; count++) {
			String holder = fr.sym[count].trim();
			System.out.println("Do you have " + holder + "?");
			x=reader.next();
			if (x.equalsIgnoreCase("yes")) {
				switch (agecat) {
				case 1: 
					riskvalue+=fr.age1[count]/pc.smolPer[count]/2;
					break;
				case 2: 
					riskvalue+=fr.age2[count]/pc.medPer[count]/2;
					break;
				case 3:
					riskvalue+=fr.age3[count]/pc.oldPer[count]/2;
					break;
				}
				//end of switch
			}			
		}//end of for loop
	
		
	}
	
	public static void main(String[] args) throws IOException{
		FileRead fr = new FileRead();
		DataCrunch dc = new DataCrunch();
		PerCalc pc = new PerCalc();
		fr.ReadIn();
		int maxflow = dc.getPeak();
		quiz q = new quiz();
		q.FindAgeCat(dc);
		pc.calcPer();
		q.interrogate(fr, pc);
		q.getRisk(maxflow);

	}

}
