package DGU;
import javax.swing.*;

// 예제 9-1 MyFrame : 300x300 스윙 프레임 만들기
public class G_2020110210_006 extends JFrame {
  public G_2020110210_006() {
    setTitle("300x300 스윙 프레임 만들기");
    setSize(300,300); // 프레임 크기 300x300
    setVisible(true); // 프레임 출력
  }
  public static void main(String[] args) {
    G_2020110210_006 frame = new G_2020110210_006();
  }
}