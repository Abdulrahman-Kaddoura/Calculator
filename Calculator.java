import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {

    private JTextArea text;
    private JTextArea history;

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public Calculator() {
        JFrame frame = new JFrame("Calculator");

        Image icon = Toolkit.getDefaultToolkit().getImage("Icon.png");

        frame.setSize(325, 525);
        frame.setTitle("Calculator");
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setResizable(false);

        // frame.setUndecorated(true);

        JPanel topCol = new JPanel();
        topCol.setPreferredSize(new Dimension(325, 50));
        topCol.setBackground(new Color(34, 34, 34));

        JPanel textArea = new JPanel();
        textArea.setPreferredSize(new Dimension(325, 100));
        textArea.setLayout(new BoxLayout(textArea, BoxLayout.Y_AXIS));
        textArea.setBackground(new Color(34, 34, 34));

        text = new JTextArea();
        text.setBackground(new Color(34, 34, 34));
        text.setPreferredSize(new Dimension(300, 75));
        text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        text.setText("0");
        text.setFocusable(false);
        text.setForeground(Color.WHITE);
        text.setMargin(new Insets(10, 0, 0, 10));
        text.setFont(new Font("Arial", Font.BOLD, 50));

        history = new JTextArea();
        history.setPreferredSize(new Dimension(300, 25));
        history.setFocusable(false);
        history.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        textArea.add(history);
        textArea.add(text);

        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(325, 325));
        // buttons.setBorder(border);
        buttons.setBackground(new Color(34, 34, 34));

        RoundedButton b1 = new RoundedButton("1", 10);
        RoundedButton b2 = new RoundedButton("2", 10);
        RoundedButton b3 = new RoundedButton("3", 10);
        RoundedButton b4 = new RoundedButton("4", 10);
        RoundedButton b5 = new RoundedButton("5", 10);
        RoundedButton b6 = new RoundedButton("6", 10);
        RoundedButton b7 = new RoundedButton("7", 10);
        RoundedButton b8 = new RoundedButton("8", 10);
        RoundedButton b9 = new RoundedButton("9", 10);
        RoundedButton b0 = new RoundedButton("0", 10);

        RoundedButton Add = new RoundedButton("+", 10);
        RoundedButton Subtract = new RoundedButton("-", 10);
        RoundedButton Multiply = new RoundedButton("x", 10);
        RoundedButton Divide = new RoundedButton("÷", 10);
        RoundedButton Mod = new RoundedButton("%", 10);
        RoundedButton Square = new RoundedButton("x²", 10);
        RoundedButton Root = new RoundedButton("√", 10);
        RoundedButton Equals = new RoundedButton("=", 10);
        RoundedButton Decimal = new RoundedButton(".", 10);
        RoundedButton Clear = new RoundedButton("C", 10);
        RoundedButton ToggleSign = new RoundedButton("+/-", 10);
        RoundedButton Del = new RoundedButton("DEL", 10);

        RoundedButton tempButton1 = new RoundedButton("", 10);
        RoundedButton tempButton2 = new RoundedButton("", 10);

        buttons.setLayout(new GridLayout(6, 4, 3, 3));

        buttons.add(Mod);
        buttons.add(tempButton1);
        buttons.add(Clear);
        buttons.add(Del);
        buttons.add(tempButton2);
        buttons.add(Square);
        buttons.add(Root);
        buttons.add(Divide);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);
        buttons.add(Multiply);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(Subtract);
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(Add);
        buttons.add(ToggleSign);
        buttons.add(b0);
        buttons.add(Decimal);
        buttons.add(Equals);

        b0.addActionListener(new ButtonHandler(this));
        b1.addActionListener(new ButtonHandler(this));
        b2.addActionListener(new ButtonHandler(this));
        b3.addActionListener(new ButtonHandler(this));
        b4.addActionListener(new ButtonHandler(this));
        b5.addActionListener(new ButtonHandler(this));
        b6.addActionListener(new ButtonHandler(this));
        b7.addActionListener(new ButtonHandler(this));
        b8.addActionListener(new ButtonHandler(this));
        b9.addActionListener(new ButtonHandler(this));
        Add.addActionListener(new ButtonHandler(this));
        Subtract.addActionListener(new ButtonHandler(this));
        Multiply.addActionListener(new ButtonHandler(this));
        Divide.addActionListener(new ButtonHandler(this));
        Mod.addActionListener(new ButtonHandler(this));
        Square.addActionListener(new ButtonHandler(this));
        Root.addActionListener(new ButtonHandler(this));
        Equals.addActionListener(new ButtonHandler(this));
        Decimal.addActionListener(new ButtonHandler(this));
        Clear.addActionListener(new ButtonHandler(this));
        ToggleSign.addActionListener(new ButtonHandler(this));
        Del.addActionListener(new ButtonHandler(this));

        for (Component c : buttons.getComponents()) {
            if (c instanceof RoundedButton) {
                RoundedButton btn = (RoundedButton) c;
                String hello = btn.getText();
                if (hello.matches("\\d")) {
                    HelperMethods.colorButton(btn, Color.WHITE, new Color(59, 59, 59));
                    HelperMethods.addHoverEffect(btn, new Color(59, 59, 59), new Color(50, 50, 50));
                } else {
                    HelperMethods.colorButton(btn, Color.WHITE, new Color(50, 50, 50));
                    HelperMethods.addHoverEffect(btn, new Color(50, 50, 50), new Color(59, 59, 59));
                }
                HelperMethods.changeFontSize(btn, 18);
            }
        }
        HelperMethods.colorButton(Equals, Color.darkGray, new Color(106, 188, 226));
        HelperMethods.addHoverEffect(Equals, new Color(106, 188, 226), new Color(118, 225, 249));

        frame.add(topCol, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        private Calculator calc;

        public ButtonHandler(Calculator calc) {
            this.calc = calc;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            switch (cmd) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    if (calc.text.getText().equals("0")) {
                        calc.text.setText(cmd);
                    } else {
                        calc.text.setText(calc.text.getText() + cmd);
                    }
                }
                case "+" -> {
                    
                }
                // case "-":
                // case "x":
                // case "÷":
                // case "%":
                // case "x²":
                // case "√":
                // case "=":
                // case ".":
                case "C" -> {
                    calc.text.setText("0");
                }
                // case "+/-":
                // case "DEL":
                    // break;
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}