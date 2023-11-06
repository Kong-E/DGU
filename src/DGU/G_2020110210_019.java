package DGU;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class G_2020110210_019 extends JFrame {
  public G_2020110210_019() {
    setTitle("라디오 버튼 만들기 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    // 2차원 배열로 과일 정보 관리
    String[][] fruits = {
        { "Cherry", "C:\\융프2이미지\\cherry.jpg", "C:\\융프2이미지\\cherry_selected.jpg" },
        { "Apple", "C:\\융프2이미지\\apple.jpg", "C:\\융프2이미지\\apple_selected.jpg" },
        { "Pear", "C:\\융프2이미지\\pear.jpg", "C:\\융프2이미지\\pear_selected.jpg" }
    };

    List<ImageIcon> icons = new ArrayList<>();
    List<ImageIcon> selectedIcons = new ArrayList<>();

    ButtonGroup group = new ButtonGroup(); // 라디오 버튼 그룹 생성

    for (String[] fruit : fruits) {
      icons.add(resizeIcon(new ImageIcon(fruit[1]), 130, 100));
      selectedIcons.add(resizeIcon(new ImageIcon(fruit[2]), 130, 100));

      // 라디오 버튼 생성 및 패널에 추가
      JRadioButton radioButton = createRadioButton(fruit[0], icons.get(icons.size() - 1),
          selectedIcons.get(selectedIcons.size() - 1));
      group.add(radioButton); // 그룹에 라디오 버튼 추가
      panel.add(radioButton);
    }

    add(panel, BorderLayout.CENTER);
    setSize(700, 200);
    setVisible(true);
  }

  private JRadioButton createRadioButton(String text, ImageIcon icon, ImageIcon selectedIcon) {
    JRadioButton radioButton = new JRadioButton(text, icon);
    radioButton.setBorderPainted(true);
    radioButton.setSelectedIcon(selectedIcon);
    return radioButton;
  }

  private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
    Image img = icon.getImage();
    Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(resizedImg);
  }

  public static void main(String[] args) {
    new G_2020110210_019();
  }
}
