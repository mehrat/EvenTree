package com.tanmay.solution;

/**
 * Created by tmehra on 12/12/15.
 */
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    static int count=0;

    public static void main(String[] args) {
     /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int[] vertex = new int[m];
        int[] edge = new int[m];
        for(int i =0; i<m; i++ ){
            vertex[i] = s.nextInt();
            edge[i] = s.nextInt();
            //s.nextLine();
        }

        int root = edge[0];
        getEdgeCount(root, vertex,edge);

        System.out.println(count);
    }

    private static void getEdgeCount(int root, int[] vertex, int[] edge) {
        for(int i=0; i< vertex.length; i++){
            int a = vertex[i];
            if(Arrays.stream(edge).anyMatch(s -> s==a)){
                getCutNode(i, vertex,edge);
            }
        }
    }

    private static void getCutNode(int index, int[] vertex, int[] edge) {

        if(getAllChildren(index,vertex,edge) %2 !=0){
            count++;
        }

    }

    private static int getAllChildren(int index, int[] vertex, int[] edge) {
        int c=0;
        Queue q = new ArrayDeque<>();
        q.add(vertex[index]);
        while(!q.isEmpty()){
            int a = (int) q.poll();
            for(int i=0;i<edge.length;i++){

                if(a==edge[i]){
                    q.add(vertex[i]);
                    c++;
                }
            }


        }
        return c;
    }

}
