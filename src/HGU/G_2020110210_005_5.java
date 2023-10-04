package HGU;

import DGU.G_2020110210_005_1;

// 다른 패키지 - 상속 클래스
public class G_2020110210_005_5 extends G_2020110210_005_1 {
  
  public static void main(String[] args) {
    G_2020110210_005_5 obj = new G_2020110210_005_5(); // 상속 클래스 객체 생성

    // System.out.println(obj.privateString); // 같은 클래스 내부에서만 접근 가능
    // System.out.println(obj.defaultString); // 같은 패키지에서만 접근 가능
    System.out.println(obj.protectedString); // 같은 패키지나 상속 클래스에서 접근 가능 - 이 경우 상속 클래스이므로 접근 가능
    System.out.println(obj.publicString); // 어디서든 접근 가능
  }
}
