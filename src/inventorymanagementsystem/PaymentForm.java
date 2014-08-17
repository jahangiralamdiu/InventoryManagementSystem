/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jahangir
 */
public class PaymentForm extends javax.swing.JPanel {

    /**
     * Creates new form PaymentForm
     */
    public PaymentForm() {
        initComponents();
        initPaymentID();
        initOrderID();
        txtDate.setDate(new Date());
        btnSave.setEnabled(false);
    }

    void initPaymentID() {
        try {
            int paymentID = 1;
            connection = new ConnectivitySupport();
            PreparedStatement pstm = connection.getConn().prepareCall("Select max(payment_id) from payment");
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                paymentID += rs.getInt(1);
            }

            txtPaymentID.setText(Integer.toString(paymentID));
            rs.close();
            pstm.close();
            connection = null;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void initOrderID() {
        try {

            connection = new ConnectivitySupport();
            PreparedStatement pstm = connection.getConn().prepareCall("Select order_id from order_table order by order_id");
            ResultSet rs = pstm.executeQuery();
            dndOrderID.addItem("Select Order ID");
            while (rs.next()) {
                dndOrderID.addItem(rs.getInt(1));
            }

            rs.close();
            pstm.close();
            connection = null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPaymentID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dndOrderID = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPayable = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDue = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        bntClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Vijaya", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payment Form");

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Payment Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 20, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Payment ID :");
        jPanel1.add(jLabel3);
        jPanel1.add(txtPaymentID);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Payment Date :");
        jPanel1.add(jLabel4);

        txtDate.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(txtDate);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Order ID :");
        jPanel1.add(jLabel6);

        dndOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dndOrderIDActionPerformed(evt);
            }
        });
        jPanel1.add(dndOrderID);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Total Payble :");
        jPanel1.add(jLabel2);
        jPanel1.add(txtTotalPayable);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Payment Amount :");
        jPanel1.add(jLabel5);

        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
        });
        jPanel1.add(txtAmount);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Due Amount :");
        jPanel1.add(jLabel7);
        jPanel1.add(txtDue);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btnSave.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\save (1).png")); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        btnNew.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\tab_new_raised.png")); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew);

        btnDisplay.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\gwenview.png")); // NOI18N
        btnDisplay.setText("View");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });
        jPanel2.add(btnDisplay);

        btnSearch.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\search.png")); // NOI18N
        btnSearch.setText("Search");
        jPanel2.add(btnSearch);

        btnDelete.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\gnome_edit_delete (2).png")); // NOI18N
        btnDelete.setText("Delete");
        jPanel2.add(btnDelete);

        btnUpdate.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\update.png")); // NOI18N
        btnUpdate.setText("Update");
        jPanel2.add(btnUpdate);

        bntClose.setIcon(new javax.swing.ImageIcon("D:\\Java\\Projects\\Swing\\InventoryByJahangir\\images\\finaldelete.png")); // NOI18N
        bntClose.setText("Exit");
        jPanel2.add(bntClose);

        jScrollPane1.setViewportView(paymentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dndOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dndOrderIDActionPerformed
        // TODO add your handling code here:

        try {

            connection = new ConnectivitySupport();
            PreparedStatement pstm = connection.getConn().prepareCall("Select total_price from order_table where order_id=?");
            pstm.setString(1, dndOrderID.getSelectedItem().toString());
            ResultSet rs = pstm.executeQuery();
            if (dndOrderID.getSelectedIndex() == 0) {
                txtTotalPayable.setText("");
            }
            while (rs.next()) {
                txtTotalPayable.setText(Double.toString(rs.getDouble(1)));
            }
            rs.close();
            pstm.close();
            connection = null;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dndOrderIDActionPerformed

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        // TODO add your handling code here:
        Double totalPayable = Double.parseDouble(txtTotalPayable.getText());
        Double amount = Double.parseDouble(txtAmount.getText());
        Double due = totalPayable - amount;

        txtDue.setText(Double.toString(due));
        btnSave.setEnabled(true);
    }//GEN-LAST:event_txtAmountKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        try {

            String query = "insert into payment values(?, ?, ?, ?, ?)";

            connection = new ConnectivitySupport();
            PreparedStatement pstm = connection.getConn().prepareCall(query);
            pstm.setString(1, txtPaymentID.getText());
            pstm.setString(2, dndOrderID.getSelectedItem().toString());
            pstm.setDate(3, java.sql.Date.valueOf(dft.format(txtDate.getDate())));
            pstm.setString(4, txtAmount.getText());
            pstm.setString(5, txtDue.getText());

            int addRow = pstm.executeUpdate();

            JOptionPane.showMessageDialog(this, "Payment Saved");
            btnSave.setEnabled(false);

            pstm.close();
            connection = null;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        initPaymentID();
        dndOrderID.setSelectedIndex(0);
        txtAmount.setText("");
        txtDue.setText("");

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        // TODO add your handling code here:
        try {
            connection = new ConnectivitySupport();

            String query = "select * from payment";

            PreparedStatement pstm = connection.getConn().prepareCall(query);

            ResultSet rs = pstm.executeQuery();
            rm.setResultSet(rs);
            paymentTable.setModel(rm);
            rs.close();
            pstm.close();
            connection = null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllSales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AllSales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDisplayActionPerformed

    ConnectivitySupport connection;
    SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
    ResultsModel rm = new ResultsModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox dndOrderID;
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
    private javax.swing.JTable paymentTable;
    private javax.swing.JTextField txtAmount;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaymentID;
    private javax.swing.JTextField txtTotalPayable;
    // End of variables declaration//GEN-END:variables
}
