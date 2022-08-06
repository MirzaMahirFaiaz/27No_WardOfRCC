/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg27noward_rcc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class House extends javax.swing.JFrame {
    public Connection connection;

    /**
     * Creates new form House
     */
    public House() {
        initComponents();
        connectDB();
        ViewData();
    }
    
     public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=27NoWord;selectMethod=cursor", "sa", "123456");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void ViewData(){
        
        try {
            String query = "SELECT * FROM Houses";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            String area,houseName;
            int ownerNID,holdingNo;
            DefaultTableModel model = (DefaultTableModel)jTableHouses.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                houseName = rs.getString("House_Name");
                holdingNo = rs.getInt("Holding_No");
                ownerNID = rs.getInt("Owner_NID");
                area = rs.getString("Area");
                
                
                
                Object[] col = new Object[4];
                
                col[0] = houseName;
                col[1] = holdingNo;
                col[2] = ownerNID;
                col[3] = area;
                
            
                model.addRow(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     void Update(){
            String area,houseName;
            int ownerNID,holdingNo;
            area = jComboBoxArea.getSelectedItem().toString();
            ownerNID=Integer.valueOf(textFieldOwnersNID.getText());
            houseName=textFieldHouseName.getText();
            holdingNo = Integer.valueOf(textFieldHoldingNo.getText());
            
            
        try {
            
                      String sql;
           sql = "UPDATE Houses Set House_Name= (?), Area=(?),Owner_NID=(?) Where Holding_No=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        
       ps.setString(1, houseName);
        ps.setString(2, area);
        ps.setInt(3, ownerNID);
        ps.setInt(4, holdingNo);
       
             
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Updated ... ", "Update Info", JOptionPane.INFORMATION_MESSAGE);
        

            textFieldHouseName.setText("");
            textFieldOwnersNID.setText("");
            textFieldHoldingNo.setText("");
            jComboBoxArea.setSelectedItem("");
          textFieldHoldingNo.setEditable(true);
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
     void Delete(){
          String area,houseName;
            int ownerNID,holdingNo;
            area = jComboBoxArea.getSelectedItem().toString();
            ownerNID=Integer.valueOf(textFieldOwnersNID.getText());
            houseName=textFieldHouseName.getText();
            holdingNo = Integer.valueOf(textFieldHoldingNo.getText());
            
        try {
            
                      String sql;
           sql = "Delete From Houses Where Holding_No=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
         ps.setInt(1, holdingNo);
        
             
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Deleted ... ", "Delete Info", JOptionPane.INFORMATION_MESSAGE);
        

              textFieldHouseName.setText("");
            textFieldOwnersNID.setText("");
            textFieldHoldingNo.setText("");
            jComboBoxArea.setSelectedItem("");
           textFieldHoldingNo.setEditable(true);
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
       void Insert(){
            String area,houseName;
            int ownerNID,holdingNo;
            area = jComboBoxArea.getSelectedItem().toString();
            ownerNID=Integer.valueOf(textFieldOwnersNID.getText());
            houseName=textFieldHouseName.getText();
            holdingNo = Integer.valueOf(textFieldHoldingNo.getText());
            
            
        try {
            
        String sql = "INSERT INTO Houses ( House_Name, Holding_No,Owner_NID, Area) VALUES (?,?,?,?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        
        ps.setString(1, houseName);
        ps.setInt(2, holdingNo);
        ps.setInt(3, ownerNID);
        ps.setString(4, area);
             
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Added ... ", "Info", JOptionPane.INFORMATION_MESSAGE);
        
//        jTextFieldFirstName.setText("");
//        jTextFieldLastName.setText("");
//        jTextFieldRelationship.setText("");
//        jTextFieldPhone.setText("");
            textFieldHouseName.setText("");
            textFieldOwnersNID.setText("");
            textFieldHoldingNo.setText("");
            jComboBoxArea.setSelectedItem("");
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxArea = new javax.swing.JComboBox<>();
        textFieldHoldingNo = new java.awt.TextField();
        textFieldHouseName = new java.awt.TextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHouses = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        textFieldOwnersNID = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonCitizens = new javax.swing.JButton();
        jButton2Store = new javax.swing.JButton();
        jButtonEDU_INS = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("27 No Ward_RCC");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setName(""); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("INFO OF HOUSES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Holding NO :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name of the House :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Owner's NID :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Area :");

        jComboBoxArea.setForeground(new java.awt.Color(0, 102, 102));
        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baliapukur", "Vodra", "Debishing Para", "Monnafer Mor", "Shadhur Mor", "Mirer chok", "Tikapara", "Moth Pukur" }));

        textFieldHoldingNo.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldHoldingNo.setForeground(new java.awt.Color(0, 102, 102));
        textFieldHoldingNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldHoldingNoActionPerformed(evt);
            }
        });

        textFieldHouseName.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldHouseName.setForeground(new java.awt.Color(0, 102, 102));

        jButtonAdd.setBackground(new java.awt.Color(0, 102, 102));
        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("ADD");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 102, 102));
        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("UPDATE");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 102, 102));
        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTableHouses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "House Name", "Holding No.", "Owner's NID", "Area"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHouses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHousesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHouses);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel6.setText("HOUSES");

        textFieldOwnersNID.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldOwnersNID.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(288, 288, 288))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldHoldingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldOwnersNID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(textFieldHouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldHouseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldHoldingNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldOwnersNID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setName(""); // NOI18N

        jButtonCitizens.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCitizens.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCitizens.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCitizens.setText("CITIZENS");
        jButtonCitizens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCitizensActionPerformed(evt);
            }
        });

        jButton2Store.setBackground(new java.awt.Color(0, 0, 0));
        jButton2Store.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2Store.setForeground(new java.awt.Color(255, 255, 255));
        jButton2Store.setText("STORES");
        jButton2Store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2StoreActionPerformed(evt);
            }
        });

        jButtonEDU_INS.setBackground(new java.awt.Color(0, 0, 0));
        jButtonEDU_INS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEDU_INS.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEDU_INS.setText("EDU_INS");
        jButtonEDU_INS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEDU_INSActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("© Monon_Mirza");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCitizens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2Store, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEDU_INS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jButtonCitizens)
                .addGap(18, 18, 18)
                .addComponent(jButton2Store)
                .addGap(18, 18, 18)
                .addComponent(jButtonEDU_INS)
                .addGap(325, 325, 325)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
   Insert();
   ViewData();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
    Update();
   ViewData();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
    Delete();
      ViewData();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCitizensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCitizensActionPerformed
