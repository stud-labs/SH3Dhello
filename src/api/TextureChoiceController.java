package eteks.api;

/*Контроллер MVC для выбора текстуры.
* http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/viewcontroller/TextureChoiceController.html*/

public class TextureChoiceController
        extends java.lang.Object
        implements Controller {

    /*Constructor Detail*/

    public TextureChoiceController(java.lang.String title,
                                   UserPreferences preferences,
                                   ViewFactory viewFactory,
                                   ContentManager contentManager){
    }

    public TextureChoiceController(java.lang.String title,
                                   boolean rotationSupported,
                                   UserPreferences preferences,
                                   ViewFactory viewFactory,
                                   ContentManager contentManager){
    }


    /*Method Detail*/

    public TextureChoiceView getView() /*Возвращает представление, связанное с этим контроллером.*/
    {
        return null;
    }

    public void addPropertyChangeListener(TextureChoiceController.Property property,
                                          java.beans.PropertyChangeListener listener)
    /*Добавляет изменение свойства listener в параметр к этому контроллеру.*/
    {
    }

    public void removePropertyChangeListener(TextureChoiceController.Property property,
                                             java.beans.PropertyChangeListener listener)
    /*Удаляет изменение свойства listenerв параметре с этого контроллера.*/
    {
    }

    public void setTexture(HomeTexture texture)/*Устанавливает текстуру, отображаемую по представлению, и срабатывает a PropertyChangeEvent.*/
    {
    }

    public HomeTexture getTexture() /*Возвращает текстуру, отображаемую по представлению.*/
    {
        return null;
    }

    public java.lang.String getDialogTitle() /*Возвращает текст, который должен отображаться как заголовок диалога выбора текстуры.*/
    {
        return null;
    }

    public boolean isRotationSupported() /*Возвращает, true если поддерживается отрезок отредактированной текстуры.*/
    {
        return false;
    }

    public void importTexture() /*Управляет импортом текстур.*/
    {
    }

    public void importTexture(java.lang.String textureName) /*Управляет импортом текстуры с заданным именем.*/
    {
    }

    public void modifyTexture(CatalogTexture texture) /*Управляет модификацией текстуры.*/
    {
    }

    public void deleteTexture(CatalogTexture texture) /*Управляет удалением текстуры.*/
    {
    }

    public void addRecentTexture(TextureImage texture) /*Добавляет данные textureк последнему набору текстур.*/{
    }

    public enum Property {}
}
