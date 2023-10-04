package DGU;

// 같은 패키지 - 같은 클래스
public class G_2020110210_005_1 {
  private static String privateString = "private";
  public static String publicString = "public";
  protected static String protectedString = "protected";
  static String defaultString = "default";

  public static void main(String[] args) {
    System.out.println(privateString); // 클래스 내부에서만 접근 가능
    System.out.println(publicString); // 어디서든 접근 가능
    System.out.println(protectedString); // 같은 패키지나 상속 클래스에서 접근 가능
    System.out.println(defaultString); // 같은 패키지에서만 접근 가능
  }
}