/**
 * Week 2 Practice 1 - Vowel & Consonant Counter (library orientation kiosk)
 */
public class P1_VowelConsonantCounter {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if (ch == ' ') continue;                  // ignore spaces
            if (ch < 'a' || ch > 'z') continue;      // only letters are counted
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowels++;
            else consonants++;
        }
        System.out.println("Input: \"" + text + "\" -> Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}
