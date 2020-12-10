
//package iaproject.ProgramStream;

//import iaproject.Installer.DatabaseAccess;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 *
 * Will create window to display the database in its entirety and allow to edit/add/delete/modify entries
 * 
 */
public class TableWindow extends JFrame implements MouseListener, ActionListener, KeyListener {
    
    private final String[] COLUMN_NAMES = {"Deal Key", "Bank Name", "Bank's Country", "Bank Credit Risk", "Length of Loan", "Supplier", "Supplier Fees", "Discount Date", "Profit Earned"};
    
    private DatabaseAccess datAcs;
    private String[] dealColumnNames;
    private Object[][] allDeals;
    private Object[] selectedDeal;
    
    private JPanel selectionPanel;
    private JPanel tablePanel;
    private JScrollPane tableScroll;
    private JButton dealInfo;
    private JButton deleteDeal;
    private JTable mainFile;
    private JTable selectedFile;
    private GroupLayout selectionLayout;
    private GroupLayout panelLayout;
    private GroupLayout tableLayout;
    private Object[][] tableData = null;
    private DatabaseAccess databaseObject;
    private JTextField searchField;
    private String searchNumber;
    private int searchedNumber;
    
    //size of the window
    private int width;
    private int height;
    private int x; 
    private int y;
    private int rowSelected;
    
