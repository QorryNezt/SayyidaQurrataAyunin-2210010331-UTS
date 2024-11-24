import java.sql.Connection;
import java.sql.Statement;
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
    
    private void backMethod(){
    AgendaPribadiGUIForm mainForm = new AgendaPribadiGUIForm();
    mainForm.setVisible(true);
    this.dispose(); // Close the input form
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
        lblAdd = new javax.swing.JLabel();
        roundedPanel2 = new assets.RoundedPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        cbbTime = new javax.swing.JComboBox<>();
        roundedPanel1 = new assets.RoundedPanel();
        jCalendar = new com.toedter.calendar.JCalendar();
        roundedPanel3 = new assets.RoundedPanel();
        jLabel5 = new javax.swing.JLabel();
        txtAgenda = new javax.swing.JTextField();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 480));
        setMinimumSize(new java.awt.Dimension(350, 480));

        jPanel1.setPreferredSize(new java.awt.Dimension(350, 480));
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
        btnAdd.setBounds(150, 370, 60, 50);

        lblAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdd.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\add.png")); // NOI18N
        jPanel1.add(lblAdd);
        lblAdd.setBounds(160, 380, 40, 40);

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
        backMethod();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    // Get user input
    String date = jCalendar.getDate().toString(); // Assuming you're using JCalendar
    String description = txtAgenda.getText();
    String time = txtTime.getText();
    String ampm = cbbTime.getSelectedItem().toString();

    // Validate input
    if (date.isEmpty() || description.isEmpty() || time.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Insert into database
    try (Connection conn = new DatabaseHelper().getConnection();
         Statement stmt = conn.createStatement()) {

        String insertSQL = "INSERT INTO agenda (date, description, time, ampm) VALUES ('"
                + date + "', '"
                + description + "', '"
                + time + "', '"
                + ampm + "');";
        stmt.executeUpdate(insertSQL);
        JOptionPane.showMessageDialog(this, "Agenda added successfully!");

        // Kembali ke halaman main
        backMethod();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to add agenda!", "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JComboBox<String> cbbTime;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdd;
    private assets.RoundedPanel roundedPanel1;
    private assets.RoundedPanel roundedPanel2;
    private assets.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txtAgenda;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
