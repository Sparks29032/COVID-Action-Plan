package Diagnosis;

import java.io.*;
import java.util.*;

public class PerCalc {
    double[] smolPer = new double[30];
    double[] medPer = new double[30];
    double[] oldPer = new double[30];

    public void calcPer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("symptoms.in"));
        StringTokenizer st;

        String temp;

        for (int i = 0; i < 30; i++) {
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            while(!temp.contains("0")&&!temp.contains("1")&&!temp.contains("2")&&!temp.contains("3")&&
                    !temp.contains("4")&&!temp.contains("5")&&!temp.contains("6")&&!temp.contains("7")&&
                    !temp.contains("8")&&!temp.contains("9")) {
                temp = st.nextToken();
            }

            st.nextToken();

            temp = st.nextToken();
            smolPer[i] = Double.parseDouble(temp.substring(temp.indexOf('/') + 1)) / 47;

            st.nextToken();

            temp = st.nextToken();
            medPer[i] = Double.parseDouble(temp.substring(temp.indexOf('/') + 1)) / 60;

            st.nextToken();

            temp = st.nextToken();
            oldPer[i] = Double.parseDouble(temp.substring(temp.indexOf('/') + 1)) / 73;
        }
    }
}
