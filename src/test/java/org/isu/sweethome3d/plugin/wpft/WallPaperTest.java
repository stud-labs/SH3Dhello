/**
 * Created by Katya on 04.06.2018.
 */
package org.isu.sweethome3d.plugin.wpft;

        import junit.framework.TestCase;

        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;

        import org.isu.sweethome3d.plugin.wpft.WallPaper;

/**
 * Unit test for simple App.
 */
public class WallPaperTest extends TestCase {

    public void testApp() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        WallPaper user = new WallPaper();
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}