
//package iaproject.Installer;

//import iaproject.ProgramStream.ErrorPopup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Install {

    public static void main(String[] args) {
         final String[] COUNTRIES = new String[]{"Afghanistan", "Albania", "Algeria", 
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
        
         DatabaseAccess databaseObject = new DatabaseAccess();
        
        String newTable;
        
         databaseObject.createDb("MainFile");
         //databaseObject.getDbConn();
         
        newTable = "CREATE TABLE BankInfo ( "+
                 "BankName varchar(30),"+
                 "Country varchar(50),"+
                 "CreditRisk int,"+
                 "LengthOfLoan int,"+
                 "LengthOfLoanMeasurement varchar(30),"+
                 "ProfitEarned int,"+
                 "BankType varchar(30),"+
                 "BankFees int"
                + ")";
         databaseObject.createTable(newTable, "MainFile");
         
         newTable = "CREATE TABLE BudgetInfo ( "+
                 "TimeFrame varchar(30),"+
                 "TheoreticalBudget int"
                 + ")";
         databaseObject.createTable(newTable, "MainFile");
         
         newTable = "CREATE TABLE SupplierInfo ( "+
                 "Supplier varchar(30),"+
                 "SupplierFee int"
                 + ")";
         databaseObject.createTable(newTable, "MainFile");
         
         newTable = "CREATE TABLE CountryInfo ( "+
                 "CountryName varchar(50),"+
                 "InterestRate int,"+
                 "CreditRisk int,"+
                 "ProfitEarned int"
                 + ")";
         databaseObject.createTable(newTable, "MainFile");
         
         newTable = "CREATE TABLE DealInfo ( "+
                 "TradeNumber int ,"+
                 "BankName varchar(30),"+
                 "Partner varchar(30),"+
                 "SupplierName varchar(30),"+
                 "CargoRental double,"+
                 "Destination varchar(50),"+
                 "DocValue int,"+
                 "TransactionType varchar(30),"+
                 "Tenor int,"+
                 "TenorMeasurement varChar(30),"+
                 "CommodityWeight double,"+
                 "DiscountDate date,"+
                 "MaturityDate date,"+
                 "ProfitEarned int,"+
                 "CreditSupportFee int"
                 + ")";
         databaseObject.createTable(newTable, "MainFile");
         
         DatabaseAccess datObj = new DatabaseAccess("MainFile");
         Connection conn = datObj.getDbConn() ;
         
         for(int i = 0; i < COUNTRIES.length-1; i++)
         {
             String query = "INSERT INTO CountryInfo(CountryName, InterestRate, CreditRisk, ProfitEarned)"+
                     "VALUES(?,?,?,?)";
             try{
                 PreparedStatement statement = conn.prepareStatement(query);
                 statement.setString(1, COUNTRIES[i]);
                 statement.setInt(2, 0);
                 statement.setInt(3, 0);
                 statement.setInt(4, 0);
                 statement.executeUpdate();
             }
             catch(SQLException err){
                 System.out.println(err);
                 ErrorPopup databaseErr = new ErrorPopup("There has been an error with the database", 400, 400,1000, 750);
             }
         }
    }
    
}
