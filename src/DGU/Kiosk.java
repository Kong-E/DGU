package DGU;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Kiosk {
  private static Map<String, Integer> cart = new HashMap<>();
  private static Map<String, Integer> burgers = Map.ofEntries(
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

  private static JLabel totalLabel;
  private static JPanel cartPanel;
  private static JPanel cartItemsPanel; // 장바구니 아이템들을 보여줄 패널
  private static int total;

  private static void setGlobalFont(Font font) {
    UIManager.put("Label.font", font);
    UIManager.put("Button.font", font);
    UIManager.put("TabbedPane.font", font);
    UIManager.put("RadioButton.font", font);
    UIManager.put("CheckBox.font", font);
    UIManager.put("TextPane.font", font);
    UIManager.put("TextField.font", font);
    UIManager.put("TextArea.font", font);
    UIManager.put("EditorPane.font", font);
    UIManager.put("Table.font", font);
    UIManager.put("List.font", font);
    UIManager.put("ComboBox.font", font);
    UIManager.put("Tree.font", font);
    UIManager.put("ScrollPane.font", font);
    UIManager.put("Panel.font", font);
    UIManager.put("Viewport.font", font);
    UIManager.put("OptionPane.font", font);
  }

  public static void main(String[] args) {
    Font globalFont = new Font("나눔고딕", Font.PLAIN, 14);
    setGlobalFont(globalFont);

    JFrame frame = new JFrame("동국대학교 키오스크");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 1000);

    JTabbedPane tabbedPane = new JTabbedPane();
    UIManager.put("TabbedPane.selected", new Color(226, 232, 240)); // #E2E8F0

    // 탭 색상 설정
    tabbedPane.setBackground(Color.WHITE);

    JPanel burgerPanel = createMenuPanel(burgers, "burgers");
    JPanel sidePanel = createMenuPanel(sides, "sides");
    JPanel drinkPanel = createMenuPanel(drinks, "drinks");

    JScrollPane burgerScrollPane = createScrollPane(burgerPanel);
    JScrollPane sideScrollPane = createScrollPane(sidePanel);
    JScrollPane drinkScrollPane = createScrollPane(drinkPanel);
    JPanel learnedThingsPanel = createLearnedThingsPanel();

    tabbedPane.addTab("버거", burgerScrollPane);
    tabbedPane.addTab("사이드", sideScrollPane);
    tabbedPane.addTab("음료", drinkScrollPane);
    tabbedPane.addTab("배운 것", learnedThingsPanel);

    JPanel logoPanel = createLogoPanel();
    JPanel cartScrollPane = createCartPanel(); // 장바구니 패널을 한 번만 생성

    frame.add(tabbedPane, BorderLayout.CENTER);
    frame.add(logoPanel, BorderLayout.NORTH);
    frame.add(cartScrollPane, BorderLayout.SOUTH); // 한 번 생성된 장바구니 패널을 추가
    frame.setVisible(true);
  }

  private static JPanel createLogoPanel() {
    JPanel logoPanel = new JPanel();
    logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    logoPanel.setBackground(Color.WHITE); // 배경색 설정
    ImageIcon logoIcon = new ImageIcon("images/dongguk.png");
    JLabel logoLabel = new JLabel(logoIcon);
    logoPanel.add(logoLabel);
    return logoPanel;
  }

  private static JPanel createCartPanel() {
    cartPanel = new JPanel(); // cartPanel 초기화
    cartPanel.setLayout(new BorderLayout()); // 레이아웃 관리자 설정
    cartPanel.setBackground(Color.WHITE);

    // 크기 조정
    cartPanel.setPreferredSize(new Dimension(800, 200));

    cartItemsPanel = new JPanel();
    cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel, BoxLayout.Y_AXIS)); // 레이아웃 관리자 설정
    cartItemsPanel.setBackground(Color.WHITE);

    // 최대 높이 설정
    cartItemsPanel.setMaximumSize(new Dimension(800, 20));

    JScrollPane scrollPane = new JScrollPane(cartItemsPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // 크기 조정
    scrollPane.setPreferredSize(new Dimension(800, 150));
    scrollPane.getViewport().setBackground(Color.WHITE);

    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topPanel.setBackground(Color.WHITE);

    totalLabel = new JLabel("총 합계: " + total + "원");
    JButton paymentButton = new JButton("결제하기");
    setButtonBackground(paymentButton, "orange");
    paymentButton.addActionListener(e -> showPaymentFrame());

    topPanel.add(totalLabel);
    topPanel.add(paymentButton);

    cartPanel.add(scrollPane, BorderLayout.CENTER); // Add scrollPane to cartPanel CENTER
    cartPanel.add(topPanel, BorderLayout.NORTH);

    return cartPanel; // Return the cartPanel
  }

  private static void updateCartPanelContents() {
    cartItemsPanel.removeAll();

    for (Map.Entry<String, Integer> entry : cart.entrySet()) {
      String item = entry.getKey();
      int quantity = entry.getValue();

      JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JLabel nameLabel = new JLabel(item + ": ");

      JButton minusButton = new JButton("-");
      setButtonBackground(minusButton, "normal");

      JButton plusButton = new JButton("+");
      setButtonBackground(plusButton, "normal");
      JLabel quantityLabel = new JLabel(" " + quantity + " ");

      itemPanel.setBackground(Color.WHITE);
      nameLabel.setBackground(Color.WHITE);
      quantityLabel.setBackground(Color.WHITE);

      minusButton.addActionListener(e -> updateCartItem(item, false));
      plusButton.addActionListener(e -> updateCartItem(item, true));

      itemPanel.add(nameLabel);
      itemPanel.add(minusButton);
      itemPanel.add(quantityLabel);
      itemPanel.add(plusButton);
      cartItemsPanel.add(itemPanel);
    }

    cartPanel.revalidate();
    cartPanel.repaint();
  }

  private static void updateCartItem(String item, boolean isAdd) {
    int currentQuantity = cart.getOrDefault(item, 0);
    int itemPrice = burgers.getOrDefault(item, 0) + sides.getOrDefault(item, 0) + drinks.getOrDefault(item, 0);

    if (isAdd) {
      cart.put(item, currentQuantity + 1);
      total += itemPrice;
    } else if (currentQuantity > 1) {
      cart.put(item, currentQuantity - 1);
      total -= itemPrice;
    } else {
      cart.remove(item);
      total -= itemPrice * currentQuantity;
    }

    totalLabel.setText("총 합계: " + total + "원");
    updateCartPanelContents();
  }

  private static JPanel createMenuPanel(Map<String, Integer> menuItems, String imageFolder) {
    JPanel menuPanel = new JPanel(new GridLayout(0, 3));
    menuPanel.setBackground(Color.WHITE);

    for (Map.Entry<String, Integer> entry : menuItems.entrySet()) {
      String itemName = entry.getKey();
      Integer price = entry.getValue();

      JPanel panel = new JPanel(new GridBagLayout());
      panel.setPreferredSize(new Dimension(200, 250));
      panel.setBackground(Color.WHITE);

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.anchor = GridBagConstraints.CENTER;

      ImageIcon icon = new ImageIcon("images/" + imageFolder + "/" + itemName + ".png");
      JLabel imageLabel = new JLabel(resizeImageSize(icon));
      JLabel nameLabel = new JLabel(itemName);
      JLabel priceLabel = new JLabel(price + "원");
      JButton addButton = new JButton("장바구니에 담기");
      setButtonBackground(addButton, "normal");

      addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          addToCart(itemName, price);
        }
      });

      panel.add(imageLabel, gbc);
      panel.add(nameLabel, gbc);
      panel.add(priceLabel, gbc);
      panel.add(addButton, gbc);
      menuPanel.add(panel);
    }

    return menuPanel;
  }

  private static JScrollPane createScrollPane(JPanel panel) {
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setPreferredSize(new Dimension(800, 600));
    scrollPane.getViewport().setBackground(Color.WHITE);

    // 스크롤바 색상 설정
    scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
    scrollPane.getHorizontalScrollBar().setBackground(Color.WHITE);

    // 스크롤바 버튼 색상 설정
    scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
      @Override
      protected void configureScrollBarColors() {
        this.thumbColor = new Color(231, 229, 228);
      }
    });

    return scrollPane;
  }

  private static void addToCart(String item, int price) {
    cart.put(item, cart.getOrDefault(item, 0) + 1);
    total += price;
    totalLabel.setText("총 합계: " + total + "원");
    updateCartPanelContents();
  }

  private static void showPaymentFrame() {
    if (cart.isEmpty()) {
      JOptionPane.showMessageDialog(null, "장바구니가 비어 있습니다.");
      return;
    }

    JFrame paymentFrame = new JFrame("결제");
    paymentFrame.setMinimumSize(new Dimension(300, 650));
    paymentFrame.setLayout(new BorderLayout());

    JPanel paymentLabelPanel = new JPanel(new BorderLayout()); // Create a panel for center-aligning paymentLabel
    JLabel paymentLabel = new JLabel("총 합계: " + total + "원", JLabel.CENTER); // Center-align text
    paymentLabelPanel.add(paymentLabel, BorderLayout.SOUTH); // Add paymentLabel to the center of paymentLabelPanel
    paymentLabelPanel.setPreferredSize(new Dimension(300, 50)); // Set height to 50 to accommodate paymentLabel

    JPanel cartContentsPanel = new JPanel();
    cartContentsPanel.setLayout(new BoxLayout(cartContentsPanel, BoxLayout.Y_AXIS));
    for (Map.Entry<String, Integer> entry : cart.entrySet()) {
      String item = entry.getKey();
      int quantity = entry.getValue();
      JLabel itemLabel = new JLabel(item + " x " + quantity, JLabel.CENTER); // Center-align text
      cartContentsPanel.add(itemLabel);
    }

    JButton receiptButton = new JButton("영수증 출력");
    setButtonBackground(receiptButton, "normal");
    receiptButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        printReceipt();

        // 영수증 출력이 완료되었습니다. 메시지 박스 출력
        JOptionPane.showMessageDialog(null, "영수증 출력이 완료되었습니다.");
      }
    });

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
    centerPanel.add(Box.createHorizontalGlue()); // Add horizontal glue to center-align horizontally
    centerPanel.add(cartContentsPanel); // Add cart contents panel
    centerPanel.add(Box.createHorizontalGlue()); // Add horizontal glue to center-align horizontally

    paymentFrame.add(paymentLabelPanel, BorderLayout.NORTH); // Add paymentLabelPanel to the top
    paymentFrame.add(centerPanel, BorderLayout.CENTER); // Add center-aligned panel
    paymentFrame.add(receiptButton, BorderLayout.SOUTH); // Add receipt button to the bottom
    paymentFrame.setVisible(true);
  }

  private static JPanel createLearnedThingsPanel() {
    JPanel learnedThingsPanel = new JPanel();
    learnedThingsPanel.setLayout(new FlowLayout());
    learnedThingsPanel.setBackground(Color.WHITE);

    JLabel colorLabel = new JLabel(" SLIDER EXAMPLE ");
    colorLabel.setOpaque(true);
    JSlider[] sliders = new JSlider[3];

    // Create and configure sliders
    for (int i = 0; i < sliders.length; i++) {
      sliders[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
      sliders[i].setPaintLabels(true);
      sliders[i].setPaintTicks(true);
      sliders[i].setMajorTickSpacing(50);
      sliders[i].setMinorTickSpacing(10);
      sliders[i].addChangeListener(e -> {
        int r = sliders[0].getValue();
        int g = sliders[1].getValue();
        int b = sliders[2].getValue();
        colorLabel.setBackground(new Color(r, g, b));
      });

      if (i == 0)
        sliders[i].setForeground(Color.RED);
      else if (i == 1)
        sliders[i].setForeground(Color.GREEN);
      else if (i == 2)
        sliders[i].setForeground(Color.BLUE);

      learnedThingsPanel.add(sliders[i]);
    }

    // Set initial color of the label
    colorLabel.setBackground(new Color(sliders[0].getValue(), sliders[1].getValue(), sliders[2].getValue()));
    learnedThingsPanel.add(colorLabel);

    return learnedThingsPanel;
  }

  private static void printReceipt() {
    try (PrintWriter out = new PrintWriter(new FileWriter("receipt.csv"))) {
      out.println("동국대학교 키오스크 영수증");
      out.println("----------------------------");
      for (Map.Entry<String, Integer> entry : cart.entrySet()) {
        String item = entry.getKey();
        int quantity = entry.getValue();
        int price = burgers.getOrDefault(item, 0) + sides.getOrDefault(item, 0) + drinks.getOrDefault(item, 0);
        out.printf("%s, %d, %d원\n", item, quantity, price);
      }
      out.println("----------------------------");
      out.printf("총 합계: %d원\n", total);
      out.println("감사합니다!");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "영수증을 출력할 수 없습니다.");
    }
  }

  private static ImageIcon resizeImageSize(ImageIcon icon) {
    Image image = icon.getImage();
    Image newImg = image.getScaledInstance(200, 130, Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
  }

  private static void setButtonBackground(JButton button, String color) { // 버튼 배경색 설정 메소드 오버로딩
    if (color.equals("orange")) {
      button.setBackground(new Color(87, 83, 78)); // #F29300 색상 설정
    } else {
      button.setBackground(new Color(168, 162, 158)); // #F29300 색상 설정
    }

    button.setForeground(Color.WHITE); // 글자색 흰색
    button.setOpaque(true); // 배경색이 보이도록
    button.setBorderPainted(false); // 테두리 없애기 (필요한 경우에만)

  }
}
