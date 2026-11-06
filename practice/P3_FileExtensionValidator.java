/**
 * Week 2 Practice 3 - File Extension Validator (assignment-upload portal)
 */
public class P3_FileExtensionValidator {

    static final String[] ACCEPTED = {"pdf", "docx", "zip"};

    static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot == -1 || dot == filename.length() - 1) {
            return "Rejected - invalid file type";
        }
        String extension = filename.substring(dot + 1);
        for (String accepted : ACCEPTED) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }
        return "Rejected - invalid file type";
    }

    public static void main(String[] args) {
        String[] files = {"Assignment1.PDF", "notes.txt"};
        for (String file : files) {
            System.out.println("\"" + file + "\" -> " + validateFileExtension(file));
        }
    }
}
