package DGU;

import java.util.Scanner;

public class G_2020110210_001 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = 0;

      // 5 이상의 학생 수를 입력 받을 때까지 반복
      while (true) {
         System.out.println("학생 수를 입력해주세요.");
         N = sc.nextInt();
         if (N >= 5) {
            break;
         } else {
            System.out.println("5 이상의 수를 입력하시오.");
         }
      }

      String[] students = new String[N];
      int[] score1 = new int[N];
      int[] score2 = new int[N];

      // 각 학생의 국어와 영어 점수 입력 받기
      for (int i = 0; i < students.length; i++) {
         students[i] = "학생" + (i + 1);
         System.out.println(students[i]);
         System.out.print("국어점수 : ");
         score1[i] = sc.nextInt();
         System.out.print("영어점수 : ");
         score2[i] = sc.nextInt();
      }

      // 학생들의 점수 및 등급 출력
      System.out.println("이름\t\t국어\t영어");
      for (int i = 0; i < score1.length; i++) {
         System.out.print(students[i] + "\t\t");
         grade(score1[i]);
         grade(score2[i]);
         System.out.println();
      }
   }

   // 주어진 점수를 바탕으로 등급 출력
   public static void grade(int score) {
      if (score <= 100 && score >= 95) {
         System.out.print("A+");
      } else if (score >= 90) {
         System.out.print("A0");
      } else if (score >= 85) {
         System.out.print("B+");
      } else if (score >= 80) {
         System.out.print("B0");
      } else if (score >= 75) {
         System.out.print("C+");
      } else if (score >= 70) {
         System.out.print("C0");
      } else if (score >= 65) {
         System.out.print("D+");
      } else if (score >= 60) {
         System.out.print("D0");
      } else {
         System.out.print("F");
      }
      System.out.print("\t");
   }
}
