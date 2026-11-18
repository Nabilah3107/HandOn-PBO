package HANSON;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// Class Generic serbaguna (bisa untuk Produk, Pelanggan, maupun Transaksi)
class DataRecord<T, U, V> {
    private T field1; // misal: nama produk / nama pelanggan
    private U field2; // misal: harga / email
    private V field3; // misal: stok (Integer) / total belanja

    public DataRecord(T field1, U field2, V field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;}

    @Override
    public String toString() {
        return field1 + "," + field2 + "," + field3;}}

public class ProdukWriterNew {
    public static void main(String[] args) {
        // 1. Penggunaan untuk Data Produk (Nama, Harga, Stok)
        List<DataRecord<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new DataRecord<>("Laptop", 15000000.0, 10));
        produkList.add(new DataRecord<>("Mouse", 150000.0, 50));
        produkList.add(new DataRecord<>("Keyboard", 350000.0, 25));

        // 2. Contoh penggunaan ulang class yang sama untuk Data Pelanggan (ID, Nama, Member)
        List<DataRecord<Integer, String, Boolean>> pelangganList = new ArrayList<>();
        pelangganList.add(new DataRecord<>(101, "Rina", true));
        pelangganList.add(new DataRecord<>(102, "Dimas", false));

        Path filePath = Paths.get("produk_output.txt");

        try {
            // Menulis data ke file menggunakan NIO.2
            List<String> linesToWrite = new ArrayList<>();
            for (DataRecord<String, Double, Integer> p : produkList) {
                linesToWrite.add(p.toString());}

            Files.write(filePath, linesToWrite);
            System.out.println("Data berhasil disimpan ke " + filePath);

            // Membaca kembali isi file menggunakan Files.readAllLines()
            System.out.println("\nIsi file " + filePath + ":");
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                System.out.println(line);}

            // Menampilkan contoh data pelanggan
            System.out.println("\nContoh Data Pelanggan (Reuse Generic Class):");
            pelangganList.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Gagal memproses file: " + e.getMessage());}}}
