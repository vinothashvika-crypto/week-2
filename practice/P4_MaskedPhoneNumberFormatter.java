/**
 * Week 2 Practice 4 - Masked Phone Number Formatter (student-support call center)
 */
public class P4_MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        StringBuilder masked = new StringBuilder(phone.substring(6)); // last 4 digits
        masked.insert(0, "-");
        masked.insert(0, "XXXXXX");
        return masked.toString();
    }

    public static void main(String[] args) {
        String[] phones = {"9876543210", "98765"};
        for (String phone : phones) {
            System.out.println("\"" + phone + "\" -> " + maskPhoneNumber(phone));
        }
    }
}
