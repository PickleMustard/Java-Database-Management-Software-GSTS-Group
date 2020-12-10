/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package iaproject.ProgramStream;

import javax.swing.JTable;

/**
 *
 * @author SchoolComputer
 */
public class DeleteDeal
{
    private Object[] selectedDeal;
    public DeleteDeal(JTable mainFile, int rowSelected, Object[][] allDeals,int x,int y,int width,int height){
                int selectedRow = mainFile.getSelectedRow();
                            String tempStorage = (String)mainFile.getValueAt(rowSelected, 0);
                            for (Object[] allDeal : allDeals)
                            {
                                String key = (String) allDeal[0];
                                if(key.equals(tempStorage))
                                {
                                    selectedDeal = allDeal;
                                }
                            }
                            //Get the selected item, then prompt again, then delete if they select yes
                            authorizationPopup ensureIntention = new authorizationPopup(x, y, ((int)(width / 2)), ((int)(height / 2)), selectedDeal, allDeals);
                        //}
    }
}
