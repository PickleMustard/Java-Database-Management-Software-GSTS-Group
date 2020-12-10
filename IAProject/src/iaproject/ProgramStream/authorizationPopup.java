
//package iaproject.ProgramStream;

//import iaproject.Installer.DatabaseAccess;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class authorizationPopup extends JFrame implements ActionListener {
    
    private DatabaseAccess datAcs;
    
    private   JButton cancelDeletion;
    private   JButton continueDeletion;
    private   JLabel authorizePrompt;
    private   JPanel authorizationPanel;
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    private Object[] dealToBeDeleted;
    private Object[][] allDeals;
    
    private GroupLayout panelLayout;
    private GroupLayout frameLayout;
    
    public authorizationPopup(int x, int y, int width, int height, Object[] deal, Object[][] allDeals){
        
        authorizationPanel = new JPanel();
        continueDeletion = new   JButton();
        cancelDeletion = new   JButton();
        authorizePrompt = new   JLabel();
        
        this.x = x;
        this.y = y; 
        this.width = width;
        this.height = height;
        this.allDeals = allDeals;
        
        datAcs = new DatabaseAccess("MainFile");
        dealToBeDeleted = deal;
        
        this.setBounds(x, y, width, height);
        setDefaultCloseOperation(  WindowConstants.DISPOSE_ON_CLOSE);

        continueDeletion.setText("Continue");
        continueDeletion.addActionListener(this);
        cancelDeletion.setText("Cancel");
        cancelDeletion.addActionListener(this);
        authorizePrompt.setText("<html>Are you sure you want to delete this entry?<br />It will be deleted permanently from the database</html>");

          panelLayout = new   GroupLayout(authorizationPanel);
        authorizationPanel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(authorizePrompt,   GroupLayout.PREFERRED_SIZE, 283,   GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(cancelDeletion)
                        .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(continueDeletion)
                        .addGap(65, 65, 65))))
        );
        panelLayout.setVerticalGroup(panelLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(authorizePrompt,   GroupLayout.PREFERRED_SIZE, 105,   GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(  GroupLayout.Alignment.BASELINE)
                    .addComponent(continueDeletion)
                    .addComponent(cancelDeletion))
                .addGap(31, 31, 31))
        );

         frameLayout = new   GroupLayout(getContentPane());
        getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(frameLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorizationPanel,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        frameLayout.setVerticalGroup(frameLayout.createParallelGroup(  GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorizationPanel,   GroupLayout.DEFAULT_SIZE,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        this.setVisible(true);
    }

    private void deleteGivenDeal()
    {
        int dealNumber = Integer.parseInt((String)dealToBeDeleted[0]);
        String query;
        Connection conn = datAcs.getDbConn();
        query = "DELETE From DealInfo"
                + " WHERE TradeNumber = " + dealNumber;
        try{
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.executeUpdate();
        }
        catch(SQLException err)
        {
                System.err.println(err);
                ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
        }
        for(int i = 0; i < allDeals.length; i++)
        {
            query = "UPDATE DealInfo "
                                + "SET TradeNumber = ?"
                                + " WHERE TradeNumber = " + i + " ";  
                            try{
                                PreparedStatement statement = conn.prepareStatement(query);
                                statement.setInt(1, i);
                                statement.executeUpdate();
                            }
                            catch(SQLException err)
                            {
                                 System.err.println(err);
                                ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object sourceObject = e.getSource();
        if(sourceObject == continueDeletion)
        {
            deleteGivenDeal();
            this.dispose();
        }
        else if(sourceObject == cancelDeletion)
        {
            this.dispose();
        }
    }

}
