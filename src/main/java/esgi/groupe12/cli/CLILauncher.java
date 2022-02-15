package esgi.groupe12.cli;

import esgi.groupe12.cli.menus.MainMenu;
import esgi.groupe12.cli.menus.Menu;
import esgi.groupe12.core.CoreOCRParser;

public class CLILauncher {
    private Menu activeMenu;
    private CoreOCRParser ocrParser;

    public CLILauncher(CoreOCRParser ocrParser) {
        this.ocrParser = ocrParser;
        this.activeMenu = new MainMenu(this);
    }

    public void start() {
        System.out.println("Starting CLI Menu");
        while (true) {
            activeMenu.start();
        }
    }

    public CoreOCRParser getCoreOcrParser() { return ocrParser;}

    public Menu getActiveMenu() { return activeMenu; }

    public void setActiveMenu(Menu activeMenu) { this.activeMenu = activeMenu;}

}
