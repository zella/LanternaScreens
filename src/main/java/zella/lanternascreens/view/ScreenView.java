package zella.lanternascreens.view;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import zella.lanternascreens.internals.CustomLoop;

public interface ScreenView extends View {
    void inflate(Screen screen);
}
