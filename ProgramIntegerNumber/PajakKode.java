package ProgramIntegerNumber;

import java.util.Scanner;

public class PajakKode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        do {
            System.out.println("=== Tax Code Calculator ===");

            // Meminta pengguna untuk memasukkan kode pajak
            byte kodePajak1 = getInputByte("Masukkan Kode Pajak (byte)\t: ");
            short kodePajak2 = getInputShort("Masukkan Kode Pajak (short)\t: ");
            int kodePajak3 = getInputInt("Masukkan Kode Pajak (int)\t: ");
            long kodePajak4 = getInputLong("Masukkan Kode Pajak (long)\t: ");

            // Meminta pengguna untuk memasukkan persentase pajak
            byte persentasePajak1 = getInputByte("Masukkan Persentase Pajak (byte)\t: ");
            short persentasePajak2 = getInputShort("Masukkan Persentase Pajak (short)\t: ");
            int persentasePajak3 = getInputInt("Masukkan Persentase Pajak (int)\t: ");
            long persentasePajak4 = getInputLong("Masukkan Persentase Pajak (long)\t: ");

            // Menampilkan kode pajak
            displayResult("Kode Pajak 1", kodePajak1);
            displayResult("Kode Pajak 2", kodePajak2);
            displayResult("Kode Pajak 3", kodePajak3);
            displayResult("Kode Pajak 4", kodePajak4);

            // Menampilkan persentase pajak
            displayResult("Persentase Pajak 1", persentasePajak1 + "%");
            displayResult("Persentase Pajak 2", persentasePajak2 + "%");
            displayResult("Persentase Pajak 3", persentasePajak3 + "%");
            displayResult("Persentase Pajak 4", persentasePajak4 + "%");

            System.out.print("Hitung pajak lagi? (Y/N): ");
            ulangi = input.next().charAt(0);
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    private static byte getInputByte(String message) {
        Scanner input = new Scanner(System.in);
        byte value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = input.nextByte();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }
        return value;
    }

    private static short getInputShort(String message) {
        Scanner input = new Scanner(System.in);
        short value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = input.nextShort();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }
        return value;
    }

    private static int getInputInt(String message) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = input.nextInt();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }
        return value;
    }

    private static long getInputLong(String message) {
        Scanner input = new Scanner(System.in);
        long value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = input.nextLong();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }
        return value;
    }

    private static void displayResult(String label, Object value) {
        System.out.println(label + ": " + value);
    }
}
