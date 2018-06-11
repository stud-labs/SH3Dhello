package eteks.api;

/*Содержимое считывается из URL-адреса без зависимости от другого содержимого, если этот URL-адрес является JAR-записью.
* http://www.sweethome3d.com/javadoc/com/eteks/sweethome3d/tools/SimpleURLContent.html*/
public class SimpleURLContent
        extends URLContent {

    /*ДЕТАЛЬ КОНСТРУКТОРА*/
    public SimpleURLContent (java.net.URL url){

    }

    /*ДЕТАЛИ МЕТОДА*/
    /*Возвращает размер этого содержимого.
    Заменяет:
    getSize в классе URLContent
    Возвращает:
    размер несжатого zip-файла, из которого происходит это содержимое, если это запись JAR или размер самого содержимого
    в противном случае или -1, если содержимое не может быть прочитано*/
    public long getSize() {
        return 0;
    }

}
