package DGU;

import java.util.Scanner;

public class G_2020110210_003 {

	// GradingSwitch
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		char grade;

		System.out.print("점수를 입력하세요(0~100) : ");
		int score = scanner.nextInt();

		System.out.print("학년을 입력하세요(1~4) : ");
		int year = scanner.nextInt();

		// switch case 문을 이용하여 60점 이상이면 합격, 미만이면 불합격 출력, 4학년의 경우 70점 이상이어야 합격
		switch (year) {
		case 1: // 1학년
		case 2: // 2학년
		case 3: // 3학년
			if (score >= 60) {
				grade = 'P'; // Pass
			} else {
				grade = 'F'; // Fail
			}
			break;
		case 4: // 4학년
			if (score >= 70) {
				grade = 'P'; // Pass
			} else {
				grade = 'F'; // Fail
			}
			break;
		default:
			grade = 'X'; // 잘못된 학년
		}
	
		scanner.close();

		if (grade == 'P') {
			System.out.println("합격입니다.");
		} else if (grade == 'F') {
			System.out.println("불합격입니다.");
		} else {
			System.out.println("학년을 잘못 입력하셨습니다.");
		}

	}
}
