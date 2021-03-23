package MainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuProgram {
    JMenu menu, submenu;
    JMenuItem i1, i2, i3;
    JTextArea textArea;
    JFrame frame;
    ActionListener menuItemActionListener;

    MenuProgram() {

        frame = new JFrame("Menu and MenuItem Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        textArea = new JTextArea("Welcome!!");
        menu = new JMenu("Menu");
        submenu = new JMenu("Fonts");
        String[] fonts = getFonts();
        int fontNumber = fonts.length;
        JMenuItem menuItem[] = new JMenuItem[fontNumber];
        menuItemActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem source = (JMenuItem) e.getSource();
                System.out.println("text = " + source.getText());
                String[] fonts = getFonts();
                for (int i = 0; i < fonts.length; i++) {

                    if (source.getText().equals(fonts[i])) {
                        setNewFont(source.getText());
                        System.out.println("font changed to :- " + source.getText());
                    }

                }
            }
        };
        for (int i = 0; i < fontNumber; i++) {
            menuItem[i] = new JMenuItem(fonts[i]);
            submenu.add(menuItem[i]);
            menuItem[i].addActionListener(menuItemActionListener);
        }
        i1 = new JMenuItem("Save");
        i2 = new JMenuItem("Save As");
        i3 = new JMenuItem("Close");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(submenu);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setSize(400, 400);
        textArea.setBounds(0, 0, 400, 400);
        frame.add(textArea);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void setNewFont(String fontName) {
        Font f = new Font(fontName, Font.PLAIN, 18);
        textArea.setFont(f);
        textArea.setText("Font Changed to :- "+fontName);
    }

    public String[] getFonts() {
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fonts.length; i++) {
            // System.out.println(fonts[i]);
        }
        return fonts;
    }

    public static void main(String args[]) {
        new MenuProgram();
    }
}