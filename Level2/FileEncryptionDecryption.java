import java.io.*;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter 'E' for encryption or 'D' for decryption:");
            char choice = reader.readLine().charAt(0);

            System.out.println("Enter file name or path:");
            String fileName = "C:\\Users\\91638\\Desktop\\FileEnDc"; 
            File inputFile = new File(fileName);

            if (!inputFile.exists()) {
                System.out.println("File not found: " + inputFile.getAbsolutePath());
                return;
            }

            System.out.println("Enter output file name or path:");
            String outputFileName = "C:\\Users\\91638\\Desktop\\FileEntDct"; 
            File outputFile = new File(outputFileName);

            if (choice == 'E' || choice == 'e') {
                encryptFile(inputFile, outputFile);
                System.out.println("Encryption Successful.");
            } else if (choice == 'D' || choice == 'd') {
                decryptFile(inputFile, outputFile);
                System.out.println("Decryption Successful");
            } else {
                System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void encryptFile(File inputFile, File outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line);
                writer.write(encryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error encrypting file: " + e.getMessage());
        }
    }

    private static void decryptFile(File inputFile, File outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error decrypting file: " + e.getMessage());
        }
    }

    private static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + 1));
        }
        return encrypted.toString();
    }

    private static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append((char) (c - 1));
        }
        return decrypted.toString();
    }
}
