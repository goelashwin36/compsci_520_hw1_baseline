public class InputValidation {
    
    public static boolean validateAmount(double amount) {
        return amount > 0 && amount < 1000;
    }

    public static boolean validateCategory(String category) {
        String[] valid_categories = { "food", "travel", "bills", "entertainment", "other" };
        for (String valid_category : valid_categories) {
            if (category.equalsIgnoreCase(valid_category)) {
                return true;
            }
        }
        return false;
    }

}