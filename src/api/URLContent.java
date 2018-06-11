package eteks.api;

import eteks.api.Content;

import java.io.IOException;
import java.io.InputStream;

/*URL-адрес для файлов, изображений ...
http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/tools/URLContent.html */
public class URLContent
        extends java.lang.Object
        implements Content {
    public URLContent() {
    }

    /*Возвращает InputStream для содержимого URL-адреса.
                Определяется:
                openStream в интерфейсе Content
                Броски:
                java.io.IOException - если поток URL нельзя открыть.*/
            @Override
            public InputStream openStream() throws IOException {
                return null;
            }

            /*Деталь конструктора*/
            public URLContent(java.net.URL url) {

                }

            /*Деталь метода*/
            /*Возвращает URL этого содержимого.*/
            public java.net.URL getURL() {
                    return null;
                }

            /*Возвращает, true если URL, хранящийся в этом контенте, ссылается на запись в JAR.*/
            public boolean isJAREntry() {/*??????????, true???? URL, ?????????? ? ???? ????????, ????????? ?? ?????? ? JAR.*/
                return false;
            }

            /*Возвращает базу URL-адреса JAR-записи.
            Броски:
            java.lang.IllegalStateException - если URL этого содержимого не ссылается на запись в JAR.*/
            public java.net.URL getJAREntryURL(){
                return null;
            }

            /*Возвращает имя записи JAR. Если запись JAR в URL-адресе, указанном во время создания, была закодирована в формате application / x-www-form-urlencoded, этот метод вернет его без изменений и не будет декодирован.
            Броски:
            java.lang.IllegalStateException - если URL этого содержимого не ссылается на запись в URL JAR.*/
            public java.lang.String getJAREntryName() {
                return null;
            }

            /*Возвращает, trueесли объект в параметре является содержимым URL-адреса,
            которое ссылается на тот же URL-адрес, что и этот объект.*/
            public boolean equals(java.lang.Object obj) {
                return false;
            }

            /*Возвращает размер этого содержимого.
            Возвращает:
            размер несжатого zip-файла, из которого происходит это содержимое, если это запись JAR или размер самого содержимого
            в противном случае или -1, если содержимое не может быть прочитано*/
            public long getSize() {
                return 0;
            }

            /*Заменяет:
              hashCode в классе java.lang.Object*/
            public int hashCode() {
                return 0;
            }

        }
