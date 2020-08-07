package com.chujian.mytest;

import android.app.Application;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoSizeConfig.getInstance().setLog(true).getUnitsManager().setSupportDP(false).setSupportSubunits(Subunits.MM);
    }
}
