package zella.lanternascreens.view;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;

public interface WindowView extends View{
    MultiWindowTextGUI inflate(Screen screen);
}
