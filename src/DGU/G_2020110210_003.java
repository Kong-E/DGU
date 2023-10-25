package DGU;

import java.util.Scanner;

// GradingSwitch
public class G_2020110210_003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;

		// 학생 수 입력 및 5 이상 체크
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

		// 학생 정보 입력
		for (int i = 0; i < students.length; i++) {
			students[i] = "학생" + (i + 1);
			System.out.println(students[i]);
			System.out.print("국어점수 : ");
			score1[i] = sc.nextInt();
			System.out.print("영어점수 : ");
			score2[i] = sc.nextInt();
		}

		// 학생 정보 및 등급 출력
		System.out.println("이름\t\t국어\t영어");
		for (int i = 0; i < score1.length; i++) {
			System.out.print(students[i] + "\t\t");
			grade(score1[i]);
			grade(score2[i]);
			System.out.println();
		}
	}

	// 점수를 바탕으로 등급 및 세부 등급 결정
	public static void grade(int score) {
		char grade;
		char sign = (score % 10 >= 5 || score == 100) ? '+' : '0'; // 세부 등급 결정

		switch (score / 10) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				sign = ' ';
				break;
		}

		System.out.printf("%c%c\t", grade, sign);
	}
}
