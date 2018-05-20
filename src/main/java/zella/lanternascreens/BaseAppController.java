package zella.lanternascreens;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import zella.lanternascreens.internals.CustomLoop;
import zella.lanternascreens.view.ScreenView;
import zella.lanternascreens.view.View;
import zella.lanternascreens.view.WindowView;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Optional;


public abstract class BaseAppController {

    private Screen screen;

    private Optional<MultiWindowTextGUI> gui = Optional.empty();

    private Optional<CustomLoop> loop = Optional.empty();

    public BaseAppController() {
        try {
            screen = init();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Screen init() throws IOException {
        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        return screen;
    }

    protected void inflate(View view) {
        screen.clear();
//        try {
//            screen.stopScreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (gui.isPresent()){
//            try {
//                screen.stopScreen();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        this.gui = Optional.empty();
        this.loop = Optional.empty();

        if (view instanceof ScreenView) {
            ((ScreenView) view).inflate(screen);
            try {
                screen.refresh();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (view instanceof WindowView) {
            MultiWindowTextGUI gui = ((WindowView) view).inflate(screen);
            this.gui = Optional.of(gui);
        }

        if (view instanceof CustomLoop) {
            this.loop = Optional.of((CustomLoop) view);
        }

        view.viewCreated();

    }


    public void loop() {
        try {

            while (true) {

                if (loop.isPresent()) {
                    loop.get().loopCycle(screen);
                } else if (gui.isPresent()) {
                    if (!gui.get().getGUIThread().processEventsAndUpdate())
                        Thread.sleep(1);
                } else {
                    //TODO default Screen layer loop
                    Thread.sleep(1);
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
