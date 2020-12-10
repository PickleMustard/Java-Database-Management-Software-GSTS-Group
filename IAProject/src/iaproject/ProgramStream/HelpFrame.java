
//package iaproject.ProgramStream;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HelpFrame extends JFrame {
    private JLabel helpLabel;
    private JPanel helpPanel;
    private JLabel systemUse;
    GroupLayout helpPanelLayout;
    GroupLayout frameLayout;
    
    public HelpFrame(int x, int y, int width, int height){
        helpPanel = new JPanel();
        helpLabel = new JLabel();
        systemUse = new JLabel();
        
        this.setBounds(x, y, width, height);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        helpLabel.setText("<html>For use of the system, open the Main File.<br> From there, the database can be edited. <br>To select an entry, select it in the table then click select. <br>To delete the entry, select it in the table, then click delete. <br>Finally, to add new entries or modify existing ones, click on Modify and Insert.</html>");

        systemUse.setText("USING THE SYSTEM:");

        helpPanelLayout = new GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(helpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(helpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(systemUse)
                    .addComponent(helpLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(885, Short.MAX_VALUE))
        );
        helpPanelLayout.setVerticalGroup(helpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(systemUse)
                .addGap(41, 41, 41)
                .addComponent(helpLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        frameLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameLayout.setVerticalGroup(frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        this.setVisible(true);
    }
}
