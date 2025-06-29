import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Calculator {
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

    public static void main(String[] args) {
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
        

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        JPanel topCol = new JPanel();
        topCol.setPreferredSize(new Dimension(325, 50));
        topCol.setBackground(Color.blue);
        topCol.setBorder(border);

        JPanel textArea = new JPanel();
        textArea.setPreferredSize(new Dimension(325, 100));
        textArea.setLayout(new BoxLayout(textArea, BoxLayout.Y_AXIS));
        textArea.setBackground(Color.blue);
        textArea.setBorder(border);

        JTextArea text = new JTextArea();
        text.setBackground(Color.red);
        text.setPreferredSize(new Dimension(300, 75));
        text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JTextArea history = new JTextArea();
        history.setPreferredSize(new Dimension(300, 25));
        history.setFocusable(false);
        history.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        textArea.add(history);
        textArea.add(text);

        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(325, 325));
        buttons.setBorder(border);
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
}