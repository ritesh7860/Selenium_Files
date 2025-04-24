import java.awt.*;
import java.awt.event.*;

public class TopAlignedTabbedFormExample {
    private Frame mainFrame;
    private Panel tabPanel;
    private CardLayout cardLayout;
    private Panel buttonPanel;

    public TopAlignedTabbedFormExample() {
        mainFrame = new Frame("Top-Aligned Tabbed Form Example");
        cardLayout = new CardLayout();
        tabPanel = new Panel(cardLayout);
        buttonPanel = new Panel();

        // Create the tabs
        createTabs();

        // Set up the main frame
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(buttonPanel, BorderLayout.NORTH); // Tabs at the top
        mainFrame.add(tabPanel, BorderLayout.CENTER); // Content area
        mainFrame.setSize(400, 350);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.LIGHT_GRAY);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    // private void createTabs() {


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
    

        // Add Save and Cancel buttons
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
            cardLayout.show(tabPanel, "Tab 1");
        });

    }

        // // Add buttons to the tab
        // Panel buttonPanelTab = new Panel();
        // buttonPanelTab.add(btnSave);
        // buttonPanelTab.add(btnCancel);


        // // Create first tab
        // Panel tab1 = createTabPanel();
        // tab1.add(new Label("Name:"));
        // tab1.add(new TextField(10));
        // tab1.add(new Label("Email:"));
        // tab1.add(new TextField(10));
        // tab1.add(new Label("Phone:"));
        // tab1.add(new TextField(10));
        // tab1.add(buttonPanelTab);
        // tabPanel.add(tab1, "Tab 1");

        // // Create second tab
        // Panel tab2 = createTabPanel();
        // tab2.add(new Label("Address:"));
        // tab2.add(new TextField(10));
        // tab2.add(new Label("City:"));
        // tab2.add(new TextField(10));
        // tab2.add(new Label("Zip Code:"));
        // tab2.add(new TextField(10));
        // tabPanel.add(tab2, "Tab 2");

        // // Create third tab
        // Panel tab3 = createTabPanel();
        // tab3.add(new Label("Username:"));
        // tab3.add(new TextField(10));
        // tab3.add(new Label("Password:"));
        // tab3.add(new TextField(10));
        // tab3.add(new Label("Confirm Password:"));
        // tab3.add(new TextField(10));

        // tab3.add(buttonPanelTab);
        // tabPanel.add(tab3, "Tab 3");

        // // Create tab buttons
        // createTabButtons();
    }

    private void createTabButtons() {
        String[] tabNames = {"Tab 1", "Tab 2", "Tab 3"};
        for (String tabName : tabNames) {
            Button tabButton = new Button(tabName);
            tabButton.setBackground(Color.DARK_GRAY);
            tabButton.setForeground(Color.WHITE);
            tabButton.setPreferredSize(new Dimension(80, 30));
            tabButton.addActionListener(e -> cardLayout.show(tabPanel, tabName));
            buttonPanel.add(tabButton);
        }
    }

    private Panel createTabPanel() {
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(0, 1, 5, 5)); // 0 rows, 2 columns, with gaps
        panel.setBackground(Color.WHITE);
        return panel;
    }

    public static void main(String[] args) {
        new TopAlignedTabbedFormExample();
    }
