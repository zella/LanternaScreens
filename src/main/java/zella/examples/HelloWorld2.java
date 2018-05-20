package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HelloWorld2 {

    static Executor ex = Executors.newSingleThreadExecutor();

    private static void runBg(Callable r) {
        ex.execute(() -> {
            try {
                r.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static Window genWindow(int grid) {
        // Create panel to hold components
        Panel panel = new Panel();
//        if (grid==1){
//        panel.setLayoutManager(new GridLayout(grid));
//
//        panel.addComponent(new Label("some wind"));
//        panel.addComponent(new TextBox());

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();

        if (grid == 2)
            window.setHints(Arrays.asList(Window.Hint.CENTERED));
        else {
            window.setHints(Arrays.asList());
        }

        window.setComponent(panel);
        return window;
    }

    private static TextGUI genScreen(Screen screen, String label, TextColor tc) throws IOException {
        Window window1 = genWindow(1);
        Window window2 = genWindow(2);

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(tc));
        gui.addWindow(window1);
        gui.addWindowAndWait(window2);

//        gui.addWindowAndWait(window3);
//        gui.updateScreen();
//        gui.waitForWindowToClose(window);
        return gui;
    }

    public static void main(String[] args) throws Exception {

//         Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();
        TextGUI gui = genScreen(screen, "1", TextColor.ANSI.BLUE);
//
//        for (int i = 0; i < 10000; i++) {
//            gui.getGUIThread().processEventsAndUpdate();
//            Thread.sleep(1);
//        }
//        new SeparateTextGUIThread.Factory().createTextGUIThread(gui);
//
//        runBg(() -> {
//            Thread.sleep(10000);
////            Terminal terminal = new DefaultTerminalFactory().createTerminal();
////            Screen screen = new TerminalScreen(terminal);
////            screen.startScreen();
////            genScreen(screen, "1", TextColor.ANSI.BLUE);
//            gui.getGUIThread().invokeLater(() -> {
//                try {
//                    genScreen(screen, "2", TextColor.ANSI.RED);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            return null;
//        });
//

//        Thread.sleep(10000)//;
        System.out.println("end");
//
//        genScreen(screen, "2",TextColor.ANSI.RED);
//
//        Thread.sleep(5000);
    }
}