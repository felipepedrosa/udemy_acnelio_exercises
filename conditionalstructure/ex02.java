package conditionalstructure;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Insert a number: ");
            int number = scanner.nextInt();

            if((number % 2) == 0 ){
                System.out.println("Pair");
            }else{
                System.out.println("Odd");
            }
        }

        scanner.close();
    }
}
