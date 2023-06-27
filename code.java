import java.util.*;

public class ArrayCombination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the elements of the array (separated by spaces): ");
        String inputStr = scanner.nextLine();
        String[] inputArr = inputStr.split(" ");
        int[] input = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            input[i] = Integer.parseInt(inputArr[i]);
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        List<int[]> firstCombination = findCombination(input, target);
        System.out.println("First Combination For \"" + target + "\" :");
        for (int[] pair : firstCombination) {
            System.out.println(Arrays.toString(pair));
        }

        int[] mergedArray = mergeArray(input);
        System.out.println("Merge Into a Single Array: " + Arrays.toString(mergedArray));

        int doubleTarget = target * 2;
        List<int[]> secondCombination = findCombination(mergedArray, doubleTarget);
        System.out.println("Second Combination For \"" + doubleTarget + "\" :");
        for (int[] pair : secondCombination) {
            System.out.println(Arrays.toString(pair));
        }

        scanner.close();
    }

    private static List<int[]> findCombination(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int num : input) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                result.add(new int[]{num, complement});
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return result;
    }

    private static int[] mergeArray(int[] input) {
        Arrays.sort(input);
        return input;
    }
}
