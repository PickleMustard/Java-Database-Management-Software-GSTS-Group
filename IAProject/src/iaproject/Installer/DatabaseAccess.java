
//package iaproject.Installer;
/*
*
* This class controls access to the database
* Allows creation of tables and databases
* 
*
*/

//import iaproject.ProgramStream.ErrorPopup;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

public class DatabaseAccess {

    private final String[] TABLE_NAMES = {"BankInfo", "BudgetInfo", "SupplierInfo", "CountryInfo", "DealInfo"};
    private final String[] BANK_INFO_COLUMNS = { "BankName", "Country", "CreditRisk", "LengthOfLoan", "LengthOfLoanMeasurement", "ProfitEarned", "BankType", "BankFees"};
    private final String[] BUDGET_INFO_COLUMNS = {"TimeFrame", "TheoreticalBudget"};
    private final String[] SUPPLIER_INFO_COLUMNS = {"Supplier", "SupplierFee"};
    private final String[] COUNTRY_INFO_COLUMNS = {"CountryName", "InterestRate", "CreditRisk", "ProfitEarned"};
    private final String[] DEAL_INFO_COLUMNS = {"TradeNumber", "BankName", "Partner","SupplierName","CargoRental", "Destination", "DocValue","TransactionType", "Tenor", "CommodityWeight", "DiscountDate", "MaturityDate", "ProfitEarned", "CreditSupportFee"};

    private int x;
    private int y;
    private int width;
    private int height;
    
    public String[] getTABLE_NAMES() {
        return TABLE_NAMES;
    }

    public String[] getBANK_INFO_COLUMNS() {
        return BANK_INFO_COLUMNS;
    }

    public String[] getBUDGET_INFO_COLUMNS() {
        return BUDGET_INFO_COLUMNS;
    }

    public String[] getSUPPLIER_INFO_COLUMNS() {
        return SUPPLIER_INFO_COLUMNS;
    }

    public String[] getCOUNTRY_INFO_COLUMNS() {
        return COUNTRY_INFO_COLUMNS;
    }

    public String[] getDEAL_INFO_COLUMNS() {
        return DEAL_INFO_COLUMNS;
    }
    
    private String dbName;
    private Object[][] data;
    private Connection dbConn;
    
    public DatabaseAccess(String dbName)
    {
        this.dbName = dbName;
        this.data = null;
        setDbConn();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width/2;
        int centerY = screenSize.height/2;
        x = (centerX-480);
        y = (centerY-320);
        width = 960;
        height = 640;
    }
    
    public DatabaseAccess()
    {
        this.dbName= "";
        this.data = null;
        this.dbConn = null;
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width/2;
        int centerY = screenSize.height/2;
        x = (centerX-480);
        y = (centerY-320);
        width = 960;
        height = 640;
    }

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public Object[][] getData(String tableName, String[] tableHeaders) 
    {
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM " + tableName;
        ArrayList<ArrayList> dataList = new ArrayList<>();
        
        try
        {
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while(rs.next())
            {
                ArrayList<String> row = new ArrayList<String>();
                for(int i=0; i<columnCount; i++)
                {
                    row.add(rs.getString(tableHeaders[i]));
                }
                dataList.add(row);
            }
            this.data = new Object[dataList.size()][columnCount];
            for (int i=0; i<dataList.size(); i++)
            {
                ArrayList<String> row = new ArrayList<String>();
                row = dataList.get(i);
                for (int j=0; j<columnCount; j++)
                {
                    this.data[i][j] = row.get(j);
                }
            }  
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Connection getDbConn() {
        return dbConn;
    }

    public void setDbConn() {
        String connectionURL = "jdbc:derby:" + this.dbName;
        this.dbConn = null;
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);  
        }
        catch (SQLException err)
        {
            System.out.println(err.toString());
            ErrorPopup objEF = new ErrorPopup(err.toString(),x,y,width,height);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.toString());
            ErrorPopup objEF = new ErrorPopup(ex.toString(), x,y,width,height);
        }
    }

    public void closeDbConn()
    {
        try
        {
            this.dbConn.close();
        }
        catch(Exception err)
        {
            System.out.println(err.toString());
           //ErrorPopup objEF = new ErrorPopup(err.toString(), x,y,height,width);
        }
    }
    
    public void createDb(String newDbName)
    {
       this.dbName = newDbName;
       String connectionURL = "jdbc:derby:" + this.dbName + ";create=true";
       
       try
       {
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           this.dbConn = DriverManager.getConnection(connectionURL);
           this.dbConn.close();
       }
       catch (Exception err)
       {
           System.err.println("DB creation error.");
           err.printStackTrace(System.err);
           System.exit(0);
       }
    }
    
    public void createTable(String newTable, String dbName)
    {
        Statement s;
        setDbName(dbName);
        setDbConn();
        try
        {
            s = this.dbConn.createStatement();
            s.execute(newTable);
            this.dbConn.close();
        }
        catch (SQLException err)
        {
            System.out.println(err.toString());
            ErrorPopup objEF = new ErrorPopup(err.toString(),x,y,height,width);
        }
    }
    
    public String toString()
    {
        return "The database is called " + getDbName();
    }
}   