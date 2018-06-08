package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Wall;
import com.eteks.sweethome3d.plugin.PluginAction;

import javax.swing.*;

/* Внутренний класс WallPaperPlugin*/
public class WallAction extends PluginAction {
    private Home home;
    public WallAction(Home home) {
        putPropertyValue(Property.NAME, "Set params of walls");
        putPropertyValue(Property.MENU, "Tools");
        // Enables the action by default
        setEnabled(true);
        this.home = home;
    }
/*
    public WallParamsDialog []{
            return textHeight
    }*/

    public WallParamsDialog dialog;
    public Float height;

    public void inputDialog()
    {

        dialog = WallParamsDialog.execute(this);
    }

    @Override
    public void execute() {

    }
}

