package eteks.api;

/**Библиотека, способная предоставить дополнительные возможности Sweet Home 3D.
 *http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/Library.html
 */
public interface Library {
    /*Method Detail*/

    //Возвращает место, где хранится эта библиотека.
    java.lang.String getLocation();

    //Возвращает идентификатор этой библиотеки.
    java.lang.String getId();

    //Возвращает тип этой библиотеки.
    java.lang.String getType();

    //Возвращает имя этой библиотеки.
    java.lang.String getName();

    //Возвращает описание этой библиотеки
    java.lang.String getDescription();

    //Возвращает версию этой библиотеки.
    java.lang.String getVersion();

    //Возвращает лицензию этой библиотеки.
    java.lang.String getLicense();

    //Возвращает поставщика этой библиотеки.
    java.lang.String getProvider();
}
