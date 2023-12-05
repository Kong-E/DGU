package DGU;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Kiosk {
  private static Map<String, Integer> cart = new HashMap<>(); // 장바구니를 저장할 맵
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
  private static Map<String, Integer> sides = Map.ofEntries( // 사이드 메뉴와 가격을 맵에 추가
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
  private static Map<String, Integer> drinks = Map.ofEntries( // 음료 메뉴와 가격을 맵에 추가
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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램 종료
    frame.setSize(800, 800); // 프레임 크기 설정

    JTabbedPane tabbedPane = new JTabbedPane(); // 탭을 담을 패널

    JPanel burgerPanel = createMenuPanel(burgers, "burgers"); // 버거 메뉴를 담을 패널
    JPanel sidePanel = createMenuPanel(sides, "sides"); // 사이드 메뉴를 담을 패널
    JPanel drinkPanel = createMenuPanel(drinks, "drinks"); // 음료 메뉴를 담을 패널

    JPanel learnedPanel = new JPanel(); // 배운 것을 담을 패널
    learnedPanel.add(new JLabel("배운 것")); // 배운 것을 표시할 레이블

    JScrollPane burgerScrollPane = createScrollPane(burgerPanel); // 버거 메뉴를 담을 스크롤 패널
    JScrollPane sideScrollPane = createScrollPane(sidePanel); // 사이드 메뉴를 담을 스크롤 패널
    JScrollPane drinkScrollPane = createScrollPane(drinkPanel); // 음료 메뉴를 담을 스크롤 패널

    tabbedPane.addTab("버거", burgerScrollPane); // 버거 탭에 버거 스크롤 패널 추가
    tabbedPane.addTab("사이드", sideScrollPane); // 사이드 탭에 사이드 스크롤 패널 추가
    tabbedPane.addTab("음료", drinkScrollPane); // 음료 탭에 음료 스크롤 패널 추가
    tabbedPane.addTab("배운것", learnedPanel); // 배운 것 탭에 배운 것 패널 추가

    JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 총합계와 결제하기 버튼을 담을 패널
    infoPanel.setPreferredSize(new Dimension(frame.getWidth(), 50)); // 패널 크기 설정
    infoPanel.setBackground(new Color(200, 200, 200)); // 패널 배경색 설정

    JButton viewCartButton = new JButton("장바구니 보기"); // 장바구니 보기 버튼
    viewCartButton.addActionListener(new ActionListener() { // 장바구니 보기 버튼에 액션 리스너 추가
      @Override
      public void actionPerformed(ActionEvent e) {
        showCartFrame(); // 장바구니 보기 프레임을 보여줌
      }
    });

    JButton paymentButton = new JButton("결제하기"); // 결제하기 버튼
    paymentButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showPaymentFrame(); // 결제하기 프레임을 보여줌
      }
    });

    totalLabel = new JLabel("총 합계: 0원");
    infoPanel.add(totalLabel); // 총합계를 표시할 레이블을 패널에 추가
    infoPanel.add(viewCartButton); // 장바구니 보기 버튼을 패널에 추가
    infoPanel.add(paymentButton); // 결제하기 버튼을 패널에 추가

    frame.add(tabbedPane, BorderLayout.CENTER); // 탭 패널을 프레임의 중앙에 추가
    frame.add(infoPanel, BorderLayout.SOUTH); // 총합계와 결제하기 버튼을 담은 패널을 프레임의 하단에 추가
    frame.setVisible(true);
  }

  // 메뉴를 담을 패널을 생성하는 메소드
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

  // 스크롤 패널을 생성하는 메소드
  private static JScrollPane createScrollPane(JPanel panel) {
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setPreferredSize(new Dimension(800, 600));
    return scrollPane;
  }

  // 장바구니를 보여주는 프레임을 생성하는 메소드
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

    try (PrintWriter out = new PrintWriter("output/영수증.csv")) {
      out.println("상품명,수량,가격"); // CSV 헤더

      for (Map.Entry<String, Integer> entry : cart.entrySet()) {
        String item = entry.getKey();
        int quantity = entry.getValue();
        int price = quantity
            * (burgers.getOrDefault(item, 0) + sides.getOrDefault(item, 0) + drinks.getOrDefault(item, 0));
        out.println(item + "," + quantity + "," + price); // 각 항목을 쉼표로 구분하여 기록
      }

      out.println("총 합계,," + total); // 총 합계
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