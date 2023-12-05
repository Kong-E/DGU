package DGU;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class G_2020110210_024 extends JFrame {
  private String[] fruits = { "apple", "cherry", "pear", "mango" };
  private JLabel imgLabel = new JLabel(); // 이미지 출력을 위한 레이블
  private JComboBox<String> strCombo = new JComboBox<String>(fruits); // 콤보박스 생성

  public G_2020110210_024() {
    setTitle("콤보박스 활용 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(strCombo);
    c.add(imgLabel);

    // 콤보박스에 리스너 등록
    strCombo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>) e.getSource(); // 선택된 콤보박스 알아내기
        int index = cb.getSelectedIndex(); // 선택된 콤보박스의 인덱스 알아내기
        ImageIcon icon = createResizedImageIcon("images/" + fruits[index] + ".jpg", 100, 100); // 이미지 크기 조절
        imgLabel.setIcon(icon); // 레이블에 이미지 출력
      }
    });

    setSize(300, 250);
    setVisible(true);
  }

  // 이미지 사이즈 조절 메서드
  private ImageIcon createResizedImageIcon(String imagePath, int width, int height) {
    try {
      BufferedImage originalImage = ImageIO.read(new File(imagePath));
      Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      return new ImageIcon(scaledImage);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    new G_2020110210_024();
  }
}
