package org.isu.sweethome3d.plugin.wpft;

/*http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/CatalogTexture.html
Текстура в каталоге текстур.
 */
public class CatalogTexture
        extends java.lang.Object
        implements TextureImage, CatalogItem, java.lang.Comparable <CatalogTexture>{

    /*Создает немодифицируемую структуру каталога.
Параметры:
id - идентификатор текстуры
name - название этой текстуры
image - содержимое изображения, используемого для этой текстуры
width - ширина текстуры в сантиметрах
height - высота текстуры в сантиметрах*/
    public CatalogTexture(java.lang.String id,
                          java.lang.String name,
                          Content image,
                          Content getIcon,
                          float width,
                          float height) {

    }

        /*ДЕТАЛИ МЕТОДА*/

        public java.lang.String getId; /* ?Возвращает идентификатор этой текстуры или null*/

        public java.lang.String getName()//Возвращает название этой текстуры.
        {
            return null;
        }

        ////Сравнивает имена этой текстуры и значение параметра.
        @Override
        public int compareTo(CatalogTexture o) {
            return 0;
        }

        public Content getImage() //Возвращает содержимое изображения, используемого для этой текстуры.
        {
            return null;
        }

        public Content getIcon()//Возвращает значок этой текстуры
        {
            return null;
        }

        public float getWidth()//Возвращает ширину изображения в сантиметрах.
        {
            return 0;
        }

        public float getHeight()//Возвращает высоту изображения в сантиметрах.
        {
            return 0;
        }

        public TexturesCategory getCategory()//Возвращает категорию этой текстуры.
        {
            return null;
        }

        public int hashCode()//Возвращает хэш-код по умолчанию.
        {
            return 0;
        }

        public boolean matchesFilter(java.lang.String filter)//Возвращает, trueесли эта текстура соответствует заданному filterтексту. Каждая подстрока filterсчитается критерием поиска, который может соответствовать имени, названию категории этой текстуры.
        {
            return false;
        }
}
