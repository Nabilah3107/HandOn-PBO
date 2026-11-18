package HANSON;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

public class FileCopyWithLog {
    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logFile = Paths.get("log.txt");

        try {
            // Menulis laporan utama
            Files.write(source, List.of("Report Generated", "Status: OK"));

            // Pengecekan file sebelum menyalin
            if (Files.exists(source)) {
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());}
                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);

                String logMessage = LocalDateTime.now() + " - Backup berhasil dibuat ke " + backup + System.lineSeparator();
                Files.writeString(logFile, logMessage, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Backup dan log berhasil dibuat!");} 
                else {
                String logError = LocalDateTime.now() + " - Gagal: File sumber tidak ditemukan." + System.lineSeparator();
                Files.writeString(logFile, logError, StandardOpenOption.CREATE, StandardOpenOption.APPEND);}
        } catch (IOException e) {
            e.printStackTrace();}}}
