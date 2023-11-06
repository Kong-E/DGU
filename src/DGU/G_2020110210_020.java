package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// 돈 계산 라디오 버튼 - 예제
public class G_2020110210_020 extends JFrame {
  private JRadioButton[] fruits = new JRadioButton[3];
  private String[] names = { "사과", "배", "체리" };
  private JLabel sumLabel;
  private ButtonGroup group = new ButtonGroup(); // 라디오 버튼 그룹을 위한 변수

  public G_2020110210_020() {
    setTitle("라디오버튼과 ItemEvent 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));

    MyItemListener listener = new MyItemListener();
    for (int i = 0; i < fruits.length; i++) {
      fruits[i] = new JRadioButton(names[i]);
      fruits[i].setBorderPainted(true);
      group.add(fruits[i]); // 라디오 버튼 그룹에 추가
      c.add(fruits[i]);
      fruits[i].addItemListener(listener);
    }
    sumLabel = new JLabel("현재 0 원 입니다.");
    c.add(sumLabel);
    setSize(250, 200);
    setVisible(true);
  }

  class MyItemListener implements ItemListener {
    private int sum = 0; // 가격의 합

    public void itemStateChanged(ItemEvent e) {
      // 선택되었을 때 가격을 합산하거나 빼지 않고 항상 선택된 라디오 버튼에 따라 가격을 설정
      if (e.getStateChange() == ItemEvent.SELECTED) {
        if (e.getItem() == fruits[0])
          sum = 100; // 사과 선택
        else if (e.getItem() == fruits[1])
          sum = 500; // 배 선택
        else
          sum = 20000; // 체리 선택
      }
      sumLabel.setText("현재 " + sum + "원 입니다.");
    }
  }

  public static void main(String[] args) {
    new G_2020110210_020();
  }
}
