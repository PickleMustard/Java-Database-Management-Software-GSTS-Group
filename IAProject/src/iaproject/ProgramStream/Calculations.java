
//package iaproject.ProgramStream;

//import iaproject.Installer.DatabaseAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class Calculations {
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
    
    Object[][] allDeals;
    Object[][] allBanks;
    Object[][] allPartners;
    Object[][] allCountries;
    
    infoModificationWindow inputs;
    DatabaseAccess datAcs;
    Connection conn; 
    
    int dealProfitEarned;
    int totalBankProfit;
    int totalCountryProfit;
    int budgetForMonth;
    int budgetForYear;
    
    int width;
    int height;
    int x;
    int y;
    
    public Calculations(infoModificationWindow inputs, int x, int y, int width, int height)
    {
        this.inputs = inputs;
        datAcs = new DatabaseAccess("MainFile");
        conn = datAcs.getDbConn();
        getData();
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    private void getData(){
        String[] dealColumnNames = datAcs.getDEAL_INFO_COLUMNS();
        String[] bankColumnNames = datAcs.getBANK_INFO_COLUMNS();
        String[] partnerColumnNames = datAcs.getSUPPLIER_INFO_COLUMNS();
        String[] countryColumnNames = datAcs.getCOUNTRY_INFO_COLUMNS();
        allDeals = datAcs.getData("DealInfo", dealColumnNames);
        allBanks = datAcs.getData("BankInfo", bankColumnNames);
        allPartners = datAcs.getData("SupplierInfo", partnerColumnNames);
        allCountries = datAcs.getData("CountryInfo", countryColumnNames);
    }
    public int getDealProfit(){
        return findTotalDealProfit();
    }
    public int getTotalBankProfit(String bankName){
        return findTotalBankProfit(bankName);
    }
    public int getTotalCountryProfit(String countryName){
        return findTotalCountryProfit(countryName);
    }
    private int findTotalDealProfit(){
        int correspondingProfit = 0;
        int bankFees = 0;
        int supplierFee = 0;
        int loanValue = 0;
        int supportFee = 0;
        double cargoRental = 0;
        
        //For all deals in the database
        for(int i = 0; i < allDeals.length-1; i++)
        {
            //Create query
            String query;
            //Set all fees equal to zero incase of failure
            bankFees = 0;
            supplierFee = 0;
            //Get the values of loan value, cargot rental, and support fee
            loanValue = Integer.parseInt((String)allDeals[i][6]);
            cargoRental = Double.parseDouble((String)allDeals[i][4]);
            supportFee = Integer.parseInt((String)allDeals[i][13]);
            //Get the values for bankfees
            for (Object[] allBank : allBanks) {
                String deal = (String)allDeals[i][1];
                String bank = (String) allBank[0];
                if (deal.equals(bank)) {
                    bankFees = Integer.parseInt((String)allBank[7]);
                }
            }
            //Get the values for supplier fees
            for (Object[] allPartner : allPartners) {
                String deal = (String)allDeals[i][2];
                String partner = (String) allPartner[0];
                if (deal.equals(partner)) {
                    supplierFee = Integer.parseInt((String)allPartner[1]);
                }
            }            
        }
        correspondingProfit = ((int)(loanValue - bankFees - supplierFee- supportFee-cargoRental));
        return correspondingProfit;
    }
    //Total profit made from all the deals with a bank
    private int findTotalBankProfit(String bankName){
        //Where the bank is equal to the one in the deal, add the profit to it. then modify it
        //Go  through all the banks
        int bankProfit = 0;
            String query;
            //If there is a deal with that bank in it, add the profit to the total profit for the bank
            for (Object[] allDeal : allDeals) {
                String deal = (String) allDeal[2];
                if (deal.equals(bankName)) {
                    bankProfit += (int) allDeal[12];
                }
            }
        return bankProfit;
    }
    private int findTotalCountryProfit(String countryName){
       //Where the bank is equal to the one in the deal, add the profit to it. then modify it
        //Go  through all the banks
            int countryProfit = 0;
            String query;
            //If there is a deal with that bank in it, add the profit to the total profit for the bank
            for(int i = 0; i < allDeals.length-1; i++){ 
                    String deal = (String) allDeals[i][5];
                    if (deal.equals(countryName)) {
                        countryProfit += (int) allDeals[i][12];
                    }
            }
            return countryProfit;
        }
}
