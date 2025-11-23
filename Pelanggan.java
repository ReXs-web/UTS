package Travel;

import java.util.ArrayList;

public class Pelanggan {
    private String nama;
    
    private ArrayList<String> listTanggal; 
    
    private ArrayList<PaketWisata> keranjang;

    public Pelanggan(String nama) {
        this.nama = nama;
        this.keranjang = new ArrayList<>();
        this.listTanggal = new ArrayList<>(); // Siapkan wadah tanggal
    }

    public void tambahPesanan(PaketWisata paket, String tanggal) {
        this.keranjang.add(paket);
        this.listTanggal.add(tanggal); // Simpan tanggal sesuai urutan paket
        System.out.println("Sukses: " + paket.getNamaPaket() + " masuk keranjang " + this.nama);
    }

    public void lihatPesanan() {
        System.out.println("Nama Pelanggan : " + nama);
        
        if (keranjang.isEmpty()) {
            System.out.println("Status: Belum ada pesanan.");
        } else {
            double total = 0;
            // Looping pakai index (i) supaya bisa ambil Paket DAN Tanggalnya barengan
            for (int i = 0; i < keranjang.size(); i++) {
                PaketWisata p = keranjang.get(i);
                String tgl = listTanggal.get(i);
                
                System.out.println("- [" + tgl + "] " + p.getNamaPaket() + " (Rp " + p.getHarga() + ")");
                total += p.getHarga();
            }
            System.out.println("Total Tagihan  : Rp " + total);
        }
        System.out.println("-------------------------");
    }
    
    public String getNama() { return nama; }
}