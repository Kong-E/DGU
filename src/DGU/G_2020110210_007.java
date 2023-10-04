package DGU;

import javax.swing.*;
import java.awt.*;

// 예제 9-2 ContentPaneEx : 3개의 버튼 컴포넌트를 가진 스윙프레임 만들기
public class G_2020110210_007 extends JFrame {
  public G_2020110210_007() {
    setTitle("ContentPane과 JFrame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = getContentPane();
    contentPane.setBackground(Color.ORANGE);
    contentPane.setLayout(new FlowLayout());

    contentPane.add(new JButton("OK"));
    contentPane.add(new JButton("Cancel"));
    contentPane.add(new JButton("Ignore"));

    setSize(300,150);
    setVisible(true);
  }

  public static void main(String[] args) {
    new G_2020110210_007();
  }
}
