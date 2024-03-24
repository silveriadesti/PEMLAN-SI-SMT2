public class MataKuliah {
    private String kode;
    private String nama;
    private int nilaiAngka;

    public MataKuliah(String kode, String nama, int nilaiAngka) {
        this.kode = kode;
        this.nama = nama;
        this.nilaiAngka = nilaiAngka;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getNilaiAngka() {
        return nilaiAngka;
    }

    public String getNilaiHuruf() {
        if (nilaiAngka >= 80) {
            return "A";
        } else if (nilaiAngka >= 75) {
            return "B+";
        } else if (nilaiAngka >= 70) {
            return "B";
        } else if (nilaiAngka >= 65) {
            return "C+";
        } else if (nilaiAngka >= 60) {
            return "C";
        } else if (nilaiAngka >= 55) {
            return "D+";
        } else if (nilaiAngka >= 50) {
            return "D";
        } else {
            return "E";
        }
    }
}
