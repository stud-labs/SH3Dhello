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
    @Override
    public void execute() {
        // Display the result in a message box (\u00b3 is for 3 in supercript)
        java.util.Collection<Wall> walls =  home.getWalls();

        Float height = new Float(290.0);
        inputDialog();

        for (Wall w : walls) {
            w.setHeight(height);
        }
        String message = String.format(
                "Set all walls to: %f",  height.floatValue());
        JOptionPane.showMessageDialog(null, message);
    }
    public void inputDialog()
    {
        JDialog dialog = new JDialog();
        WallParamsDialog wpd = new WallParamsDialog();
        dialog.setContentPane(wpd.getPanel());
        dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        dialog.pack();
        dialog.setSize(300, 150);
        dialog.setVisible(true);
    }
}

