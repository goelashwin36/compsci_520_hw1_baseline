import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();

      if (InputValidation.validateAmount(amount) && InputValidation.validateCategory(category)) {

        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
      } else if (!InputValidation.validateAmount(amount)) {
        JOptionPane.showMessageDialog(view,
            "Amount should be greater than 0 and less than 1000.",
            "Input Error",
            JOptionPane.ERROR_MESSAGE);

        System.out.println("Invalid input!!");
      } else if (!InputValidation.validateCategory(category)) {
        JOptionPane.showMessageDialog(view,
            "Category should be one of these: food, travel, bills, entertainment, other",
            "Input Error",
            JOptionPane.ERROR_MESSAGE);

        System.out.println("Invalid input!!");
      }
    });
  }
}