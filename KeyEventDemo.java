import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class KeyEventDemo extends JFrame implements KeyListener,ActionListener{

    JTextArea displayArea;
    String frase = "Um pequeno jabuti xereta viu dez cegonhas felizes";
    double contadorCaracteres = 0;
    double contadorErros = 0;
    
    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        KeyEventDemo frame = new KeyEventDemo("Digite algo:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane();
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    private void addComponentsToPane() {
        String buttonLabels = "~1234567890-+QWERTYUIOP[]ASDFGHJKL:*ZXCVBNM,.?<>^v";
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 20));

       // JButton button = new JButton("Limpar");
       // button.addActionListener(this);
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));

        displayArea.setLineWrap(true);
        displayArea.addKeyListener(this);

        getContentPane().add(scrollPane, BorderLayout.PAGE_START);
        for (int i = 0; i < buttonLabels.length(); i++) {
            JButton b = new JButton(buttonLabels.substring(i, i + 1));  
            panel.add(b);
        }    
        JButton Backspace = new JButton("Backspace");  
        JButton Tab = new JButton("Tab");  
        JButton Caps = new JButton("Caps");  
        JButton Shift = new JButton("Shift");  
        JButton Enter = new JButton("Enter");  
        JButton Espaco = new JButton("                   ");  

        panel.add(Backspace);
        panel.add(Tab);
        panel.add(Caps);
        panel.add(Shift);
        panel.add(Enter);
        panel.add(Espaco);
        getContentPane().add(panel, BorderLayout.CENTER);
        //getContentPane().add(button, BorderLayout.PAGE_END);
    }
    
    public KeyEventDemo(String name) {
        super(name);
    }
    
    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }

    public void keyPressed(KeyEvent e) {
        displayInfo(e, "KEY PRESSED: ");
    }
    
    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
    }
    
    public void actionPerformed(ActionEvent e) {
        displayArea.setText("");
    }
    
    private void displayInfo(KeyEvent e, String keyStatus){
        int id = e.getID();
        String keyString="";
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString =""+ c;
        } 
        
        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }
        
        
        displayArea.append("" + keyString);
        //displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }
}
