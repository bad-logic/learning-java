package fundamentals.practise.gui;

import javax.swing.*;
import java.awt.event.*;

public class Counter extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField counterText;

    private int counter = 0;

    public Counter() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        counterText.setText(String.valueOf(counter));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        this.counter++;
        counterText.setText(String.valueOf(counter));
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Counter dialog = new Counter();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
