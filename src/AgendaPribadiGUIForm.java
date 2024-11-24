import assets.RoundedPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
        refreshAgendaList();
        updateDateAndDay();
        updateGreeting();
        bgDayNight();
        
    }
   private RoundedPanel createAgendaPanel(String day, String month, String description, String time) {
    // Create a RoundedPanel with a radius of 20 and set its layout
    RoundedPanel agendaPanel = new RoundedPanel(20);
    agendaPanel.setLayout(new BorderLayout()); // Use BorderLayout for proper alignment
    agendaPanel.setPreferredSize(new Dimension(230, 60));
    agendaPanel.setBackground(Color.WHITE);
    agendaPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Optional border

    // West: Date (day and month)
    RoundedPanel datePanel = new RoundedPanel(20); // Nested panel for the date
    datePanel.setLayout(new GridLayout(2, 1));     // Two rows: Day and month
    JLabel dayLabel = new JLabel(day, JLabel.CENTER);
    JLabel monthLabel = new JLabel(month, JLabel.CENTER);
    datePanel.add(dayLabel);
    datePanel.add(monthLabel);

    // Center: Agenda description
    JLabel descriptionLabel = new JLabel(description, JLabel.CENTER);

    // East: Time reminder
    JLabel timeLabel = new JLabel(time, JLabel.CENTER);

    // Add components to the agenda panel
    agendaPanel.add(datePanel, BorderLayout.WEST);
    agendaPanel.add(descriptionLabel, BorderLayout.CENTER);
    agendaPanel.add(timeLabel, BorderLayout.EAST);

    return agendaPanel;
}
    
  private void refreshAgendaList() {
    pnlAgendaList.removeAll(); // Clear the existing list

    try (Connection conn = new DatabaseHelper().getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM agenda")) {

        while (rs.next()) {
            String date = rs.getString("date");
            String description = rs.getString("description");
            String time = rs.getString("time");
            String ampm = rs.getString("ampm");

            // Create a rounded panel for each agenda
            RoundedPanel agendaPanel = new RoundedPanel(20); // Use your custom RoundedPanel class
            agendaPanel.setLayout(new BorderLayout());
            agendaPanel.setBackground(new Color(255, 255, 255, 200)); // Slightly transparent white
            agendaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Add content to the rounded panel
            JLabel lblDayDate = new JLabel("<html><b>" + date + "</b></html>");
            lblDayDate.setForeground(Color.DARK_GRAY);
            lblDayDate.setHorizontalAlignment(JLabel.CENTER);

            JLabel lblDesc = new JLabel("<html><i>" + description + "</i></html>");
            lblDesc.setForeground(Color.BLACK);
            lblDesc.setHorizontalAlignment(JLabel.CENTER);

            JLabel lblTime = new JLabel(time + " " + ampm);
            lblTime.setForeground(Color.GRAY);
            lblTime.setHorizontalAlignment(JLabel.CENTER);

            // Add labels to the agenda panel
            agendaPanel.add(lblDayDate, BorderLayout.NORTH);
            agendaPanel.add(lblDesc, BorderLayout.CENTER);
            agendaPanel.add(lblTime, BorderLayout.SOUTH);

            // Add MouseListener to handle click events
            agendaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    openEditForm(date, description, time, ampm); // Open the EditForm with agenda details
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    agendaPanel.setBackground(new Color(230, 230, 230)); // Optional: Highlight on hover
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    agendaPanel.setBackground(new Color(255, 255, 255, 200)); // Reset background on exit
                }
            });

            // Add agenda panel to the list
            pnlAgendaList.add(agendaPanel);
        }

        pnlAgendaList.revalidate();
        pnlAgendaList.repaint();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
   // Method to open EditForm with agenda data
    private void openEditForm(String date, String description, String time, String ampm) {
    try {
        // Convert date to the required format
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Adjust pattern to match your database format
        String formattedDate = parsedDate.toString(); // Convert to yyyy-MM-dd

        // Pass formattedDate to the EditForm
        EditForm editForm = new EditForm(formattedDate, description, time, ampm);
        editForm.setVisible(true);
        this.dispose(); // Close the main form
    } catch (Exception e) {
        e.printStackTrace(); // Log the error for debugging
    }
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
        greeting = "Good Evening!";
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

private void bgDayNight() {
    int hour = LocalTime.now().getHour();
    if (hour >= 6 && hour < 18) { // Morning/Afternoon
        backgroundLabel.setIcon(new ImageIcon("assets/day_bg.png"));
    } else { // Evening/Night
        backgroundLabel.setIcon(new ImageIcon("assets/night_bg.png"));
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
        pnlAgendaList = new javax.swing.JPanel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 480));
        setMinimumSize(new java.awt.Dimension(350, 480));
        setPreferredSize(new java.awt.Dimension(350, 480));

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

        pnlAgendaList.setOpaque(false);
        pnlAgendaList.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        jPanel1.add(pnlAgendaList);
        pnlAgendaList.setBounds(0, 220, 350, 260);

        backgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\3.png")); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(350, 480));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(350, 480));
        jPanel1.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 350, 480);
        backgroundLabel.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_HeartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_HeartMouseClicked
    UserInputForm inputForm = new UserInputForm(); // Your input form class
    inputForm.setVisible(true);
    this.dispose(); // Close the main form
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDatePlaceholder;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JPanel pnlAgendaList;
    // End of variables declaration//GEN-END:variables
}
