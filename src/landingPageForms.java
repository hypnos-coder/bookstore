import javax.swing.*;
import java.awt.*;

public class landingPageForms extends  JDialog{
    private JTextField textField1;
    private JButton contactUsButton;
    private JComboBox comboBox1;
    private JPanel mainPanel;
    private JPanel head;
    private JPanel aside;
    private JPanel bookPanel;

    public landingPageForms(JFrame parent){
        super(parent);
        setTitle("Login");
        setMinimumSize(new Dimension(450, 474));
        setVisible(true);
        setLocationRelativeTo(parent);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
