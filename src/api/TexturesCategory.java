package eteks.api;

/**Category of textures.
 *http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/TexturesCategory.html
 */
public class TexturesCategory
        extends java.lang.Object
        implements java.lang.Comparable<TexturesCategory> {

    /*Constructor Detail*/

    public TexturesCategory(java.lang.String name) {

    }

    /*Method Detail*/

    //Сравнивает имена этой категории и одну в параметре.
    @Override
    public int compareTo(TexturesCategory o) {
        return 0;
    }

    //Возвращает название этой категории.
    public java.lang.String getName() {
        return null;
    }

    /*Возвращает список текстур этой категории, отсортированный по имени.
        Возвращает:
            немодифицируемый список мебели.*/
    public java.util.List<CatalogTexture> getTextures() {
        return null;
    }

    //Возвращает количество текстур в этой категории.
    public int getTexturesCount() {
        return 0;
    }

    //Возвращает текстуру при заданном index.
    public CatalogTexture getTexture(int index) {
        return null;
    }

    //Возвращает индекс данного texture.
    public int getIndexOfTexture(CatalogTexture texture) {
        return 0;
    }

    /*Возвращает true, если эта категория и одна в параметре имеют одно и то же имя.
        Заменяет:
            equals в классе java.lang.Object*/
    public boolean equals(java.lang.Object obj) {
        return false;
    }

    /*Заменяет:
        hashCode в классе java.lang.Object*/
    public int hashCode() {
        return 0;
    }
}
