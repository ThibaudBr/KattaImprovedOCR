package esgi.groupe12.core;

import esgi.groupe12.core.tools.fileManagement.CreateFile;
import esgi.groupe12.core.tools.fileManagement.ReadFile;
import esgi.groupe12.core.tools.parser.OcrParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CoreOCRParser {
    private final ReadFile readFile;
    private final OcrParser ocrParser;
    private final CreateFile createFile;

    public CoreOCRParser(ReadFile readFile, OcrParser ocrParser, CreateFile createFile) {
        this.readFile = readFile;
        this.ocrParser = ocrParser;
        this.createFile = createFile;
    }

    public ReadFile getReadFile() {
        return readFile;
    }

    public String getDateNow() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .format(DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss"));
    }

    public OcrParser getOcrParser() {
        return ocrParser;
    }

    public CreateFile getCreateFile() {
        return createFile;
    }
}
