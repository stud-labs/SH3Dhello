package org.isu.sweethome3d.plugin.hello;

/*Изображение используется как текстура для домашних 3D-объектов.
* http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/model/HomeTexture.html*/
public class HomeTexture
        extends java.lang.Object
        implements TextureImage, java.io.Serializable {

        /*МЕТОДЫ КОНСТРУКТОРА*/

        /*Создает домашнюю текстуру из существующей.
        Параметры:
        texture - текстура, с которой копируются данные;*/
        public HomeTexture(TextureImage texture) {

        }

        /*Создает домашнюю текстуру из существующей с настраиваемым углом и смещением.
        Параметры:
        texture - текстура, с которой копируются данные;
        angle - угол поворота, применяемый к текстуре*/
        public HomeTexture(TextureImage texture,
                           float angle) {

        }

        /*Создает домашнюю текстуру из существующей с настраиваемым углом и смещением.
        Параметры:
        texture - текстура, с которой копируются данные;
        angle - угол поворота, применяемый к текстуре
        leftToRightOriented - ориентация, используемая для текстуры при нанесении на объекты, видимые спереди*/
        public HomeTexture(TextureImage texture,
                           float angle,
                           boolean leftToRightOriented) {

        }

        /*Создает домашнюю текстуру из существующей с настраиваемым углом и смещением.
        Параметры:
        texture - текстура, с которой копируются данные;
        angle - угол поворота, применяемый к текстуре
        scale - масштаб, применяемый к текстуре
        leftToRightOriented - ориентация, используемая для текстуры при нанесении на объекты, видимые спереди*/
        public HomeTexture(TextureImage texture,
                           float angle,
                           float scale,
                           boolean leftToRightOriented) {

        }

        /*ДЕТАЛИ МЕТОДА*/

        /*Возвращает идентификатор каталога этой текстуры или nullесли он не существует.*/
        public java.lang.String getCatalogId() {
            return null;
        }

        /*Возвращает название этой текстуры.*/
        public java.lang.String getName() {
            return null;
        }

        /*Возвращает создателя этой текстуры.*/
        public java.lang.String getCreator() {
            return null;
        }

        //Возвращает содержимое изображения, используемого для этой текстуры.
        public Content getImage() {
            return null;
        }

        //Возвращает ширину изображения в сантиметрах.
        public float getWidth() {
            return 0;
        }

        //Возвращает высоту изображения в сантиметрах.
        public float getHeight() {
            return 0;
        }

        //Возвращает угол поворота в радианах, применяемых к этой текстуре.
        public float getAngle() {
            return 0;
        }

        //Возвращает масштаб, применяемый к этой текстуре.
        public float getScale() {
            return 0;
        }

        //Возвращает, true если объекты, использующие эту текстуру, должны учитывать ориентацию текстуры.
        public boolean isLeftToRightOriented() {
            return false;
        }

        //Возвращает, trueесли объект в параметре равен этой текстуре.
        public boolean equals(java.lang.Object obj) {
            return false;
        }

        //Возвращает хэш-код для этой текстуры.
        public int hashCode() {
            return 0;
        }
}
