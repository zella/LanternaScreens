package zella.lanternascreens.view;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;

public interface View {
    void inflate(MultiWindowTextGUI gui)  ;

    void onCreate();

    void onDestroy();
}
