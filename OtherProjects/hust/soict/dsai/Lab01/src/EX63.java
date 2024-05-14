package soict.dsai.Lab01.src;

import java.util.Scanner;

public class EX63 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter the height of the star: ");
        int height = sr.nextInt();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sr.close();
    }
}
