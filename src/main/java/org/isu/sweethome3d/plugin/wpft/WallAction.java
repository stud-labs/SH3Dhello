package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Wall;
import com.eteks.sweethome3d.model.Selectable;
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
    public Float thickness;
    public Float width;


    @Override
    public void execute() {
        dialog = WallParamsDialog.execute(this);
        java.util.Collection<Wall> walls = home.getWalls();
        java.util.List<Selectable> wS = home.getSelectedItems();

        Wall wXS = null;
        wXS.getXStart();
        //Wall wYS = null;
        //wYS.getYStart();

        Wall wXE = null;
        wXE.getXEnd();
        //Wall wYE = null;
        //wYE.getYEnd();

       /* Wall wAS = null;
        wAS.getWallAtStart();

        Wall wAE = null;
        wAE.getWallAtEnd();*/

        Float AtEnd = null;
        AtEnd = new Float(String.valueOf(wXS)) + width;

        for (Wall w : walls) {
            if (w == wS){
                w.setHeight(new Float(height));
                w.setThickness(new Float(thickness));
                w.setXEnd(new Float(AtEnd));
            }
        }
    }
}

