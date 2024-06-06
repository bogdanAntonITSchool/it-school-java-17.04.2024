import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Write a program that reads a number from the user and then prints if the number is prime or not.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number (or type '0' if you want to stop): ");
            int n = scanner.nextInt();

            if (n == 0) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.println(isPrime(n));
        }

        // 2. Write a program that reads a number from the user and then prints if the number is a palindrome or not.
        while (true) {
            System.out.print("Enter a number (or type '0' if you want to stop): ");
            int n = scanner.nextInt();

            if (n == 0) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.println(isPalindrom(n));
        }

        // 3. Write a program that reads a number from the user and then prints the first N Fibonacci numbers.
        while (true) {
            System.out.print("Enter a number (or type '0' if you want to stop): ");
            int n = scanner.nextInt();

            if (n == 0) {
                System.out.println("Goodbye!");
                break;
            }

            printFirstNFibonacciNumbers(n);
        }

        // 4. Write a program that reads a string from the user and then prints the inverse of the string.
        while (true) {
            System.out.print("Enter a string (or type 'exit' if you want to stop): ");
            String s = scanner.next();

            if (s.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.println(computeInverseOfString(s));
            System.out.println(computeInverseOfStringSecondApproach(s));
        }

        // 5. Write a program that reads two strings from the user and then prints if the two strings are anagrams or not.
        while (true) {
            System.out.print("Enter the first string (or type 'exit' if you want to stop): ");
            String s1 = scanner.next();

            if (s1.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter the second string: ");
            String s2 = scanner.next();

            System.out.println(checkIfTwoStringsAreAnagrams(s1, s2));
        }

        // 6. Write a program that reads the size of an array from the user and then prints the sum of the elements in the array.
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        Random random = new Random();

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10);
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }

        System.out.println();
        System.out.println(sumInArray(arr));

        // 7. Write a program that reads the size of an array from the user and then prints the minimum and maximum elements in the array.
        printMinAndMaxInArray(arr);

        // 8. Write a program that reads a matrix from the user and then prints the elements on the first diagonal.
        System.out.print("Enter the number of rows and columns: ");
        int m = scanner.nextInt();

        int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        printFirstDiagonal(matrix);
        System.out.println();
        printSecondDiagonal(matrix);

        // release the resources
        scanner.close();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrom(int n) {
        // n = 12321
        int aux = n;
        int result = 0;

        while (aux > 0) {
            int digit = aux % 10;
            // digit = 1
            // digit = 2
            // digit = 3
            // digit = 2
            // digit = 1

            aux = aux / 10; // <=> aux /= 10;
            // aux = 1232
            // aux = 123
            // aux = 12
            // aux = 1
            // aux = 0

            result = result * 10 + digit;
            // result = 0 * 10 + 1 = 1
            // result = 1 * 10 + 2 = 12
            // result = 12 * 10 + 3 = 123
            // result = 123 * 10 + 2 = 1232
            // result = 1232 * 10 + 1 = 12321
        }

        // n = 12321 = result
        return result == n;
    }

    private static void printFirstNFibonacciNumbers(int n) {
        if (n <= 0) {
            return;
        }
        int i = 0;
        int j = 1;

        System.out.print(i + " " + j + " ");
        n -= 2;
        while (n > 0) {
            int sum = i + j;
            System.out.print(sum + " ");
            i = j;
            j = sum;
            n--;
        }
        System.out.println();
    }

    private static String computeInverseOfString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String computeInverseOfStringSecondApproach(String s) {
        //return new StringBuilder(s).reverse().toString();

        return new StringBuffer(s).toString();
    }

    private static boolean checkIfTwoStringsAreAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        Arrays.sort(s1CharArray);
        Arrays.sort(s2CharArray);

        return Arrays.equals(s1CharArray, s2CharArray);
    }

    private static int sumInArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static void printMinAndMaxInArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int elem : arr) {
            if (elem < min) {
                min = elem;
            }
            if (elem > max) {
                max = elem;
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    private static void printFirstDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    private static void printSecondDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + j == matrix.length - 1) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

}