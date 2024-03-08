package StudyCase2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean next = true;

        while (next) {
            System.out.print("Masukkan nim : ");
            String nim = scanner.nextLine();

            System.out.print("Masukkan nama : ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan alamat: ");
            String alamat = scanner.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, alamat);
            daftarMahasiswa.add(mahasiswa);

            System.out.print("Tambah data lagi? (y/t) ");
            String tambah = scanner.nextLine();

            if (tambah.equals("t")) {
                next = false;
            }
        }

        System.out.println("==================================");
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println(mhs.getNim() + " | " + mhs.getNama() + " | " + mhs.getAlamat());
        }
    }
}
