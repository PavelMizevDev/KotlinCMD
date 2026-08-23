# En:

## KotlinCMD – a project built using the Kotlin programming language.
It is a terminal application (currently launched via the OS terminal and lacking its own dedicated window). The concept behind the terminal is to provide users with a cross-platform console that supports adding easily created `.jar` files as plugins. The project is currently under development but is actively evolving. Author: Pavel Mizev.

### Features:
The following commands are currently available:
- `help` - Displays the list of terminal commands.
- `exit` - Closes the terminal.
- `info` - Program information.
- `calc` - Launches the calculator.
- `tmanag` - Launches TimeManager (includes Timer and Stopwatch functions).
- `fmanag` - Launches FileManager; the following commands are available:
    - `help` - Displays the list of FileManager commands.
    - `exit` - Closes the FileManager process.
    - `uf` - Moves up one directory level.
    - `cd` - Prompts for a user-specified path.
    - `list` - Lists folders and files at the current path.
    - `cdir` - Creates a folder at the current path.
    - `cfil` - Creates a file at the current path.
    - `del` - Deletes a folder or file at the current path.

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
- Developers:
  Pavel Mizev ( https://github.com/PavelMizevDev )
  Roit ( https://github.com/Roit-liasp )

Contact me: all available contact methods can be found on my GitHub profile.

# Ru:

## KotlinCMD - проект созданный на языке программирования Kotlin.
Он представляет из себя терминал (Пока запускаемый через терминал ОС и не имеет своего окна). Идея терминала: дать пользователю кроссплатформенную консоль с возможностью добавления легкосоздаваемых `.jar` файлов в качестве плагинов. Проект пока в стадии разработки, но активно развивается. Автор: Павел Мизев.

### Возможности:
На данный момент доступны такие команды:
- `help` - Отображает список команд терминала.
- `exit` - Закрывает терминал.
- `info` - Информация о программе.
- `calc` - Запускает калькулятор.
- `tmanag` - Запускает TimeManager (Внутри доступен Таймер и Секундомер).
- `fmanag` - Запускает FileManager, доступны следующие команды:
    - `help` - Отображает список команд FileManager.
    - `exit` - Закрывает процесс FileManager.
    - `uf` - Переносит вас на папку выше.
    - `cd` - Запрашивает пользовательский путь.
    - `list` - Отображает список папок и файлов по текущему пути.
    - `cdir` - Создает папку по текущему пути.
    - `cfil` - Создает файл по текущему пути.
    - `del` - Удаляет папку или файл по текущему пути.

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
- Разработчики:
  Павел Мизев ( https://github.com/PavelMizevDev )
  Roit ( https://github.com/Roit-liasp )

Связаться со мной: все возможные пути в профиле GitHub.
