import java.util.Arrays;
import java.util.Random;

/**
 * Created by abbyr on 05/12/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Searching
{

   public static<T extends Comparable<T>> boolean inArray(T[] arr, T entry){
      for (T element : arr) {
         if (element.compareTo(entry) > 0) return false; // Terminate early
         if (element.equals(entry)) return true;
      }
      return false;
   }

   public static <T extends Comparable<T>> boolean inArray_r(T[] arr, int first, int last, T entry){
      if (first > last) return false;
      if (arr[first].compareTo(entry) > 0) return false; // Terminate early
      if (arr[first].equals(entry)) return true;
      return inArray_r(arr, first + 1, last, entry);
   }

   public static <T extends Comparable<T>> boolean binarySearch(T[] anArray, int first, int last, T searchValue){
      int mid = (first + last) / 2;

      if(first > last) return false;
      else if(anArray[mid].equals(searchValue)) return true;
      else if(searchValue.compareTo(anArray[mid]) > 0)
         return binarySearch(anArray, first, mid - 1, searchValue);
      else return binarySearch(anArray, mid + 1, last, searchValue);

   }

   public static Integer[] getRandomAscendingArray(int size, int limit){
      Random random = new Random();
      Integer[] arr= new Integer[size];

      for(int i = 0; i<size; i++){
         arr[i] = random.nextInt(limit) + 1;
      }
      Arrays.sort(arr);
      return arr;
   }
   public static int[] randomArray(int n, int range){
      Random rand = new Random();
      int[] arr = new int[n];
      for(int i = 0; i<n; i++){
         arr[i] = rand.nextInt(range) + 1;
      }
      return arr;
   }

   public static void main(String[] args){
      Random random = new Random();




      int[] arraySizes = {10, 100, 1000, 5000, 10000, 15000, 20000};



      for (int arraySize : arraySizes)
      {
         long iterativeTime = 0;
         long recursiveTimeSeq = 0;
         long recursiveTimeBin = 0;
         int range = arraySize * 10;

         Integer[] arr = getRandomAscendingArray(arraySize, range);
         int[] searchValues = randomArray(arraySize, range);


         for (int searchValue : searchValues)
         {

            long startTime = System.nanoTime();
            inArray(arr, range);
            long endTime = System.nanoTime();
            iterativeTime += (endTime - startTime);

            // Measure recursive selection sort time
            startTime = System.nanoTime();
            inArray_r(arr, 0, arr.length - 1, searchValue);
            endTime = System.nanoTime();
            recursiveTimeSeq += (endTime - startTime);

            startTime = System.nanoTime();
            binarySearch(arr, 0, arr.length - 1, searchValue);
            endTime = System.nanoTime();
            recursiveTimeBin += (endTime - startTime);
         }
         System.out.println("Array size: " + arraySize + ", Value range 1-" + range);
         System.out.println("---------------------------------------------");
         System.out.println("Iterative Sequential: " + iterativeTime);
         System.out.println("Recursive Sequential: " + recursiveTimeSeq);
         System.out.println("Recursive Binary: " + recursiveTimeBin);
         System.out.println();

      }

//      Random random = new Random();
//
//      for(int i = 0; i < 10; i++){
//         Integer[] arr = getRandomAscendingArray(100, 1000);
//         int searchValue = random.nextInt(1000);
//         System.out.println("Array: " + Arrays.toString(arr));
//         System.out.println("Looking for " + searchValue + "... ");
//         System.out.println(binarySearch(arr, 0, arr.length - 1, searchValue));
//         System.out.println();
//      }



//      Integer[] integerArray = {1, 3, 5, 7, 9};
//      String[] stringArray = {"one", "three", "five", "seven", "nine"};
//      AListChain myListInteger = new AListChain();
//      AListChain myListString = new AListChain();
//
//
//
//      System.out.println("5 in integerArray is " + inArray(integerArray, 5));
//      System.out.println("6 in integerArray is " + inArray(integerArray, 6));
//      System.out.println("9 in integerArray is " + inArray(integerArray, 9));
//      System.out.println();
//
//      System.out.println("five in integerArray is " + inArray(stringArray, "five"));
//      System.out.println("six in integerArray is " + inArray(stringArray, "six"));
//      System.out.println("nine in integerArray is " + inArray(stringArray, "nine"));
//      System.out.println();
//
//      System.out.println("5 in_r integerArray is " + inArray_r(integerArray, 0, integerArray.length - 1, 5 ));
//      System.out.println("6 in_r integerArray is " + inArray_r(integerArray, 0, integerArray.length - 1, 6 ));
//      System.out.println("9 in_r integerArray is " + inArray_r(integerArray, 0, integerArray.length - 1, 9 ));
//      System.out.println();
//
//      System.out.println("five in_r integerArray is " + inArray_r(stringArray, 0, stringArray.length-1, "five"));
//      System.out.println("six in_r integerArray is " + inArray_r(stringArray, 0, stringArray.length-1, "six"));
//      System.out.println("nine in_r integerArray is " + inArray_r(stringArray, 0, stringArray.length-1, "nine"));
//      System.out.println();
//
//      myListInteger.add(1);
//      myListInteger.add(3);
//      myListInteger.add(5);
//      myListInteger.add(7);
//      myListInteger.add(9);
//
//      System.out.println("5 in myListInteger is " + myListInteger.contains_r( 5));
//      System.out.println("6 in myListInteger is " + myListInteger.contains_r( 6));
//      System.out.println("9 in myListInteger is " + myListInteger.contains_r( 9));
//      System.out.println();
//
//      myListString.add("one");
//      myListString.add("three");
//      myListString.add("five");
//      myListString.add("seven");
//      myListString.add("nine");
//
//      System.out.println("5 in myListString is " + myListString.contains_r( "five"));
//      System.out.println("6 in myListString is " + myListString.contains_r( "six"));
//      System.out.println("9 in myListString is " + myListString.contains_r( "nine"));
//      System.out.println();

   }
}//class
