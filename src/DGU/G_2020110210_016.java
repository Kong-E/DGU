package DGU;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class G_2020110210_016 extends JFrame {
  public G_2020110210_016() {
    setTitle("체크박스 만들기 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    // 2차원 배열로 과일 정보 관리
    String[][] fruits = {
        { "Cherry", "images\\cherry.jpg", "images\\cherry_selected.jpg" },
        { "Apple", "images\\apple.jpg", "images\\apple_selected.jpg" },
        { "Pear", "images\\pear.jpg", "images\\pear_selected.jpg" }
    };

    List<ImageIcon> icons = new ArrayList<>();
    List<ImageIcon> selectedIcons = new ArrayList<>();

    for (String[] fruit : fruits) {
      icons.add(resizeIcon(new ImageIcon(fruit[1]), 130, 100));
      selectedIcons.add(resizeIcon(new ImageIcon(fruit[2]), 130, 100));

      // 체크박스 생성 및 패널에 추가
      JCheckBox checkBox = createCheckBox(fruit[0], icons.get(icons.size() - 1),
          selectedIcons.get(selectedIcons.size() - 1));
      panel.add(checkBox);
    }

    add(panel, BorderLayout.CENTER);
    setSize(700, 200);
    setVisible(true);
  }

  private JCheckBox createCheckBox(String text, ImageIcon icon, ImageIcon selectedIcon) {
    JCheckBox checkBox = new JCheckBox(text, icon);
    checkBox.setBorderPainted(true);
    checkBox.setSelectedIcon(selectedIcon);
    return checkBox;
  }

  private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
    Image img = icon.getImage();
    Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(resizedImg);
  }

  public static void main(String[] args) {
    new G_2020110210_016();
  }
}
