package DGU;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class G_2020110210_027 extends JFrame {
  private JLabel colorLabel;
  private JSlider[] sl = new JSlider[3];

  public G_2020110210_027() {
    setTitle("슬라이더와 ChangeEvent 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    colorLabel = new JLabel(" SLIDER EXAMPLE ");

    // 슬라이더 생성
    for (int i = 0; i < sl.length; i++) {
      sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128); // 최소값, 최대값, 초기값
      sl[i].setPaintLabels(true); // 눈금에 레이블 표시
      sl[i].setPaintTicks(true); // 눈금 표시
      sl[i].setPaintTrack(true); // 슬라이더 트랙 표시
      sl[i].setMajorTickSpacing(50); // 큰 눈금 간격
      sl[i].setMinorTickSpacing(10); // 작은 눈금 간격
      sl[i].addChangeListener(new MyChangeListener()); // 리스너 등록
      c.add(sl[i]); // 컨텐트팬에 슬라이더 부착
    }

    // 슬라이더 색상 설정
    sl[0].setForeground(Color.RED);
    sl[1].setForeground(Color.GREEN);
    sl[2].setForeground(Color.BLUE);

    int r = sl[0].getValue(); // 슬라이더의 초기값을 배경색으로 설정
    int g = sl[1].getValue();
    int b = sl[2].getValue();
    colorLabel.setOpaque(true); // 불투명 설정
    colorLabel.setBackground(new Color(r, g, b)); // 배경색 설정
    c.add(colorLabel);
    setSize(300, 230);
    setVisible(true);
  }

  // 슬라이더의 값이 변경되면 레이블의 배경색을 변경
  class MyChangeListener implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      int r = sl[0].getValue();
      int g = sl[1].getValue();
      int b = sl[2].getValue();
      colorLabel.setBackground(new Color(r, g, b));
    }
  }

  public static void main(String[] args) {
    new G_2020110210_027();
  }
}