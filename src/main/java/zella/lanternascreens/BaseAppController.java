package zella.lanternascreens;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import zella.lanternascreens.view.View;

import java.io.IOException;
import java.io.UncheckedIOException;


public abstract class BaseAppController {

    private MultiWindowTextGUI gui;

    public BaseAppController() {
        try {
            gui = init();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    //TODO создавать новый слой каждый раз вместо переиспользования

    private MultiWindowTextGUI init() throws IOException {
        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        return new MultiWindowTextGUI(screen);
    }

    protected void inflate(View view) {
        gui.getWindows().forEach(Window::close);
        view.inflate(gui);
        view.onCreate();
    }


    public MultiWindowTextGUI getGui() {
        return gui;
    }
}
