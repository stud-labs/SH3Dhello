package org.isu.sweethome3d.plugin.wpft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WallParamsDialog {
    private JRadioButton radioRectangular;
    private JRadioButton radioTrapeze;
    private JTextField textHeight;
    private JTextField textBegin;
    private JTextField textEnd;
    private JTextField textWidth;
    private JTextField textThick;
    private JCheckBox checkAddSizes;
    private JButton cancelButton;
    private JButton okButton;
    private JPanel panel;

    public WallParamsDialog() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Hi!");
            }
        });
    }


    public JPanel getPanel() {
        return panel;
    }
}
