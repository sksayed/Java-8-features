package com.company;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        //write a code that takes input from console
     /*   Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        soleWired(N);
        scanner.close();*/

        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            System.out.println(formatName(s1)+formatIntegerToThreeDigits(x));
        }
        System.out.println("================================");

    }

    private static String formatIntegerToThreeDigits ( Integer x) {
        if (x < 100) {
            if (x<10){
                return "00"+x;
            }
            return "0"+x;
        }
        else
            return x.toString();
    }

    private static String formatName (String s) {
        if ( s.length() < 15){
            char[] charArr = new char[15];
            for(int i = 0; i<s.length() ;i++) {
                charArr[i] = s.charAt(i);
            }
            for( int i = s.length() ; i <15 ; i++){
                charArr[i] = ' ';
            }
            return String.copyValueOf(charArr);
        }
        return s ;
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
