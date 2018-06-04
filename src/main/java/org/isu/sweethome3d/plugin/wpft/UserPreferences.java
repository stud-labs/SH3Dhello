package org.isu.sweethome3d.plugin.wpft;

/**Пользовательские настройки.
 *http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/UserPreferences.html#UserPreferences--
 */
public abstract class UserPreferences
        extends java.lang.Object {
    /*Constructor Detail*/

    /*Создает пользовательские настройки.
        Внимание: во время создания языковой стандарт по умолчанию будет обновлен, если он не относится к поддерживаемым.*/
    public UserPreferences() {

    }

    /*Деталь метода*/

    // Возвращает каталог текстур.
    /*public TexturesCatalog getTexturesCatalog() {
        return null;
    }

    //Устанавливает каталог текстур.
    protected void setTexturesCatalog(TexturesCatalog catalog) {

    }*/

    /*Устанавливает, должны ли полы помещений быть выделены цветом или текстурой, и уведомляет слушателей об этом изменении.
        Параметры:
            roomFloorColoredOrTextured- true если используется цвет или текстура пола,  false в противном случае.*/
    public void setFloorColoredOrTextured(boolean roomFloorColoredOrTextured) {

    }

    /*Устанавливает, как стены по умолчанию отображаются в плане, и уведомляет слушателей об этом изменении.*/
    public void setWallPattern(TextureImage wallPattern) {

    }

    /*Возвращает шаблон, используемый для новых стен в плане, или nullесли он не установлен.*/
    public TextureImage getNewWallPattern() {
        return null;
    }

    //Устанавливает, как новые стены должны отображаться в плане, и уведомляет слушателей об этом изменении.
    public void setNewWallPattern(TextureImage newWallPattern) {

    }

    //Устанавливает толщину новых стен дома и уведомляет слушателей об этом изменении.
    public void setNewWallThickness(float newWallThickness) {

    }

    //Возвращает стандартную высоту стены новых внутренних стен.
    public float getNewWallHeight() {
        return 0;
    }

    //Устанавливает высоту стены по умолчанию для новых стен и уведомляет слушателей об этом изменении.
    public void setNewWallHeight(float newWallHeight) {

    }

    //Возвращает неизменяемый список последних текстур.
    public java.util.List<TextureImage> getRecentTextures() {
        return null;
    }

    //Устанавливает список последних текстур и уведомляет слушателей об этом изменении.
    public void setRecentTextures(java.util.List<TextureImage> recentTextures) {

    }

    /*Добавляет библиотеку текстур в указанное место в каталог текстур, чтобы сделать доступные текстуры.
        Параметры:
            texturesLibraryLocation - место нахождения библиотеки.
        Броски:
            RecorderException*/
    public abstract void addTexturesLibrary (java.lang.String texturesLibraryLocation)
        throws RecorderException;

    /*Возвращает, trueесли существует библиотека текстур в данном месте.
            Параметры:
    texturesLibraryLocation - имя ресурса для проверки
    Броски:
    RecorderException*/
    public abstract boolean texturesLibraryExists(java.lang.String texturesLibraryLocation)
            throws RecorderException;

    //Возвращает библиотеки, доступные в настройках пользователя.
    public abstract java.util.List<Library> getLibraries();

}
