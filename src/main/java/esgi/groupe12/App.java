package esgi.groupe12;

import esgi.groupe12.cli.CLILauncher;
import esgi.groupe12.core.CoreOCRParser;
import esgi.groupe12.core.tools.parser.OcrParser;
import esgi.groupe12.core.tools.fileManagement.CreateFile;
import esgi.groupe12.core.tools.fileManagement.ReadFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReadFile readFile = new ReadFile(
                "/home/thibaud-briand/Programe/java_/KattaImpovedOCR/fileInput/",
                100 * 4
        );
        CreateFile createFile = new CreateFile(
                "/home/thibaud-briand/Programe/java_/KattaImpovedOCR/fileOutput/"
        );

        OcrParser ocrParser = new OcrParser(4, 3);

        CoreOCRParser coreOCRParser = new CoreOCRParser(readFile, ocrParser, createFile);
        CLILauncher cliLauncher = new CLILauncher(coreOCRParser);

        cliLauncher.start();
    }

}
