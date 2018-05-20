package zella.examples;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import zella.lanternascreens.internals.CustomLoop;
import zella.lanternascreens.view.ScreenView;
import zella.lanternascreens.view.WindowView;

import java.io.IOException;
import java.util.Arrays;

public class View3 implements ScreenView {

    private final MyAppController app;

    public View3(MyAppController app) {
        this.app = app;
    }


    @Override
    public void inflate(Screen screen) {
        try {
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(10, 5, "ui_3");
    }

//    @Override
//    public void loopCycle(Screen screen) {
//        try {
//            screen.refresh();
//            Thread.sleep(10);
//        } catch (InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Override
    public void viewCreated() {

    }

    @Override
    public void viewDestroyed() {

    }
}
