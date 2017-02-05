import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        k=k%n;
        int[] newArr=new int[n];
        int counter=0;
        for (int i=k;counter<n;i=plusOne(i,n),counter++) {
            newArr[counter]=a[i];
        }

        for(int i=0;i<n;i++)
            System.out.print(newArr[i]+" ");
        System.out.println();
    }

    public static int plusOne(int i,int length){
        i=i+1;
        if(i==length)
            i=0;
        return i;
    }
}
