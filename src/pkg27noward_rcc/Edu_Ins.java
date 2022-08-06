/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg27noward_rcc;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author HP
 */
public class Edu_Ins extends javax.swing.JFrame {
    public Connection connection;

    /**
     * Creates new form Edu_Ins
     */
    public Edu_Ins() {
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
            String query = "SELECT * FROM Edu_Ins";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            String area,insName,hiClass;
            int eiin;
            DefaultTableModel model = (DefaultTableModel)jTableInstitute.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                
                insName = rs.getString("InsName");
                eiin = rs.getInt("EIIN");
                area = rs.getString("Area");
                hiClass = rs.getString("HighestClass");
                
                
                
                
                Object[] col = new Object[4];
                
                col[0] = insName;
                col[1] = eiin;
                col[2] = hiClass;
                col[3] = area;
                
            
                model.addRow(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Edu_Ins.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void Update(){
            String area,insName,hiClass;
            int eiin;
            area = jComboBoxArea.getSelectedItem().toString();
            hiClass=jComboBoxHighestClass.getSelectedItem().toString();
            insName=textFieldInstituteName.getText();
            eiin = Integer.valueOf(textFieldEIIN.getText());
            
            
        try {
            
                      String sql;
           sql = "UPDATE Edu_Ins Set InsName= (?), Area=(?),HighestClass=(?) Where EIIN=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        
        ps.setString(1, insName);
        ps.setInt(4, eiin);
        ps.setString(2, area);
        ps.setString(3, hiClass);
             
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Updated ... ", "Update Info", JOptionPane.INFORMATION_MESSAGE);
        
            textFieldInstituteName.setText("");
            textFieldEIIN.setText("");
            jComboBoxHighestClass.setSelectedItem("Baliapukur");
            jComboBoxArea.setSelectedItem("1");
          textFieldEIIN.setEditable(true);
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong.May be Wrong EIIN number", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    void Insert(){
            String area,insName,hiClass;
            int eiin;
            area = jComboBoxArea.getSelectedItem().toString();
            hiClass=jComboBoxHighestClass.getSelectedItem().toString();
            insName=textFieldInstituteName.getText();
            eiin = Integer.valueOf(textFieldEIIN.getText());
            
            
        try {
            
        String sql = "INSERT INTO Edu_Ins ( InsName, EIIN, Area,HighestClass) VALUES (?,?,?,?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        
        ps.setString(1, insName);
        ps.setInt(2, eiin);
        ps.setString(3, area);
        ps.setString(4, hiClass);
             
        ps.executeUpdate();
            
        JOptionPane.showMessageDialog(null, "Info Added ... ", "Info", JOptionPane.INFORMATION_MESSAGE);
        

            textFieldInstituteName.setText("");
            textFieldEIIN.setText("");
            jComboBoxHighestClass.setSelectedItem("Baliapukur");
            jComboBoxArea.setSelectedItem("1");
        
       
    }
    catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    void Delete(){
          String area,insName,hiClass;
            int eiin;
            area = jComboBoxArea.getSelectedItem().toString();
            hiClass=jComboBoxHighestClass.getSelectedItem().toString();
            insName=textFieldInstituteName.getText();
            eiin = Integer.valueOf(textFieldEIIN.getText());
            
            
        try {
                      String sql;
           sql = "Delete From Edu_Ins Where EIIN=(?)";
            
        PreparedStatement ps = connection.prepareStatement(sql);
            
        
        
        ps.setInt(1, eiin); 
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Info Deleted ... ", "Delete Info", JOptionPane.INFORMATION_MESSAGE);
        
            textFieldInstituteName.setText("");
            textFieldEIIN.setText("");
            jComboBoxHighestClass.setSelectedItem("Baliapukur");
            jComboBoxArea.setSelectedItem("1");
          textFieldEIIN.setEditable(true);
      
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
        jButtonCitizens = new javax.swing.JButton();
        jButtonHouse = new javax.swing.JButton();
        jButtonSTORE = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxArea = new javax.swing.JComboBox<>();
        jComboBoxHighestClass = new javax.swing.JComboBox<>();
        textFieldEIIN = new java.awt.TextField();
        textFieldInstituteName = new java.awt.TextField();
        jButton4 = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInstitute = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("27 No Ward_RCC");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jButtonCitizens.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCitizens.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCitizens.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCitizens.setText("CITIZENS");
        jButtonCitizens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCitizensActionPerformed(evt);
            }
        });

        jButtonHouse.setBackground(new java.awt.Color(0, 0, 0));
        jButtonHouse.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonHouse.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHouse.setText("HOUSES");
        jButtonHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHouseActionPerformed(evt);
            }
        });

