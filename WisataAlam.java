package Travel;

public class WisataAlam extends PaketWisata {
    // Variabel disesuaikan dengan data baru
    private String lokasi;
    private String durasi;
    private String fasilitas; // Gabungan Fasilitas & Transport

    public WisataAlam(String kode, String nama, double harga, String lokasi, String durasi, String fasilitas) {
        super(kode, nama, harga);
        this.lokasi = lokasi;
        this.durasi = durasi;
        this.fasilitas = fasilitas;
    }

    @Override
    public void infoPaket() {
        super.infoPaket();
        System.out.println("Kategori  : Wisata Alam (Bandung)");
        System.out.println("Lokasi    : " + lokasi);
        System.out.println("Durasi    : " + durasi);
        System.out.println("Fasilitas : " + fasilitas);
    }

    // Method Tambahan 1
    public void cekPerlengkapan() {
        System.out.println("Info: Disarankan membawa jaket tebal dan sepatu nyaman.");
    }
    
    // Method Tambahan 2
    public void cekTransportasi() {
        if (fasilitas.contains("Bus")) {
            System.out.println("Info: Meeting point di Pool Bus Pusat.");
        } else {
            System.out.println("Info: Penjemputan bisa di hotel/stasiun.");
        }
    }
}