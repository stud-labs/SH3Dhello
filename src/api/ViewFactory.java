package eteks.api;

import eteks.api.TextureChoiceController;
import eteks.api.TextureChoiceView;
import eteks.api.UserPreferences;

/**Фабрика, которая определяет, как создавать представления, отображаемые в Sweet Home 3D.
 *http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/viewcontroller/ViewFactory.html
 */
public interface ViewFactory {
    //Возвращает новое представление, которое отображает различные шаги, которые помогают пользователю импортировать текстуру.
   /* View createImportedTextureWizardStepsView(CatalogTexture texture,
                                              java.lang.String textureName,
                                              UserPreferences preferences,
                                              ImportedTextureWizardController importedTextureWizardController);

    //Возвращает новое представление, редактирующее значения стены.
    DialogView createWallView(UserPreferences preferences,
                              WallController wallController);*/

    //Возвращает новое представление, редактирующее текстуру своего контроллера.
    TextureChoiceView createTextureChoiceView(UserPreferences preferences,
                                              TextureChoiceController textureChoiceController);


}
