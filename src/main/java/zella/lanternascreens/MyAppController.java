package zella.lanternascreens;

import zella.examples.Controller1;
import zella.lanternascreens.view.View;
import zella.examples.View1;
import zella.examples.View2;


//should be singleton
public class MyAppController extends BaseAppController {


    public void go1(){
        Controller1 controller = new Controller1();
        View1 view1 = new View1(this, controller);
        controller.setView(view1);
        inflate(view1);
    }

    public void go2(){
        View view2 = new View2(this);
        inflate(view2);
    }


}
