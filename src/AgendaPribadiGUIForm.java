import assets.RoundedPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sayyida Qurrata A'yunin (2210010331)
 */
public class AgendaPribadiGUIForm extends javax.swing.JFrame {
    private final String AGENDA_FILE = "agenda.csv";
    /**
     * Creates new form AgendaPribadiGUIForm
     */
    public AgendaPribadiGUIForm() {
        createAgendaFileIfNotExists();
        initComponents();
        loadAgendaPanels();
        updateDateAndDay();
        updateGreeting();
        bgDayNight();
        
         
        
   }
     private void createAgendaFileIfNotExists() {
        try {
            File file = new File(AGENDA_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private void loadAgendaPanels() {
    pnlAgendaList.removeAll(); // Clear existing panels
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); // Adjust for dd/MM/yyyy format
    try (BufferedReader reader = new BufferedReader(new FileReader(AGENDA_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", -1); // Use -1 to keep empty values
            if (parts.length < 3) { // Ensure there are at least 3 columns (date, time, description)
                System.err.println("Skipping malformed row (not enough columns): " + line);
                continue; // Skip invalid rows
            }

            String date = parts[0].trim();
            String time = parts[1].trim();
            String description = parts[2].trim();

            try {
                // Try to parse the date using SimpleDateFormat
                dateFormat.setLenient(false); // Disable lenient parsing
                dateFormat.parse(date); // Try to parse the date
            } catch (ParseException e) {
                // If parsing fails, log the error and skip the row
                System.err.println("Skipping row with invalid date format: " + line);
                continue;
            }

            // Create and add agenda panel
            RoundedPanel agendaPanel = createAgendaPanel(date, time, description);
            pnlAgendaList.add(agendaPanel);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading agenda data!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    pnlAgendaList.revalidate(); // Refresh UI
    pnlAgendaList.repaint();
}

private LocalDate parseDate(String dateStr) {
    // Try parsing the date in a known format (e.g., dd MMMM yyyy)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
    try {
        return LocalDate.parse(dateStr, formatter);
    } catch (Exception e) {
        // If parsing fails, return null
        return null;
    }
}
private RoundedPanel createAgendaPanel(String date, String time, String description) {
    // Create the panel
    RoundedPanel agendaPanel = new RoundedPanel(20);
    agendaPanel.setLayout(new BorderLayout());
    agendaPanel.setPreferredSize(new Dimension(230, 60));
    agendaPanel.setBackground(Color.WHITE);
    agendaPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

    // Parse the date string and format it to display day and month
    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM", Locale.ENGLISH);

    try {
        java.util.Date parsedDate = inputFormat.parse(date);
        String formattedDate = outputFormat.format(parsedDate);

        String[] dateParts = formattedDate.split(" ");
        String day = dateParts[0];
        String month = dateParts[1];

        // Create date panel
        RoundedPanel datePanel = new RoundedPanel(20);
        datePanel.setLayout(new GridLayout(2, 1));
        JLabel dayLabel = new JLabel(day, JLabel.CENTER);
        dayLabel.setFont(new Font("Montserrat", Font.PLAIN, 14));
        JLabel monthLabel = new JLabel(month, JLabel.CENTER);
        monthLabel.setFont(new Font("Montserrat", Font.PLAIN, 14));
        datePanel.add(dayLabel);
        datePanel.add(monthLabel);

        // Create description label
        JLabel descriptionLabel = new JLabel(description, JLabel.CENTER);
        descriptionLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));

        // Create time label
        JLabel timeLabel = new JLabel(time, JLabel.CENTER);
        timeLabel.setFont(new Font("Montserrat", Font.PLAIN, 14));

        // Split time into hours and AM/PM
        String[] timeParts = time.split(":");
        String ampm = timeParts[1].endsWith("PM") ? "PM" : "AM";  // Extract AM/PM
        String timeWithoutAMPM = time.split(" ")[0];  // Get time without AM/PM

        // Add panel components
        agendaPanel.add(datePanel, BorderLayout.WEST);
        agendaPanel.add(descriptionLabel, BorderLayout.CENTER);
        agendaPanel.add(timeLabel, BorderLayout.EAST);

        // Add MouseListener for redirecting to the EditForm when clicked
        agendaPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open the EditForm and pass the necessary data
                openEditForm(date, description, timeWithoutAMPM, ampm); // Pass time without AM/PM and AM/PM
            }
        });

    } catch (ParseException e) {
        System.err.println("Error parsing date: " + date);
    }

    return agendaPanel;
}

    private void addAgendaPanel(String date, String time, String description, String ampm) {
        RoundedPanel panel = new RoundedPanel();
        panel.setBackground(new Color(255, 255, 255, 200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblDate = new JLabel("Date: " + date);
        JLabel lblTime = new JLabel("Time: " + time + " " + ampm);
        JLabel lblDescription = new JLabel("Description: " + description);

        lblDate.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblTime.setFont(new Font("Montserrat", Font.PLAIN, 12));
        lblDescription.setFont(new Font("Montserrat", Font.PLAIN, 12));

        panel.add(lblDate);
        panel.add(lblTime);
        panel.add(lblDescription);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openEditForm(date, description, time, ampm);
            }
        });

        pnlAgendaList.add(panel);
    }

    private void openEditForm(String date, String description, String time, String ampm) {
        EditForm editForm = new EditForm(date, description, time, ampm);
        editForm.setVisible(true);
        this.dispose();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(350, 480));
        setMinimumSize(new java.awt.Dimension(350, 480));

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
        pnlAgendaList.add(jScrollPane1);

        jPanel1.add(pnlAgendaList);
        pnlAgendaList.setBounds(0, 220, 350, 260);

        backgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Documents\\NetBeansProjects\\AplikasiAgendaPribadi\\assets\\night_bg.png")); // NOI18N
        backgroundLabel.setMaximumSize(new java.awt.Dimension(350, 480));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(350, 480));
        jPanel1.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 350, 480);

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatePlaceholder;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JPanel pnlAgendaList;
    // End of variables declaration//GEN-END:variables
}
