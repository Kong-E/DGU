package DGU;

import java.util.Scanner;

public class G_2020110210_001 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int N = 0;
      while(true) {
         N = sc.nextInt();
         if(N>=10) {
            break;
         }
         else if(N<10) {
            System.out.println("10 이상의 수를 입력하시오.");
         }
         
      }
      
      String[] students = new String[N];
      int[] score1 = new int[N];
      int[] score2 = new int[N];
      for(int i=0;i<students.length;i++) {
         students[i] = "홍길동"+String.valueOf(i+1);
         System.out.println(students[i]);
         System.out.print("국어점수 : ");
         score1[i] = sc.nextInt();
         System.out.print("영어점수 : ");
         score2[i] = sc.nextInt();
      }
      System.out.println("이름\t국어\t영어");
      for(int i=0;i<score1.length;i++) {
         System.out.print(students[i]+"\t");
         grade(score1[i]);
         grade(score2[i]);
         System.out.println();
      }
      
   
   }
   public static void grade(int a) {
      if(a<=100 && a>=95) {
         System.out.print("A+");
      }
      else if(a>=90) {
         System.out.print("A0");
      }
      else if(a>=85) {
         System.out.print("B+");
      }
      else if(a>=80) {
         System.out.print("B0");
      }
      else if(a>=75) {
         System.out.print("C+");
      }
      else if(a>=70) {
         System.out.print("C0");
      }
      else if(a>=65) {
         System.out.print("D+");
      }
      else if(a>=60) {
         System.out.print("D0");
      }
      else {
         System.out.print("F");
      }
      System.out.print("\t");
   }

}