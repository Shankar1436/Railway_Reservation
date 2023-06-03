
package Railway;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author shank
 */
public class reservation extends javax.swing.JFrame {

   
    public reservation() {
        initComponents();
        Connect();
        LoadStartplace();
        LoadEndplace();
        LoadPref();
        
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public void LoadPref()
    {
        txtBerthPref.removeAllItems();
        txtBerthPref.addItem("Upper Berth");
        txtBerthPref.addItem("Middle Berth");
        txtBerthPref.addItem("Lower Berth");
        txtBerthPref.addItem("Side Upper");
        txtBerthPref.addItem("Side Lower");
        




    }
    
    
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost/railway","root","");
            } catch (SQLException ex) {
                Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadStartplace()
    {
      /*
        @auth: Shankar Gowd 
        @Description: Getting and Loading the Source into the Database 
        
        */
        try
        {
            
            pst=con.prepareStatement("SELECT startplace FROM traindetails");
            rs=pst.executeQuery();
            txtsplace.removeAllItems(); //Removing previously fetched values for replacing the items in the field.
            while(rs.next())
            {
                txtsplace.addItem(rs.getString(1));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     public void LoadEndplace()
    {
        
      /*
        @auth: Shankar Gowd 
        @Description: Getting and Loading the Destination into the Database 
        
        */
      
        try
        {
            
            pst=con.prepareStatement("SELECT destinationplace FROM traindetails");
            rs=pst.executeQuery();
            txteplace.removeAllItems(); //To Remove previously fetched values. 
            while(rs.next())
            {
                txteplace.addItem(rs.getString(1));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     public void load()
     {
         String splace=txtsplace.getSelectedItem().toString();
         String eplace =txteplace.getSelectedItem().toString();
         try
         {
             pst=con.prepareStatement("SELECT * FROM traindetails where startplace = ? and destinationplace=?");
             pst.setString(1,splace);
             pst.setString(2,eplace);
             rs=pst.executeQuery();
             if(rs.next()==true)
             {
                 txttno.setText(rs.getString(1));
                 txttname.setText(rs.getString(2));
                 txtprice.setText(rs.getString(5));
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "No Train is operating from "+splace+" to "+eplace);
             }
             
         }
         catch (Exception e)
         {
                     e.printStackTrace();
         }
             
     }
     public void findSeats()
     {
         String berth=txtBerthPref.getSelectedItem().toString();
         String coach="S";
         int k=(int)(Math.random()*100)%15;
         while(k==0)
         {
             k=(int)(Math.random()*100)%15;
         }
         coach+=k;
         showSeats.removeAllItems();
         
         
         try
         {
             switch(berth){
                 case "Upper Berth":
                     showSeats.addItem(coach+ "-1");
                     showSeats.addItem(coach+ "-4");
                     showSeats.addItem(coach+ "-9");
                     showSeats.addItem(coach+ "-12");
                     showSeats.addItem(coach+ "-17");
                     showSeats.addItem(coach+ "-20");
                     showSeats.addItem(coach+ "-25");
                     showSeats.addItem(coach+ "-28");
                     showSeats.addItem(coach+ "-33");
                     showSeats.addItem(coach+ "-36");
                     showSeats.addItem(coach+ "-41");
                     showSeats.addItem(coach+ "-44");
                     showSeats.addItem(coach+ "-49");
                     showSeats.addItem(coach+ "-52");
                     showSeats.addItem(coach+ "-57");
                     showSeats.addItem(coach+ "-60");
                     showSeats.addItem(coach+ "-65");
                     showSeats.addItem(coach+ "-68");
                     
                     
                     break;
                 case "Middle Berth":
                     showSeats.addItem(coach+ "-2");
                     showSeats.addItem(coach+ "-5");
                     showSeats.addItem(coach+ "-10");
                     showSeats.addItem(coach+ "-13");
                     showSeats.addItem(coach+ "-18");
                     showSeats.addItem(coach+ "-21");
                     showSeats.addItem(coach+ "-26");
                     showSeats.addItem(coach+ "-29");
                     showSeats.addItem(coach+ "-34");
                     showSeats.addItem(coach+ "-37");
                     showSeats.addItem(coach+ "-42");
                     showSeats.addItem(coach+ "-45");
                     showSeats.addItem(coach+ "-50");
                     showSeats.addItem(coach+ "-53");
                     showSeats.addItem(coach+ "-58");
                     showSeats.addItem(coach+ "-61");
                     showSeats.addItem(coach+ "-66");
                     showSeats.addItem(coach+ "-69");
                     
                     
                     
                     
                     
                     break;
                 case "Lower Berth":
                     showSeats.addItem(coach+ "-3");
                     showSeats.addItem(coach+ "-6");
                     showSeats.addItem(coach+ "-11");
                     showSeats.addItem(coach+ "-14");
                     showSeats.addItem(coach+ "-19");
                     showSeats.addItem(coach+ "-22");
                     showSeats.addItem(coach+ "-27");
                     showSeats.addItem(coach+ "-30");
                     showSeats.addItem(coach+ "-35");
                     showSeats.addItem(coach+ "-38");
                     showSeats.addItem(coach+ "-43");
                     showSeats.addItem(coach+ "-46");
                     showSeats.addItem(coach+ "-51");
                     showSeats.addItem(coach+ "-54");
                     showSeats.addItem(coach+ "-59");
                     showSeats.addItem(coach+ "-62");
                     showSeats.addItem(coach+ "-67");
                     showSeats.addItem(coach+ "-70");
                     break;
                 case "Side Upper":
                     showSeats.addItem(coach+ "-7");
                     showSeats.addItem(coach+ "-15");
                     showSeats.addItem(coach+ "-23");
                     showSeats.addItem(coach+ "-31");
                     showSeats.addItem(coach+ "-39");
                     showSeats.addItem(coach+ "-47");
                     showSeats.addItem(coach+ "-55");
                     showSeats.addItem(coach+ "-63");
                     showSeats.addItem(coach+ "-71");
                     break;
                 case "Side Lower":
                      showSeats.addItem(coach+ "-8");
                     showSeats.addItem(coach+ "-16");
                     showSeats.addItem(coach+ "-24");
                     showSeats.addItem(coach+ "-32");
                     showSeats.addItem(coach+ "-40");
                     showSeats.addItem(coach+ "-48");
                     showSeats.addItem(coach+ "-56");
                     showSeats.addItem(coach+ "-64");
                     showSeats.addItem(coach+ "-72");
                         break;
                 default:
                         break;
             }
           
             
         }
         catch (Exception e)
         {
                     e.printStackTrace();
         }
         
         
     }
   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpno = new javax.swing.JTextField();
        txtsplace = new javax.swing.JComboBox<>();
        txteplace = new javax.swing.JComboBox<>();
        txttno = new javax.swing.JTextField();
        txttname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtticket = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        seatPreference = new javax.swing.JLabel();
        txtBerthPref = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        showSeats = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Reservation");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Passenger No");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Start Place");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("End Place");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Train  No");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Train  Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Total");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("No of Tickets");

        txtticket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtticketKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        seatPreference.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seatPreference.setText("Seat Preference");

        txtBerthPref.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Upper Berth", "Middle Berth", "Lower Berth", "Side Upper", "Side Lower" }));
        txtBerthPref.setSelectedIndex(-1);
        txtBerthPref.setSelectedItem(null);
        txtBerthPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBerthPrefActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Seat No");

        showSeats.setMaximumRowCount(30);

        jButton3.setText("Find Seats");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatPreference, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtprice)
                    .addComponent(txttname)
                    .addComponent(txttno)
                    .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpno)
                    .addComponent(txtticket)
                    .addComponent(txttotal)
                    .addComponent(txteplace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsplace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBerthPref, 0, 209, Short.MAX_VALUE)
                    .addComponent(showSeats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtsplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txteplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatPreference, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBerthPref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        load();
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtticketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtticketKeyPressed
        // TODO add your handling code here:
        int price,ticket,tot;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            price=Integer.parseInt(txtprice.getText());
            ticket=Integer.parseInt(txtticket.getText());
            tot=price*ticket;
            txttotal.setText(String.valueOf(tot));
            
            
        }
    }//GEN-LAST:event_txtticketKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String pno=txtpno.getText();
        String splace=txtsplace.getSelectedItem().toString();
        String eplace=txteplace.getSelectedItem().toString();
        
        String tno=txttno.getText();
        String tname=txttname.getText();
        String price=txtprice.getText();
        SimpleDateFormat date_form=new SimpleDateFormat("yyyy-MM-dd");
        String date=date_form.format(txtdate.getDate());
        String ticket=txtticket.getText();
        String total=txttotal.getText();
        String seatNo=showSeats.getSelectedItem().toString();
        String s=""+Math.random();
        int k=0;
        String g="";
        
        for(int i=s.length()-1;i>=0 && k<=10;i--)
        {
            
            if(k!=3)
            {
                g+=s.charAt(i);
            }
            else
            {
                g+='-';
            }
            k++;
        }
        String PNR=g;
        try {
            
            pst=con.prepareStatement("insert into reservation(pno,splace,eplace,tno,tname,seatNo,PNR,price,date,ticket,tot)values(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, pno);
                pst.setString(2, splace);
                pst.setString(3, eplace);
                pst.setString(4, tno);
                pst.setString(5, tname);
                pst.setString(6, seatNo);
                pst.setString(7, PNR);
                
                pst.setString(8, price);
                pst.setString(9, date);
                pst.setString(10, ticket);
                pst.setString(11, total);
                
                int l=pst.executeUpdate();
                if(l==1)
                {
                    JOptionPane.showMessageDialog(this,"Ticket Reserved!!!"+ '\n' +" your PNR is: "+PNR);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Reservation Failed");
                }
                
        }
        
        catch (SQLException ex) {
            Logger.getLogger(addtrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBerthPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBerthPrefActionPerformed
        
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        findSeats();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservation().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel seatPreference;
    private javax.swing.JComboBox<String> showSeats;
    private javax.swing.JComboBox<String> txtBerthPref;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox<String> txteplace;
    private javax.swing.JTextField txtpno;
    private javax.swing.JTextField txtprice;
    private javax.swing.JComboBox<String> txtsplace;
    private javax.swing.JTextField txtticket;
    private javax.swing.JTextField txttname;
    private javax.swing.JTextField txttno;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
