package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        //write a code that takes input from console
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        soleWired(N);
        scanner.close();

    }




    private static void soleWired(int n) {
        if (n % 2 == 0) {
            //this means its even
            if (n >= 2 && n <= 5) {
                System.out.println("Not Weird");
            }
            if (n >= 6 && n <= 20) {
                System.out.println("Weird");
            }
            if (n > 20) {
                System.out.println("Not Weird");
            }
        } else {
            //this means its odd
            System.out.println("Weird");
        }
    }
}
