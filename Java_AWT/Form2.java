import java.awt.*;
import java.awt.event.*;

public class TopAlignedTabbedFormExample {
    private Frame mainFrame;
    private Panel tabPanel;
    private CardLayout cardLayout;

    // Text fields for each tab
    private TextField nameField, emailField, phoneField;
    private TextField addressField, cityField, zipField;
    private TextField usernameField, passwordField, confirmPasswordField;

    public TopAlignedTabbedFormExample() {
        mainFrame = new Frame("Top-Aligned Tabbed Form Example");
        cardLayout = new CardLayout();
        tabPanel = new Panel(cardLayout);

        // Create the tabs
        createTabs();

        // Set up the main frame
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(createTabButtons(), BorderLayout.NORTH); // Tabs at the top
        mainFrame.add(tabPanel, BorderLayout.CENTER); // Content area
        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.LIGHT_GRAY);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private void createTabs() {
        // Create first tab
        Panel tab1 = createTabPanel();
        tab1.add(new Label("Name:"));
        nameField = new TextField(20);
        tab1.add(nameField);
        tab1.add(new Label("Email:"));
        emailField = new TextField(20);
        tab1.add(emailField);
        tab1.add(new Label("Phone:"));
        phoneField = new TextField(20);
        tab1.add(phoneField);
        tab1.add(createActionButtons()); // Add Save and Cancel buttons
        tabPanel.add(tab1, "Tab 1");

        // Create second tab
        Panel tab2 = createTabPanel();
        tab2.add(new Label("Address:"));
        addressField = new TextField(20);
        tab2.add(addressField);
        tab2.add(new Label("City:"));
        cityField = new TextField(20);
        tab2.add(cityField);
        tab2.add(new Label("Zip Code:"));
        zipField = new TextField(20);
        tab2.add(zipField);
        tab2.add(createActionButtons()); // Add Save and Cancel buttons
        tabPanel.add(tab2, "Tab 2");

        // Create third tab
        Panel tab3 = createTabPanel();
        tab3.add(new Label("Username:"));
        usernameField = new TextField(20);
        tab3.add(usernameField);
        tab3.add(new Label("Password:"));
        passwordField = new TextField(20);
        passwordField.setEchoChar('*'); // Hide password input
        tab3.add(passwordField);
        tab3.add(new Label("Confirm Password:"));
        confirmPasswordField = new TextField(20);
        confirmPasswordField.setEchoChar('*'); // Hide password input
        tab3.add(confirmPasswordField);
        tab3.add(createActionButtons()); // Add Save and Cancel buttons
        tabPanel.add(tab3, "Tab 3");
    }

    private Panel createActionButtons() {
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
        Button btnSave = new Button("Save");
        Button btnCancel = new Button("Cancel");

        btnSave.addActionListener(e -> {
            // Action for Save button
            System.out.println("Data from Tab 1:");
            System.out.println("Name: " + nameField.getText());
            System.out.println("Email: " + emailField.getText());
            System.out.println("Phone: " + phoneField.getText());

            System.out.println("Data from Tab 2:");
            System.out.println("Address: " + addressField.getText());
            System.out.println("City: " + cityField.getText());
            System.out.println("Zip Code: " + zipField.getText());

            System.out.println("Data from Tab 3:");
            System.out.println("Username: " + usernameField.getText());
            System.out.println("Password: " + passwordField.getText());
            System.out.println("Confirm Password: " + confirmPasswordField.getText());
        });

        btnCancel.addActionListener(e -> {
            // Action for Cancel button
            cardLayout.show(tabPanel, "Tab 1"); // Switch back to the first tab
        });

        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        return button;