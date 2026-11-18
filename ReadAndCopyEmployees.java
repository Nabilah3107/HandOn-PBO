package HANSON;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndCopyEmployees {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("HANSON/employees.txt");
        Path destPath = Paths.get("HANSON/copy_employees.txt");
        List<String> employeeList = new ArrayList<>();

        // Deteksi jika file tidak ditemukan
        if (Files.notExists(sourcePath)) {
            System.out.println("Error: File " + sourcePath.toAbsolutePath() + " tidak ditemukan!");
            return;}

        // Membaca file dan menyimpan ke ArrayList
        try (BufferedReader br = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                employeeList.add(line);}
            System.out.println("Berhasil membaca " + employeeList.size() + " baris data.");

            // Menulis isi ArrayList ke file baru
            Files.write(destPath, employeeList, StandardCharsets.UTF_8);
            System.out.println("Data berhasil disalin ke " + destPath.getFileName());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());}}}