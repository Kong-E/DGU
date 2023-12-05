package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class G_2020110210_018 extends JFrame {
  private JLabel sumLabel;
  private int sum = 0;
  private List<ImageIcon> icons = new ArrayList<>();
  private List<ImageIcon> selectedIcons = new ArrayList<>();

  public G_2020110210_018() {
    setTitle("과일 체크박스와 합계 계산");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    sumLabel = new JLabel("현재 0 원 입니다.");

    // 과일 정보 및 가격
    String[][] fruits = {
        { "Cherry", "10000", "images\\cherry.jpg", "images\\cherry_selected.jpg" },
        { "Apple", "500", "images\\apple.jpg", "images\\apple_selected.jpg" },
        { "Pear", "1000", "images\\pear.jpg", "images\\pear_selected.jpg" }
    };

    MyItemListener listener = new MyItemListener();
    for (String[] fruit : fruits) {
      icons.add(resizeIcon(new ImageIcon(fruit[2]), 130, 100));
      selectedIcons.add(resizeIcon(new ImageIcon(fruit[3]), 130, 100));

      JCheckBox checkBox = createCheckBox(fruit[0], icons.get(icons.size() - 1),
          selectedIcons.get(selectedIcons.size() - 1));
      checkBox.addItemListener(listener);
      checkBox.putClientProperty("price", Integer.parseInt(fruit[1]));
      panel.add(checkBox);
    }

    // sumLabel을 위한 새로운 패널 생성, 가운데 정렬
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    sumLabel = new JLabel("현재 0 원 입니다.");
    topPanel.add(sumLabel);

    // topPanel을 창의 위쪽에 추가
    add(topPanel, BorderLayout.NORTH);
    add(panel, BorderLayout.CENTER);

    setSize(700, 250);
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

  class MyItemListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      JCheckBox checkBox = (JCheckBox) e.getItem();
      int price = (int) checkBox.getClientProperty("price");

      if (e.getStateChange() == ItemEvent.SELECTED) {
        sum += price;
      } else {
        sum -= price;
      }
      sumLabel.setText("현재 " + sum + "원 입니다.");
    }
  }

  public static void main(String[] args) {
    new G_2020110210_018();
  }
}
