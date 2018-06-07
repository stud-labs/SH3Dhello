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

    @Override
    public void execute() {
        // Display the result in a message box (\u00b3 is for 3 in supercript)
        java.util.Collection<Wall> walls =  home.getWalls();

        inputDialog();
        String message;
        if (height!=null) {
            for (Wall w : walls) {
                w.setHeight(height);
            }
            message = String.format(
                    "Set all walls to: %f",  height.floatValue());
        } else {
            message = String.format("Setting cancelled");
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public JDialog dialog;
    public Float height;

    public void inputDialog()
    {
        dialog = new JDialog();
        WallParamsDialog wpd = new WallParamsDialog();
        wpd.setContext(this);
        dialog.setContentPane(wpd.getPanel());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setSize(600, 600);
        dialog.setVisible(true);
    }
}

