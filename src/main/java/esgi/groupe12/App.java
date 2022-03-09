package esgi.groupe12;

import esgi.groupe12.cli.CLILauncher;
import esgi.groupe12.core.CoreOCRParser;
import esgi.groupe12.core.tools.parser.OcrParser;
import esgi.groupe12.core.tools.fileManagement.CreateFile;
import esgi.groupe12.core.tools.fileManagement.ReadFile;

public class App 
{
    public static void main( String[] args )
    {
        ReadFile readFile = new ReadFile(
                "fileInput/",
                100 * 4
        );
        CreateFile createFile = new CreateFile(
                "fileOutput/"
        );

        OcrParser ocrParser = new OcrParser(4, 3);

        CoreOCRParser coreOCRParser = new CoreOCRParser(readFile, ocrParser, createFile);
        CLILauncher cliLauncher = new CLILauncher(coreOCRParser);

        cliLauncher.start();
    }

}
