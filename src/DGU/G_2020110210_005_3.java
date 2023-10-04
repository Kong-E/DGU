package DGU;

class G_2020110210_005_3_parent {
  private static String privateString = "private";
  public static String publicString = "public";
  protected static String protectedString = "protected";
  static String defaultString = "default";
}

// 같은 패키지 - 다른 클래스
class G_2020110210_005_3_other  {
  public static void main(String[] args) {
    G_2020110210_005_1 obj = new G_2020110210_005_1(); // 같은 패키지 내 다른 클래스 객체 생성

    // System.out.println(obj.privateString); // 같은 클래스 내부에서만 접근 가능
    System.out.println(obj.publicString); // 어디서든 접근 가능
    System.out.println(obj.protectedString); // 같은 패키지나 상속 클래스에서 접근 가능
    System.out.println(obj.defaultString); // 같은 패키지에서만 접근 가능
  }
  
}
