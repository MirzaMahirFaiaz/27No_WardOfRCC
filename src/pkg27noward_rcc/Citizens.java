/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg27noward_rcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Citizens extends javax.swing.JFrame {
    public Connection connection;

    /**
     * Creates new form Citizens
     */
    public Citizens() {
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
            String query = "SELECT * FROM Citizens LEFT OUTER Join LivesIn On Citizens.NID_No = LivesIn.NID_No Left Outer Join Houses On LivesIn.Holding_No=Houses.Holding_No";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            String area,name,bd;
            int nid,phn;
            DefaultTableModel model = (DefaultTableModel)jTableCitizens.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                name = rs.getString("Name");
                nid = rs.getInt("NID_No");
                area = rs.getString("Area");
                bd = rs.getString("BirthDate");
                phn=rs.getInt("Phone");
                
                
                
                
                Object[] col = new Object[5];
                
                col[0] = name;
                col[1] = nid;
                col[2] = phn;
                col[3] = area;
                col[4] = bd;
                
            
                model.addRow(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Citizens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         void Insert(){
            String area,name,bd;
            int nid,phn,hNo;
            
            name=textFieldName.getText();
            nid = Integer.valueOf(textFieldNid.getText());
            phn= Integer.valueOf(textFieldphn.getText());
            hNo= Integer.valueOf(textFieldhNo.getText());
            bd =dateChooserComboBD.getText();
            
            
        try {
            
        String sql = "INSERT INTO Citizens ( Name, NID_No, Phone,BirthDate) VALUES (?,?,?,?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        
        ps.setString(1, name);
        ps.setInt(2, nid);
        ps.setInt(3, phn);
        ps.setString(4, bd);
             
        ps.executeUpdate();
        
        sql = "INSERT INTO LivesIn ( NID_No, Holding_No) VALUES (?,?)";
            
        ps = connection.prepareStatement(sql);
            
        
        ps.setInt(2, hNo);
        ps.setInt(1, nid);
        
             
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Added ... ", "Info", JOptionPane.INFORMATION_MESSAGE);
        

            textFieldName.setText("");
            textFieldNid.setText("");
            textFieldphn.setText("");
            textFieldhNo.setText("");
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
          void Update(){
            String area,name,bd;
            int nid,phn,hNo;
            
            name=textFieldName.getText();
            nid = Integer.valueOf(textFieldNid.getText());
            phn= Integer.valueOf(textFieldphn.getText());
            hNo= Integer.valueOf(textFieldhNo.getText());
            bd =dateChooserComboBD.getText();
            
            
        try {
            
                      String sql;
           sql = "UPDATE Citizens Set Name= (?), Phone=(?),BirthDate=(?) Where NID_No=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        ps.setString(1, name);
        ps.setInt(4, nid);
        ps.setInt(2, phn);
        ps.setString(3, bd);
             
        ps.executeUpdate();
        
        sql = "INSERT INTO LivesIn ( NID_No, Holding_No) VALUES (?,?)";
        ps = connection.prepareStatement(sql);
        
        ps.setInt(2, hNo);
        ps.setInt(1, nid);
        
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Updated ... ", "Update Info", JOptionPane.INFORMATION_MESSAGE);
        
            textFieldName.setText("");
            textFieldNid.setText("");
            textFieldphn.setText("");
            textFieldhNo.setText("");
          textFieldNid.setEditable(true);
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong.May be Wrong EIIN number", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
             void Delete(){
         String area,name,bd;
            int nid,phn,hNo;
            
            name=textFieldName.getText();
            nid = Integer.valueOf(textFieldNid.getText());
            phn= Integer.valueOf(textFieldphn.getText());
            hNo= Integer.valueOf(textFieldhNo.getText());
            bd =dateChooserComboBD.getText();
            
            
        try {
                      String sql;
           sql = "Delete From Citizens Where NID_No=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
             
        ps.setInt(1, nid); 
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Info Deleted ... ", "Delete Info", JOptionPane.INFORMATION_MESSAGE);
        
           textFieldName.setText("");
            textFieldNid.setText("");
            textFieldphn.setText("");
            textFieldhNo.setText("");
            textFieldNid.setEditable(true);
      
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong.", "Error", JOptionPane.INFORMATION_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jButtonHouses = new javax.swing.JButton();
        jButton2Store = new javax.swing.JButton();
        jButtonEDU_INS = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldhNo = new java.awt.TextField();
        textFieldName = new java.awt.TextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCitizens = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        textFieldNid = new java.awt.TextField();
        textFieldphn = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        dateChooserComboBD = new datechooser.beans.DateChooserCombo();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("27 No Ward_RCC");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setName(""); // NOI18N

        jButtonHouses.setBackground(new java.awt.Color(0, 0, 0));
        jButtonHouses.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonHouses.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHouses.setText("HOUSES");
        jButtonHouses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHousesActionPerformed(evt);
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
                    .addComponent(jButtonHouses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jButtonHouses)
                .addGap(18, 18, 18)
                .addComponent(jButton2Store)
                .addGap(18, 18, 18)
                .addComponent(jButtonEDU_INS)
                .addGap(325, 325, 325)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setName(""); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("INFO OF CITIZENS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Holding No :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name of the Citizen :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Phone (+880) :");

        textFieldhNo.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldhNo.setForeground(new java.awt.Color(0, 102, 102));
        textFieldhNo.setText("1200000");

        textFieldName.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldName.setForeground(new java.awt.Color(0, 102, 102));

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

        jTableCitizens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NID No.", "Phone No.", "Area", "BirthDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCitizens.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCitizens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCitizensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCitizens);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel6.setText("CITIZENS");

        textFieldNid.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldNid.setForeground(new java.awt.Color(0, 102, 102));
        textFieldNid.setText("234567890");

        textFieldphn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldphn.setForeground(new java.awt.Color(0, 102, 102));
        textFieldphn.setText("234567890");
        textFieldphn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldphnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("NID :");

        dateChooserComboBD.setFormat(1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("BirthDate :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(288, 288, 288))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textFieldhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textFieldphn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel7))
                                            .addComponent(dateChooserComboBD, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldNid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(20, 20, 20)
                                .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(250, 250, 250))
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
                            .addComponent(textFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(textFieldhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldNid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldphn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dateChooserComboBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUpdate)
                            .addComponent(jButtonDelete)
                            .addComponent(jButtonAdd))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jButtonHousesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHousesActionPerformed
dispose();
        House obj = new House();
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHousesActionPerformed

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
        ViewData();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void textFieldphnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldphnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldphnActionPerformed

    private void jTableCitizensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCitizensMouseClicked
DefaultTableModel tblModel = (DefaultTableModel)jTableCitizens.getModel();
            String tblName= tblModel.getValueAt(jTableCitizens.getSelectedRow(),0).toString();
            String tblbd= tblModel.getValueAt(jTableCitizens.getSelectedRow(),4).toString();
            String tblnid= tblModel.getValueAt(jTableCitizens.getSelectedRow(),1).toString();
            String tblPhn= tblModel.getValueAt(jTableCitizens.getSelectedRow(),2).toString();
            

              textFieldName.setText(tblName);
              textFieldNid.setText(tblnid);
              dateChooserComboBD.setText(tblbd);
              textFieldphn.setText(tblPhn);
              textFieldNid.setEditable(false);
              try {
            
        String sql = "Delete From LivesIn Where NID_No=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        int nid =Integer.parseInt(tblnid);
        ps.setInt(1, nid);
        ps.executeUpdate();
            
        //JOptionPane.showMessageDialog(null, "Info Added ... ", "Info", JOptionPane.INFORMATION_MESSAGE);

       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
              // TODO add your handling code here:
    }//GEN-LAST:event_jTableCitizensMouseClicked

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
            java.util.logging.Logger.getLogger(Citizens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Citizens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Citizens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Citizens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Citizens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserComboBD;
    private javax.swing.JButton jButton2Store;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEDU_INS;
    private javax.swing.JButton jButtonHouses;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCitizens;
    private java.awt.TextField textFieldName;
    private java.awt.TextField textFieldNid;
    private java.awt.TextField textFieldhNo;
    private java.awt.TextField textFieldphn;
    // End of variables declaration//GEN-END:variables
}
