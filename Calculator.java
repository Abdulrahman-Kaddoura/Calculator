import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {

    private final JTextArea text;
    private final JTextArea history;

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
        
        JPanel topCol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topCol.setPreferredSize(new Dimension(325, 50));
        topCol.setBackground(new Color(34, 34, 34));
        JButton bHistory = new JButton();
        bHistory.setPreferredSize(new Dimension(30, 20));
        HelperMethods.addHoverEffect(bHistory, new Color(34, 34, 34), new Color(96,96,96));
        bHistory.setIcon(new ImageIcon("his.png"));
        topCol.add(bHistory);

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
        text.setMargin(new Insets(9, 0, 0, 10));
        text.setFont(new Font("Arial", Font.BOLD, 50));

        history = new JTextArea();
        history.setPreferredSize(new Dimension(300, 25));
        history.setFocusable(true);
        history.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        history.setMargin(new Insets(10, 0, 0, 10));
        history.setFont(new Font("Arial", 0, 15));
        history.setForeground(Color.lightGray);
        history.setBackground(new Color(34, 34, 34));

        textArea.add(history);
        textArea.add(text);

        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(325, 325));
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
        RoundedButton Multiply = new RoundedButton("×", 10);
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
            if (c instanceof RoundedButton btn) {
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

    private boolean pressedOperator = false;
    private double num1;
    private double num2;
    private double answerD;
    private int answerI;
    private boolean adding;
    private boolean subtracting;
    private boolean multiplying;
    private boolean dividing;
    private boolean modding;

    private class ButtonHandler implements ActionListener {
        private final Calculator calc;

        public ButtonHandler(Calculator calc) {
            this.calc = calc;
        }

        private void clearText() {
            text.setText("0");
        }

        private void clearHistory() {
            history.setText("");
        }

        private void resetOperators() {
            adding = false;
            subtracting = false;
            multiplying = false;
            dividing = false;
            modding = false;
        }

        private boolean checkDouble(double x) {
            return Math.round(x) != x;
        }

        private void setAnswerInt(double x) {
            answerI = (int) x;
            checkLength(answerI);
            if (answerI < 0) {
                text.setText(String.valueOf(-answerI) + "-");
            } else {
                text.setText(String.valueOf(answerI));
            }
        }

        private void setAnswerDouble(double x) {
            checkLength(x);
            if (x < 0) {
                text.setText(String.valueOf(-x) + "-");
            } else {
                text.setText(String.valueOf(x));
            }
        }

        private double parseDisplayText(String displayText) {
            if (displayText.endsWith("-")) {
                String numberPart = displayText.substring(0, displayText.length() - 1);
                return -Double.parseDouble(numberPart);
            } else {
                return Double.parseDouble(displayText);
            }
        }

        private void checkLength(Object x) {
            if (x instanceof Double y) {
                String l = String.valueOf(Math.abs(y));
                if (l.length() <= 9) {
                    // do nothing here. i could fix it but it works so ima leave the if as is
                } else if (l.length() >= 14) {
                    changeFontSize(30);
                }
            } else {
                String l = String.valueOf(Math.abs((Integer) x));
                if (l.length() <= 9) {
                    // do nothing here. i could fix it but it works so ima leave the if as is
                } else if (l.length() >= 14) {
                    changeFontSize(30);
                }
            }
        }

        private void changeFontSize(int x) {
            text.setFont(new Font("Arial", Font.BOLD, x));
            text.setMargin(new Insets(20, 0, 0, 10));
        }

        private void resetFontSize() {
            text.setFont(new Font("Arial", Font.BOLD, 50));
            text.setMargin(new Insets(9, 0, 0, 10));
        }

        @Override
        @SuppressWarnings("UnnecessaryReturnStatement")
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            JTextArea text = calc.text;
            JTextArea history = calc.history;

            switch (cmd) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    if (pressedOperator) {
                        pressedOperator = false;
                        clearText();
                    }
                    if (text.getText().equals("0")) {
                        text.setText(cmd);
                    } else {
                        text.setText(text.getText() + cmd);
                    }
                }
                case "+" -> {
                    resetOperators();
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(" + " + num1Str);
                    pressedOperator = true;
                    adding = true;
                }
                case "-" -> {
                    resetOperators();
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(" - " + num1Str);
                    pressedOperator = true;
                    subtracting = true;
                }
                case "×" -> {
                    resetOperators();
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(" × " + num1Str);
                    pressedOperator = true;
                    multiplying = true;
                }
                case "÷" -> {
                    resetOperators();
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(" ÷ " + num1Str);
                    pressedOperator = true;
                    dividing = true;
                }
                case "%" -> {
                    resetOperators();
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(" % " + num1Str);
                    pressedOperator = true;
                    modding = true;
                }
                case "x²" -> {
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(String.format("sqr(%s)", num1Str));
                    try {
                        Math.pow(num1, 2);
                    } catch (ArithmeticException omg) {
                        text.setText("Lol");
                        return;
                    }
                    answerD = num1 * num1;
                    if (!checkDouble(answerD)) {
                        setAnswerInt(answerD);
                    } else {
                        setAnswerDouble(answerD);
                    }
                    pressedOperator = true;
                    modding = true;
                }
                case "√" -> {
                    String num1Str = text.getText();
                    num1 = parseDisplayText(num1Str);
                    history.setText(String.format("root(%s)", num1Str));
                    try {
                        Math.sqrt(num1);
                    } catch (ArithmeticException omg) {
                        text.setText("Lol");
                        return;
                    }
                    answerD = Math.sqrt(num1);
                    if (!checkDouble(answerD)) {
                        setAnswerInt(answerD);
                    } else {
                        setAnswerDouble(answerD);
                    }
                    pressedOperator = true;
                }
                case "=" -> {
                    String num2Str = text.getText();
                    num2 = parseDisplayText(num2Str);
                    if (adding) {
                        answerD = num1 + num2;
                        adding = false;
                    } else if (subtracting) {
                        answerD = num1 - num2;
                        subtracting = false;
                    } else if (multiplying) {
                        answerD = num1 * num2;
                        multiplying = false;
                    } else if (dividing) {
                        if (num2 == 0) {
                            dividing = false;
                            return;
                        }
                        answerD = num1 / num2;
                        dividing = false;
                    } else if (modding) {
                        answerD = num1 % num2;
                        modding = false;
                    }
                    if (!checkDouble(answerD)) {
                        setAnswerInt(answerD);
                    } else {
                        setAnswerDouble(answerD);
                    }
                    history.setText(" = " + num2Str + " " + history.getText());
                }
                case "." -> {
                    if (pressedOperator) {
                        pressedOperator = false;
                        text.setText("0.");
                    }
                    else if (text.getText().equals("0")) {
                        text.setText("0.");
                    }
                    else if (text.getText().contains(".")) {
                        return;
                    }
                    else if (text.getText().endsWith("-")) {
                        String numberPart = text.getText().substring(0, text.getText().length() - 1);
                        text.setText(numberPart + ".-");
                    }
                    else {
                        text.setText(text.getText() + ".");
                    }
                }
                case "C" -> {
                    text.setText("0");
                    clearHistory();
                    resetFontSize();
                    pressedOperator = false;
                }
                case "+/-" -> {
                    if (text.getText().equals("0")) {
                        return;
                    }

                    double currentNum = parseDisplayText(text.getText());
                    currentNum = -currentNum;

                    if (!checkDouble(currentNum)) {
                        setAnswerInt(currentNum);
                    } else {
                        setAnswerDouble(currentNum);
                    }

                    if (pressedOperator) {
                        num1 = currentNum;
                        String historyText = history.getText();
                        if (historyText.contains(" + ")) {
                            history.setText(historyText.replace(" + ", " - "));
                        } else if (historyText.contains(" - ")) {
                            history.setText(historyText.replace(" - ", " + "));
                        } else if (historyText.contains(" × ")) {
                            String newDisplayValue = text.getText();
                            history.setText(" × " + newDisplayValue);
                        } else if (historyText.contains(" ÷ ")) {
                            String newDisplayValue = text.getText();
                            history.setText(" ÷ " + newDisplayValue);
                        } else if (historyText.contains(" % ")) {
                            String newDisplayValue = text.getText();
                            history.setText(" % " + newDisplayValue);
                        }
                    }
                }
                case "DEL" -> {
                    if (text.getText().length() == 1 || text.getText().equals("0")) {
                        clearText();
                    } else {
                        text.setText(text.getText().substring(0, text.getText().length() - 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Calculator calculator = new Calculator();
    }
}