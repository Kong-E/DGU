package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class G_2020110210_021 extends JFrame {
  private JLabel sumLabel;
  private ButtonGroup group = new ButtonGroup();

  private List<ImageIcon> icons = new ArrayList<>();
  private List<ImageIcon> selectedIcons = new ArrayList<>();

  public G_2020110210_021() {
    setTitle("과일 라디오 버튼과 합계 계산");
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

      JRadioButton radioButton = createRadioButton(fruit[0], icons.get(icons.size() - 1),
          selectedIcons.get(selectedIcons.size() - 1));
      radioButton.addItemListener(listener);
      radioButton.putClientProperty("price", Integer.parseInt(fruit[1]));
      group.add(radioButton);
      panel.add(radioButton);
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

  class MyItemListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      JRadioButton radioButton = (JRadioButton) e.getItem();
      if (radioButton.isSelected()) {
        int price = (int) radioButton.getClientProperty("price");
        sumLabel.setText("현재 " + price + "원 입니다.");
      }
    }
  }

  public static void main(String[] args) {
    new G_2020110210_021();
  }
}
