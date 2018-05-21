package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HelloWorld_threads {

    static ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();

    private static void runBg(Callable r) {
        ex.execute(() -> {
            try {
                r.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static Window newWindow() {
        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        Label label = new Label("Forename");

        panel.addComponent(label);
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Surname"));
        panel.addComponent(new TextBox());

        panel.addComponent(new EmptySpace(new TerminalSize(0, 0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit"));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow(UUID.randomUUID().toString());
        window.setComponent(panel);

        return window;
    }

    private static void ui_1(Screen screen) throws IOException {
        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        Label label = new Label("Forename");

        panel.addComponent(label);
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Surname"));
        panel.addComponent(new TextBox());

        panel.addComponent(new EmptySpace(new TerminalSize(0, 0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit"));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow("ui_1");
        window.setComponent(panel);

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
        gui.addWindow(window);
        gui.getGUIThread().processEventsAndUpdate();
    }

    private static void ui_2(Screen screen) throws IOException {
        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        Label label = new Label("Forename");

        panel.addComponent(label);
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Surname"));
        panel.addComponent(new TextBox());

        panel.addComponent(new EmptySpace(new TerminalSize(0, 0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit"));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow("ui_2");
        window.setHints(Arrays.asList(Window.Hint.CENTERED));

        window.setComponent(panel);

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);

        gui.addWindow(window);
        gui.getGUIThread().processEventsAndUpdate();
    }

    private static void ui_3(Screen screen) throws IOException {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(10, 5, "ui_3");
        screen.refresh();
    }


    public static void main(String[] args) throws Exception {

        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();
        while (true) {

            ui_1(screen);

            screen.clear();
            Thread.sleep(1000);

            ui_2(screen);

            screen.clear();
            Thread.sleep(1000);

            ui_3(screen);

            screen.clear();
            Thread.sleep(1000);
//        screen.refresh();
        }
    }
}