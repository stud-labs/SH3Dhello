package org.isu.sweethome3d.plugin.wpft;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.listFiles;

public class TextureDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBoxSearch;
    private JList listTexture;
    private JLabel imageTexture;
    private JTextField textQuery;
    public JButton loadTexturesButton;

    public TextureDialog() {
        $$$setupUI$$$();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setTitle("Wall Texture");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // ? ?????. ?? ?? ???? ???? ?????? ????????? ?????????.

        textQuery.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                super.keyReleased(keyEvent);
                onKey(keyEvent);
            }
        });

        listTexture.setModel(listModel);

        loadTexturesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onLoadTextures();
            }
        });

        listTexture.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                onModelChange(listSelectionEvent);
            }

        });
    }

    private Article selected = null;

    private void onModelChange(ListSelectionEvent event) {
        // ??????? ?? ??? ????????.
        Article art = (Article) listTexture.getSelectedValue();
        if (art != null && selected != art) {
            System.out.println("Selected: " + art);
            onArticleSelected(art);
        }
        if (art == null) {
            onArticleDeSelected();
        }
        selected = art;
    }

    private void onArticleSelected(Article art) {
        String url = art.toURL(WallPaperPlugin.BASE_URL);
        try {
            URL url_ = new URL(url);
            image = ImageIO.read(url_);
            iconImage = Scalr.resize(image, 200);
            ImageIcon icon = new ImageIcon(iconImage);
            imageTexture.setIcon(icon);
        } catch (IOException e) {
            System.err.println("We could not load image from " + url);
            onArticleDeSelected();
        }
    }

    public BufferedImage image = null;
    public BufferedImage iconImage = null;
    public BufferedImage wallImage = null;

    private void onArticleDeSelected() {
        // remove preview.
        image = null;
        iconImage = null;
        wallImage = null;
        imageTexture.setIcon(null);
    }

    private DefaultListModel<Article> listModel = new DefaultListModel<>();

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onKey(KeyEvent e) {
        String query = textQuery.getText().trim(); // Sting= ????. remove spaces
        if (query.length() > 3) {
            performSearch(query);
        }
    }

    private void performSearch(String query) {
        listModel.clear(); // ?????? ??? ????????.
        Session s = WallPaperPlugin.session;
        Query q = s.createQuery("from Article where name LIKE :nameq");
        q.setParameter("nameq", query + "%");
        q.setMaxResults(WallPaperPlugin.MAXRESULTS);
        for (Object obj : q.list()) {
            Article art = (Article) obj;
            listModel.addElement(art);
        }
    }

    private void onLoadTextures() {
        // ???? ?????? ?????? ???????????, ??????????? ???????? ?????? ??????
        // ?? ???????????.
        // ?????????? ?????????? ? ????????? ????????????? ??? ????????? ??????.

        Session s = WallPaperPlugin.session;
        String dir = WallPaperPlugin.articleDir;

        String[] exts = new String[]{"jpg"};

        File root = new File(dir);

        java.util.Collection<File> list = listFiles(root, exts, true);
        String sep = File.separator;
        for (File f : list) {
            String path = f.getPath().replace(dir + sep, "");
            String name = f.getName();
            path = path.replace(sep + name, "");
            System.out.println("path:" + path);

            String article = name.replace(".jpg", "");
            System.out.println("article:" + article);

            String[] parts = path.split(sep); // ....
            String producer = parts[0];
            String collection = "default";

            if (parts.length == 2) {
                collection = parts[1];
            }
            // Now we have article collection and producer

            // ???? ?????????? ????? ??????????, ????? ????????? ? ????? ???????.

            s.getTransaction().begin();

            Query q = s.createQuery("from Producer where name = :name ");
            q.setParameter("name", producer);
            java.util.List<?> res = q.list(); // ???0?? ????? - ?

            Producer p;
            if (res.size() > 0) {
                p = (Producer) res.get(0);
            } else {
                p = new Producer();
                p.setName(producer);
                s.save(p);
            }

            Query qc = s.createQuery("from Collection where producer = :p and name = :name");
            qc.setParameter("name", collection);
            qc.setParameter("p", p);

            java.util.List<?> resc = qc.list();

            Collection col;
            if (resc.size() > 0) {
                col = (Collection) resc.get(0);
            } else {
                col = new Collection();
                col.setName(collection);
                col.setProducer(p);
                s.save(col);
            }

            Query qa = s.createQuery("from Article where collection = :col and name = :name ");
            qa.setParameter("name", article);
            qa.setParameter("col", col);

            java.util.List<?> resa = qa.list();

            Article art;
            if (resa.size() > 0) {
                art = (Article) resa.get(0); // ????? ??????? ??? ????...????????.
            } else {
                art = new Article();
                art.setName(article);
                art.setCollection(col);
                s.save(art);
            }

            s.getTransaction().commit();
            System.out.println("Added " + art.getName() + " in " + col.getName() + " of " + p.getName());
        }
    }

    public static void execute() {
        TextureDialog dialog = new TextureDialog();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(600, 600);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 7, new Insets(10, 10, 10, 10), -1, -1));
        contentPane.setBorder(BorderFactory.createTitledBorder("Texture"));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(4, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        panel2.add(buttonCancel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        imageTexture = new JLabel();
        imageTexture.setText("");
        panel3.add(imageTexture, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 100), null, 0, false));
        final JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();
        contentPane.add(toolBar$Separator1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Available textures:");
        contentPane.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Selected texture:");
        contentPane.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Search by:");
        contentPane.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        contentPane.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        listTexture = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        listTexture.setModel(defaultListModel1);
        scrollPane1.setViewportView(listTexture);
        comboBoxSearch = new JComboBox();
        comboBoxSearch.setEditable(true);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Article");
        defaultComboBoxModel1.addElement("Collection");
        defaultComboBoxModel1.addElement("Producer");
        defaultComboBoxModel1.addElement("Colors");
        defaultComboBoxModel1.addElement("Pattern type");
        comboBoxSearch.setModel(defaultComboBoxModel1);
        contentPane.add(comboBoxSearch, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonOK = new JButton();
        buttonOK.setText("OK");
        contentPane.add(buttonOK, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textQuery = new JTextField();
        textQuery.setText("");
        contentPane.add(textQuery, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        loadTexturesButton = new JButton();
        loadTexturesButton.setText("Load textures");
        contentPane.add(loadTexturesButton, new com.intellij.uiDesigner.core.GridConstraints(3, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
