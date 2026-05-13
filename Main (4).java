import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    // Window
    JFrame window;

    // Text Area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    // Menu Bar
    JMenuBar menuBar;

    // Menus
    JMenu MenuFile, MenuEdit, MenuFormat, MenuColor;

    // File Menu Items
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    // Format Menu Items
    JMenuItem iWrap;
    JMenuItem iFontArial, iFontCSMS, iFontTNR;
    JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24;
    JMenu menuFont, menuFontSize;

    // Color Menu Items
    JMenuItem iColorWhite, iColorRed, iColorYellow;

    // Helper classes
    function_file file = new function_file(this);
    function_format format = new function_format(this);
    function_color color = new function_color(this);

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createMenuBar();
        createMenuFile();
        createFormatMenu();
        createColorMenu();

        format.selectFont = "Arial";
        format.createFont(12);
        format.wordWrap();
        color.changeColor("White");

        window.setVisible(true);
    }

    // Create main window and scroll area
    private void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();

        scrollPane = new JScrollPane(
            textArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    // Create menu bar with menus
    private void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        MenuFile = new JMenu("File");
        menuBar.add(MenuFile);

        MenuEdit = new JMenu("Edit");
        menuBar.add(MenuEdit);

        MenuFormat = new JMenu("Format");
        menuBar.add(MenuFormat);

        MenuColor = new JMenu("Color");
        menuBar.add(MenuColor);
    }

    // File menu items
    public void createMenuFile() {
        iNew = new JMenuItem("New");
        iNew.setActionCommand("New");
        iNew.addActionListener(this);
        MenuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.setActionCommand("Open");
        iOpen.addActionListener(this);
        MenuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.setActionCommand("Save");
        iSave.addActionListener(this);
        MenuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.setActionCommand("SaveAs");
        iSaveAs.addActionListener(this);
        MenuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.setActionCommand("Exit");
        iExit.addActionListener(this);
        MenuFile.add(iExit);
    }

    // Format menu items (word wrap, font, font size)
    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.setActionCommand("Word Wrap");
        iWrap.addActionListener(this);
        MenuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        MenuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.setActionCommand("Arial");
        iFontArial.addActionListener(this);
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.setActionCommand("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.setActionCommand("Times New Roman");
        iFontTNR.addActionListener(this);
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        MenuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.setActionCommand("8");
        iFontSize8.addActionListener(this);
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.setActionCommand("12");
        iFontSize12.addActionListener(this);
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.setActionCommand("16");
        iFontSize16.addActionListener(this);
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.setActionCommand("20");
        iFontSize20.addActionListener(this);
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.setActionCommand("24");
        iFontSize24.addActionListener(this);
        menuFontSize.add(iFontSize24);
    }

    // Color menu items
    public void createColorMenu() {
        iColorWhite = new JMenuItem("White");
        iColorWhite.setActionCommand("White");
        iColorWhite.addActionListener(this);
        MenuColor.add(iColorWhite);

        iColorRed = new JMenuItem("Red");
        iColorRed.setActionCommand("Red");
        iColorRed.addActionListener(this);
        MenuColor.add(iColorRed);

        iColorYellow = new JMenuItem("Yellow");
        iColorYellow.setActionCommand("Yellow");
        iColorYellow.addActionListener(this);
        MenuColor.add(iColorYellow);
    }

    // Handle all menu actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":             file.newFile();             break;
            case "Open":            file.open();                break;
            case "Save":            file.save();                break;
            case "SaveAs":          file.saveAs();              break;
            case "Exit":            System.exit(0);             break;
            case "Word Wrap":       format.wordWrap();          break;
            case "Arial":           format.setFont(command);    break;
            case "Comic Sans MS":   format.setFont(command);    break;
            case "Times New Roman": format.setFont(command);    break;
            case "8":               format.createFont(8);       break;
            case "12":              format.createFont(12);      break;
            case "16":              format.createFont(16);      break;
            case "20":              format.createFont(20);      break;
            case "24":              format.createFont(24);      break;
            case "White":           color.changeColor(command); break;
            case "Red":             color.changeColor(command); break;
            case "Yellow":          color.changeColor(command); break;
        }
    }
}
