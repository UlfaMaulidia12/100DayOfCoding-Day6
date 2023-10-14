package ProgramFloatingNumber;

import java.util.Scanner;

public class PajakTahunandanBulanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        do {
            System.out.println("=== Kalkulator Pajak ===");
            try {
                // Input pendapatan tahunan (double)
                double pendapatanTahunan = getInput("Masukkan Pendapatan Tahunan (Double)\t: $");
                double tarifPajak1 = getInput("Masukkan Tarif Pajak (Double)\t\t: ");

                // Input jenis pajak
                String jenisPajak = getTaxType();
                double tarifPajak2 = getTaxRate(jenisPajak);

                // Input pendapatan bulanan (double)
                double pendapatanBulanan = getInput("Masukkan Pendapatan Bulanan (Double)\t: $");

                double jumlahPajakTahunan = calculateTax(pendapatanTahunan, tarifPajak1);
                double jumlahPajakBulanan = calculateTax(pendapatanBulanan, tarifPajak2);

                // Menampilkan hasil perhitungan dengan format yang sesuai
                displayResult("Pendapatan Tahunan (Double)\t", String.valueOf(pendapatanTahunan));
                displayResult("Jenis Pajak\t\t\t", jenisPajak);
                displayResult("Tarif Pajak (Double)\t\t", String.valueOf(tarifPajak2));
                displayResult("Pajak Tahunan (Double)\t\t", String.valueOf(jumlahPajakTahunan));

                System.out.println();

                displayResult("Pendapatan Bulanan (Double)\t", String.valueOf(pendapatanBulanan));
                displayResult("Jenis Pajak\t\t\t", jenisPajak);
                displayResult("Tarif Pajak (Double)\t\t", String.valueOf(tarifPajak2));
                displayResult("Pajak Bulanan (Double)\t\t", String.valueOf(jumlahPajakBulanan));

                double totalPajak = jumlahPajakTahunan + jumlahPajakBulanan;
                displayResult("Total Pajak\t\t\t", String.valueOf(totalPajak));
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Pastikan Anda memasukkan angka yang benar.");
            }

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N):");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    // Metode untuk mengambil input dari pengguna
    private static double getInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextDouble();
    }

    // Metode untuk menghitung pajak
    private static double calculateTax(double pendapatan, double tarif) {
        return pendapatan * (tarif / 100);
    }

    // Metode untuk menampilkan hasil dengan format yang sesuai
    private static void displayResult(String label, String value) {
        System.out.println(label + ": " + value);
    }

    // Metode untuk mengambil input 'Y' atau 'N' dari pengguna
    private static char getYesNoInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        String response = input.nextLine().trim();
        if (response.length() > 0) {
            return response.charAt(0);
        }
        return 'N'; // Default value if no input is provided
    }

    // Metode untuk mendapatkan jenis pajak
    private static String getTaxType() {
        Scanner input = new Scanner(System.in);
        System.out.print("Jenis Pajak (Penghasilan/Properti/Lainnya):\t");
        return input.nextLine();
    }

    // Metode untuk mendapatkan tarif pajak berdasarkan jenis pajak
    private static double getTaxRate(String jenisPajak) {
        if (jenisPajak.equalsIgnoreCase("Penghasilan")) {
            return 15.0; // Tarif pajak penghasilan
        } else if (jenisPajak.equalsIgnoreCase("Properti")) {
            return 5.0; // Tarif pajak properti
        } else {
            return 10.0; // Tarif pajak default untuk jenis lainnya
        }
    }
}
