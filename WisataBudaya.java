package Travel;

public class WisataBudaya extends PaketWisata {
    // Variabel disesuaikan dengan data baru
    private String lokasi;
    private String durasi;
    private String fasilitas;

    public WisataBudaya(String kode, String nama, double harga, String lokasi, String durasi, String fasilitas) {
        super(kode, nama, harga);
        this.lokasi = lokasi;
        this.durasi = durasi;
        this.fasilitas = fasilitas;
    }

    @Override
    public void infoPaket() {
        super.infoPaket();
        System.out.println("Kategori  : Wisata Budaya (Bandung)");
        System.out.println("Lokasi    : " + lokasi);
        System.out.println("Durasi    : " + durasi);
        System.out.println("Fasilitas : " + fasilitas);
    }

    // Method Tambahan 1
    public void jadwalShow() {
        System.out.println("Info: Pertunjukan budaya dimulai pukul 09.00 atau 15.30.");
    }
    
    // Method Tambahan 2
    public void infoGuide() {
        System.out.println("Info: Guide bersertifikat HPI (Himpunan Pramuwisata Indonesia).");
    }
}