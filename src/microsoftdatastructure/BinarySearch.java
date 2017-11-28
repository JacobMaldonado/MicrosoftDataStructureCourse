/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsoftdatastructure;

/**
 *
 * @author jacob
 */
import java.util.Random;
public class BinarySearch {
 
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        int array[] = new int[10];
        
        for(int i = 0; i<10;i++)
            array[i] = r.nextInt(20);
        
        binarySearch(10,array,0,9);
        
    }
    
    public static boolean binarySearch(int v, int[] lst, int low, int high) {
    if (low > high) {
        System.out.println("not found");
        return false;
    }
    
    int middle = (low+high)/2;
    
    if (v == lst[middle]) {
        System.out.println("found! It is at " + middle);
        return true;
    }
    else if (v > lst[middle]) {
        return binarySearch(v, lst, middle+1, high);
    }
    else {
        return binarySearch(v, lst, low, middle-1);
    }
}
}
