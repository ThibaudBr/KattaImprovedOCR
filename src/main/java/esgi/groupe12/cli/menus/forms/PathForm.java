package esgi.groupe12.cli.menus.forms;

import java.io.File;

public class PathForm extends Form{

    public PathForm() { super();}

    public String askEntries() {
        String path;
        do {
            path = this.stringField("Enter new valid Path:");
        } while (!isValidPath(path));

        return path;
    }

    private boolean isValidPath(String path){
        File file = new File(path);
        return file.exists();
    }
}
