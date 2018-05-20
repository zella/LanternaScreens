package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import zella.lanternascreens.MyAppController;
import zella.lanternascreens.view.View;

import java.util.Arrays;

public class View2 implements View {

    private final MyAppController app;

    public View2(MyAppController app) {
        this.app = app;
    }

    @Override
    public void inflate(MultiWindowTextGUI gui)   {
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
                app.go1();
            }
        }));


        // Create window to hold the panel
        BasicWindow window = new BasicWindow("ui_2");
        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        window.setComponent(panel);

        gui.addWindow(window);


    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

}
