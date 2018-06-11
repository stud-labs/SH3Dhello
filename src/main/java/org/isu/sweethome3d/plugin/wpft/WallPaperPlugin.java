package org.isu.sweethome3d.plugin.wpft;

import com.eteks.sweethome3d.plugin.PluginAction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class WallPaperPlugin extends com.eteks.sweethome3d.plugin.Plugin {
    public static final String BASE_URL = "http://127.0.0.1:8080";

    public WallPaperPlugin() {
        super();
        if (session == null) createDefaultSession();
    }
    @Override
    public PluginAction[] getActions() {

        return new PluginAction [] {
                new WallAction(getHome()),
                new WallPaperAction(getHome())
        };
    }

    public static Session session = null;

    public static String articleDir = "/home/eugeneai/projects/code/SweetHome3D-plugin/www";

    //public static String articleDir = "C:\\Users\\Katya\\IdeaProjects\\hello\\" +
    //        "www";

    public static final int MAXRESULTS = 20;

    protected void createDefaultSession()
    {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        session = factory.openSession();
    }
}