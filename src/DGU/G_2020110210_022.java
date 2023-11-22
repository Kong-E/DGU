package DGU;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 과일의 가격과 이름, 이미지를 담은 클래스
class Fruit {
  public String name;
  public int price;
  public ImageIcon image;

  // 생성자
  public Fruit(String n, int p) {
    name = n;
    price = p;
    image = new ImageIcon("images/" + name + ".jpg");
  }
}

public class G_2020110210_022 extends JFrame {
  public int w, h; // 프레임 크기
  public int size; // 과일의 개수
  public Container c = getContentPane(); // 컨테이너
  public TextInputPanel p2; // 과일 이름, 가격 입력 패널
  public RadioPanel p3; // 라디오 버튼 패널
  public Fruit[] FArray; // 과일 배열

  public G_2020110210_022() {
    w = 300;
    h = 300;
    // 기본 프레임 설정
    setTitle("입력받은대로 출력");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 개수입력 패널(패널1)을 컨텐츠 팬에 붙이기
    c.add(new FruitQuantityPanel(this), BorderLayout.CENTER);

    setSize(w, h);
    setVisible(true);
  }

  // 패널을 교체하는 메소드
  public void changePanel(int p) {
    c.removeAll(); // 현재 패널 지우기

    if (p == 2) {
      p2 = new TextInputPanel(this, size); // 패널2 객체 생성
      c.add(p2, BorderLayout.CENTER); // 새로운 패널 컨테이너에 붙이기
    } else if (p == 3) {
      p3 = new RadioPanel(this, size); // 패널3 객체 생성
      c.add(p3, BorderLayout.CENTER);
    }
    c.revalidate(); // 컨테이너 업데이트
  }

  public static void main(String[] args) {
    new G_2020110210_022();
  }
}

// 개수입력 패널
class FruitQuantityPanel extends JPanel {
  public FruitQuantityPanel(G_2020110210_022 g) {
    setLayout(new GridLayout(3, 1));
    add(new JLabel("원하는 개수입력하세요"));
    JTextField inputField = new JTextField();
    JButton inputButton = new JButton("확인");

    inputButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int size = Integer.parseInt(inputField.getText());
        g.size = size; // 개수 업데이트
        g.changePanel(2); // 2번째 패널로 변경
      }
    });

    add(inputField);
    add(inputButton);
  }
}

// 이름, 가격 입력 패널
class TextInputPanel extends JPanel {
  public int size; // 과일 개수

  public TextInputPanel(G_2020110210_022 g, int size) {
    setLayout(new BorderLayout());
    this.size = g.size; // 개수 가져오기
    g.FArray = new Fruit[size]; // 과일 배열 생성

    JPanel scrolledPanel = new JPanel();
    scrolledPanel.setLayout(new GridLayout(size + 1, 1)); // 입력 필드 + 버튼
    JScrollPane sp = new JScrollPane(scrolledPanel);

    JPanel[] inputPanel = new JPanel[size];
    JTextField[] inputNameField = new JTextField[size];
    JTextField[] inputPriceField = new JTextField[size];
    JButton inputButton2 = new JButton("버튼 만들기");

    for (int i = 0; i < size; i++) {
      inputPanel[i] = new JPanel(new GridLayout(2, 2));
      inputNameField[i] = new JTextField();
      inputPriceField[i] = new JTextField();
      inputPanel[i].add(new JLabel((i + 1) + "번째 과일이름"));
      inputPanel[i].add(inputNameField[i]);
      inputPanel[i].add(new JLabel((i + 1) + "번째 과일가격"));
      inputPanel[i].add(inputPriceField[i]);
      scrolledPanel.add(inputPanel[i]);
    }
    scrolledPanel.add(inputButton2);

    inputButton2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < size; i++) {
          String name = inputNameField[i].getText();
          int price = Integer.parseInt(inputPriceField[i].getText());
          g.FArray[i] = new Fruit(name, price);
        }
        g.changePanel(3);
      }
    });

    add(sp);
  }
}

// 라디오 버튼 패널
class RadioPanel extends JPanel {
  public int size; // 과일 개수

  public RadioPanel(G_2020110210_022 g, int size) {
    setLayout(new BorderLayout());
    this.size = g.size;
    JRadioButton[] radioButtons = new JRadioButton[size];

    JPanel radioPanel = new JPanel();
    JPanel imagePanel = new JPanel();
    JPanel pricePanel = new JPanel();

    JLabel showimage = new JLabel();
    imagePanel.add(showimage);
    JLabel showPrice = new JLabel("과일을 선택하십시오.");
    pricePanel.add(showPrice);

    ButtonGroup bg = new ButtonGroup();
    for (int i = 0; i < size; i++) {
      Fruit fruit = g.FArray[i];
      radioButtons[i] = new JRadioButton(fruit.name);
      bg.add(radioButtons[i]);
      radioPanel.add(radioButtons[i]);

      radioButtons[i].addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
          if (e.getStateChange() == ItemEvent.SELECTED) {
            ImageIcon image = new ImageIcon(fruit.image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
            showimage.setIcon(image);
            showPrice.setText(fruit.name + "의 가격은 " + fruit.price + "원 입니다.");
          }
        }
      });
    }

    JScrollPane js = new JScrollPane(radioPanel);
    js.setPreferredSize(new Dimension(0, 50));
    add(js, BorderLayout.NORTH);
    add(imagePanel, BorderLayout.CENTER);
    add(pricePanel, BorderLayout.SOUTH);
  }
}
