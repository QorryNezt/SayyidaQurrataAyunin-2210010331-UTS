import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Locale;
/**
 *
 * @author 
 */
public class AgendaPribadiGUIForm extends javax.swing.JFrame {

    /**
     * Creates new form AgendaPribadiGUIForm
     */
    public AgendaPribadiGUIForm() {
        initComponents();
        updateDateAndDay();
        updateGreeting();
    }
    
private void updateGreeting() {
    LocalTime now = LocalTime.now();
    int hour = now.getHour();
    String greeting;

    if (hour >= 5 && hour < 12) {
        greeting = "Good Morning!";
    } else if (hour >= 12 && hour < 18) {
        greeting = "Good Afternoon!";
    } else {
        greeting = "Good Night!";
    }

    lblGreeting.setText(greeting);
}
private void updateDateAndDay() {
    LocalDate today = LocalDate.now();
    DayOfWeek dayOfWeek = today.getDayOfWeek();

    // Format Day and Date
    String day = dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);
    String date = today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH));

    // Update Labels
    lblDay.setText("Today is " + day);
    lblDatePlaceholder.setText(date);
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
        lblGreeting = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblDatePlaceholder = new javax.swing.JLabel();
        icoLock = new javax.swing.JLabel();
        Button_Heart = new javax.swing.JLabel();
        icoClock2 = new javax.swing.JLabel();
        icoSearch = new javax.swing.JLabel();
        icoCalendar = new javax.swing.JLabel();
        roundedPanel1 = new assets.RoundedPanel();
        lblDesc = new javax.swing.JLabel();
        icoWeather = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDayDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 480));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(350, 480));
        jPanel1.setLayout(null);

        lblGreeting.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        lblGreeting.setForeground(new java.awt.Color(255, 255, 255));
        lblGreeting.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGreeting.setText("Good Morning!");
        jPanel1.add(lblGreeting);
        lblGreeting.setBounds(170, 140, 170, 23);

        lblDay.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        lblDay.setForeground(new java.awt.Color(255, 255, 255));
        lblDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDay.setText("DayPlaceholder");
        jPanel1.add(lblDay);
        lblDay.setBounds(230, 170, 110, 15);

        lblDatePlaceholder.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        lblDatePlaceholder.setForeground(new java.awt.Color(255, 255, 255));
        lblDatePlaceholder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDatePlaceholder.setText("DatePlaceholder");
        jPanel1.add(lblDatePlaceholder);
        lblDatePlaceholder.setBounds(220, 190, 120, 15);

        icoLock.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\heart-lock.png")); // NOI18N
        icoLock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(icoLock);
        icoLock.setBounds(60, 20, 30, 30);

        Button_Heart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Button_Heart.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\heart_button2.png")); // NOI18N
        Button_Heart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button_Heart.setPreferredSize(new java.awt.Dimension(75, 74));
        Button_Heart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_HeartMouseClicked(evt);
            }
        });
        jPanel1.add(Button_Heart);
        Button_Heart.setBounds(40, 100, 110, 80);

        icoClock2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\heart-clock.png")); // NOI18N
        icoClock2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(icoClock2);
        icoClock2.setBounds(20, 20, 30, 30);

        icoSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\search-heart.png")); // NOI18N
        jPanel1.add(icoSearch);
        icoSearch.setBounds(260, 20, 30, 30);

        icoCalendar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\icons\\calendar-heart thin.png")); // NOI18N
        icoCalendar.setText("icoCal");
        jPanel1.add(icoCalendar);
        icoCalendar.setBounds(300, 20, 30, 30);

        roundedPanel1.setLayout(new java.awt.GridBagLayout());

        lblDesc.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblDesc.setText("Desc Goes Here");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        roundedPanel1.add(lblDesc, gridBagConstraints);

        icoWeather.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        icoWeather.setText("weather");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 8, 0);
        roundedPanel1.add(icoWeather, gridBagConstraints);

        lblTime.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        lblTime.setText("time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 8, 0);
        roundedPanel1.add(lblTime, gridBagConstraints);

        lblDayDate.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lblDayDate.setText("DD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 26);
        roundedPanel1.add(lblDayDate, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setText("MMM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 26);
        roundedPanel1.add(jLabel2, gridBagConstraints);

        jPanel1.add(roundedPanel1);
        roundedPanel1.setBounds(10, 230, 330, 60);

        backgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\3.png")); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(340, 495));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(340, 495));
        jPanel1.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 350, 480);
        backgroundLabel.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_HeartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_HeartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_HeartMouseClicked

    
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
    private javax.swing.JLabel Button_Heart;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel icoCalendar;
    private javax.swing.JLabel icoClock2;
    private javax.swing.JLabel icoLock;
    private javax.swing.JLabel icoSearch;
    private javax.swing.JLabel icoWeather;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDatePlaceholder;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDayDate;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JLabel lblTime;
    private assets.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
