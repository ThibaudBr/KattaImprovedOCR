package esgi.groupe12.cli.menus;

import esgi.groupe12.cli.CLILauncher;
import esgi.groupe12.cli.menus.forms.PathForm;
import esgi.groupe12.core.tools.FileType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainMenu extends Menu{

    public MainMenu(CLILauncher launcher) {
        super(launcher, "Menu Principale");
        System.out.println("Input file Path:" + launcher.getCoreOcrParser().getReadFile().getPathFileInput());
        System.out.println("Input file Path:" + launcher.getCoreOcrParser().getCreateFile().getPathFileOutput());
        System.out.println("Choose an action :");

        addAction(new Action( "Multiple Files (classic)") {
            @Override
            public void execute() {
                List<List<String>> result = new ArrayList<>();
                String dateNow = launcher.getCoreOcrParser().getDateNow();
                List<List<String>> ocrList = launcher.getCoreOcrParser().getReadFile().getAllString();
                for (List<String> list: ocrList){
                    result.add(launcher.getCoreOcrParser().getOcrParser().run(list));
                }
                launcher.getCoreOcrParser().getCreateFile().generateAndWriteFile(result, dateNow);
                System.out.println( "File create succesfully (" + dateNow + ")" );
                launcher.setActiveMenu(new MainMenu(launcher));
            }
        });

        addAction(new Action("Ordered Files") {
            @Override
            public void execute() {
                List<List<String>> result = new ArrayList<>();
                String dateNow = launcher.getCoreOcrParser().getDateNow();
                List<List<String>> ocrList = launcher.getCoreOcrParser().getReadFile().getAllString();
                for (List<String> list: ocrList){
                    result.add(launcher.getCoreOcrParser().getOcrParser().run(list));
                }
                launcher.getCoreOcrParser().getCreateFile().generateAndWriteOrderedFile(result, dateNow);
                System.out.println( "File create succesfully (" + dateNow + ")" );
                launcher.setActiveMenu(new MainMenu(launcher));

            }
        });

        addAction(new Action("Change InputPath") {
            @Override
            public void execute() {
                launcher.getCoreOcrParser().getReadFile().setPathFileInput(new PathForm().askEntries());
                launcher.setActiveMenu(new MainMenu(launcher));
            }
        });

        addAction(new Action("Change OutputPath") {
            @Override
            public void execute() {
                launcher.getCoreOcrParser().getCreateFile().setPathFileOutput(new PathForm().askEntries());
                launcher.setActiveMenu(new MainMenu(launcher));
            }
        });

        addAction(new Action("Exit") {
            @Override
            public void execute() {
                System.exit(1);
            }
        });
    }
}
