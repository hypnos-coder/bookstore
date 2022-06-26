import javax.swing.*;
import java.awt.*;

public class splash extends JWindow {
    public splash() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        Icon img = new ImageIcon(this.getClass().getResource("images/book-school.gif"));
        JLabel label = new JLabel(img);

        getContentPane().add(label);

        setBounds(((int) d.getWidth() - 500) / 2, ((int) d.getHeight() - 300) / 2, 500, 300);
        setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dispose();

    }

}