dispose();
        Citizens obj = new Citizens();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCitizensActionPerformed

    private void jButton2StoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2StoreActionPerformed
  dispose();
        Store_Info obj = new Store_Info();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2StoreActionPerformed

    private void jButtonEDU_INSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEDU_INSActionPerformed
        // TODO add your handling code here:
        dispose();
        Edu_Ins obj = new Edu_Ins();
        obj.setVisible(true);
    }//GEN-LAST:event_jButtonEDU_INSActionPerformed

    private void textFieldHoldingNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldHoldingNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldHoldingNoActionPerformed

    private void jTableHousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHousesMouseClicked
DefaultTableModel tblModel = (DefaultTableModel)jTableHouses.getModel();
            String tblhName= tblModel.getValueAt(jTableHouses.getSelectedRow(),0).toString();
            String tblaName= tblModel.getValueAt(jTableHouses.getSelectedRow(),3).toString();
            String tblhNo= tblModel.getValueAt(jTableHouses.getSelectedRow(),1).toString();
            String tbloNID= tblModel.getValueAt(jTableHouses.getSelectedRow(),2).toString();
            

              textFieldHouseName.setText(tblhName);
              textFieldHoldingNo.setText(tblhNo);
              textFieldOwnersNID.setText(tbloNID);
              jComboBoxArea.setSelectedItem(tblaName);
              textFieldHoldingNo.setEditable(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jTableHousesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(House.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(House.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(House.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(House.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new House().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2Store;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCitizens;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEDU_INS;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHouses;
    private java.awt.TextField textFieldHoldingNo;
    private java.awt.TextField textFieldHouseName;
    private java.awt.TextField textFieldOwnersNID;
    // End of variables declaration//GEN-END:variables
}
