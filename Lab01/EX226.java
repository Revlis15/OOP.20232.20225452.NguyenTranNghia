import java.util.*;

public class EX226 {

    public static void FirstDegreeEquation1() {
        double A1, B1, result;
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        A1 = sr.nextDouble();
        System.out.println("Enter the second number: ");
        B1 = sr.nextDouble();
        if (A1 == 0) {
            if (B1 == 0) {
                System.out.println("The equation has infinite solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            result = -B1 / A1;
            System.out.println("The equation has one solution: " + String.format("%.2f", result));
        }
        sr.close();
    }    

    public static void FirstDegreeEquation2(){
        double A1, B1, C1, A2, B2, C2;
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        A1 = sr.nextDouble();
        System.out.println("Enter the second number: ");
        B1 = sr.nextDouble();
        System.out.println("Enter the third number: ");
        C1 = sr.nextDouble();
        System.out.println("Enter the fourth number: ");
        A2 = sr.nextDouble();
        System.out.println("Enter the fifth number: ");
        B2 = sr.nextDouble();
        System.out.println("Enter the sixth number: ");
        C2 = sr.nextDouble();
        double D, Dx, Dy;
        D = A1*B2 - B1*A2;
        Dx = C1*B2 - B1*C2;
        Dy = A1*C2 - C1*A2;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                System.out.println("The equation has infinite solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            double x, y;
            x = Dx/D;
            y = Dy/D;
            System.out.println("The equation has one solution: " + "x = " + String.format("%.2f",x) + " y = " + String.format("%.2f",y));
        }
        sr.close();
    }

    public static void SecondDegreeEquation() {
        double A1, B1, C1, result;
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        A1 = sr.nextDouble();
        System.out.println("Enter the second number: ");
        B1 = sr.nextDouble();
        System.out.println("Enter the third number: ");
        C1 = sr.nextDouble();
        double delta;
        delta = B1*B1 - 4*A1*C1;

        if (A1 == 0){
            result = -C1/B1;
            System.out.println("The equation has one solution:" + String.format("%.2f", result));
        }
        else if (delta < 0) {
            System.out.println("The equation has no solution");
        }
        else if (delta == 0) {
            result = -B1/(2*A1);
            System.out.println("The equation has one solution: " + String.format("%.2f",result));
        }
        else {
            double x1, x2;
            x1 = (-B1 + Math.sqrt(delta))/(2*A1);
            x2 = (-B1 - Math.sqrt(delta))/(2*A1);
            System.out.println("The equation has two solution: " + "x1 = " + String.format("%.2f",x1) + " x2 = " + String.format("%.2f",x2));
        }
        sr.close();
    }

    public static void main(String[] args) {
        int deg, var;
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter the degree of the equation: ");
        deg = sr.nextInt();
        System.out.println("Enter the number of variable: ");
        var = sr.nextInt();
        if (deg == 1 && var == 1) {
            FirstDegreeEquation1();
        }
        else if (deg == 1 && var == 2) {
            FirstDegreeEquation2();
        }
        else if (deg == 2 && var == 1) {
            SecondDegreeEquation();
        }
        else {
            System.out.println("This program only support equation with degree 1 or 2 and number of varible is 1 or 2");
        }
        sr.close();
    }
}