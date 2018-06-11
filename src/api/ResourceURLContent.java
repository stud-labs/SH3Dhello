package eteks.api;

/*URL-адрес, прочитанный из ресурса класса.
* http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/tools/ResourceURLContent.html*/
public class ResourceURLContent
        extends URLContent {

    /*ДЕТАЛИ КОНСТРУКТОРА*/

    /*Создает контент по resourceName отношению к resourceClass.
    Параметры:
    resourceClass - класс относительно имени ресурса для загрузки
    resourceName - название ресурса
    Броски:
    java.lang.IllegalArgumentException - если ресурс не соответствует действительному ресурсу.*/
    public ResourceURLContent(java.lang.Class<?> resourceClass,
                              java.lang.String resourceName) {

    }

    /*Создает контент по resourceName отношению к resourceClass.
    Параметры:
    resourceClass - класс относительно имени ресурса для загрузки
    resourceName - название ресурса
    multiPartResource- если true тогда ресурс является ресурсом нескольких частей, хранящимся в папке с другими необходимыми ресурсами
    Броски:
    java.lang.IllegalArgumentException - если ресурс не соответствует действительному ресурсу.*/
    public ResourceURLContent (java.lang.Class <?> resourceClass,
                               java.lang.String resourceName,
                               boolean multiPartResource){

    }

    /*Создает контент по resourceName отношению к resourceClassLoader. resourceNameявляется абсолютным и не должен начинаться с косой черты.
    Параметры:
    resourceClassLoader - загрузчик классов, используемый для загрузки данного имени ресурса
    resourceName - название ресурса
    Броски:
    java.lang.IllegalArgumentException - если ресурс не соответствует действительному ресурсу.*/
    public ResourceURLContent (java.lang.ClassLoader resourceClassLoader,
                               java.lang.String resourceName){

    }

    /*Создает контент для resourceUrl.
    Параметры:
    url - URL-адрес ресурса*/
    public ResourceURLContent (java.net.URL url,
                               boolean multiPartResource){

    }

    /*ДЕТАЛИ МЕТОДА */

    /*Возвращает, true если ресурс является ресурсом нескольких частей, хранящимся в папке с другими необходимыми ресурсами.*/
    public boolean isMultiPartResource() {
        return false;
    }

}
