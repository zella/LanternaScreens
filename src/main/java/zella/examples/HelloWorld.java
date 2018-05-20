package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.*;

public class HelloWorld {

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

    private static MultiWindowTextGUI ui_1(Screen screen) {
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
        return gui;
    }

    private static MultiWindowTextGUI ui_2(Screen screen) {
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
        return gui;

    }

    private static Screen ui_3(Screen screen) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(10, 5, "ui_3");
        return screen;
    }


    public static void main(String[] args) throws Exception {

        MyAppController app = new MyAppController();

        app.go2();

        app.loop();
    }
}