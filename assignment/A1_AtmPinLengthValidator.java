/**
 * Week 2 Assignment 1 - ATM PIN Length Validator
 */
public class A1_AtmPinLengthValidator {

    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("\"" + pin + "\" -> Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("\"" + pin + "\" -> PIN length OK.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }
}
