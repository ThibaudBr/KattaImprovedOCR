package esgi.groupe12.cli.menus;

import esgi.groupe12.cli.CLILauncher;

public class HelpMenu extends Menu {
    public HelpMenu(CLILauncher launcher) {
        super(launcher, "---- Help Menu");
        System.out.println("This application is an app who read file with ocr code of 9 number and" +
                "return integer number of it in file.");
        System.out.println("Choose an action :");

        addAction(new Action("Change path") {
            @Override
            public void execute() {
                System.out.println("You can change input and output filePath in the main menu of this application. Also" +
                        "you can change directory in App.java file");
                launcher.setActiveMenu(new HelpMenu(launcher));
            }
        });

        addAction(new Action("Read File") {
            @Override
            public void execute() {
                System.out.println("All the methode that read value in file is in ReadFile.java\n" +
                        "Method:\n" +
                        "-- getListFiles: return all the file in the given directory \n" +
                        "-- getStrings: return a List of all the read line in the given file\n" +
                        "-- concatIfMaxLigne: concat the List of string of getString if there is more than 400 lines in file" +
                        "you can change the maxLine in App.java\n" +
                        "-- getAllString: is the methode call by other class and who use all the previous methode");
                launcher.setActiveMenu(new HelpMenu(launcher));
            }
        });

        addAction(new Action("Create File") {
            @Override
            public void execute() {
                System.out.println("All the method that create and write in file are in the class CreatFile.java\n" +
                        "Method :\n" +
                        "-- The main method are generateAndWriteFile and generateAndWriteOrderedFile" +
                        "--- generateAndWriteFile: a method that generate file for each file given in the input repository\n" +
                        "--- generateAndWriteOrderedFile: method that generate 3 file in wich are classified each ocr return if there are Authorized, Errored or Unknown\n" +
                        "-- generateFile: Create a file in the repertory with the given name\n" +
                        "-- writeInFile: Write the list of string given in the file create with generateFile");
                launcher.setActiveMenu(new HelpMenu(launcher));
            }
        });

        addAction(new Action("OCR Parser") {
            @Override
            public void execute() {
                System.out.println("All the method that convert OCR String in number\n" +
                        "Method :\n" +
                        "-- run: Main method call by other classes\n" +
                        "-- countNbRun: return the number of ocr present in the given list (allLine/divided by height of OCR)\n" +
                        "-- runSublist: return a list of the converted OCR input\n" +
                        "-- isWithErrorOrUnknown: return an error string for each errored or unknown result\n" +
                        "-- calculChecksum: calc checksum for each given string\n" +
                        "-- parse and parseEight: return a string with number for each OCR in the file, Read number by number right to left, top to bottom");
                launcher.setActiveMenu(new HelpMenu(launcher));
            }
        });

        addAction(new Action("Ordered List") {
            @Override
            public void execute() {
                System.out.println("All the method that order the result OCR are oredred in OrderList.java\n" +
                        "Method :\n" +
                        "-- getHashMap: Main method call by other classes. Retrun an hashmap of 3 list : Autorized, Errored, Unknown\n" +
                        "-- getUnknown: return Unknow OCR\n" +
                        "-- getErrored: return Errored OCR\n" +
                        "-- getAuthorized: return Authorized OCR");
                launcher.setActiveMenu(new HelpMenu(launcher));
            }
        });

        addAction(new Action("Codex OCR") {
            @Override
            public void execute() {
                System.out.println("The codex is where are reference which string give which number\n" +
                        "-- initializeCodex(int height, int length): Main method of CodexOCR. if you want to add more " +
                        "codex for different eight/length you will  need to add a new if condition with the eight and length" +
                        "and create a new method who return an hashmap of with the number ocr in string as parameter");
                launcher.setActiveMenu(new HelpMenu(launcher));
            }
        });

        addAction(new Action("Go to Main Menu") {
            @Override
            public void execute() {
                launcher.setActiveMenu(new MainMenu(launcher));
            }
        });
    }
}
