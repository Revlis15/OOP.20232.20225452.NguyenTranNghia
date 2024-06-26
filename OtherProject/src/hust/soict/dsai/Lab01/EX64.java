package hust.soict.dsai.Lab01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EX64 {
    public static void main(String[] args) {

        List<List<String>> months = new ArrayList<>();
        months.add(Arrays.asList("January", "Jan.","Jan", "1"));
        months.add(Arrays.asList("February", "Feb.","Feb", "2"));
        months.add(Arrays.asList("March", "Mar.","Mar", "3"));
        months.add(Arrays.asList("April", "Apr.","Apr", "4"));
        months.add(Arrays.asList("May","May.", "5"));
        months.add(Arrays.asList("June", "Jun.","Jun", "6"));
        months.add(Arrays.asList("July", "Jul.","Jul", "7"));
        months.add(Arrays.asList("August", "Aug.","Aug", "8"));
        months.add(Arrays.asList("September", "Sep.","Sep", "9"));
        months.add(Arrays.asList("October", "Oct.","Oct", "10"));
        months.add(Arrays.asList("November", "Nov.","Nov", "11"));
        months.add(Arrays.asList("December", "Dec.","Dec", "12"));


        Scanner scn = new Scanner(System.in);
        System.out.print("Enter month: ");
        String input = scn.nextLine();
        int month = -1;
        
        while (true) {
            for (int i = 0; i < months.size(); i++) {
                if (months.get(i).contains(input)) {
                    month = Integer.parseInt(months.get(i).get((months.get(i).size() - 1)));
                    break;
                }
            }
            if (month != -1) {
                break;
            } else {
                System.out.print("Invalid month. Please enter again: ");
                input = scn.nextLine();
            }
        }

        System.out.print("Enter year: ");
        String inp = scn.nextLine();
        int year = -1;

        while (true) {
            if (!inp.matches("\\d+")) {
                System.out.print("Invalid year. Please enter again: ");
                inp = scn.nextLine();
            }
            else {
                year = Integer.parseInt(inp);
                break;
            }
        }

        int days = -1; 
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }
        System.out.println("Number of days in month " + month + " is " + days);
        scn.close();
    }  
}
