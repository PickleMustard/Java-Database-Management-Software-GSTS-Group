
//package iaproject.ProgramStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class inspectDeal extends JFrame implements ActionListener {
    private  JLabel bankCountryInd;
    private  JLabel bankCountryIns;
    private  JLabel bankNameInd;
    private  JLabel bankNameIns;
    private  JLabel cargoDestInd;
    private  JLabel cargoDestIns;
    private  JLabel cargoRentalInd;
    private  JLabel cargoRentalIns;
    private  JButton closeInspector;
    private  JLabel creditSupportFeeInd;
    private  JLabel creditSupportIns;
    private  JLabel discountDateInd;
    private  JLabel discountDateIns;
    private  JLabel docValueInd;
    private  JLabel docValueIns;
    private  JPanel inspectorContainment;
    private  JLabel maturityDateInd;
    private  JLabel maturityDateIns;
    private  JLabel partnerNameInd;
    private  JLabel partnerNameIns;
    private  JLabel profitEarnedInd;
    private  JLabel profitEarnedIns;
    private  JLabel supplierNameInd;
    private  JLabel supplierNameIns;
    private  JLabel tenorInd;
    private  JLabel tenorIns;
    private  JLabel tradeNumberInd;
    private  JLabel tradeNumberIns;
    private  JLabel transactionTypeInd;
    private  JLabel transactionTypeIns;
    
    private String tradeNumber;
    private String bankName;
    private String supplierName;
    private String bankCountry;
    private String cargoDest;
    private String cargoRent;
    private String docValue;
    private String transactionType;
    private String tenor;
    private String discountDate;
    private String maturityDate;
    private String profitEarned;
    private String creditSupport;
    private String partnerName;
    private Object[] deal;
    
    private  GroupLayout containmentLayout;
    private GroupLayout frameLayout;
    
    public inspectDeal(Object[] dealToDisplay, int x, int y, int width, int height, String name){
        
        super(name);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(x, y, width, height);
        
        deal = dealToDisplay;
        
        getValues();
        
        inspectorContainment = new  JPanel();
        containmentLayout = new GroupLayout(inspectorContainment);
        //Set the layout of the panel
        inspectorContainment.setLayout( containmentLayout);
        
        frameLayout = new GroupLayout(this.getContentPane());
        //Set the panels layout within the frame:s
         this.getContentPane().setLayout(frameLayout);
        
        tradeNumberInd = new  JLabel("Trade Number:");
        tradeNumberIns = new  JLabel(tradeNumber);
        bankNameInd = new  JLabel("Bank Name:");
        bankNameIns = new  JLabel(bankName);
        supplierNameInd = new  JLabel("Supplier Name:");
        supplierNameIns = new  JLabel(supplierName);
        bankCountryInd = new  JLabel("Country of Bank:");
        bankCountryIns = new  JLabel(bankCountry);
        cargoDestInd = new  JLabel("Destination:");
        cargoDestIns = new  JLabel(cargoDest);
        cargoRentalInd = new  JLabel("Cargo Rental:");
        cargoRentalIns = new  JLabel(cargoRent);
        docValueInd = new  JLabel("Doc Value:");
        docValueIns = new  JLabel(docValue);
        transactionTypeInd = new  JLabel("Transaction Type Date:");
        transactionTypeIns = new  JLabel(transactionType);
        tenorInd = new  JLabel("Tenor:");
        tenorIns = new  JLabel(tenor);
        discountDateInd = new  JLabel("Discount Date:");
        discountDateIns = new  JLabel(discountDate);
        maturityDateInd = new  JLabel("Maturity Date:");
        maturityDateIns = new  JLabel(maturityDate);
        profitEarnedInd = new  JLabel("Profit Earned: ");
        profitEarnedIns = new  JLabel(profitEarned);
        creditSupportFeeInd = new  JLabel("Credit Support Fee:");
        creditSupportIns = new  JLabel(creditSupport);
        partnerNameInd = new  JLabel("Partner Name:");
        partnerNameIns = new  JLabel(partnerName);
        
        closeInspector = new  JButton("Close");
        closeInspector.addActionListener(this);

        setLayout();
        this.setVisible(true);
    }
    
    private void getValues()
    {
        tradeNumber = (String) deal[0];
        bankName = (String) deal[1];
        supplierName = (String) deal[3];
        bankCountry = (String) deal[4];
        cargoDest = (String) deal[5];
        cargoRent = (String) deal[6];
        docValue = (String) deal[7];
        transactionType = (String) deal[8];
        tenor = (String) deal[9];
        discountDate = (String) deal[10];
        maturityDate = (String) deal[11];
        profitEarned = (String) deal[12];
        creditSupport = (String) deal[13];
        partnerName = (String) deal[2];
    }
     
    private void setLayout()
    {
        
        
        //Set the horizontal grouping of the labels in the panel
         containmentLayout.setHorizontalGroup(
             containmentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup( containmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(tradeNumberInd)
                        .addGap(39, 39, 39)
                        .addComponent(tradeNumberIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(bankNameInd)
                        .addGap(39, 39, 39)
                        .addComponent(bankNameIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(supplierNameInd)
                        .addGap(39, 39, 39)
                        .addComponent(supplierNameIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(bankCountryInd)
                        .addGap(39, 39, 39)
                        .addComponent(bankCountryIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(cargoDestInd)
                        .addGap(39, 39, 39)
                        .addComponent(cargoDestIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(cargoRentalInd)
                        .addGap(39, 39, 39)
                        .addComponent(cargoRentalIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(docValueInd)
                        .addGap(39, 39, 39)
                        .addComponent(docValueIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(transactionTypeInd)
                        .addGap(39, 39, 39)
                        .addComponent(transactionTypeIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(tenorInd)
                        .addGap(39, 39, 39)
                        .addComponent(tenorIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(discountDateInd)
                        .addGap(39, 39, 39)
                        .addComponent(discountDateIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(maturityDateInd)
                        .addGap(39, 39, 39)
                        .addComponent(maturityDateIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(profitEarnedInd)
                        .addGap(39, 39, 39)
                        .addComponent(profitEarnedIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(creditSupportFeeInd)
                        .addGap(39, 39, 39)
                        .addComponent(creditSupportIns))
                    .addGroup( containmentLayout.createSequentialGroup()
                        .addComponent(partnerNameInd)
                        .addGap(39, 39, 39)
                        .addComponent(partnerNameIns)))
                .addContainerGap(711, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING,  containmentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeInspector, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        );
         
         //Set the vertical grouping of the labels in the panel
         containmentLayout.setVerticalGroup(
             containmentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup( containmentLayout.createSequentialGroup()
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tradeNumberInd)
                    .addComponent(tradeNumberIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bankNameInd)
                    .addComponent(bankNameIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierNameInd)
                    .addComponent(supplierNameIns))
                .addGap(9, 9, 9)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(partnerNameInd)
                    .addComponent(partnerNameIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bankCountryInd)
                    .addComponent(bankCountryIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cargoDestInd)
                    .addComponent(cargoDestIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cargoRentalInd)
                    .addComponent(cargoRentalIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(docValueInd)
                    .addComponent(docValueIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionTypeInd)
                    .addComponent(transactionTypeIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tenorInd)
                    .addComponent(tenorIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(discountDateInd)
                    .addComponent(discountDateIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(maturityDateInd)
                    .addComponent(maturityDateIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profitEarnedInd)
                    .addComponent(profitEarnedIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup( containmentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(creditSupportFeeInd)
                    .addComponent(creditSupportIns))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(closeInspector, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
         
         
         
         //Set the horizontal setting
         frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inspectorContainment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
         //Set the vertical grouping
         frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inspectorContainment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
         
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourceObject = e.getSource();
        if(sourceObject == closeInspector)
        {
            this.dispose();
        }
    }
}
