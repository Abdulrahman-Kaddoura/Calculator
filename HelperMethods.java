import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class HelperMethods {
    public static RoundedButton colorButton(RoundedButton b, Color fg, Color bg) {
        b.setForeground(fg);
        b.setBackground(bg);
        return b;
    }

    public static void changeFontSize(RoundedButton b, int newSize) {
        Font currentFont = b.getFont();
        b.setFont(new Font(currentFont.getName(), currentFont.getStyle(), newSize));
    }

    public static void addHoverEffect(JButton button, Color normalColor, Color hoverColor) {
        button.setBackground(normalColor);
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(normalColor);
            }
        });
    }
}
