package Challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge2 {

  /*Caso 2

  Dado un arreglo de n valores int[primitivo],
  retornar por consola el número menor, cuya ocurrencia en el arreglo sea única.

  Por ejemplo, en el arreglo [1, 23, 5, 80, 2, 53, 8, 75, 23, 75, 80, 23, 2, 1, 8],
  los números 5 y 53 tienen una única ocurrencia,
  pero se debe mostrar el 5 dado que es menor a 53.

   */

  static final int FIRST_ELEMENT = 0 ;
  static final int MAX_APPEARANCES = 1 ;
  static final String NEW_LINE = "\n";
  static Integer[] array = {1, 23, 53, 80, 2, 5, 8, 75, 23, 75, 80, 23, 2, 1, 8};

  /* Used a number generator to generate lists
  https://numbergenerator.org/randomnumberlist-1-1000#!numbers=5000&low=1&high=1000000&unique=true&csv=csv&oddeven=&oddqty=0&sorted=false&addfilters=
  */
  static Integer[] array1 = {67,7,97,95,70,79,30,71,35,1,91,48,88,73,49,40,75,83,5,3};
  static Integer[] array2 = {4,57,96,17,9,24,39,4,29,36,23,78,52,27,19,16,97,92,1,90,9,13,34,25,61,55,30,48,97,95,89,43,6,64,5,28,74,63,32,69,7,70,70,45,89,30,19,99,22,88,49,48,84,48,55,8,25,30,32,7,48,42,9,79,57,29,20,74,94,96,72,58,37,15,9,39,59,6,67,23,3,6,30,48,45,20,4,91,84,40,52,91,24,85,77,34,20,52,76,22,77,100,23,38,77,68,5,61,58,90,33,61,33,31,36,47,39,52,26,34,19,12,29,97,100,68,34,12,83,44,21,65,42,68,62,79,88,19,11,26,35,95,44,88,96,63,15,81,4,4,8,74,38,32,73,42,54,41,98,24,54,19,85,97,91,89,30,72,66,30,85,4,32,85,98,72,6,55,87,7,94,3,100,29,91,85,59,97,75,84,13,20,94,2,24,52,67,20,75,44,96,6,82,81,61,54,59,22,99,73,25,73,13,65,15,43,40,95,49,81,92,27,97,94,68,59,96,25,41,93,52,20,32,36,55,74,18,86,100,67,77,75,75,67,92,40,1,29,78,72,18,26,92,86,82,90,7,8,90,81,68,44,21,39,56,89,41,37,85,44,12,98,43,24,19,61,15,66,24,28,97,29,83,98,38,32,49,24,5,52,99,59,44,2,81,75,21,83,42,81};

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    /* Modify numbers in the array in process different values */
    List<Integer> values = Arrays.asList(array);

    /* Filter values by frequency equal to just one appearance in the array */
    List uniques = values.stream()
        .filter(e-> Collections.frequency(values,e) == MAX_APPEARANCES)
        .distinct()
        .sorted()
        .collect(Collectors.toList());


    System.out.println(NEW_LINE+NEW_LINE);
    System.out.println("Original list of values: " + values +NEW_LINE);
    System.out.println("List of uniques values in the original list: " + uniques +NEW_LINE);
    System.out.println("The minor value from the list of uniques: [" + uniques.get(FIRST_ELEMENT) + "]" +NEW_LINE);

    long endTime = System.nanoTime();
    double durationInMilliseconds = (endTime - startTime)/1000000 ;  //divide by 1000000 to get milliseconds.
    double durationInSeconds = (endTime - startTime)/1000000000;  //divide by 1000000000 to get seconds.
    System.out.println("This process took " + durationInMilliseconds + " milliseconds" + NEW_LINE);
    System.out.println("This process took " + durationInSeconds + " seconds");

  }

}
