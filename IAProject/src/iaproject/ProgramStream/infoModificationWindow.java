
//package iaproject.ProgramStream;

//import iaproject.Installer.DatabaseAccess;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

public class infoModificationWindow extends JFrame implements ActionListener {
    private final String[] BANK_POSITION = new String[]{"Confirming", "Counterparty", "Standby"};
    private final String[] TRANSACTION_TYPE = new String[]{"Transit", "ECA"};
    private final String[] COUNTRIES = new String[]{"Afghanistan", "Albania", "Algeria", 
        "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica",
        "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", 
        "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", 
        "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", 
        "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil",
        "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", 
        "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", 
        "Central African Republic", "Chad", "Chile", "China", "Christmas Island", 
        "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", 
        "The Democratic Republic of the Congo", "Cook Islands", "Costa Rica", 
        "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", 
        "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", 
        "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", 
        "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", 
        "France Metropolitan", "French Guiana", "French Polynesia", 
        "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", 
        "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", 
        "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", 
        "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", 
        "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", 
        "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", 
        "Kazakhstan", "Kenya", "Kiribati", "Democratic People's Republic of Korea", 
        "Korea", "Kuwait", "Kyrgyzstan", "People's Democratic Republic of Lao", "Latvia", 
        "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", 
        "Lithuania", "Luxembourg", "Macau", "The Former Yugoslav Republic of Macedonia", 
        "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", 
        "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", 
        "Federated States of Micronesia", "Republic of Moldova", "Monaco", "Mongolia", 
        "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", 
        "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", 
        "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", 
        "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", 
        "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", 
        "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", 
        "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", 
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", 
        "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", 
        "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", 
        "Solomon Islands", "Somalia", "South Africa", 
        "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", 
        "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", 
        "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", 
        "Syrian Arab Republic", "Taiwan", "Tajikistan", "United Republic of Tanzania", 
        "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", 
        "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", 
        "Ukraine", "United Arab Emirates", "United Kingdom", "United States", 
        "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", 
        "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", 
        "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
    private final String[] WEIGHT_MEASUREMENTS = new String[]{"LBS", "KGs"};
    private final String[] DATE_MEASUREMENTS = new String[]{"Days", "Weeks", "Years"};
    
    private String[] bankNamesAndAdd;
    private String[] bankNames;
    private String[] partnerNamesAndAdd;
    private String[] partnerNames;
    private String[] supplierNames;
    
    private Object[][] BANK_NAMES;
    private Object[][] PARTNER_NAMES;
    private Object[][] SUPPLIER_NAMES;
    
    private int lastDealNumber;
    
    //private String[] Banks;
  //  private String[] Partners;
    //private String[] Suppliers;
    
    private int width;
    private int height;
    private int x;
    private int y;
    
    private String bankName;
    private String countryOfBank;
    private int creditRiskOfBank;
    private int lengthOfLoanToBank;
    private String lengthOfLoanMeasurement;
    private int profitEarnedFromBank;
    private int volumeOfDealsFromBank;
    private int averageSizeOfDealsFromBank;
    private String bankPositionInDeal;
    private int fees;

    private String supplierName;
    private int supplierFee;
    
    private String countryName;
    private double interestRateOfCountry;
    private double creditRiskInCountry;
    private int profitEarnedInCountry;
    private int VolumeOfDealsInCountry;
    private int averageSizeOfDealsInCountry;
    
    private String dealBankName;
    private String dealPartnerName;
    private String dealSupplierName;
    private String transactionType;
    private double cargoRental;
    private int tenor;
    private int docValue;
    private String tenorMeasurement;
    private double commodityWeight;
    private String commodityWeightMeasurement;
    private double creditSupportFee;
    private String destination;
    private String discountDate;
    private String maturityDate;
    private int profitEarned;
    
    private JPanel currentPanel;
    
    private  JMenuBar dataInputModMenuBar;
    
    private  JMenu fileMenu;
    private  JMenu areasOfInformationMenu;
    
    private  JMenuItem bankInfoMenuItem;
    private  JMenuItem countryInfoMenuItem;
    private  JMenuItem dealInfoMenuItem;
    private  JMenuItem helpMenuItem;
    private  JMenuItem cancelMenuItem;
    private  JMenuItem supplierInfoMenuItem;
    
    private  JComboBox<String> bankCountryDropdown;
    private  JComboBox<String> bankNameDropdown;
    private  JComboBox<String> bankPositionDropdown;
    private  JComboBox<String> typeOfDateDropdown;
    private  JComboBox<String> countryNameDropdown;
    private  JComboBox<String> partnerNameDropdown;
    private  JComboBox<String> dealBankNameDropdown;
    private  JComboBox<String> dealPartnerNameDropdown;
    private  JComboBox<String> dealSupplierNameDropdown;
    private  JComboBox<String> dealTransactionTypeDropdown;
    private  JComboBox<String> dealDestinationDropdown;
    private  JComboBox<String> dealMeasureOfTimeDropdown;
    private  JComboBox<String> dealWeightMeasurementDropdown;
    
    private  JFormattedTextField bankCreditRiskInputField;
    private  JFormattedTextField expensesInputField;
    private  JFormattedTextField lengthOfLoanInputField;
    private  JFormattedTextField countryCreditRiskInputField;
    private  JFormattedTextField countryInterestRateInputField;
    private  JFormattedTextField partnerFeeInputField;
    private  JFormattedTextField dealDiscountDateInputField;
    private  JFormattedTextField dealMaturityDateInputField;
    private  JFormattedTextField dealCargoRentalInputField;
    private  JFormattedTextField dealTenorInputField;
    private  JFormattedTextField dealCreditSupportFeeInputField;
    private  JFormattedTextField dealCommodityWeightInputField;
    private  JFormattedTextField newBankNameInputField;
    private  JFormattedTextField newPartnerNameInputField;
    private  JFormattedTextField newSupplierNameInputField;
    private  JFormattedTextField docValueInputField;
    
    private  JPanel bankInformationPrompts;
    private  JPanel countryInformationPrompts;
    private  JPanel partnerInformationPrompts;
    private  JPanel newDealInformationPrompts;
    
    private  JPanel informationAcceptanceOrDenial;
    
    private  JLabel lengthOfLoanIndicator;
    private  JLabel bankNameIndicator;
    private  JLabel bankPositionIndicator;
    private  JLabel bankCountryIndicator;
    private  JLabel bankCreditRiskIndicator;
    private  JLabel expensesIndicator;
    private  JLabel countryNameIndicator;
    private  JLabel interestRateIndicator;
    private  JLabel countryCreditRiskIndicator;
    private  JLabel partnerNameIndicator;
    private  JLabel partnerFeeIndicator;
    private  JLabel dealBankNameIndicator;
    private  JLabel dealPartnerNameIndicator;
    private  JLabel dealSupplierNameIndicator;
    private  JLabel dealTransactionTypeIndicator;
    private  JLabel dealDiscountDateIndicator;
    private  JLabel dealMaturityDateIndicator;
    private  JLabel dealCargoRentalIndicator;
    private  JLabel dealDestinationIndicator;
    private  JLabel dealTenorIndicator;
    private  JLabel dealCreditSupportFeeIndicator;
    private  JLabel dealCommodityWeightIndicator;
    private  JLabel docValueIndicator;
    
    private  JButton enterInformation;
    private  JButton cancelInformation;
    
    private Color frameBackground;
    private Color bankInfoBackground;
    private Color countryInfoBackground;
    private Color partnerInfoBackground;
    private Color newDealBackground;
    private Color inputInformationBackground;
    
    private Font baseFont;
    
    private Border bankInfoBorder;
    private Border countryInfoBorder;
    private Border partnerInfoBorder;
    private Border newDealBorder;
    private Border inputInformationBorder;
    
    GroupLayout informationAcceptanceOrDenialLayout;
    GroupLayout bankInformationPromptsLayout; 
    GroupLayout countryInformationPromptsLayout;
    GroupLayout partnerInformationPromptsLayout;
    GroupLayout newDealInformationPromptsLayout;
    GroupLayout frameLayout;
    
    DatabaseAccess datAcs;
    Connection conn;
    Calculations useForCalculations;
    
    public infoModificationWindow(int x, int y, int width, int height, String name){
       
        super(name);
        
        datAcs = new DatabaseAccess("MainFile");
        conn  = datAcs.getDbConn();
        getNames();
        initializeComponents();
        addActionListeners();
        
        
        this.x = x;
        this.y = y - 35;
        this.width = width;
        this.height = height + height/2;
        this.setBounds(this.x, this.y, this.width, this.height);
        this.setBackground(frameBackground);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fileMenu.add(cancelMenuItem);
        fileMenu.add(helpMenuItem);
        areasOfInformationMenu.add(bankInfoMenuItem);
        areasOfInformationMenu.add(countryInfoMenuItem);
        areasOfInformationMenu.add(supplierInfoMenuItem);
        areasOfInformationMenu.add(dealInfoMenuItem);
        dataInputModMenuBar.add(fileMenu);
        dataInputModMenuBar.add(areasOfInformationMenu);
        this.setJMenuBar(dataInputModMenuBar);
        
        setBankInfoPanel();
        setCountryInfoPanel();
        setPartnerInfoPanel();
        setDealInfoPanel();
        setInfoInputPanel();
        addToFrame(bankInformationPrompts);
        currentPanel = bankInformationPrompts;
        
        this.setVisible(true);
        
        useForCalculations = new Calculations(this, x, y, width, height);
    }
    
    private void getNames(){
        String[] bankInfoColumns = datAcs.getBANK_INFO_COLUMNS();
        String[] supplierInfoColumns = datAcs.getDEAL_INFO_COLUMNS();
        String[] partnerInfoColumns = datAcs.getSUPPLIER_INFO_COLUMNS();
        BANK_NAMES = datAcs.getData("BankInfo", bankInfoColumns);
        PARTNER_NAMES = datAcs.getData("SupplierInfo", partnerInfoColumns);
        SUPPLIER_NAMES = datAcs.getData("DealInfo", supplierInfoColumns);
        
        bankNames = new String[BANK_NAMES.length];
        bankNamesAndAdd = new String[BANK_NAMES.length + 1];
        partnerNamesAndAdd = new String[PARTNER_NAMES.length + 1];
        partnerNames = new String[PARTNER_NAMES.length];
        supplierNames = new String[SUPPLIER_NAMES.length + 1];
        
        bankNamesAndAdd[0] = ("Add New Bank");
        partnerNamesAndAdd[0] = ("Add New Partner");
        supplierNames[0] = ("Add New Supplier");
        
        try{
            lastDealNumber = Integer.parseInt((String)SUPPLIER_NAMES[SUPPLIER_NAMES.length-1][0]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            lastDealNumber = 0;
        }
        
        for(int i = 0; i < BANK_NAMES.length; i ++)
        {
            bankNames[i] = (String)BANK_NAMES[i][0];
            bankNamesAndAdd[i+1] = (String)BANK_NAMES[i][0];
        }
        for(int i = 0; i < PARTNER_NAMES.length; i ++)
        {
             partnerNames[i] = (String)PARTNER_NAMES[i][0];
             partnerNamesAndAdd[i+1] = (String)PARTNER_NAMES[i][0];
        }
        for(int i = 0; i < SUPPLIER_NAMES.length; i ++)
        {
             supplierNames[i+1] = (String)SUPPLIER_NAMES[i][3];
        }
        
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    private void setBankInfoPanel(){
        bankInformationPrompts.setBackground(bankInfoBackground);
        bankInformationPrompts.setBorder(bankInfoBorder);
        
        bankInformationPrompts.setLayout(bankInformationPromptsLayout);
        bankInformationPromptsLayout.setHorizontalGroup(
            bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                        .addGroup( GroupLayout.Alignment.LEADING, bankInformationPromptsLayout.createSequentialGroup()
                            .addComponent(bankCreditRiskIndicator)
                            .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                            .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                .addComponent(bankPositionDropdown,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)
                                .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                                    .addComponent(lengthOfLoanIndicator)
                                    .addGap(96, 96, 96)
                                    .addComponent(lengthOfLoanInputField,  GroupLayout.PREFERRED_SIZE,  140,  GroupLayout.PREFERRED_SIZE))
                                .addComponent(expensesInputField,  GroupLayout.PREFERRED_SIZE,  140,  GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(typeOfDateDropdown,  GroupLayout.PREFERRED_SIZE, 115,  GroupLayout.PREFERRED_SIZE)
                            .addGap(477, 477, 477)))
                    .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                        .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addComponent(expensesIndicator)
                            .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                .addComponent(bankCreditRiskInputField,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)
                                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                                        .addComponent(bankCountryIndicator)
                                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bankCountryDropdown,  GroupLayout.PREFERRED_SIZE, 188,  GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                                        .addComponent(bankNameIndicator)
                                        .addGap(81, 81, 81)
                                        .addComponent(bankNameDropdown,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)
                                        .addGap(40,40,40)
                                        .addComponent(newBankNameInputField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(bankPositionIndicator))
                        .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bankInformationPromptsLayout.setVerticalGroup(
            bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(bankNameIndicator)
                    .addComponent(bankNameDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBankNameInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(bankCountryIndicator)
                    .addComponent(bankCountryDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(bankCreditRiskIndicator)
                    .addComponent(bankCreditRiskInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthOfLoanInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeOfDateDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(lengthOfLoanIndicator))
                .addGap(30, 30, 30)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(bankPositionIndicator))
                    .addComponent(bankPositionDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(bankInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(bankInformationPromptsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(expensesIndicator))
                    .addComponent(expensesInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }
    
    private void setPartnerInfoPanel(){
       partnerInformationPrompts.setBackground(partnerInfoBackground);
        partnerInformationPrompts.setBorder(partnerInfoBorder);
        
        partnerInformationPrompts.setLayout(partnerInformationPromptsLayout);
        partnerInformationPromptsLayout.setHorizontalGroup(
            partnerInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(partnerInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(partnerInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                    .addGroup(partnerInformationPromptsLayout.createSequentialGroup()
                        .addComponent(partnerFeeIndicator)
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(partnerFeeInputField,  GroupLayout.PREFERRED_SIZE,  140,  GroupLayout.PREFERRED_SIZE))
                    .addGroup(partnerInformationPromptsLayout.createSequentialGroup()
                        .addComponent(partnerNameIndicator)
                        .addGap(81, 81, 81)
                        .addComponent(partnerNameDropdown,  GroupLayout.PREFERRED_SIZE, 150,  GroupLayout.PREFERRED_SIZE)
                        .addGap(80,80,80)
                        .addComponent(newPartnerNameInputField, GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(647, Short.MAX_VALUE))
        );
        partnerInformationPromptsLayout.setVerticalGroup(
            partnerInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(partnerInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(partnerInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(partnerNameIndicator)
                    .addComponent(partnerNameDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPartnerNameInputField, GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(partnerInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addComponent(partnerFeeIndicator)
                    .addComponent(partnerFeeInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
    }
    
    private void setCountryInfoPanel(){
        countryInformationPrompts.setBackground(countryInfoBackground);
        countryInformationPrompts.setBorder(countryInfoBorder);
        
        countryInformationPrompts.setLayout(countryInformationPromptsLayout);
        countryInformationPromptsLayout.setHorizontalGroup(
            countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(countryInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(countryInformationPromptsLayout.createSequentialGroup()
                        .addComponent(countryCreditRiskIndicator)
                        .addGap(868, 868, 868))
                    .addGroup(countryInformationPromptsLayout.createSequentialGroup()
                        .addGroup(countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                            .addComponent(countryCreditRiskInputField,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)
                            .addGroup(countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                                .addGroup(countryInformationPromptsLayout.createSequentialGroup()
                                    .addComponent(interestRateIndicator)
                                    .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(countryInterestRateInputField,  GroupLayout.PREFERRED_SIZE,  140,  GroupLayout.PREFERRED_SIZE))
                                .addGroup(countryInformationPromptsLayout.createSequentialGroup()
                                    .addComponent(countryNameIndicator)
                                    .addGap(81, 81, 81)
                                    .addComponent(countryNameDropdown,  GroupLayout.PREFERRED_SIZE, 148,  GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        countryInformationPromptsLayout.setVerticalGroup(
            countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(countryInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(countryNameIndicator)
                    .addComponent(countryNameDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addComponent(interestRateIndicator)
                    .addComponent(countryInterestRateInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(countryInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(countryCreditRiskIndicator)
                    .addComponent(countryCreditRiskInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

    }
    
    private void setDealInfoPanel(){
        newDealInformationPrompts.setBackground(newDealBackground);
        newDealInformationPrompts.setBorder(newDealBorder);
        
        newDealInformationPrompts.setLayout(newDealInformationPromptsLayout);
       
        newDealInformationPromptsLayout.setHorizontalGroup(
            newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup( GroupLayout.Alignment.TRAILING, newDealInformationPromptsLayout.createSequentialGroup()
                                .addComponent(dealBankNameIndicator)
                                .addGap(81, 81, 81))
                            .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                                .addComponent(dealPartnerNameIndicator)
                                .addGap(70, 70, 70))))
                    .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                        .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                    .addComponent(dealSupplierNameIndicator)
                                    .addComponent(dealTransactionTypeIndicator)))
                            .addComponent(dealDiscountDateIndicator)
                            .addComponent(dealMaturityDateIndicator)
                            .addComponent(dealCargoRentalIndicator)
                            .addComponent(dealDestinationIndicator)
                            .addComponent(docValueIndicator)
                            .addComponent(dealTenorIndicator)
                            .addComponent(dealCreditSupportFeeIndicator)
                            .addComponent(dealCommodityWeightIndicator))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(dealCreditSupportFeeInputField,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealTenorInputField,  GroupLayout.Alignment.TRAILING, 140,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(docValueInputField,  GroupLayout.Alignment.TRAILING, 140,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealDestinationDropdown,  GroupLayout.Alignment.TRAILING, 0,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dealCargoRentalInputField,  GroupLayout.Alignment.TRAILING, 140,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealMaturityDateInputField,  GroupLayout.Alignment.TRAILING, 140,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealDiscountDateInputField,  GroupLayout.Alignment.TRAILING, 140,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealTransactionTypeDropdown,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 128,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealSupplierNameDropdown,  GroupLayout.Alignment.TRAILING, 0,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dealPartnerNameDropdown,  GroupLayout.Alignment.TRAILING, 0,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dealBankNameDropdown,  GroupLayout.Alignment.TRAILING, 0,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dealCommodityWeightInputField,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(dealMeasureOfTimeDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(newSupplierNameInputField,  GroupLayout.PREFERRED_SIZE, 140,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealWeightMeasurementDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap(508, Short.MAX_VALUE))
        );
        newDealInformationPromptsLayout.setVerticalGroup(
            newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealBankNameIndicator)
                    .addComponent(dealBankNameDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealPartnerNameIndicator)
                    .addComponent(dealPartnerNameDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealSupplierNameDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealSupplierNameIndicator)
                    .addComponent(newSupplierNameInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealTransactionTypeDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealTransactionTypeIndicator))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addGroup(newDealInformationPromptsLayout.createSequentialGroup()
                        .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(dealDiscountDateIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(dealDiscountDateInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(dealMaturityDateIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(dealMaturityDateInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(dealCargoRentalIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(dealCargoRentalInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                            .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(docValueIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(docValueInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dealDestinationIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE))
                    .addComponent(dealDestinationDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealTenorIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealMeasureOfTimeDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealTenorInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealCreditSupportFeeIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealCreditSupportFeeInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newDealInformationPromptsLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(dealCommodityWeightIndicator,  GroupLayout.PREFERRED_SIZE, 19,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealCommodityWeightInputField,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealWeightMeasurementDropdown,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }
    
    private void setInfoInputPanel(){
        informationAcceptanceOrDenial.setBackground(inputInformationBackground);
        informationAcceptanceOrDenial.setBorder(inputInformationBorder);
        
        informationAcceptanceOrDenial.setLayout(informationAcceptanceOrDenialLayout);
        informationAcceptanceOrDenialLayout.setHorizontalGroup(
            informationAcceptanceOrDenialLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(informationAcceptanceOrDenialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelInformation,  GroupLayout.PREFERRED_SIZE, 110,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(enterInformation,  GroupLayout.PREFERRED_SIZE, 100,  GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        informationAcceptanceOrDenialLayout.setVerticalGroup(
            informationAcceptanceOrDenialLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(informationAcceptanceOrDenialLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(informationAcceptanceOrDenialLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelInformation,  GroupLayout.PREFERRED_SIZE, 40,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterInformation,  GroupLayout.PREFERRED_SIZE, 40,  GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }
    
    private void addToFrame(JPanel currentPanel)
    {
        this.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addGroup(frameLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addGroup( GroupLayout.Alignment.LEADING, frameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(currentPanel,  GroupLayout.PREFERRED_SIZE, 946,  GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameLayout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(informationAcceptanceOrDenial,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)))
                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPanel,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(informationAcceptanceOrDenial,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }
    
    private void replaceOnFrame(JPanel currentPanel, JPanel wantedPanel)
    {
        frameLayout.replace(currentPanel, wantedPanel);
        wantedPanel.validate();
        wantedPanel.repaint();
        this.currentPanel = wantedPanel;
        refreshDropdowns();
    }
    
    private void refreshDropdowns()
    {
        datAcs = new DatabaseAccess("MainFile");
        getNames();
        bankNameDropdown = new JComboBox<>(bankNamesAndAdd);
        bankCountryDropdown = new  JComboBox<>(COUNTRIES);
        typeOfDateDropdown = new  JComboBox<>(DATE_MEASUREMENTS);
        bankPositionDropdown = new  JComboBox<>(BANK_POSITION);
        countryNameDropdown = new JComboBox<>(COUNTRIES);
        dealBankNameDropdown = new JComboBox<>(bankNames);
        dealPartnerNameDropdown = new JComboBox<>(partnerNames);
        dealSupplierNameDropdown = new JComboBox<>(supplierNames);
        dealTransactionTypeDropdown = new JComboBox<>(TRANSACTION_TYPE);
        dealDestinationDropdown = new JComboBox<>(COUNTRIES);
        dealMeasureOfTimeDropdown = new JComboBox<>(DATE_MEASUREMENTS);
        dealWeightMeasurementDropdown = new JComboBox<>(WEIGHT_MEASUREMENTS);
    }
    
    private void revalidateAndRepaint(){
        this.validate();
        this.repaint();
    }
    
    private boolean getInputs(){
        //If the current panel is bank info
        boolean continueInput = true;
            if(currentPanel == bankInformationPrompts)
            {
                try{
                String tempBankName = (String)bankNameDropdown.getSelectedItem();
                if(tempBankName.equals("Add New Bank"))
                {
                    bankName = newBankNameInputField.getText();
                    profitEarnedInCountry = 0;
                }
                else {
                    bankName = tempBankName;
                }
                countryOfBank =(String) bankCountryDropdown.getSelectedItem();
                creditRiskOfBank = Integer.parseInt(bankCreditRiskInputField.getText());
                lengthOfLoanToBank = Integer.parseInt(lengthOfLoanInputField.getText());
                lengthOfLoanMeasurement = (String)typeOfDateDropdown.getSelectedItem();
                bankPositionInDeal = (String)bankPositionDropdown.getSelectedItem();
                fees = Integer.parseInt(expensesInputField.getText());
                }
                catch(NullPointerException e)
                {
                    System.err.println(e);
                    ErrorPopup error = new ErrorPopup("Please enter data into fields", x, y, width + 200, height);
                    continueInput = false;
                }
                catch(NumberFormatException e){
                    ErrorPopup error = new ErrorPopup("Please recheck that values are correct", x, y, width + 200, height);
                    continueInput = false;
                }
            }
            //If the currentPanel is partner info
            else if(currentPanel == partnerInformationPrompts){
                try{
                    String tempSupName = (String)partnerNameDropdown.getSelectedItem();
                    supplierName = tempSupName;
                    if(tempSupName.equals("Add New Partner")){
                        supplierName = newPartnerNameInputField.getText();
                    }
                    supplierFee = Integer.parseInt(partnerFeeInputField.getText());
                }
                catch(NullPointerException e)
                {
                    ErrorPopup error = new ErrorPopup("Please enter data into fields", x, y, width + 200, height);
                    continueInput = false;
                }
                catch(NumberFormatException e){
                    ErrorPopup error = new ErrorPopup("Please recheck that values are correct", x, y, width + 200, height);
                    continueInput = false;
                }
            }
            //If the currentpanel is country info
            else if(currentPanel == countryInformationPrompts){
                try{
                countryName = (String)countryNameDropdown.getSelectedItem();
                interestRateOfCountry = Double.parseDouble(countryInterestRateInputField.getText());
                creditRiskInCountry = Double.parseDouble(countryCreditRiskInputField.getText());
                }
                catch(NullPointerException e)
                {
                    ErrorPopup error = new ErrorPopup("Please enter data into fields", x, y, width + 200, height);
                    continueInput = false;
                }
                catch(NumberFormatException e){
                    ErrorPopup error = new ErrorPopup("Please recheck that values are correct", x, y, width + 200, height);
                    continueInput = false;
                }
            }
            //if the currentpanel is deal info
            else if(currentPanel == newDealInformationPrompts){
                try{
                dealBankName = (String)dealBankNameDropdown.getSelectedItem();
                dealPartnerName = (String)dealPartnerNameDropdown.getSelectedItem();
                String tempSupName = (String)dealSupplierNameDropdown.getSelectedItem();
                if(tempSupName.equals("Add New Supplier")){
                    dealSupplierName = newSupplierNameInputField.getText();
                    System.out.println(newSupplierNameInputField.getText());
                }
                else {
                    System.out.println(tempSupName);
                    dealSupplierName = tempSupName;
                }
                transactionType = (String)dealTransactionTypeDropdown.getSelectedItem();
                cargoRental = Double.parseDouble(dealCargoRentalInputField.getText());
                tenorMeasurement = (String)dealMeasureOfTimeDropdown.getSelectedItem();
                commodityWeightMeasurement = (String)dealWeightMeasurementDropdown.getSelectedItem();
                docValue = Integer.parseInt(docValueInputField.getText());
                if(tenorMeasurement.equals("Days")){
                    tenor = Integer.parseInt(dealTenorInputField.getText());
                }
                else if(tenorMeasurement.equals("Weeks")) {
                    tenor = (int)(Integer.parseInt(dealTenorInputField.getText()) * 7);
                }
                else if(tenorMeasurement.equals("Years")){
                    tenor = (int)(Integer.parseInt(dealTenorInputField.getText()) * 365);
                }
                if(commodityWeightMeasurement.equals("LBS"))
                {
                    commodityWeight = Integer.parseInt(dealCommodityWeightInputField.getText());
                }
                else{
                    commodityWeight = (int)(Integer.parseInt(dealCommodityWeightInputField.getText()) * 2.20462);
                }
                creditSupportFee = Double.parseDouble(dealCreditSupportFeeInputField.getText());
                destination = (String)dealDestinationDropdown.getSelectedItem();
                discountDate = dealDiscountDateInputField.getText();
                maturityDate = dealMaturityDateInputField.getText();
                }catch(NullPointerException e)
                {
                    System.out.println(e);
                    ErrorPopup error = new ErrorPopup("Please enter data into fields", x, y, width + 200, height);
                    continueInput = false;
                }
                catch(NumberFormatException e){
                    ErrorPopup error = new ErrorPopup("<html>Please recheck that values are correct</n> and dates are formatted as yyyy-mm-dd ", x, y, width + 200, height);
                    continueInput = false;
                }
            }
            return continueInput;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourceObject = e.getSource();
        String query;
        int status;
        if(sourceObject == enterInformation)
        {
            boolean doInput;
            doInput = getInputs();
            if(doInput)
            {
                profitEarnedFromBank = useForCalculations.getTotalBankProfit(bankName);
                //If it is on new deal, only add
                //If it is on bank, partner, if it is add new, then it is insert
                //If it is on country then it can only modify
                //bank
                if(currentPanel == bankInformationPrompts){
                    String tempNewBank = (String)bankNameDropdown.getSelectedItem();
                    if(tempNewBank.equals("Add New Bank")){
                        query = "INSERT INTO BankInfo(BankName, Country, CreditRisk, LengthOfLoan, LengthOfLoanMeasurement, ProfitEarned, BankType, BankFees)" 
                                + " VALUES(?,?,?,?,?,?,?,?)";
                        try{
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, bankName);
                            statement.setString(2, countryOfBank);
                            statement.setInt(3, creditRiskOfBank);
                            statement.setInt(4, lengthOfLoanToBank);
                            statement.setString(5, lengthOfLoanMeasurement);
                            statement.setInt(6, profitEarnedFromBank);
                            statement.setString(7, bankPositionInDeal);
                            statement.setInt(8, fees);
                            statement.executeUpdate();
                        }
                        catch(SQLException err)
                        {
                             System.err.println(err);
                            ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                        }

                    }

                else{
                    query = "UPDATE BankInfo "
                            + "SET Country = ?, CreditRisk = ?, LengthOfLoan = ?, LengthOfLoanMeasurement = ?, ProfitEarned = ?, BankType = ?, BankFees = ?"
                            + " WHERE BankName = '" + bankName + "'";  
                        try{
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setString(1, countryOfBank);
                            statement.setInt(2, creditRiskOfBank);
                            statement.setInt(3, lengthOfLoanToBank);
                            statement.setString(4, lengthOfLoanMeasurement);
                            statement.setInt(5, profitEarnedFromBank);
                            statement.setString(6, bankPositionInDeal);
                            statement.setInt(7, fees);
                            status = statement.executeUpdate();
                        }
                        catch(SQLException err)
                        {
                             System.err.println(err);
                            ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                        }

                     }

                }

                //partner
                else if(currentPanel == partnerInformationPrompts){
                        String tempPartner = (String) partnerNameDropdown.getSelectedItem();
                        if(tempPartner.equals("Add New Partner")){
                            query = "INSERT INTO SupplierInfo(Supplier, SupplierFee)" 
                                    + " VALUES(?,?)";
                            try{
                                PreparedStatement statement = conn.prepareStatement(query);
                                statement.setString(1, supplierName);
                                statement.setInt(2, supplierFee);
                                statement.executeUpdate();
                            }
                            catch(SQLException err)
                            {
                                 System.err.println(err);
                                ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                            }
                        }
                        else{
                            query = "UPDATE SupplierInfo"
                            + " SET SupplierFee = ?"
                            + " WHERE Supplier = '" + supplierName + "'";  
                            try{
                                PreparedStatement statement = conn.prepareStatement(query);
                                statement.setInt(1, supplierFee);
                                status = statement.executeUpdate();
                            }
                            catch(SQLException err)
                            {
                                 System.err.println(err);
                                ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                            }
                        }            
                }
                //country
                else if(currentPanel == countryInformationPrompts){
                    query = "UPDATE CountryInfo "
                            + "SET InterestRate = ?, CreditRisk = ?, ProfitEarned = ? "
                                + "WHERE CountryName = '" + countryName  + "'";
                    profitEarnedInCountry = useForCalculations.getTotalCountryProfit(countryName);
                        try{
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setInt(1, (int)interestRateOfCountry);
                            statement.setInt(2, (int)creditRiskInCountry);
                            statement.setInt(3, profitEarnedInCountry);
                            status = statement.executeUpdate();
                        }
                        catch(SQLException err)
                        {
                            System.out.println("countryMod");
                             System.err.println(err);
                            ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                        }
                }
                //deal
                else if(currentPanel == newDealInformationPrompts){
                    int tempProfit = 0;
                    query = "INSERT INTO DealInfo(TradeNumber, BankName, Partner, SupplierName, CargoRental, Destination, DocValue, TransactionType, Tenor, TenorMeasurement, CommodityWeight, DiscountDate, MaturityDate, ProfitEarned, CreditSupportFee )" 
                                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        try{
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setInt(1, lastDealNumber + 1);
                            statement.setString(2, dealBankName);
                            statement.setString(3, dealPartnerName);
                            statement.setString(4, dealSupplierName);
                            statement.setDouble(5, cargoRental);
                            statement.setString(6, destination);
                            statement.setInt(7, docValue);
                            statement.setString(8, transactionType);
                            statement.setInt(9, tenor);
                            statement.setString(10, tenorMeasurement);
                            statement.setDouble(11, commodityWeight);
                            statement.setDate(12, Date.valueOf(discountDate));
                            statement.setDate(13, Date.valueOf(maturityDate));
                            statement.setInt(14, tempProfit);
                            statement.setInt(15, (int)creditSupportFee);
                            status = statement.executeUpdate();
                        }
                        catch(SQLDataException err)
                        {
                            ErrorPopup databaseErr = new ErrorPopup("There has been an error in your date or time formating. Please ensure it is in YYYY-MM-DD", x -250, y, width + 500, height);
                        }
                        catch(SQLException err)
                        {
                            System.out.println("dealIns2");
                             System.err.println(err);
                            ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x -250, y, width + 500, height);
                        }
                        
                        profitEarned = useForCalculations.getDealProfit();
                        lastDealNumber++;
                        query = "UPDATE DealInfo SET ProfitEarned  = ? WHERE TradeNumber = " + lastDealNumber + " ";
                        try{
                            PreparedStatement statement = conn.prepareStatement(query);
                            statement.setInt(1, profitEarned);
                            statement.executeUpdate();
                        }
                        catch(SQLException err)
                        {
                            System.out.println("DealIns1");
                            System.out.println(err);
                            System.err.println();
                            ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", x - 250, y , width + 500, height);
                        }
                }
            }
        }
        else if(sourceObject == cancelInformation)
        {
            TableWindow reopenTable = new TableWindow(x,y,width, height, "TABLE");
            this.dispose();
        }
        //Remove current panel and add bank info
        else if(sourceObject == bankInfoMenuItem){
           if(currentPanel != bankInformationPrompts){
                replaceOnFrame(currentPanel, bankInformationPrompts);
                //addToFrame(bankInformationPrompts);
                revalidateAndRepaint();
            }
        }
        else if(sourceObject == countryInfoMenuItem){
            if(currentPanel != countryInformationPrompts){
                replaceOnFrame(currentPanel, countryInformationPrompts);
                //addToFrame(countryInformationPrompts);
                revalidateAndRepaint();
            }
        }
        else if(sourceObject == dealInfoMenuItem){
            if(currentPanel != newDealInformationPrompts){
                replaceOnFrame(currentPanel, newDealInformationPrompts);
                //addToFrame(newDealInformationPrompts);
                revalidateAndRepaint();
            }
        }
        else if(sourceObject == helpMenuItem){
            //open the help menu
            HelpFrame help = new HelpFrame(x, y, width, height);
        }
        else if(sourceObject == cancelMenuItem){
            TableWindow reopenTable = new TableWindow(x,y,width, height, "TABLE");
            this.dispose();
        }
        else if(sourceObject == supplierInfoMenuItem){
            if(currentPanel != partnerInformationPrompts){
                replaceOnFrame(currentPanel, partnerInformationPrompts);
                //addToFrame(partnerInformationPrompts);
                revalidateAndRepaint();
            }
        }
    }

    public int getLastDealNumber() {
        return lastDealNumber;
    }

    public void setLastDealNumber(int lastDealNumber) {
        this.lastDealNumber = lastDealNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountryOfBank() {
        return countryOfBank;
    }

    public void setCountryOfBank(String countryOfBank) {
        this.countryOfBank = countryOfBank;
    }

    public int getCreditRiskOfBank() {
        return creditRiskOfBank;
    }

    public void setCreditRiskOfBank(int creditRiskOfBank) {
        this.creditRiskOfBank = creditRiskOfBank;
    }

    public int getLengthOfLoanToBank() {
        return lengthOfLoanToBank;
    }

    public void setLengthOfLoanToBank(int lengthOfLoanToBank) {
        this.lengthOfLoanToBank = lengthOfLoanToBank;
    }

    public String getLengthOfLoanMeasurement() {
        return lengthOfLoanMeasurement;
    }

    public void setLengthOfLoanMeasurement(String lengthOfLoanMeasurement) {
        this.lengthOfLoanMeasurement = lengthOfLoanMeasurement;
    }

    public int getProfitEarnedFromBank() {
        return profitEarnedFromBank;
    }

    public void setProfitEarnedFromBank(int profitEarnedFromBank) {
        this.profitEarnedFromBank = profitEarnedFromBank;
    }

    public int getVolumeOfDealsFromBank() {
        return volumeOfDealsFromBank;
    }

    public void setVolumeOfDealsFromBank(int volumeOfDealsFromBank) {
        this.volumeOfDealsFromBank = volumeOfDealsFromBank;
    }

    public int getAverageSizeOfDealsFromBank() {
        return averageSizeOfDealsFromBank;
    }

    public void setAverageSizeOfDealsFromBank(int averageSizeOfDealsFromBank) {
        this.averageSizeOfDealsFromBank = averageSizeOfDealsFromBank;
    }

    public String getBankPositionInDeal() {
        return bankPositionInDeal;
    }

    public void setBankPositionInDeal(String bankPositionInDeal) {
        this.bankPositionInDeal = bankPositionInDeal;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierFee() {
        return supplierFee;
    }

    public void setSupplierFee(int supplierFee) {
        this.supplierFee = supplierFee;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getCreditRiskInCountry() {
        return creditRiskInCountry;
    }

    public void setCreditRiskInCountry(double creditRiskInCountry) {
        this.creditRiskInCountry = creditRiskInCountry;
    }

    public int getProfitEarnedInCountry() {
        return profitEarnedInCountry;
    }

    public void setProfitEarnedInCountry(int profitEarnedInCountry) {
        this.profitEarnedInCountry = profitEarnedInCountry;
    }

    public int getVolumeOfDealsInCountry() {
        return VolumeOfDealsInCountry;
    }

    public void setVolumeOfDealsInCountry(int VolumeOfDealsInCountry) {
        this.VolumeOfDealsInCountry = VolumeOfDealsInCountry;
    }

    public int getAverageSizeOfDealsInCountry() {
        return averageSizeOfDealsInCountry;
    }

    public void setAverageSizeOfDealsInCountry(int averageSizeOfDealsInCountry) {
        this.averageSizeOfDealsInCountry = averageSizeOfDealsInCountry;
    }

    public String getDealBankName() {
        return dealBankName;
    }

    public void setDealBankName(String dealBankName) {
        this.dealBankName = dealBankName;
    }

    public String getDealPartnerName() {
        return dealPartnerName;
    }

    public void setDealPartnerName(String dealPartnerName) {
        this.dealPartnerName = dealPartnerName;
    }

    public String getDealSupplierName() {
        return dealSupplierName;
    }

    public void setDealSupplierName(String dealSupplierName) {
        this.dealSupplierName = dealSupplierName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getCargoRental() {
        return cargoRental;
    }

    public void setCargoRental(double cargoRental) {
        this.cargoRental = cargoRental;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public int getDocValue() {
        return docValue;
    }

    public void setDocValue(int docValue) {
        this.docValue = docValue;
    }

    public String getTenorMeasurement() {
        return tenorMeasurement;
    }

    public void setTenorMeasurement(String tenorMeasurement) {
        this.tenorMeasurement = tenorMeasurement;
    }

    public double getCommodityWeight() {
        return commodityWeight;
    }

    public void setCommodityWeight(double commodityWeight) {
        this.commodityWeight = commodityWeight;
    }

    public String getCommodityWeightMeasurement() {
        return commodityWeightMeasurement;
    }

    public void setCommodityWeightMeasurement(String commodityWeightMeasurement) {
        this.commodityWeightMeasurement = commodityWeightMeasurement;
    }

    public double getCreditSupportFee() {
        return creditSupportFee;
    }

    public void setCreditSupportFee(double creditSupportFee) {
        this.creditSupportFee = creditSupportFee;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(String discountDate) {
        this.discountDate = discountDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public int getProfitEarned() {
        return profitEarned;
    }

    public void setProfitEarned(int profitEarned) {
        this.profitEarned = profitEarned;
    }
    
    private void initializeComponents()
    {
        bankInformationPrompts = new JPanel();
        countryInformationPrompts = new JPanel();
        partnerInformationPrompts  = new JPanel();
        newDealInformationPrompts = new JPanel();
        bankNameDropdown = new JComboBox<>(bankNamesAndAdd);
        bankNameIndicator = new  JLabel("Name of the Bank:");
        bankCountryIndicator = new  JLabel("Country:");
        bankCountryDropdown = new  JComboBox<>(COUNTRIES);
        bankCreditRiskIndicator = new  JLabel("Credit Risk:");
        bankCreditRiskInputField = new  JFormattedTextField();
        lengthOfLoanIndicator = new  JLabel("Length Of Loan:");
        lengthOfLoanInputField = new  JFormattedTextField();
        typeOfDateDropdown = new  JComboBox<>(DATE_MEASUREMENTS);
        bankPositionIndicator = new  JLabel("Bank Position in Deal:");
        countryNameIndicator = new JLabel("Country:");
        interestRateIndicator = new JLabel("Interest Rate:");
        countryCreditRiskIndicator = new JLabel("Credit Risk:");
        bankPositionDropdown = new  JComboBox<>(BANK_POSITION);
        countryNameDropdown = new JComboBox<>(COUNTRIES);
        countryCreditRiskInputField = new JFormattedTextField();
        countryInterestRateInputField = new JFormattedTextField();
        expensesIndicator = new  JLabel("<html>Fees <br> Paid to Counterparty <br> Standby Amount</html>");
        expensesInputField = new  JFormattedTextField();
        partnerFeeIndicator = new JLabel("Partner Fee:");
        partnerNameIndicator = new JLabel("Partner:");
        partnerFeeInputField = new JFormattedTextField();
        partnerNameDropdown = new JComboBox<>(partnerNamesAndAdd);
        informationAcceptanceOrDenial = new  JPanel();
        enterInformation = new  JButton("ENTER");
        cancelInformation = new  JButton("CANCEL");
        dataInputModMenuBar = new  JMenuBar();
        fileMenu = new  JMenu("FILE");
        docValueIndicator = new JLabel("Doc Value:");
        
        cancelMenuItem = new  JMenuItem("CANCEL");
        helpMenuItem = new  JMenuItem("HELP");
        areasOfInformationMenu = new  JMenu("AREAS OF INFORMATION");
        bankInfoMenuItem = new  JMenuItem("BANK INFO");
        countryInfoMenuItem = new  JMenuItem("COUNTRY INFO");
        dealInfoMenuItem = new  JMenuItem("DEAL INFO");
        supplierInfoMenuItem = new  JMenuItem("SUPPLIER INFO");
        
        newBankNameInputField = new JFormattedTextField();
        newPartnerNameInputField = new JFormattedTextField();
        newSupplierNameInputField = new JFormattedTextField();
        docValueInputField = new JFormattedTextField();
        
        dealBankNameDropdown = new JComboBox<>(bankNames);
        dealPartnerNameDropdown = new JComboBox<>(partnerNames);
        dealSupplierNameDropdown = new JComboBox<>(supplierNames);
        dealTransactionTypeDropdown = new JComboBox<>(TRANSACTION_TYPE);
        dealDestinationDropdown = new JComboBox<>(COUNTRIES);
        dealMeasureOfTimeDropdown = new JComboBox<>(DATE_MEASUREMENTS);
        dealWeightMeasurementDropdown = new JComboBox<>(WEIGHT_MEASUREMENTS);
        
        dealDiscountDateInputField = new JFormattedTextField();
        dealMaturityDateInputField = new JFormattedTextField();
        dealCargoRentalInputField = new JFormattedTextField();
        dealTenorInputField = new JFormattedTextField();
        dealCreditSupportFeeInputField = new JFormattedTextField();
        dealCommodityWeightInputField = new JFormattedTextField();
        
        dealBankNameIndicator = new JLabel("Bank:");
        dealPartnerNameIndicator = new JLabel("Partner:");
        dealSupplierNameIndicator = new JLabel("Supplier:");
        dealTransactionTypeIndicator = new JLabel("Transaction Type:");
        dealDiscountDateIndicator = new JLabel("Discount Date:");
        dealMaturityDateIndicator = new JLabel("Maturity Date:");
        dealCargoRentalIndicator = new JLabel("Cargo Rental:");
        dealDestinationIndicator = new JLabel("Destination:");
        dealTenorIndicator = new JLabel("Tenor:");
        dealCreditSupportFeeIndicator = new JLabel("Credit Support Fee:");
        dealCommodityWeightIndicator = new JLabel("Commodity Weight:");
        
        frameBackground = new Color(158,158,158);
        bankInfoBackground = new Color(96,125,139);
        countryInfoBackground = new Color(96,125,139);
        partnerInfoBackground = new Color(96,125,139);
        newDealBackground = new Color(96,125,139);
        inputInformationBackground = new Color(96, 125, 139);
        
        bankInfoBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.LIGHT_GRAY), "BANK INFO");
        countryInfoBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.LIGHT_GRAY), "COUNTRY INFO");
        partnerInfoBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.LIGHT_GRAY), "PARTNER INFO");
        newDealBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.LIGHT_GRAY), "INSERT NEW DEAL");
        inputInformationBorder = BorderFactory.createEtchedBorder(Color.BLACK, Color.LIGHT_GRAY);
        
       informationAcceptanceOrDenialLayout = new GroupLayout(informationAcceptanceOrDenial);
       bankInformationPromptsLayout = new GroupLayout(bankInformationPrompts);
       countryInformationPromptsLayout = new GroupLayout(countryInformationPrompts);
       partnerInformationPromptsLayout = new GroupLayout(partnerInformationPrompts);
       newDealInformationPromptsLayout = new GroupLayout(newDealInformationPrompts);
       frameLayout = new GroupLayout(this.getContentPane());
    }
    private void addActionListeners()
    {
        enterInformation.addActionListener(this);
        cancelInformation.addActionListener(this);
        bankInfoMenuItem.addActionListener(this);
        countryInfoMenuItem.addActionListener(this);
        dealInfoMenuItem.addActionListener(this);
        supplierInfoMenuItem.addActionListener(this);
        helpMenuItem.addActionListener(this);
        cancelMenuItem.addActionListener(this);
    }
    
    
}
