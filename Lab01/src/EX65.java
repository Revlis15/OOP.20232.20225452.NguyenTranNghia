import java.util.*;

public class EX65 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        System.out.print("Enter the elements (integer) of the array separated by spaces: ");
        String[] str = scn.nextLine().split(" ");
        boolean valid = true;

        while (true) {
            
            if (str.length == 0) {
                System.out.println("Invalid input. Please enter integers separated by spaces.");
                str = scn.nextLine().split(" ");
                valid = false;
            } else {
                for (String s : str) {
                    try {
                        arr.add(Integer.parseInt(s));
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter integers separated by spaces.");
                        str = scn.nextLine().split(" ");
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                break;
            }
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        int average = (int) sum / arr.size();

        System.out.println("Sorted array: " + arr.toString());
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
        scn.close();
    }
}
