
//package iaproject.ProgramStream;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 *  Pop up to show errors in the program to the user
 */
public class ErrorPopup extends JFrame implements ActionListener {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private JButton exitWindow;
    private JPanel popUpPanel;
    private JLabel errorInformation;
    private Color textColor;
    private Color backgroundColor;
    private GroupLayout panelLayout;
    private Font textFont;
    
    public ErrorPopup(String errorMessage, int x, int y, int width, int height)
    {
        super("ERROR");
        
        this.x = x;
        this.y = y;
        this.width = width/2;
        this.height = height/2;
        
        this.setBounds(this.x, this.y, this.width, this.height);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Create button to exit window
        exitWindow = new JButton("Exit Window");
        exitWindow.addActionListener(this);
        //Color of the text
        textColor = new Color(204,0,0);
        //Font of the text
        textFont = new Font("Times New Roman", Font.BOLD, 36);
        //Color of the background
        backgroundColor = new Color(180,180,180);
        //Set the error text and color of the text
        errorInformation = new JLabel(errorMessage);
        errorInformation.setForeground(textColor);
        errorInformation.setFont(textFont);
        //Create panel and layout for it
        popUpPanel = new JPanel();
        panelLayout = new GroupLayout(popUpPanel);
        popUpPanel.setLayout(panelLayout);
        popUpPanel.setBackground(backgroundColor);
        exitWindow.setBackground(backgroundColor);
        //Add button and label to the panel
        //set Horizontal group for window group layout
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(GroupLayout.PREFERRED_SIZE, ((int)(this.width * 1/4)), Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(errorInformation)
                    .addComponent(exitWindow))
                .addContainerGap(((int)(this.width * 1/4)), Short.MAX_VALUE))
        );
        //Set vertical group for window group layout
       panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(GroupLayout.PREFERRED_SIZE, ((int)(this.height * 1/4)), Short.MAX_VALUE)
                .addComponent(errorInformation)
                .addGap(GroupLayout.PREFERRED_SIZE, ((int)(this.height * 1/4)), Short.MAX_VALUE)
                .addComponent(exitWindow)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        this.add(popUpPanel);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object sourceObject = e.getSource();
       if(sourceObject == exitWindow)
       {
           this.dispose();
       }
    }
    
}
