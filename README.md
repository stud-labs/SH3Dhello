# Плагин Hello World для Sweet Home 3D  

Пример плагина для Sweet Home 3D (http://www.sweethome3d.com/pluginDeveloperGuide.jsp).

## Установка программного обеспечения

Дальнейшие действия предполагают, что в системе Linux установлена среда разработки JetBrains IntelliJ IDEA.

## Клонирование данного проекта

Перед тем, как запустить пакет необходимо его склонировать с сервера в папку на компьютере.  Делается это при помощи программы `git` (https://git-scm.com/).  Можно загрузить дополнительные пакеты, интегрирующие `git` с операционной системой или редакторами.  Хороши пример такой программы - `tortoisegit` (https://tortoisegit.org/).

```shell
$ mkdir -p ~/IdeaProjects
$ cd ~/IdeaProjects
$ git clone SH3Dhello
$ cd SH3Dhello
```
Первые две строки не относятся к клонированию, они оснащают среду.

### Компиляция и запуск проекта

Для того, чтобы скомпилировать проект надо из командной строки запустить команду сборки.

```shell
$ mvn package
```

Далее результат (`test-sweethome3d-plugin-0.0-SNAPSHOT.jar`) в папке `target` копируется 

   * в ОС Windows Vista / 7 / 8 / 10 в папку `C:\Users\<user>\AppData\Roaming\eTeks\Sweet Home 3D\plugins`,
   * В ОС Windows XP и раньше - `C:\Documents and Settings\user\Application Data\eTeks\Sweet Home 3D\plugins`,
   * В ОС Mac OS X - `Library/Application Support/eTeks/Sweet Home 3D/plugins of your user folder`,
   * В Linux и других Unix-ах - `.eteks/sweethome3d/plugins` в папке пользователя.

Командная строка в Linux - дело привычное: запускаете эмулятор терминала, переходите в директорий проекта (`cd ~/IdeaProjects/SH3Dhello`). В Windows все аналогично, только запускать надо `cmd.exe` или `far.exe` (если он был установлен: https://www.farmanager.com/download.php).

Программа `mvn` предназначена для сборки проекта.  Ее установка зависит от операционной системы.  Адрес - https://maven.apache.org/download.cgi . Для обеспечения ее функционирования и запуска данного проекта необходимо установить Java версии 1.8 или раньше (больше).

Если компиляция и запуск завершились удачно, то на экране появится текст, вроде этого:

```text
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.930 s
[INFO] Finished at: 2018-03-20T17:58:47+08:00
[INFO] Final Memory: 22M/73M
[INFO] ------------------------------------------------------------------------
```

## Разработка

Данный проект - это проект среды разработки (IDE) JetBrains IntelliJ Idea.  По идее, если на компьютере установлена эта среда, то после клонирования она должна импортировать проект в список проектов.
