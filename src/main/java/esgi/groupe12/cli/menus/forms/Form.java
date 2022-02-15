package esgi.groupe12.cli.menus.forms;

import java.util.Scanner;

public abstract class Form {

    private static final Scanner SCANNER = new Scanner(System.in);

    protected Form() {
    }

    protected String stringField(String display) {
        String str = "";
        while (str.isBlank()) {
            System.out.println(display);
            str = SCANNER.nextLine();
        }
        return str;
    }
}
