package DGU;

  // ScoreAverage
public class G_2020110210_004 {
  public static void main(String[] args) {
    double score[][] = {{4.5, 3.88}, // 1학년 1, 2학기 평점
                        {4.3, 4.33}, // 2학년 1, 2학기 평점
                        {4.32, 4.17}}; // 3학년 1, 2학기 평점

    double sum = 0;
    for (int year=0; year<score.length; year++) // 각 학년별로 반복
      for (int term=0; term<score[year].length; term++) // 각 학기별로 반복
        sum += score[year][term]; // 전체 평점 합

    int n = score.length; // 배열의 행 개수, 3
    int m = score[0].length; // 배열의 열 개수, 2
    System.out.println("3년 전체 평점 평균은 " + sum/(n*m));
  }
}
