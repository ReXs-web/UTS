package Travel;

/**
 * Superclass: PaketWisata
 * Menyimpan data umum paket wisata.
 */
public class PaketWisata {
    // 1. Tiga Atribut Private (Encapsulation)
    private String kodePaket;
    private String namaPaket;
    private double harga;

    // 2. Constructor Berparameter
    public PaketWisata(String kodePaket, String namaPaket, double harga) {
        this.kodePaket = kodePaket;
        this.namaPaket = namaPaket;
        this.harga = harga;
    }

    // 3. Method Tambahan 1: Menampilkan info dasar
    public void infoPaket() {
        System.out.println("Kode   : " + kodePaket);
        System.out.println("Nama   : " + namaPaket);
        System.out.println("Harga  : Rp " + harga);
    }

    // 4. Method Tambahan 2: Cek Status (Syarat Menu)
    public String cekStatus() {
        if (harga > 0) {
            return "Tersedia";
        } else {
            return "Tidak Valid/Habis";
        }
    }

    // --- Getter dan Setter (Encapsulation) ---
    public String getKodePaket() { return kodePaket; }
    public String getNamaPaket() { return namaPaket; }
    public double getHarga() { return harga; }
    
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }
}