        jButtonSTORE.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSTORE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSTORE.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSTORE.setText("STORES");
        jButtonSTORE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSTOREActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("© Monon_Mirza");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCitizens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSTORE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jButtonCitizens)
                .addGap(18, 18, 18)
                .addComponent(jButtonHouse)
                .addGap(18, 18, 18)
                .addComponent(jButtonSTORE)
                .addGap(325, 325, 325)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LIST OF EDUCATIONAL INSTITUTE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("EIIN :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name of the Institue :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Highest Class :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Area :");

        jComboBoxArea.setForeground(new java.awt.Color(0, 102, 102));
        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baliapukur", "Vodra", "Debishing Para", "Monnafer Mor", "Shadhur Mor", "Mirer chok", "Tikapara", "Moth Pukur" }));

        jComboBoxHighestClass.setForeground(new java.awt.Color(0, 102, 102));
        jComboBoxHighestClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "SSC", "HSC", "Honors" }));

        textFieldEIIN.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldEIIN.setForeground(new java.awt.Color(0, 102, 102));
        textFieldEIIN.setText("120");

        textFieldInstituteName.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        textFieldInstituteName.setForeground(new java.awt.Color(0, 102, 102));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jTableInstitute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Edu_Ins Name", "EIIN", "Highest Class", "Area Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInstitute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInstituteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTableInstituteMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(jTableInstitute);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel6.setText("Educational Institutions");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(jLabel1))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFieldEIIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxArea, 0, 140, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxHighestClass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3)
                                .addGap(20, 20, 20)
                                .addComponent(textFieldInstituteName, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(222, 222, 222))
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
                            .addComponent(textFieldInstituteName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldEIIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jComboBoxHighestClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
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

    private void jButtonCitizensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCitizensActionPerformed
dispose();
        Citizens obj = new Citizens();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCitizensActionPerformed

    private void jButtonHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHouseActionPerformed
dispose();
        House obj = new House();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHouseActionPerformed

    private void jButtonSTOREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSTOREActionPerformed
        // TODO add your handling code here:
        dispose();
        Store_Info obj = new Store_Info();
        obj.setVisible(true);
    }//GEN-LAST:event_jButtonSTOREActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Insert();
        ViewData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
   Update();
   ViewData();
          // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
      Delete();
      ViewData();
   // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableInstituteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInstituteMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel)jTableInstitute.getModel();
            String tblName= tblModel.getValueAt(jTableInstitute.getSelectedRow(),0).toString();
            String tblAName= tblModel.getValueAt(jTableInstitute.getSelectedRow(),3).toString();
            String tbleiin= tblModel.getValueAt(jTableInstitute.getSelectedRow(),1).toString();
            String tblHC= tblModel.getValueAt(jTableInstitute.getSelectedRow(),2).toString();
            

              textFieldInstituteName.setText(tblName);
              textFieldEIIN.setText(tbleiin);
              jComboBoxHighestClass.setSelectedItem(tblHC);
              jComboBoxArea.setSelectedItem(tblAName);
              textFieldEIIN.setEditable(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jTableInstituteMouseClicked

    private void jTableInstituteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInstituteMouseExited
               // TODO add your handling code here:
    }//GEN-LAST:event_jTableInstituteMouseExited

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
            java.util.logging.Logger.getLogger(Edu_Ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edu_Ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edu_Ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edu_Ins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edu_Ins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCitizens;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonHouse;
    private javax.swing.JButton jButtonSTORE;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxArea;
    private javax.swing.JComboBox<String> jComboBoxHighestClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInstitute;
    private java.awt.TextField textFieldEIIN;
    private java.awt.TextField textFieldInstituteName;
    // End of variables declaration//GEN-END:variables
}
