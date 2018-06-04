package org.isu.sweethome3d.plugin.hello;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.plugin.PluginAction;

import javax.swing.*;

public class MyTextureAction extends PluginAction {
    private Home home;
    public MyTextureAction(Home home) {
        putPropertyValue(PluginAction.Property.NAME, "Текстура");//в приложении русский язык не отображается
        putPropertyValue(PluginAction.Property.MENU, "Стены");
        // Enables the action by default
        setEnabled(true);
        this.home = home;
    }


    @Override
    public void execute() {

    }
}
