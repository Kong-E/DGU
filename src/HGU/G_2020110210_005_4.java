package HGU;

import DGU.G_2020110210_005_1;

// 다른 패키지 - 클래스 접근
public class G_2020110210_005_4 {

  public static void main(String[] args) {
      G_2020110210_005_1 obj = new G_2020110210_005_1(); // 다른 패키지 내 다른 클래스 객체 생성

      // System.out.println(obj.privateString); // 같은 클래스 내부에서만 접근 가능
      // System.out.println(obj.protectedString); // 같은 패키지나 상속 클래스에서 접근 가능
      // System.out.println(obj.defaultString); // 같은 패키지에서만 접근 가능
      System.out.println(obj.publicString); // 어디서든 접근 가능
  }
}
