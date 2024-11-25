import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sayyida Qurrata A'yunin (2210010331)
 */
public class EditForm extends javax.swing.JFrame {
    private String date;
    private String time;
    private String description;
    private String ampm;

    /**
     * Creates new form AgendaPribadiGUIForm
     * @param date
     * @param description
     * @param time
     * @param ampm
     */
    public EditForm(String date, String description, String time, String ampm) {
        this.date = date;
        this.description = description;
        this.time = time;
        this.ampm = ampm;
        initComponents();
        setInitialValues(); // Set the values to the input fields
        
    }
    
     private void setInitialValues() {
    // If 'date' is a string, parse it to a Date object
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
        Date parsedDate = sdf.parse(date);
        dateAgenda.setDate(parsedDate);  // Set the date to JDateChooser
    } catch (ParseException e) {
        e.printStackTrace();
    }
    
    // Set the agenda description
    txtAgenda.setText(description);

    // Set the time without AM/PM
    txtTime.setText(time);  // Set time to txtTime without AM/PM

    // Set AM/PM in the combo box
    if ("PM".equals(ampm)) {
        cbbTime.setSelectedItem("PM");  // Set PM in the combo box
    } else {
        cbbTime.setSelectedItem("AM");  // Set AM in the combo box
    }
}
private void updateAgenda(String newDate, String newTime, String newDescription, String newAmpm) {
    String formattedTime = newTime.trim() + " " + newAmpm;  // Ensure the format is "HH:mm AM/PM"
    File csvFile = new File("agenda.csv");
    List<String> lines = new ArrayList<>();
    boolean updated = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) {  // Ensure there are three parts (date, time, description)
                String storedDate = data[0].trim();
                String storedTime = data[1].trim();

                // If the current line matches the agenda to update, replace it
                if (storedDate.equals(newDate.trim()) && storedTime.equals(formattedTime)) {
                    String updatedLine = newDate + "," + formattedTime + "," + newDescription;
                    lines.add(updatedLine);  // Add the updated agenda line
                    updated = true;
                } else {
                    lines.add(line);  // Keep the existing line if it doesn't match
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (!updated) {
        JOptionPane.showMessageDialog(this, "Agenda not found to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Write the updated lines back to the file
    try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
        for (String line : lines) {
            writer.println(line);
        }
        JOptionPane.showMessageDialog(this, "Agenda updated successfully!");
        backToMain();  // Redirect to the main form after update
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to update agenda.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


private void deleteAgenda() {
    File csvFile = new File("agenda.csv");
    List<String> lines = new ArrayList<>();
    boolean deleted = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) {  // Ensure there are three parts (date, time, description)
                String storedDate = data[0].trim();
                String storedTime = data[1].trim();

                // If the current line matches the agenda to delete, remove it
                if (!(storedDate.equals(date.trim()) && storedTime.equals(time.trim() + " " + ampm))) {
                    lines.add(line);  // Keep the line if it doesn't match
                } else {
                    deleted = true; // Found the agenda to delete
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (!deleted) {
        JOptionPane.showMessageDialog(this, "Agenda not found to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
        for (String line : lines) {
            writer.println(line);
        }
        JOptionPane.showMessageDialog(this, "Agenda deleted successfully!");
        backToMain();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to delete agenda.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void backToMain() {
        AgendaPribadiGUIForm agendaForm = new AgendaPribadiGUIForm();
        agendaForm.setVisible(true);
        dispose();  // Close current form
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
        btnEdit = new assets.HeartButton();
        btnDel = new assets.HeartButton();
        lblEdit = new javax.swing.JLabel();
        lblDel = new javax.swing.JLabel();
        roundedPanel2 = new assets.RoundedPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        cbbTime = new javax.swing.JComboBox<>();
        roundedPanel1 = new assets.RoundedPanel();
        jLabel6 = new javax.swing.JLabel();
        dateAgenda = new com.toedter.calendar.JDateChooser();
        roundedPanel3 = new assets.RoundedPanel();
        jLabel5 = new javax.swing.JLabel();
        txtAgenda = new javax.swing.JTextField();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel1.setText("Edit Your Agenda Here!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 100, 260, 23);

        btnEdit.setText("");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(200, 340, 60, 50);

        btnDel.setText("");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnDel);
        btnDel.setBounds(80, 340, 60, 50);

        lblEdit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\edit.png")); // NOI18N
        jPanel1.add(lblEdit);
        lblEdit.setBounds(220, 350, 40, 40);

        lblDel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\trash.png")); // NOI18N
        jPanel1.add(lblDel);
        lblDel.setBounds(80, 350, 60, 40);

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
        roundedPanel2.setBounds(20, 260, 310, 40);

        roundedPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel6.setText("Enter Agenda Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 28);
        roundedPanel1.add(jLabel6, gridBagConstraints);
        roundedPanel1.add(dateAgenda, new java.awt.GridBagConstraints());

        jPanel1.add(roundedPanel1);
        roundedPanel1.setBounds(20, 160, 310, 40);

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
        roundedPanel3.setBounds(20, 210, 310, 40);

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
        backToMain();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        deleteAgenda();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
   // Get the values from the input fields
    String newDescription = txtAgenda.getText().trim();  // Description from the text field
    String newTime = txtTime.getText().trim();           // Time from the text field
    String newAmpm = (String) cbbTime.getSelectedItem(); // AM/PM from the combo box
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String newDate = sdf.format(dateAgenda.getDate());   // Date from the JDateChooser

    // Ensure the time includes the AM/PM part before updating
    String formattedTime = newTime + " " + newAmpm; // Format time with AM/PM part

    // Validate the time format
    if (!newTime.matches("([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
        JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:mm (e.g., 10:30).", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validate if all fields are filled
    if (newDescription.isEmpty() || newTime.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Update the agenda with the new values
    updateAgenda(newDate, formattedTime, newDescription, newAmpm);

    }//GEN-LAST:event_btnEditActionPerformed

    
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
    private assets.HeartButton btnBack;
    private assets.HeartButton btnDel;
    private assets.HeartButton btnEdit;
    private javax.swing.JComboBox<String> cbbTime;
    private com.toedter.calendar.JDateChooser dateAgenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDel;
    private javax.swing.JLabel lblEdit;
    private assets.RoundedPanel roundedPanel1;
    private assets.RoundedPanel roundedPanel2;
    private assets.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txtAgenda;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
