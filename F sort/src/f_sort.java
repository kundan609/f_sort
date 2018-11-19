import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class f_sort {
    
    static void sortByFreq(int a[]){
        Map<Integer, Integer> map = new TreeMap<> ();
        
       /* Logic to place the elements to Map */
       for(int i=0; i<a.length; i++){
           if(map.get(a[i]) == null){
               map.put(a[i], 1);
            }
           else{
               int frequency = map.get(a[i]);
               map.put(a[i], frequency+1);
           }
       }
       
       //System.out.println(map);
       
       List list = new LinkedList(map.entrySet());
       
       /* Sort the list elements based on frequency */
       Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
               return ((Comparable) ((Map.Entry) (obj1)).getValue())
                  .compareTo(((Map.Entry) (obj2)).getValue());
            }
       });
       
       int count=0;
       
       /* Place the elements in to the array based on frequency */
       for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            
            for(int i=0; i < val; i++){
                a[count] = key;
                count++;
            }            
       } 
    }
    
    public static void main(String args[]){
        int a[] = {4, 5, 7, 7, 6, 5, 4, 3};
        
        System.out.println("Before Sorting");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
        
        sortByFreq(a);
        
        System.out.println("\nAfter Sorting");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
    }
}