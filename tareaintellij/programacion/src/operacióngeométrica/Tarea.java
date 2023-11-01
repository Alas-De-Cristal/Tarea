package operacióngeométrica;

import java.util.Random;
import java.util.Scanner;

public class Tarea {

    public static void main(String args[]){
        Random rand = new Random();
        Scanner myInput = new Scanner( System.in );
        int max, min, num1,num2,count=0, numberOfQuestions =10;
        int success = 0;
        while (true) {

            System.out.println("1. Level 1");
            System.out.println("2. Level 2");
            System.out.println("3. Level 3");
            System.out.println("4. Level 4");
            System.out.print("Please select the difficulty level::");
            int input_level = myInput.nextInt();
            System.out.println();
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4.Division");
            System.out.println("5. Random operation");
            System.out.print("Please select the Arithmetic Operation:: ");
            int input_operation = myInput.nextInt();
            System.out.println();
            if (input_level == 1) {
                min = 0;
                max = 10;

                while (count < numberOfQuestions) {
                    num1 = rand.nextInt((max - min)) + min;
                    num2 = rand.nextInt((max - min)) + min;
                    success = success + findArithematicOperation(num1, num2, input_operation, success);
                    count++;
                }
            } else if (input_level == 2) {
                min = 10;
                max = 100;

                while (count < numberOfQuestions) {
                    num1 = rand.nextInt((max - min)) + min;
                    num2 = rand.nextInt((max - min)) + min;
                    success = success + findArithematicOperation(num1, num2, input_operation, success);
                    count++;
                }
            } else if (input_level == 3) {
                min = 100;
                max = 1000;

                while (count < numberOfQuestions) {
                    num1 = rand.nextInt((max - min)) + min;
                    num2 = rand.nextInt((max - min)) + min;
                    success = success + findArithematicOperation(num1, num2, input_operation, success);
                    count++;
                }
            } else if (input_level == 4) {
                min = 1000;
                max = 10000;

                while (count < numberOfQuestions) {
                    num1 = rand.nextInt((max - min)) + min;
                    num2 = rand.nextInt((max - min)) + min;
                    success = success + findArithematicOperation(num1, num2, input_operation, success);
                    count++;
                }
            } else {
                System.out.println("Please select a correct choice");
                System.out.println("Next Student please...............");
                continue;
            }
            int percentage = (100 / numberOfQuestions) * success;
            if (percentage >= 75) {
                System.out.println("Congratulations!!!!, you are ready to move to the next level.");
                System.out.println("Next Student please...............");
                System.out.println();
            } else {
                System.out.println("Please ask your instructor for additional help!!!");
                System.out.println("Next Student please...............");
                System.out.println();
            }
            count = 0;
            success = 0;

        }
    }

    private static int findArithematicOperation(int num1, int num2, int input_operation, int success) {
        int num;
        if(input_operation==1){
            num= performAddition(num1, num2, success);
            return num;
        }
        else if(input_operation ==2) {
            num= performSubtraction(num1, num2);
            return num;
        }
        else if(input_operation ==3){
            num = performMultiplication(num1, num2);
            return num;
        }
        else if(input_operation ==4){
            num = performDivision(num1, num2);
            return num;
        } else if (input_operation ==5) {
            Random rand = new Random();
            int num4 = rand.nextInt(4);
            if(num4==0){
                num= performAddition(num1, num2, success);
                return num;
            } else if (num4==1) {
                num= performSubtraction(num1, num2);
                return num;
            } else if (num4==2) {
                num = performMultiplication(num1, num2);
                return num;
            } else if (num4==3) {
                num = performDivision(num1, num2);
                return num;
            }
        }

        else{
            System.out.println("Please choose a correct option");
        }
        return 0;
    }

    private static int performDivision(int num1, int num2) {
        int userInput;
        boolean error = false;
        Scanner myInput = new Scanner( System.in );
        while (true) {
            System.out.print("What is " + num1 + " / " + num2 + " =");
            userInput = myInput.nextInt();
            int addition = num1 / num2;
            if (addition == userInput) {
                displaySuccessMessage();
                if(!error){
                    return 1;
                }
                break;
            } else {
                displayErrorMessage();
                error =true;
            }
        }
        return 0;
    }

    private static int performMultiplication(int num1, int num2) {
        int userInput;
        boolean error = false;
        Scanner myInput = new Scanner( System.in );
        while (true) {
            System.out.print("What is " + num1 + " * " + num2 + " =");
            userInput = myInput.nextInt();
            int addition = num1 * num2;
            if (addition == userInput) {
                displaySuccessMessage();
                if(!error){
                    return 1;
                }
                break;
            } else {
                displayErrorMessage();
                error =true;
            }
        }
        return 0;
    }

    private static int performSubtraction(int num1, int num2) {
        int userInput;
        boolean error = false;
        Scanner myInput = new Scanner( System.in );
        while (true) {
            System.out.print("What is " + num1 + " - " + num2 + " =");
            userInput = myInput.nextInt();
            int addition = num1 - num2;
            if (addition == userInput) {
                displaySuccessMessage();
                if(!error){
                    return 1;
                }
                break;
            } else {
                displayErrorMessage();
                error =true;
            }
        }
        return 0;
    }

    private static int performAddition(int num1, int num2, int success) {
        int userInput;
        boolean error = false;
        Scanner myInput = new Scanner( System.in );
        while (true) {
            System.out.print("What is " + num1 + " + " + num2 + " =");
            userInput = myInput.nextInt();
            int addition = num1 + num2;
            if (addition == userInput) {
                displaySuccessMessage();
                if(!error){
                    return 1;
                }
                break;
            } else {
                displayErrorMessage();
                error =true;
            }
        }
        return 0;
    }

    private static void displayErrorMessage() {
        Random rand = new Random();
        int index = rand.nextInt(4);
        String[] errorMessage = {"No. Please try again", "Incorrect. Try one more time", "Do not give up", "No. Keep trying"};
        System.out.println(errorMessage[index]);
        System.out.println();
    }

    private static void displaySuccessMessage() {
        Random rand = new Random();
        int index = rand.nextInt(4);
        String[] successMessage = {"Very Good!!!", "Excellent!!!!", "Good job!", "Keep it up!!"};
        System.out.println(successMessage[index]);
        System.out.println();
    }
}
