package Challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Challenge3 {

  /*Caso 3

    Dado una colección de 20 jaulas, cuyos identificadores van del 101 al 120, siendo estos de tipo Integer.
    Es decir tenemos la jaula 101, la jaula 102 y así sucesivamente hasta 120.

    Se solicita: armar 60 grupos, con 4 jaulas por grupo.
    Las condiciones a cumplir, son:
    - Cada jaula debe tener la misma probabilidad de ser elegida para formar parte de un grupo (distribución uniforme)
    - Las 4 jaulas de un grupo deben ser distintas. Ejemplo de grupo [Jaula 105, Jaula 108, Jaula 116, Jaula 120]
    - Mostrar por consola la estructura de grupos formada.

   */

  public static void main(String[] args) {
    //Generate cages with indexes
    List<Integer> cages = buildListOfCages(101, 120);
    int groupsToBuild = 60 ;
    int cagesPerGroup = 4;
    //Generate groups of cages for those indexes
    List<List<Integer>> groups = generateGroups(cages, groupsToBuild, cagesPerGroup);

    //Display the generated groups
    displayGroups(groups);
  }

  /**
   * Builds the cage's collection with the provided indexes
   * @param minIndex the minimum index identifier for the list of cages
   * @param maxIndex the maximum index identifier for the list of cages
   * @return a list of integer representing cages, if we used a map linking the integer with an object we could actually hold something in the cage, like a bird.
   */
  private static List<Integer> buildListOfCages(int minIndex, int maxIndex) {

    List<Integer> cages = new ArrayList<>();
    //Traverse distance between min and max and add items to the list
    for (int i = minIndex; i <= maxIndex; i++) {
      cages.add(i);
    }
    return cages;
  }

  /**
   * Generates random groups of cages.
   *
   * @param cages       The list of available cages.
   * @param numGroups   The total number of groups to generate.
   * @param cagesPerGroup The number of cages per group.
   * @return A list of generated cage groups.
   */
  public static List<List<Integer>> generateGroups(List<Integer> cages, int numGroups, int cagesPerGroup) {
    List<List<Integer>> groups = new ArrayList<>();
    Random rand = new Random();

    // Loop to add groups until all requested groups are added
    for (int i = 0; i < numGroups; i++) {
      List<Integer> group = new ArrayList<>();

      /* While for adding cages to the group till the group is full of cages  */
      while (group.size() < cagesPerGroup) {
        int index = rand.nextInt(cages.size());
        int cage = cages.get(index);

       /* Just add a cage to the group if it doesn't contain said cage */
        if (!group.contains(cage)) {
          group.add(cage);
        }
      }
      groups.add(group);
    }

    return groups;
  }

  /**
   * Displays the structure of the generated cage groups.
   *
   * @param groups The list of generated cage groups.
   */
  public static void displayGroups(List<List<Integer>> groups) {
    //Display Group
    for (int i = 0; i < groups.size(); i++) {
      System.out.print("Group " + (i + 1) + ": ");
      List<Integer> group = groups.get(i);
      //Display Cages
      for (int j = 0; j < group.size(); j++) {
        System.out.print("Cage " + group.get(j));
        if (j < group.size() - 1) {
          System.out.print(", ");
        }
      }
      System.out.println();
    }
  }


}
