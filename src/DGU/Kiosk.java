package DGU;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Kiosk {
  private static Map<String, Integer> cart = new HashMap<>();
  private static Map<String, Integer> burgers = Map.ofEntries( // 버거 메뉴와 가격을 맵에 추가
      Map.entry("맥크리스피 스리라차 마요", 5000),
      Map.entry("맥스파이시 스리라차 마요", 5500),
      Map.entry("빅맥", 6000),
      Map.entry("더블 쿼터파운더 치즈", 6500),
      Map.entry("쿼터파운더 치즈", 7000),
      Map.entry("맥크리스피 디럭스 버거", 7500),
      Map.entry("맥크리스피 클래식 버거", 8000),
      Map.entry("맥스파이시 상하이 버거", 8500),
      Map.entry("1955 버거", 9000));
  private static Map<String, Integer> sides = Map.ofEntries(
      Map.entry("소시지 스낵랩", 3000),
      Map.entry("칠리 치즈 후라이", 3500),
      Map.entry("토마토 치킨 스낵랩", 3000),
      Map.entry("코울슬로", 2500),
      Map.entry("상하이 치킨 스낵랩", 3000),
      Map.entry("골든 모짜렐라 치즈스틱", 4000),
      Map.entry("후렌치 후라이", 2000),
      Map.entry("맥너겟", 4000),
      Map.entry("맥스파이시 치킨 텐더", 4500),
      Map.entry("해쉬 브라운", 2000));
  private static Map<String, Integer> drinks = Map.ofEntries(
      Map.entry("코카콜라", 2000),
      Map.entry("코카콜라 제로", 2000),
      Map.entry("스프라이트", 2000),
      Map.entry("환타", 2000),
      Map.entry("바닐라 쉐이크", 3500),
      Map.entry("딸기 쉐이크", 3500),
      Map.entry("초코 쉐이크", 3500),
      Map.entry("오렌지 주스", 3000),
      Map.entry("생수", 1000));

  private static JLabel totalLabel; // 총합계를 표시할 레이블
  private static int total; // 총합계를 저장할 클래스 레벨 변수

  public static void main(String[] args) {
    JFrame frame = new JFrame("동국대학교 키오스크");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);

    JTabbedPane tabbedPane = new JTabbedPane();

    JPanel burgerPanel = createMenuPanel(burgers, "burgers");
    JPanel sidePanel = createMenuPanel(sides, "sides");
    JPanel drinkPanel = createMenuPanel(drinks, "drinks");

    JPanel learnedPanel = new JPanel();
    learnedPanel.add(new JLabel("배운 것"));

    JScrollPane burgerScrollPane = createScrollPane(burgerPanel);
    JScrollPane sideScrollPane = createScrollPane(sidePanel);
    JScrollPane drinkScrollPane = createScrollPane(drinkPanel);

    tabbedPane.addTab("버거", burgerScrollPane);
    tabbedPane.addTab("사이드", sideScrollPane);
    tabbedPane.addTab("음료", drinkScrollPane);
    tabbedPane.addTab("배운것", learnedPanel);

    JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    infoPanel.setPreferredSize(new Dimension(frame.getWidth(), 50));
    infoPanel.setBackground(new Color(200, 200, 200));

    JButton viewCartButton = new JButton("장바구니 보기");
    viewCartButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showCartFrame();
      }
    });

    JButton paymentButton = new JButton("결제하기");
    paymentButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showPaymentFrame();
      }
    });

    totalLabel = new JLabel("총 합계: 0원");
    infoPanel.add(totalLabel);
    infoPanel.add(viewCartButton);
    infoPanel.add(paymentButton);

    frame.add(tabbedPane, BorderLayout.CENTER);
    frame.add(infoPanel, BorderLayout.SOUTH);
    frame.setVisible(true);
  }

  private static JPanel createMenuPanel(Map<String, Integer> menuItems, String imageFolder) {
    JPanel menuPanel = new JPanel(new GridLayout(0, 3));

    for (Map.Entry<String, Integer> entry : menuItems.entrySet()) {
      String itemName = entry.getKey();
      Integer price = entry.getValue();

      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panel.setMinimumSize(new Dimension(200, 250));

      ImageIcon icon = new ImageIcon("images/" + imageFolder + "/" + itemName + ".png");
      JLabel imageLabel = new JLabel(resizeImageSize(icon));

      JLabel nameLabel = new JLabel(itemName);
      JLabel priceLabel = new JLabel(price + "원");
      JButton addButton = new JButton("장바구니에 담기");
      addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          addToCart(itemName, price);
        }
      });

      panel.add(imageLabel);
      panel.add(nameLabel);
      panel.add(priceLabel);
      panel.add(addButton);
      menuPanel.add(panel);
    }

    return menuPanel;
  }

  private static JScrollPane createScrollPane(JPanel panel) {
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setPreferredSize(new Dimension(800, 600));
    return scrollPane;
  }

  private static void showCartFrame() {
    JFrame cartFrame = new JFrame("장바구니");
    cartFrame.setSize(400, 600);
    cartFrame.setLayout(new BorderLayout());

    JPanel cartItemsPanel = new JPanel();
    cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel, BoxLayout.Y_AXIS));

    total = 0;
    for (Map.Entry<String, Integer> entry : cart.entrySet()) {
      String item = entry.getKey();
      int quantity = entry.getValue();
      int itemPrice = quantity
          * (burgers.getOrDefault(item, 0) + sides.getOrDefault(item, 0) + drinks.getOrDefault(item, 0));

      JPanel itemPanel = new JPanel();
      itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

      JLabel nameLabel = new JLabel(item);
      JLabel priceLabel = new JLabel("가격: " + itemPrice);
      JLabel quantityLabel = new JLabel("수량: " + quantity);

      JButton removeButton = new JButton("빼기");
      removeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          removeFromCart(item);
          cartFrame.dispose();
          showCartFrame();
        }
      });

      itemPanel.add(nameLabel);
      itemPanel.add(priceLabel);
      itemPanel.add(quantityLabel);
      itemPanel.add(removeButton);
      cartItemsPanel.add(itemPanel);

      total += itemPrice;
    }

    // 총합계와 결제하기 버튼을 담을 패널
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JLabel totalLabel = new JLabel("총 합계: " + total + "원");
    totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    bottomPanel.add(totalLabel);

    JButton paymentButton = new JButton("결제하기");
    paymentButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showPaymentFrame();
      }
    });
    bottomPanel.add(paymentButton);

    cartFrame.add(new JScrollPane(cartItemsPanel), BorderLayout.CENTER);
    cartFrame.add(bottomPanel, BorderLayout.SOUTH);

    cartFrame.setVisible(true);

  }

  private static void addToCart(String item, int price) {
    cart.put(item, cart.getOrDefault(item, 0) + 1);
    total += price;
    totalLabel.setText("총 합계: " + total + "원");
  }

  private static void removeFromCart(String item) {
    int currentQuantity = cart.getOrDefault(item, 0);
    int itemPrice = burgers.getOrDefault(item, 0) + sides.getOrDefault(item, 0) + drinks.getOrDefault(item, 0);

    if (currentQuantity > 1) {
      cart.put(item, currentQuantity - 1);
      total -= itemPrice;
    } else {
      cart.remove(item);
      total -= itemPrice * currentQuantity;
    }
    totalLabel.setText("총 합계: " + total + "원");
  }

  private static void showPaymentFrame() {
    if (cart.isEmpty()) {
      JOptionPane.showMessageDialog(null, "상품을 담아주세요.");
    } else {
      JFrame paymentFrame = new JFrame("결제 완료");
      paymentFrame.setSize(300, 200);
      paymentFrame.setLayout(new BorderLayout());

      JLabel paymentLabel = new JLabel("결제 완료", JLabel.CENTER);
      JButton receiptButton = new JButton("영수증 출력");
      receiptButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          printReceipt();
        }
      });

      paymentFrame.add(paymentLabel, BorderLayout.CENTER);
      paymentFrame.add(receiptButton, BorderLayout.SOUTH);

      paymentFrame.setVisible(true);
    }
  }

  private static void printReceipt() {
    File outputDir = new File("output");
    if (!outputDir.exists()) {
      outputDir.mkdirs(); // output 폴더가 없으면 생성
    }

    try (PrintWriter out = new PrintWriter("output/영수증.txt")) {
      for (Map.Entry<String, Integer> entry : cart.entrySet()) {
        String item = entry.getKey();
        int quantity = entry.getValue();
        int price = quantity
            * (burgers.getOrDefault(item, 0) + sides.getOrDefault(item, 0) + drinks.getOrDefault(item, 0));
        out.println(item + " - 수량: " + quantity + ", 가격: " + price);
      }
      out.println("총 합계: " + total + "원");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    JOptionPane.showMessageDialog(null, "영수증 출력이 완료되었습니다.");
  }

  private static ImageIcon resizeImageSize(ImageIcon i) {
    Image image = i.getImage();
    return new ImageIcon(image.getScaledInstance(200, 130, Image.SCALE_SMOOTH));
  }
}