package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import zella.lanternascreens.view.View;
import zella.lanternascreens.view.WindowView;

import java.util.Arrays;

public class View2 implements WindowView {

    private final MyAppController app;

    public View2(MyAppController app) {
        this.app = app;
    }

    @Override
    public MultiWindowTextGUI inflate(Screen screen) {
        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        Label label = new Label("Forename");

        panel.addComponent(label);
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Surname"));
        panel.addComponent(new TextBox());

        panel.addComponent(new EmptySpace(new TerminalSize(0, 0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit", new Runnable() {
            @Override
            public void run() {
                app.go3();
            }
        }));


        // Create window to hold the panel
        BasicWindow window = new BasicWindow("ui_2");
        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        window.setComponent(panel);

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.CYAN));

        gui.addWindow(window);
        return gui;

    }

    @Override
    public void viewCreated() {

    }

    @Override
    public void viewDestroyed() {

    }

}
