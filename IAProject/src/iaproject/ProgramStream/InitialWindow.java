
//package iaproject.ProgramStream;
//Purpose: The initial window for the Deal Tracker; Holds selection for access to the database
// and access to the calculation windows

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class InitialWindow extends JFrame implements ActionListener {
    
    //Todo: Insert logo of GSTS as background image
    //Create help menu for instructions on use
    //Create window for accessing data from database
    //Jpanels
    private LogoPanel logoPanel;
    private JPanel selectionPanel;
    //JButtons
    private JButton helpSelection;
    private JButton databaseSelection;
    //JLabels
    private JLabel authorIndicator;
    //Fonts
    private Font fontForButtons;
    private Font fontForAuthor;
    //Colors
    private Color backgroundColorSelection = new Color(211, 211,211);
    //Borders
    private Border panelBorderLogo;
    private Border panelBorderSelection;
    //Logo for Business
    private java.net.URL businessLogoURL = getClass().getResource("GSTS logo.png");
    //Placement of window
    private int x;
    private int y;
    //Size of window
    private int width;
    private int height;
    //Layout
    private GroupLayout selectionLayout;
    public InitialWindow(int x, int y, int width, int height, String name)
    {
        //Give the frame/window its name
        super(name);
        //Set the position and size of the window
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //Set the close operation, size, location, and layout of window
        this.setBounds(x, y, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1, 20, 5));
        
        try {
            //Instantiate the panels for the window
            logoPanel = new LogoPanel(width, height/2);
        } catch (URISyntaxException ex) {
           System.err.println();
        }
        selectionPanel = new JPanel();
        
        //Instantiate the labels of the window
        authorIndicator = new JLabel("Program created by Dillon Carter");
        
        //Instantiate the buttons of the window and add ActionListeners
        helpSelection = new JButton("Help Menu");
        databaseSelection = new JButton("Open Master File");
        helpSelection.addActionListener(this);
        databaseSelection.addActionListener(this);
        
        //Instantiate the fonts for the labels and buttons
        fontForButtons = new Font("Times New Roman", Font.PLAIN, 28);
        fontForAuthor = new Font("Times New Roman", Font.PLAIN, 12);
        
        
        //Instantiate the borders for the panels
        panelBorderLogo = BorderFactory.createLineBorder(Color.BLACK, 2);
        panelBorderSelection = BorderFactory.createLineBorder(Color.BLACK, 2);
        
        //Set the logos for Buttons and Labels
        helpSelection.setFont(fontForButtons);
        databaseSelection.setFont(fontForButtons);
        authorIndicator.setFont(fontForAuthor);
        
       //Background for Selection Panel
        selectionPanel.setBackground(backgroundColorSelection);
        
        //Set borders for the panels
        logoPanel.setBorder(panelBorderLogo);
        selectionPanel.setBorder(panelBorderSelection);
        
        //Add panels to the window
        this.add(logoPanel);
        this.add(selectionPanel);
        
       selectionLayout = new GroupLayout(selectionPanel);
       selectionPanel.setLayout(selectionLayout);
        //Set the horizontal group for the group layout of selection panel
          selectionLayout.setHorizontalGroup(selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(selectionLayout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addGroup(selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(authorIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(databaseSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(width/2 - 125 , width/2 - 125 , width/2 - 125 ))
        );
          //Set the vertical group for the group layout of selection panel
         selectionLayout.setVerticalGroup(selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGap(height /4 - 80,height /4 - 80,height /4 - 80)
                .addComponent(databaseSelection, GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGap(120,120,120)
                .addComponent(authorIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
         
        //Set window visible
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourceObject = e.getSource();
        if(sourceObject == databaseSelection)
        {   
            TableWindow informationVisualized = new TableWindow(x,y,width,height,"INFORMATION");
             this.dispose();
        }
        else if(sourceObject == helpSelection){
            HelpFrame help = new HelpFrame(x,y,width,height);
        }
    }
    
}
