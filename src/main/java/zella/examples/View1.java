package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import zella.lanternascreens.view.View;
import zella.lanternascreens.view.WindowView;

public class View1 implements WindowView {

    private final MyAppController app;

    private BasicWindow window;

    private final Controller1 controller;

    public View1(MyAppController app, Controller1 controller) {
        this.app = app;
        this.controller = controller;
    }

    public void showTitle(String title) {
        window.setTitle(title);
        controller.someControllerAction();
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
                app.go2();
            }
        }));

        // Create window to hold the panel
        window = new BasicWindow("ui_1");
        window.setComponent(panel);

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);

        gui.setTheme(new SimpleTheme(TextColor.ANSI.GREEN,TextColor.ANSI.YELLOW));

        gui.addWindow(window);
        return gui;
    }

    @Override
    public void viewCreated() {
        controller.startPeriodWork();
    }

    @Override
    public void viewDestroyed() {
        controller.stopPeriodWork();
    }


}
