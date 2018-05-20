package zella.lanternascreens.controller;

import zella.lanternascreens.view.View;

public abstract class BaseController<T extends View> {

    protected T view;

    public void setView(T view){
        this.view = view;
    }

}
