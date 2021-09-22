# Automatic installed programs checker
Java program that automatically checks if given programs (read from .csv) have ever been "installed". There are other ways to check for previously installed programs with system specific api's / registry keys, but this is a user friendly method that can be easily expanded to include other programs.

## How it works
If the provided system is Windows the program will check for directory names that match the given program names in ../AppData and its subdirectories.
If deep search is on (or the given OS isn't windows), search will start at root system directory and search up to the given depth (usually up to 10) for installed programs.

### Input file
The input .csv file can be:
* manually added from the javafx gui
* automatically downloaded from a public github repository

### Why have a GUI at all?
The GUI provides a user friendly program installed checker, auto-configurable interface for automatically downloading binaries and customising the program list for different use cases.

## Built with
* [Maven](https://mvnrepository.com/artifact/org.openjfx/javafx/11.0.2)
* [OpenJavaFX](https://openjfx.io/openjfx-docs/)
* [OpenJDK - runtime](https://www.openlogic.com/openjdk-downloads)

## UX Requirements
The app should have 2 screens:
* Main view screen, where the user can look at all programs from the list
  * with not installed programs annotated  
* Edit screen, where the user can edit the program list

## .CSV file format
An example of the .csv file format
| Program name (Required)| Program category (Optional) | License type (Optional) | Is always required (Required) | Download URL (Optional) | User Profile (Optional)
|:----:|:-----------:|:----:|:----:|:----:|:----:|
Mozilla Firefox | Browser | FOSS | yes | https://download.mozilla.org/?product=firefox-stub&os=win&lang=en-US | Regular
Google Chrome | Browser | Freeware | yes | http://dl.google.com/chrome/install/375.126/chrome_installer.exe | Regular
ffmpeg | Video editor | FOSS | no | https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2 | Video editor
Visual Studio Code | Programmer | Shareware| no | https://code.visualstudio.com/docs/?dv=win | Programmer
Arduino IDE | Programmer | FOSS | no | https://downloads.arduino.cc/arduino-nightly-windows.zip | Programmer

## Additional dependencies
* OpenJFX [JavaFX 16](https://mvnrepository.com/artifact/org.openjfx/javafx/16)
* Google's [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
* Google's [Guava](https://mvnrepository.com/artifact/com.google.guava/guava)

## License
Licensed under [GPLv3](https://www.gnu.org/licenses/gpl-3.0.html)
