package ordenacao;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import view.ViewPrincipal;

/**
 *
 * @author cassio
 */
public class Main {
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, null, "ORDENAÇÃO - V1.0",
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/img/icon.png"));
        
        ViewPrincipal view = new ViewPrincipal();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        
    }
}
