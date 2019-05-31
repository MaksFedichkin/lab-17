import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Notepad extends Frame{
    public Notepad(){
        addWindowListener(new NotepadWindowAdapter());
    }
    public static void main(String[] args){
        Notepad notepad =new Notepad();
        notepad.setTitle("Блокнот");
        notepad.setSize(640,480);

        Menu menuFile=new Menu("Файл");
        Menu menuFile1=new Menu("Формат");

        MenuItem menuItemOpen=new MenuItem("Открыть");
        menuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    FileDialog fileDialog = new FileDialog(notepad,"Открыть...",FileDialog.LOAD);
                    fileDialog.setVisible(true);
                    File file =new File(fileDialog.getFile());
                System.out.println(file.getAbsolutePath());
                }
        });
        menuFile.add(menuItemOpen);

        MenuItem menuItemSaveAs=new MenuItem("Сохранить");
        menuItemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(notepad, "Созхранить как...", FileDialog.SAVE);
                fileDialog.setVisible(true);
                File file = new File(fileDialog.getFile());
                System.out.println(file.getAbsolutePath());
            }
        });
        menuFile.add(menuItemSaveAs);

        MenuItem menuItemExit=new MenuItem("Выход1");
        MenuItem menuItemExit1=new MenuItem("Выход2");

        menuFile.addSeparator();

        Menu menuFile3=new Menu("Выход");
        menuFile3.add(menuItemExit);
        menuFile3.add(menuItemExit1);
        menuFile.add(menuFile3);

        MenuBar menuBar =new MenuBar();
        menuBar.add(menuFile);
        menuBar.add(menuFile1);

        notepad.setMenuBar(menuBar);

        TextArea textArea=new TextArea();
        notepad.add(textArea);

        notepad.setVisible(true);
    }
}

class NotepadWindowAdapter extends WindowAdapter {
    public void windowClosing (WindowEvent we ){
        System.exit(0) ;
    }
}

