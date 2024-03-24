
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

        boolean nextMhs = true;
        while (nextMhs) {
            System.out.println("Kartu Hasil Studi");
            System.out.println("=================");
            System.out.println();

            System.out.print("Masukan nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukan NIM: ");
            String nim = scanner.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama);

            boolean nextMatkul = true;
            while (nextMatkul) {
                System.out.print("Masukkan kode mata kuliah: ");
                String kode = scanner.nextLine();
                System.out.print("Masukkan nama mata kuliah: ");
                String namaMatkul = scanner.nextLine();
                System.out.print("Masukkan nilai angka: ");
                int nilai = Integer.parseInt(scanner.nextLine());

                MataKuliah mataKuliah = new MataKuliah(kode, namaMatkul, nilai);
                mahasiswa.tambahMataKuliah(mataKuliah);

                System.out.print("Tambah mata kuliah lain? (y/t): ");
                String tambah = scanner.nextLine();
                if (tambah.equalsIgnoreCase("t")) {
                    nextMatkul = false;
                }
            }

            mahasiswaList.add(mahasiswa);

            System.out.print("Tambah mahasiswa lain? (y/t): ");
            String tambahMhs = scanner.nextLine();
            if (tambahMhs.equalsIgnoreCase("t")) {
                nextMhs = false;
            }
        }

        System.out.println("\nKartu Hasil Studi");
        System.out.println("=================");
        for (Mahasiswa mahasiswa : mahasiswaList) {
            System.out.println("Mahasiswa: " + mahasiswa.getNim() + " - " + mahasiswa.getNama());
            System.out.println("Mata Kuliah:");
            for (MataKuliah mataKuliah : mahasiswa.getMataKuliahList()) {
                System.out.println("Kode: " + mataKuliah.getKode() + ", Nama: " + mataKuliah.getNama() + ", Nilai: " + mataKuliah.getNilaiAngka() + ", Nilai Huruf: " + mataKuliah.getNilaiHuruf());
            }
            System.out.println();
        }
    }
}

