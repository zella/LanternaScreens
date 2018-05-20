package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import zella.lanternascreens.MyAppController;
import zella.lanternascreens.view.View;

public class View1 implements View {

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
    public void inflate(MultiWindowTextGUI gui) {
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

        gui.addWindow(window);
    }

    @Override
    public void onCreate() {
        controller.startPeriodWork();
    }

    @Override
    public void onDestroy() {
        controller.stopPeriodWork();
    }


}
