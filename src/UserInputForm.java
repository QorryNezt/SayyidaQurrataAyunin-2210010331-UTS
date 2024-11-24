import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Locale;
import javax.swing.JOptionPane;
/**
 *
 * @author 
 */
public class UserInputForm extends javax.swing.JFrame {

    /**
     * Creates new form AgendaPribadiGUIForm
     */
    public UserInputForm() {
        initComponents();
       
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnBack = new assets.HeartButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new assets.HeartButton();
        btnDel = new assets.HeartButton();
        btnEdit = new assets.HeartButton();
        lblAdd = new javax.swing.JLabel();
        lblDel = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        roundedPanel2 = new assets.RoundedPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        cbbTime = new javax.swing.JComboBox<>();
        roundedPanel1 = new assets.RoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        jCalendar = new com.toedter.calendar.JCalendar();
        roundedPanel3 = new assets.RoundedPanel();
        jLabel5 = new javax.swing.JLabel();
        txtAgenda = new javax.swing.JTextField();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(290, 480));
        jPanel1.setLayout(null);

        btnBack.setText("");
        btnBack.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(10, 10, 60, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\back_arrow.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 60, 40);

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Your Agenda Here!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 70, 260, 23);

        btnAdd.setText("");
        btnAdd.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);
        btnAdd.setBounds(40, 370, 60, 50);

        btnDel.setText("");
        btnDel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnDel);
        btnDel.setBounds(140, 370, 60, 50);

        btnEdit.setText("");
        btnEdit.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jPanel1.add(btnEdit);
        btnEdit.setBounds(240, 370, 60, 50);

        lblAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdd.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\add.png")); // NOI18N
        jPanel1.add(lblAdd);
        lblAdd.setBounds(50, 380, 40, 40);

        lblDel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\trash.png")); // NOI18N
        jPanel1.add(lblDel);
        lblDel.setBounds(140, 380, 60, 40);

        lblEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\edit.png")); // NOI18N
        jPanel1.add(lblEdit);
        lblEdit.setBounds(240, 380, 60, 40);

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel4.setText("Enter Time :");

        txtTime.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        cbbTime.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cbbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cbbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(cbbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel1.add(roundedPanel2);
        roundedPanel2.setBounds(20, 310, 310, 40);

        roundedPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enter Date :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 14);
        roundedPanel1.add(jLabel3, gridBagConstraints);

        jCalendar.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        roundedPanel1.add(jCalendar, new java.awt.GridBagConstraints());

        jPanel1.add(roundedPanel1);
        roundedPanel1.setBounds(20, 100, 310, 150);

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel5.setText("Enter Agenda :");

        txtAgenda.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(roundedPanel3);
        roundedPanel3.setBounds(20, 260, 310, 40);

        backgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\2.png")); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(340, 495));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(340, 495));
        jPanel1.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 350, 480);
        backgroundLabel.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AgendaPribadiGUIForm mainForm = new AgendaPribadiGUIForm();
        mainForm.setVisible(true);
        this.dispose(); // Close the input form
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        btnDel.addActionListener(e -> {
    if (txtAgenda.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nothing to delete", "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
        // Clear fields
        jCalendar.setDate(null);
        txtAgenda.setText("");
        txtTime.setText("");
    }
});
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
         if (jCalendar.getDate() == null || txtAgenda.getText().isEmpty() || txtTime.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields", "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
        
    }
    }//GEN-LAST:event_btnAddActionPerformed

    
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
            java.util.logging.Logger.getLogger(AgendaPribadiGUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadiGUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadiGUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadiGUIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaPribadiGUIForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private assets.HeartButton btnAdd;
    private assets.HeartButton btnBack;
    private assets.HeartButton btnDel;
    private assets.HeartButton btnEdit;
    private javax.swing.JComboBox<String> cbbTime;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblDel;
    private javax.swing.JLabel lblEdit;
    private assets.RoundedPanel roundedPanel1;
    private assets.RoundedPanel roundedPanel2;
    private assets.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txtAgenda;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