    private Color tableBackground;
    private Color buttonBackground;
    
    
    public TableWindow(int x, int y, int width, int height, String name){
        //Give the window a name
        super(name);
        //Set the size
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.setBounds(x, y, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchField = new JTextField("Trade Number");
        searchField.addMouseListener(this);
        searchField.addKeyListener(this);
        
        datAcs = new DatabaseAccess("MainFile");
         dealColumnNames = datAcs.getDEAL_INFO_COLUMNS();
         allDeals = datAcs.getData("DealInfo", dealColumnNames);
        
        //Set colors
        tableBackground  = new Color(158,158,158);
        buttonBackground = new Color(96,125,139);
        
        databaseObject = new DatabaseAccess("MainFile");
        
        //Instantiate the Scrollpane 
        tablePanel = new JPanel();
        tableLayout = new GroupLayout(tablePanel);
        tablePanel.setLayout(tableLayout);
        tablePanel.setBackground(tableBackground);
        
        //Instantiate the button group layout and panel
        selectionPanel = new JPanel();
        selectionLayout = new GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionLayout);
        selectionPanel.setBackground(buttonBackground); 
        
        //Instantiate buttons
        deleteDeal = new JButton("Delete");
        deleteDeal.addActionListener(this);
        dealInfo = new JButton("Add or Change");
        dealInfo.addActionListener(this);
        
        //Give the window its group layout
        panelLayout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(panelLayout);
        
        getTableData();
        tableScroll = new JScrollPane(mainFile);
        mainFile.setFillsViewportHeight(true);
        mainFile.addMouseListener(this);
         setLayout();
        
        //set the visibility of the window
        this.setVisible(true);
    }
     public TableWindow(int x, int y, int width, int height, String name, JTable selectedItems){
        //Give the window a name
        super(name);
        //Set the size
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.setBounds(x, y, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchField = new JTextField("Trade Number");
        searchField.addMouseListener(this);
        searchField.addKeyListener(this);
        
        datAcs = new DatabaseAccess("MainFile");
         dealColumnNames = datAcs.getDEAL_INFO_COLUMNS();
         allDeals = datAcs.getData("DealInfo", dealColumnNames);
        
        //Set colors
        tableBackground  = new Color(158,158,158);
        buttonBackground = new Color(96,125,139);
        
        databaseObject = new DatabaseAccess("MainFile");
        
        //Instantiate the Scrollpane 
        tablePanel = new JPanel();
        tableLayout = new GroupLayout(tablePanel);
        tablePanel.setLayout(tableLayout);
        tablePanel.setBackground(tableBackground);
        
        //Instantiate the button group layout and panel
        selectionPanel = new JPanel();
        selectionLayout = new GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionLayout);
        selectionPanel.setBackground(buttonBackground); 
        
        //Instantiate buttons
        deleteDeal = new JButton("Delete");
        deleteDeal.addActionListener(this);
        dealInfo = new JButton("Add or Change");
        dealInfo.addActionListener(this);
        
        //Give the window its group layout
        panelLayout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(panelLayout);
        
        getTableData();
        this.selectedFile = selectedItems;
        tableScroll = new JScrollPane(selectedFile);
        selectedFile.setFillsViewportHeight(true);
        selectedFile.addMouseListener(this);
         setSelectedLayout();
        
        //set the visibility of the window
        this.setVisible(true);
    }
    private void setSelectedLayout(){
        
        tableLayout.setHorizontalGroup(tableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(searchField)
            .addComponent(selectedFile.getTableHeader())
            .addComponent(selectedFile)
        );
        tableLayout.setVerticalGroup(tableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectedFile.getTableHeader(), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectedFile, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
            )
        );
        selectionLayout.setHorizontalGroup(selectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(dealInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteDeal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        selectionLayout.setVerticalGroup(selectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(selectionLayout.createSequentialGroup()
                        .addComponent(dealInfo, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteDeal, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
                )
        );
        //set Horizontal group for window group layout
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, ((int)(width * 3/4)), GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectionPanel, GroupLayout.DEFAULT_SIZE, ((int)(width*1/4)), Short.MAX_VALUE))
        );
        //Set vertical group for window group layout
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }
    private void setLayout(){
        tableLayout.setHorizontalGroup(tableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(searchField)
            .addComponent(mainFile.getTableHeader())
            .addComponent(mainFile)
        );
        tableLayout.setVerticalGroup(tableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainFile.getTableHeader(), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainFile, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
            )
        );
        selectionLayout.setHorizontalGroup(selectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(dealInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteDeal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        selectionLayout.setVerticalGroup(selectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(selectionLayout.createSequentialGroup()
                        .addComponent(dealInfo, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteDeal, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
                )
        );
        //set Horizontal group for window group layout
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, ((int)(width * 3/4)), GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectionPanel, GroupLayout.DEFAULT_SIZE, ((int)(width*1/4)), Short.MAX_VALUE))
        );
        //Set vertical group for window group layout
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }
    private void getSpecifiedTableData()
    {
        Object[][] tempDataBank = null;
        Object[][] tempDataSupplier = null;
        Object[][] tempDataCountry = null;
        Object[][] tempDataDeal = null;
        
        ArrayList<ArrayList> dataList = new ArrayList<ArrayList>();
        ArrayList<Object> objectList;
        
        tempDataBank = databaseObject.getData(databaseObject.getTABLE_NAMES()[0], databaseObject.getBANK_INFO_COLUMNS());
        tempDataSupplier = databaseObject.getData(databaseObject.getTABLE_NAMES()[2], databaseObject.getSUPPLIER_INFO_COLUMNS());
        tempDataCountry = databaseObject.getData(databaseObject.getTABLE_NAMES()[3], databaseObject.getCOUNTRY_INFO_COLUMNS());
        tempDataDeal= databaseObject.getData(databaseObject.getTABLE_NAMES()[4], databaseObject.getDEAL_INFO_COLUMNS());
        
        String bankID;
        String supplierID;
        String country;
        
        for(int i = 0; i < tempDataDeal.length; i++)
        {
           objectList = new ArrayList<Object>();
           if(searchedNumber == Integer.parseInt((String)tempDataDeal[i][0]))
               {
                    objectList.add(tempDataDeal[i][0]);
                    for(int j = 0; j < tempDataBank.length; j++)
                    {
                        if(tempDataDeal[i][1].equals(tempDataBank[j][0]))
                        {
                            objectList.add(tempDataBank[j][0]);
                            objectList.add(tempDataBank[j][1]);
                            objectList.add(tempDataBank[j][2]);
                            objectList.add(tempDataBank[j][3]);
                        }
                    }
                    for(int j = 0; j < tempDataSupplier.length; j++)
                    {
                        if(tempDataDeal[i][2].equals(tempDataSupplier[j][0]))
                        {
                            objectList.add(tempDataSupplier[j][0]);
                            objectList.add(tempDataSupplier[j][1]);
                        }
                    }
                    objectList.add(tempDataDeal[i][11]);
                    objectList.add(tempDataDeal[i][13]);
                    dataList.add(objectList);
                }
            }
            try{
                this.tableData = new Object[dataList.size()][dataList.get(0).size()];
                    for (int i=0; i<dataList.size(); i++)
                    {
                        ArrayList<Object> row = new ArrayList<Object>();
                        row = dataList.get(i);
                        for (int j=0; j<COLUMN_NAMES.length; j++)
                        {
                            this.tableData[i][j] = row.get(j);
                        }
                    }
                }
                catch(IndexOutOfBoundsException e)
                {
                    System.out.println("There has been an error in creating the table");
                    this.tableData = new Object[0][0];
                }
                selectedFile = new JTable(tableData, COLUMN_NAMES);
        }
    
    private void getTableData()
    {
        Object[][] tempDataBank = null;
        Object[][] tempDataSupplier = null;
        Object[][] tempDataCountry = null;
        Object[][] tempDataDeal = null;
        
        ArrayList<ArrayList> dataList = new ArrayList<ArrayList>();
        ArrayList<Object> objectList;
        
        tempDataBank = databaseObject.getData(databaseObject.getTABLE_NAMES()[0], databaseObject.getBANK_INFO_COLUMNS());
        tempDataSupplier = databaseObject.getData(databaseObject.getTABLE_NAMES()[2], databaseObject.getSUPPLIER_INFO_COLUMNS());
        tempDataCountry = databaseObject.getData(databaseObject.getTABLE_NAMES()[3], databaseObject.getCOUNTRY_INFO_COLUMNS());
        tempDataDeal= databaseObject.getData(databaseObject.getTABLE_NAMES()[4], databaseObject.getDEAL_INFO_COLUMNS());
        
        String bankID;
        String supplierID;
        String country;
        
        for(int i = 0; i < tempDataDeal.length; i++)
        {
           objectList = new ArrayList<Object>();
           
            objectList.add(tempDataDeal[i][0]);
            for(int j = 0; j < tempDataBank.length; j++)
            {
                if(tempDataDeal[i][1].equals(tempDataBank[j][0]))
                {
                    objectList.add(tempDataBank[j][0]);
                    objectList.add(tempDataBank[j][1]);
                    objectList.add(tempDataBank[j][2]);
                    objectList.add(tempDataBank[j][3]);
                }
            }
            for(int j = 0; j < tempDataSupplier.length; j++)
            {
                if(tempDataDeal[i][2].equals(tempDataSupplier[j][0]))
                {
                    objectList.add(tempDataSupplier[j][0]);
                    objectList.add(tempDataSupplier[j][1]);
                }
            }
            objectList.add(tempDataDeal[i][11]);
            objectList.add(tempDataDeal[i][13]);
            dataList.add(objectList);
        }
        try{
            this.tableData = new Object[dataList.size()][dataList.get(0).size()];
                for (int i=0; i<dataList.size(); i++)
                {
                    ArrayList<Object> row = new ArrayList<Object>();
                    row = dataList.get(i);
                    for (int j=0; j<COLUMN_NAMES.length; j++)
                    {
                        this.tableData[i][j] = row.get(j);
                    }
                }    
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("There has been an error in creating the table");
                this.tableData = new Object[0][0];
            }
            mainFile = new JTable(tableData, COLUMN_NAMES);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourceObject = e.getSource();
        if(sourceObject == deleteDeal){
            DeleteDeal deletion = new DeleteDeal(mainFile, rowSelected, allDeals, x, y, width, height);
        }
        else if(sourceObject == dealInfo){
            //Open window with bunch of text fields to enter but cannot be left blank
            infoModificationWindow changeData = new infoModificationWindow(x,y,width, height, "INSERT");
            this.dispose();
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
           Object objSource =  e.getSource();
           if(objSource == mainFile){
                JTable table =(JTable) e.getSource();
                Point point = e.getPoint();
                rowSelected = table.rowAtPoint(point);
                if (e.getClickCount() == 2 && table.getSelectedRow() > -1) {
                    String tempStorage = (String)mainFile.getValueAt(rowSelected, 0);
                    for (Object[] allDeal : allDeals)
                    {
                        String key = (String) allDeal[0];
                        if(key.equals(tempStorage))
                        {
                            selectedDeal = allDeal;
                        }
                    }
                    inspectDeal temporaryInspect = new inspectDeal(selectedDeal, x, y, width,height, "Display");
                }
            }
           else if(objSource == selectedFile){
                JTable table =(JTable) e.getSource();
                Point point = e.getPoint();
                rowSelected = table.rowAtPoint(point);
                if (e.getClickCount() == 2 && table.getSelectedRow() > -1) {
                    String tempStorage = (String)selectedFile.getValueAt(rowSelected, 0);
                    for (Object[] allDeal : allDeals)
                    {
                        System.out.println((String)allDeal[0]);
                        String key = (String) allDeal[0];
                        if(key.equals(tempStorage))
                        {
                            selectedDeal = allDeal;
                        }
                    }
                    inspectDeal temporaryInspect = new inspectDeal(selectedDeal, x, y, width,height, "Display");
                }
            }
           else if(objSource == searchField)
           {
               searchField.setText("");
           }
           /*else{
               searchField.setText("Trade Number");
           }*/
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
           if(e.getKeyCode() == KeyEvent.VK_ENTER)
           {
               searchNumber = searchField.getText();
               try{
                    searchedNumber = Integer.parseInt(searchNumber);
               }
               catch(NumberFormatException err)
               {
                   ErrorPopup error = new ErrorPopup("Please enter a number into the field", x, y, width + (int)(width * .75) , height);
               }
               
               getSpecifiedTableData();
               TableWindow specified = new TableWindow(x, y, width, height, "Main File", selectedFile);
               this.dispose();
           }
        }
    }
