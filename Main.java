/* How do I check my code

A shorter array called testList is created to test if the merge sort works. It will be print when a comparison or change happened to the array.
This allows us to see if the array is sorting as the way it supposed to be.

There are details showed every time the array is being checked/sorted,
including which recursion is the algorithm currently on, pivot, index of the pivot, min and max that represented the range that is being sorted.
If the array is not printed in a particular recursion, it indicates that there are no data being changed in that recursion.
In other words, the range that recursion is checking is already in order, therefore no need to be sort.

*/
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Integer> List = generateArraylist(100);
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(9, 4, 2, 1, 8, 1, 6, 7, 10, 5));
        testList = quickSort(testList, 0, testList.size() - 1);

    }
    // prints the array
    public static void printArray(ArrayList<Integer> list, int pivotValue, int pivotIndex, int min, int max)
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println("(recursion " + count + " / pivot " + pivotValue + " / pivotIndex " + pivotIndex + " / min " + min + " / max " + max + ")");
    }

    // method that will generate a non-sorted array with given size that contains numbers up to 100
    public static ArrayList<Integer> generateArraylist(int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++)
        {
            Random rand = new Random();
            int randnum = rand.nextInt(99) + 1;
            list.add(randnum);
        }
        return list;
    }

    // min is the first index, max is the last index, max or min will be previous pivot after first iteration
    public static int count = 0;
    public static ArrayList<Integer> quickSort(ArrayList<Integer> list, int min, int max)
    {
        // always choose the last data as pivot, move data bigger than pivot behind the pivot
        int index = min;
        int pivotIndex = max;
        int pivotValue = list.get(max);
        int timemoved = 1;
        count ++;

        while (index != pivotIndex)
        {
            if (list.get(index) > pivotValue)
            {
                list.add(pivotIndex + timemoved, list.get(index));
                list.remove(index);
                index --;
                pivotIndex --;
                timemoved ++;
            }
            printArray(list, pivotValue, pivotIndex, min, max);
            index ++;
        }
        System.out.println("=== recursion " + count + " ends ===");
        System.out.println("");

        // recursion
        if (pivotIndex > min) // sort data before the pivot
        {
            quickSort(list, min, pivotIndex - 1);
        }

        if (pivotIndex < max) // sort data after the pivot
        {
            quickSort(list, pivotIndex + 1, max);
        }

        return list;
    }
}

// https://github.com/Lord-Beaverbrook-High-School/cse-3310-mastery-project-1-Ian-H-H