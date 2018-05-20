package zella.examples;

import zella.lanternascreens.controller.BaseController;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller1 extends BaseController<View1> {

    private ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();

    public void startPeriodWork(){
                ex.scheduleAtFixedRate(() -> {
                    view.showTitle(UUID.randomUUID().toString());
                }, 1, 1, TimeUnit.SECONDS);
    }

    public void stopPeriodWork(){
        ex.shutdownNow();
    }

    public void someControllerAction(){
        System.out.println(System.currentTimeMillis());
    }
}
