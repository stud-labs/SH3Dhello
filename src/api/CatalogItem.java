package eteks.api;

/*Элемент каталога.
http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/CatalogItem.html
 */
public interface CatalogItem{
    java.lang.String getName ();//Возвращает имя этого элемента каталога.
    Content getIcon();//Возвращает значок этого элемента каталога.
}
