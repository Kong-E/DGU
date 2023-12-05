package DGU;

import javax.swing.*;
import java.awt.*;

public class G_2020110210_026 extends JFrame {
  public G_2020110210_026() {
    setTitle("이미지 버튼 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    // Load and resize the icons
    ImageIcon normalIcon = imageSize(new ImageIcon("images//apple.jpg"));
    ImageIcon rolloverIcon = imageSize(new ImageIcon("images//cherry.jpg"));
    ImageIcon pressedIcon = imageSize(new ImageIcon("images//pear.jpg"));

    JButton btn = new JButton("call~~", normalIcon);
    btn.setPressedIcon(pressedIcon);
    btn.setRolloverIcon(rolloverIcon);

    c.add(btn);
    setSize(500, 300);
    setVisible(true);
  }

  // 이미지 사이즈 조절 메서드
  ImageIcon imageSize(ImageIcon i) {
    Image image = i.getImage();
    return new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
  }

  public static void main(String[] args) {
    new G_2020110210_026();
  }
}
