package Travel;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    // --- DATABASE GLOBAL ---
    // Menyimpan daftar paket wisata
    static ArrayList<PaketWisata> daftarPaket = new ArrayList<>();
    
    // Menyimpan data pelanggan agar orderan tersimpan (History)
    static ArrayList<Pelanggan> historyPelanggan = new ArrayList<>();
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // --- 1. INISIALISASI DATA DUMMY (BANDUNG SERIES) ---
        
        // Wisata Alam
        daftarPaket.add(new WisataAlam("A01", "Tangkuban Perahu & Ciater", 650000, 
                "Bandung Utara", "1 Hari", "Transport Elf, Tiket, Guide, Makan Siang"));
        
        daftarPaket.add(new WisataAlam("A02", "Kawah Putih + Glamping", 1200000, 
                "Ciwidey (Selatan)", "2 Hari 1 Malam", "Transport Bus, Tiket, Glamping, Welcome Drink"));
        
        daftarPaket.add(new WisataAlam("A03", "Ranca Upas Camping", 850000, 
                "Ciwidey", "2 Hari 1 Malam", "Transport Elf, Tenda, Sleeping Bag, Tiket Rusa, Makan"));

        // Wisata Budaya
        daftarPaket.add(new WisataBudaya("B01", "Saung Angklung Udjo", 350000, 
                "Bandung Timur", "1 Hari", "Transport Bus, Tiket Show, Workshop, Snack"));
        
        daftarPaket.add(new WisataBudaya("B02", "Bandung Heritage Tour", 500000, 
                "Kota Bandung", "1 Hari", "Transport Mobil/Elf, Tiket Museum, Guide"));
        
        daftarPaket.add(new WisataBudaya("B03", "Braga & Asia Afrika Tour", 450000, 
                "Kota Bandung", "1 Hari", "Transport Elf, Dokumentasi, Guide, Tiket Museum"));

        // --- 2. MENU UTAMA ---
        int pilihan = 0;
        while (pilihan != 7) {
            System.out.println("\n=== BANDUNG TRAVEL AGENT ===");
            System.out.println("1. Tambah Paket Baru");
            System.out.println("2. Tampilkan Daftar Paket");
            System.out.println("3. Cari Paket (by Nama)");
            System.out.println("4. Ubah Harga Paket");
            System.out.println("5. Cek Status (Paket & Pelanggan)");
            System.out.println("6. Pesan Paket (Input Manual)");
            System.out.println("7. Keluar");
            System.out.print("Pilihan: ");
            
            // Validasi input menu harus angka
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Bersihkan buffer
            } else {
                System.out.println("Error: Masukkan angka 1-7!");
                scanner.next(); // Buang input salah
                continue;
            }

            switch (pilihan) {
                case 1: menuTambah(); break;
                case 2: menuTampil(); break;
                case 3: menuCari(); break;
                case 4: menuUbah(); break;
                case 5: menuCekStatus(); break;
                case 6: menuPesanManual(); break;
                case 7: System.out.println("Terima Kasih! Hatur Nuhun."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // --- MENU 1: TAMBAH DATA (ANTI ERROR) ---
    static void menuTambah() {
        System.out.println("\n--- TAMBAH PAKET BARU ---");
        System.out.println("1. Wisata Alam");
        System.out.println("2. Wisata Budaya");
        
        int jenis = 0;
        while (true) {
            System.out.print("Pilih Jenis (1/2): ");
            try {
                jenis = Integer.parseInt(scanner.nextLine());
                if (jenis == 1 || jenis == 2) break;
            } catch (Exception e) {
                System.out.println("Input harus angka 1 atau 2.");
            }
        }

        System.out.print("Kode Paket: "); String kode = scanner.nextLine();
        System.out.print("Nama Paket: "); String nama = scanner.nextLine();
        
        // Validasi Harga (Bisa input titik/koma)
        double harga = 0;
        while (true) {
            System.out.print("Harga (cth: 500000): ");
            String inputHarga = scanner.nextLine();
            try {
                // Bersihkan titik ribuan
                String hargaBersih = inputHarga.replace(".", "").replace(",", "");
                harga = Double.parseDouble(hargaBersih);
                break;
            } catch (Exception e) {
                System.out.println("Error: Harga harus berupa angka!");
            }
        }

        System.out.print("Lokasi: "); String lokasi = scanner.nextLine();
        System.out.print("Durasi: "); String durasi = scanner.nextLine();
        System.out.print("Fasilitas & Transport: "); String fas = scanner.nextLine();

        if (jenis == 1) {
            daftarPaket.add(new WisataAlam(kode, nama, harga, lokasi, durasi, fas));
        } else {
            daftarPaket.add(new WisataBudaya(kode, nama, harga, lokasi, durasi, fas));
        }
        System.out.println("Data paket berhasil disimpan!");
    }

    // --- MENU 2: TAMPIL DATA ---
    static void menuTampil() {
        System.out.println("\n--- DAFTAR PAKET WISATA ---");
        if (daftarPaket.isEmpty()) System.out.println("Data masih kosong.");
        for (PaketWisata p : daftarPaket) {
            p.infoPaket();
            System.out.println("---------------------------");
        }
    }

    // --- MENU 3: CARI DATA ---
    static void menuCari() {
        System.out.print("\nCari Nama Paket: "); 
        String cari = scanner.nextLine();
        boolean found = false;
        
        for (PaketWisata p : daftarPaket) {
            if (p.getNamaPaket().toLowerCase().contains(cari.toLowerCase())) {
                System.out.println("DITEMUKAN:");
                p.infoPaket();
                found = true;
            }
        }
        if (!found) System.out.println("Paket tidak ditemukan.");
    }

    // --- MENU 4: UBAH HARGA ---
    static void menuUbah() {
        System.out.print("\nMasukkan Kode Paket: "); 
        String kode = scanner.nextLine();
        
        for (PaketWisata p : daftarPaket) {
            if (p.getKodePaket().equalsIgnoreCase(kode)) {
                System.out.println("Paket: " + p.getNamaPaket());
                System.out.print("Masukkan Harga Baru: ");
                p.setHarga(scanner.nextDouble());
                System.out.println("Harga berhasil diubah.");
                return;
            }
        }
        System.out.println("Kode paket tidak ditemukan.");
    }

    // --- MENU 5: CEK STATUS (PAKET & PELANGGAN) ---
    static void menuCekStatus() {
        // Bagian 1: Status Paket (Inventory)
        System.out.println("\n=== [1] STATUS PAKET WISATA ===");
        if (daftarPaket.isEmpty()) {
            System.out.println("Data paket kosong.");
        } else {
            for (PaketWisata p : daftarPaket) {
                System.out.print("- " + p.getNamaPaket() + " [" + p.cekStatus() + "] ");
                
                // Polymorphism: Panggil method khusus anak
                if (p instanceof WisataAlam) ((WisataAlam) p).cekTransportasi();
                else if (p instanceof WisataBudaya) ((WisataBudaya) p).jadwalShow();
            }
        }

        // Bagian 2: Status Pelanggan (History Order)
        System.out.println("\n=== [2] DATA PEMESANAN PELANGGAN ===");
        if (historyPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan yang memesan.");
        } else {
            for (Pelanggan p : historyPelanggan) {
                p.lihatPesanan(); // Menampilkan detail tiap pelanggan
            }
        }
    }

    // --- MENU 6: PESAN MANUAL (LOGIKA BARU) ---
    static void menuPesanManual() {
        System.out.println("\n--- FORM PEMESANAN ---");
        
        // 1. Input Identitas
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Tanggal Pesan (cth: 25-Nov): ");
        String tanggal = scanner.nextLine();

        // 2. Cek Logika: Apakah pelanggan ini orang lama atau baru?
        Pelanggan pembeli = null;
        for (Pelanggan p : historyPelanggan) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                pembeli = p; // Ketemu! Ini pelanggan lama
                System.out.println("(Selamat datang kembali, " + nama + "!)");
                break;
            }
        }
        
        // Kalau tidak ketemu, berarti pelanggan baru
        if (pembeli == null) {
            pembeli = new Pelanggan(nama);
            historyPelanggan.add(pembeli); // Simpan ke list history
            System.out.println("(Pelanggan Baru didaftarkan)");
        }

        // 3. Tampilkan Pilihan Paket
        System.out.println("\nPaket Tersedia:");
        for (int i = 0; i < daftarPaket.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPaket.get(i).getNamaPaket() + 
                               " (Rp " + daftarPaket.get(i).getHarga() + ")");
        }

        // 4. Proses Pilih
        System.out.print("Pilih Nomor Paket: ");
        int indeks = 0;
        try {
            indeks = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {}

        if (indeks > 0 && indeks <= daftarPaket.size()) {
            PaketWisata paketDipilih = daftarPaket.get(indeks - 1);
            
            // Simpan pesanan ke dalam objek Pelanggan tersebut
            pembeli.tambahPesanan(paketDipilih, tanggal);
            
            System.out.println(">>> Berhasil! Cek detailnya di Menu 5. <<<");
        } else {
            System.out.println("Nomor paket salah / Batal.");
        }
    }
}