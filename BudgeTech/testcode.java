import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testcode extends JFrame {
    private JTextField budgetField;
    private JTextField expenseField;
    private JTextField categoryField;
    private JTextArea summaryArea;
    private JTextArea breakdownArea;
    private double totalBudget = 0;
    private double totalExpenses = 0;

    public testcode() {

        ImageIcon image2 = new ImageIcon("Logo.png");

        setTitle("BudgeTech");
        setSize(1000, 650);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


       
        JLabel title = new JLabel("BugeTech");
        title.setFont(new Font("null", Font.PLAIN, 50));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(title, gbc);

        JLabel pic = new JLabel();
        pic.setIcon(image2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pic, gbc);
    

        JLabel budgetLabel = new JLabel("Enter fixed budget:");
        budgetLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(budgetLabel, gbc);

        budgetField = new JTextField(10);
        gbc.gridx = 1;
        add(budgetField, gbc);

        JButton addBudgetButton = new JButton("Add Budget");
        addBudgetButton.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 2;
        add(addBudgetButton, gbc);

        JLabel expenseLabel = new JLabel("Enter actual budget:");
        expenseLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(expenseLabel, gbc);

        expenseField = new JTextField(10);
        gbc.gridx = 1;
        add(expenseField, gbc);

        JLabel categoryLabel = new JLabel("Enter expense category:");
        categoryLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(categoryLabel, gbc);

        categoryField = new JTextField(10);
        gbc.gridx = 1;
        add(categoryField, gbc);

        JButton logExpenseButton = new JButton("Log Expense");
        logExpenseButton.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        add(logExpenseButton, gbc);

        JButton viewSummaryButton = new JButton("View Budget Summary");
        viewSummaryButton.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(viewSummaryButton, gbc);

        JButton viewBreakdownButton = new JButton("View Expense Breakdown");
        viewBreakdownButton.setFont(new Font("Serif", Font.PLAIN, 20));
        gbc.gridx = 2;
        add(viewBreakdownButton, gbc);

        summaryArea = new JTextArea(15, 30);
        summaryArea.setEditable(false);
        breakdownArea = new JTextArea(15, 30);
        breakdownArea.setEditable(false);

        addBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    totalBudget = Double.parseDouble(budgetField.getText());
                    JOptionPane.showMessageDialog(null, "Budget added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid budget amount.");
                }
            }
        });

        logExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double expense = Double.parseDouble(expenseField.getText());
                    String category = categoryField.getText();
                    totalExpenses += expense;
                    breakdownArea.append("Expense: " + expense + " Category: " + category + "\n");
                    JOptionPane.showMessageDialog(null, "Expense logged successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid expense amount.");
                }
            }
        });

        viewSummaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double remainingBudget = totalBudget - totalExpenses;
                summaryArea.setText("Total Budget: " + totalBudget + "\nTotal Expenses: " + totalExpenses + "\nRemaining Budget: " + remainingBudget);
                summaryArea.setFont(new Font("Serif", Font.PLAIN, 20));
                JOptionPane.showMessageDialog(null, new JScrollPane(summaryArea), "Budget Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        viewBreakdownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakdownArea.setFont(new Font("Serif", Font.PLAIN, 20));
                JOptionPane.showMessageDialog(null, new JScrollPane(breakdownArea), "Expense Breakdown", JOptionPane.INFORMATION_MESSAGE);
            }
        });



    ImageIcon image = new ImageIcon("CAT copy.png");
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(230,230,250));
    
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new testcode().setVisible(true);
            }
        });
    }
}