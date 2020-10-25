import java.util.Scanner;

public class TestClass {

    public static void main(String[] args)   {
        int uChoice = 0;

        uChoice = menu();

        switch (uChoice) {
            case 1:
                iterativeFibo();
                break;
            case 2:
                recursiveWrapper();
                break;
            case 3:
                iterativeFibo();
                recursiveWrapper();
                break;
        }



        return;

    }

    static void iterativeFibo(){
        long x =0;
        long y = 1, z = 1;

        long startTime = 0;
        long endTime = 0;
        long runTime = 0;

        startTime = System.nanoTime();

        for(int i = 0; i < 49; i++){
            z = x + y;
            x = y;
            y = z;
        }

        endTime = System.nanoTime();
        runTime = endTime - startTime;


        System.out.println("Program iteratively calculated first 50 Fibonacci numbers in " + runTime + " nanoseconds.");
    }

    static int menu() {
        Scanner cat = new Scanner(System.in);
        int choice = ' ';
        boolean validChoice = false;

        while(!validChoice){

            System.out.println("Please select (1) for Iterative Fibonacci, (2) for Recursive Fibonacci, or (3) for both.");
            choice = cat.nextInt();

            if(choice == 1 || choice == 2 || choice == 3) {
                validChoice = true;
            }else{
                System.out.println("Invalid selection");
            }
        }

        return choice;
    }

    static long recursiveFibo(long n){

        if(n <= 1)
            return n;

        return recursiveFibo(n - 1) + recursiveFibo(n - 2);

    }

    static void recursiveWrapper(){

        int n = 50;
        long startTime = 0;
        long endTime = 0;
        long runTime = 0;

        startTime = System.nanoTime();

        recursiveFibo(n);

        endTime = System.nanoTime();
        runTime = endTime - startTime;

        System.out.println("Program recursively calculated first 50 Fibonacci numbers in " + runTime + " nanoseconds.");

    }

}
