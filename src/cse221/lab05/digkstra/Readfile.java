/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse221.lab05.digkstra;

/**
 *
 * @author Mahin
 */
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Readfile {

    public void method() {
        ArrayList<Integer> arr = new ArrayList<>();

        try {

            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            String sArray[] = line.split(" ");
            int z = Integer.parseInt(sArray[0]);
            int arr2[][] = new int[z][z];

            while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                sArray = line.split(" ");
                int a = Integer.parseInt(sArray[0]);
                int b = Integer.parseInt(sArray[1]);
                int c = Integer.parseInt(sArray[2]);
                arr2[a][b] = c;
                arr2[b][a] = c;
                //arr.add(arr2[a][b]);

            }
            for (int c = 0; c < arr2.length; c++) {
                for (int i = 0; i < arr2.length; i++) {
                    if (arr2[c][i] == 0) {
                        arr2[c][i] = 9999;
                    }
                }

            }
//            for(int c=0;c<arr2.length;c++)
//            {
//                for(int i=0;i<arr2.length;i++)
//                {
//                   System.out.print(arr2[c][i]+"  ");
//                }
//                System.out.println();
//            }


            Digkstra ob = new Digkstra(z, arr2, 0);

            br.close();



        } catch (FileNotFoundException ex) {
            Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
