# En:

## KotlinCMD – a project built using the Kotlin programming language.
This project is currently a pseudo-terminal intended to evolve into a full-fledged terminal.
While its feature set is currently limited, the core concept is to allow users to add their own plugins in the form of `.jar` files.
Additionally, this project is being developed as part of my process of learning the Kotlin programming language.

### Features:
Currently, this project includes only 6 commands:
- `help` - displays available terminal commands.
- `exit` - exits the terminal (with confirmation).
- `calc` - launches the calculator.
- `cfile` - activates the file manager with file creation capabilities.
> Usage:
```bash
Create File > text.txt #Creates the file in the same directory as the program (KotlinCMD); similar to ./text.txt. You can also use ../text.txt to create a file in the parent directory.
```
```bash
Create File > C:/Users/Admin/Documents/text.txt #Creates the file at the specified path.
```
- `dfile` - activates the file manager with file deletion capabilities (works just like the creation command, but for deleting).
- `info_cmd` - displays project information.

#### Running the program:

To run the program, you need the Java Development Kit (JDK), version 21 or higher. Download instructions depend on your operating system:

- Windows:
Go to https://adoptium.net/temurin/releases/?version=21 and download the Windows file with the `.msi` extension.

- macOS:
Go to https://adoptium.net/temurin/releases/?version=21 and download the macOS file with the `.pkg` extension.

- Linux:
For most distributions, it is best to use the terminal:
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

Once JDK 21 and the project file [link: https://github.com/PavelMizevDev/KotlinCMD/releases/] are installed, simply open your operating system's terminal and enter the following command:
```bash
java -jar [path_to_your_file.jar]
```
For the `[path_to_your_file.jar]` part, you can simply drag and drop the project file into the terminal window to avoid typing the file path manually.

##### Where, how, and by whom it was created:

- The project was created in the IntelliJ IDEA development environment (by JetBrains) using the Kotlin programming language (by JetBrains).
- Gradle is used for build automation and dependency management.
- Git is used for version control.
- Developer: Pavel Mizev

Contact me: all available contact methods can be found on my GitHub profile.

# Ru:

## KotlinCMD - проект созданный на языке программирования Kotlin.
Этот проект представляет из себя псевдотерминал, который в будущем должен стать полноценным терминалом.
В нем пока что мало возможностей, но, основная идея состоит в том чтобы пользователь мог добавлять свои плагины в виде файлов `.jar`.
Также этот проект создается во время моего обучения языка программирования Kotlin.

### Возможности:
На данный момент этот проект имеет лишь 6 команд:
- `help` - используется для вывода доступных команд терминала.
- `exit` - используется для выхода с терминала с подтверждением.
- `calc` - используется для запуска калькулятора.
- `cfile` - активирует файловый менеджер с возможностью создавать файлы
> как использовать:
```bash
Create File > text.txt #Файл создастся там же где лежит файл программы (KotlinCMD), этот способ аналогичен ./text.txt и также есть ../text.txt который может создасть файл на папку выше относительно программы.
```
```bash
Create File > C:/Users/Admin/Documents/text.txt #Файл создастся по заданному пути.
```
- `dfile` - активирует файловый менеджер с возможностью создавать файлы (все аналогично с созданием, только тут удаление)
- `info_cmd` - отображает информацию о проекте.

#### Запуск программы:

Для запуска программы вам нужно иметь Java Development Kit (JDK) минимальной версии 21. Скачивание зависит от вашей ОС:

- Windows:
Перейдите по ссылке https://adoptium.net/temurin/releases/?version=21 и скачайте файл для Windows в расширении `.msi`.

- MacOS:
Перейдите по ссылке https://adoptium.net/temurin/releases/?version=21 и скачайте файл для MacOS в расширении `.pkg`.

- Linux:
В большинстве дистрибутивах лучше использовать терминал:
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

Если JDK21 и готовый файл проекта [ссылка: https://github.com/PavelMizevDev/KotlinCMD/releases/] уже установлены, то достаточно просто запустить терминал вашей ОС и ввести следующую команду:
```bash
java -jar [ваш_путь_к_файлу.jar]
```
То где в `[ваш_путь_к_файлу.jar]` вы можете просто взять файл проекта и перенести в окно терминала чтобы не пришлось прописывать путь к файлу вручную.

##### Где, как и кем создан:

- Проект был создан в среде разработки IntelliJ IDEA от JetBrains на языке программирования Kotlin от JetBrains.
- Для сборки и управления зависимостями используется система Gradle.
- Для контроля версий используется Git.
- Разработчик: Павел Мизев

Связаться со мной: все возможные пути в профиле GitHub.
