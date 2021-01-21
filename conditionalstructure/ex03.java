package conditionalstructure;

import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Insert the first number: ");
            int firstNumber = scanner.nextInt();

            System.out.println("Insert the second number: ");
            int secondNumber = scanner.nextInt();

            if(firstNumber % secondNumber == 0 || secondNumber  % firstNumber == 0){
                System.out.println("Are multiple");
            }else{
                System.out.println("Are not multiple");
            }
        }

        scanner.close();
    }
}
