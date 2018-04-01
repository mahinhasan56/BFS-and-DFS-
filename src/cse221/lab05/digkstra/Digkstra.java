/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse221.lab05.digkstra;

/**
 *
 * @author Mahin
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Digkstra {

    int dist[];
    int[][] arr;
    //int parent [];
    //ArrayList<Integer> arr1 = new ArrayList<Integer> ();
    int[] visited;
    int source;
    int min;
    int nextNode;
    int preD[];

    public Digkstra(int vertex, int[][] a, int source) {

        dist = new int[vertex];
        visited = new int[vertex];
        arr = a;
        //parent=new int[vertex];
        dist[source] = 0;
        visited[source] = 1;
        preD = new int[vertex];
        dist = arr[0];
        mainMethod();
    }

    public void mainMethod() {
        // System.out.println(arr.length);
        for (int counter = 0; counter < arr.length; counter++) {

            min = 999;

            for (int i = 0; i < arr.length; i++) {

                if (min > dist[i] && visited[i] != 1) {

                    min = dist[i];
                    nextNode = i;

                }
                // System.out.println(dist[0]);


                visited[nextNode] = 1;

                for (int c = 0; c < arr.length; c++) {

                    if (visited[c] != 1) {

                        if (min + arr[nextNode][c] < dist[c]) {

                            dist[c] = min + arr[nextNode][c];
                            preD[c] = nextNode;

                        }

                    }
                }
            }
        }

        printMethod(dist);
    }

    public void printMethod(int[] dist) {
        try {

            String number = "";


            File newFile = new File("output.txt");
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);

            dist[0] = 0;
            for (int c = 0; c < arr.length; c++) {

                number = number + dist[c] + ",";
                System.out.print(dist[c] + ",");
            }
            // bw.write(number);
            bw.newLine();

            number = "";
            int j;
            for (int i = 0; i < arr.length; i++) {

                if (i != 0) {

                    System.out.print("Path : " + i);
                    number = "Path = " + i;
                    j = i;
                    do {

                        j = preD[j];
                        System.out.print(" <- " + j);
                        number = number + " <- " + j;
                    } while (j != 0);
                    bw.write(number);
                    bw.newLine();
                    number = "";
                }

                System.out.println();

            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Readfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
