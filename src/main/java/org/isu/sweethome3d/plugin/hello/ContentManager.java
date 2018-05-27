package org.isu.sweethome3d.plugin.hello;

/**Контент менеджер.
 * http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/viewcontroller/ContentManager.html
 */
public interface ContentManager {
    /*Детали метода*/

    /*Возвращает contentобъект, который ссылается на заданное местоположение содержимого.
        Броски:
        RecorderException*/
    Content getContent(java.lang.String contentLocation)
            throws RecorderException;

    /*Возвращает читаемую пользователем строку для заданного местоположения содержимого.*/
    java.lang.String getPresentationName(java.lang.String contentLocation,
                                         ContentManager.ContentType contentType);

    /*Возвращает, true если принимается местоположение содержимого в параметре contentType.*/
    boolean isAcceptable(java.lang.String contentLocation,
                         ContentManager.ContentType contentType);

    /*Возвращает местоположение содержимого, выбранное пользователем, с открытым диалоговым окном содержимого.
        Возвращает:
        выбранное местоположение контента или null если пользователь отменил свой выбор.*/
    java.lang.String showOpenDialog(View parentView,
                                    java.lang.String dialogTitle,
                                    ContentManager.ContentType contentType);

    /*Возвращает местоположение содержимого, выбранное пользователем, с помощью диалогового окна сохранения содержимого.
        Если возвращаемое местоположение уже существует, этот метод должен быть подтвержден,
        если пользователь хочет перезаписать его перед возвратом.
        Возвращает:
        выбранное местоположение контента или null если пользователь отменил свой выбор.*/
    java.lang.String showSaveDialog(View parentView,
                                    java.lang.String dialogTitle,
                                    ContentManager.ContentType contentType,
                                    java.lang.String location);

    public enum ContentType {}
}
