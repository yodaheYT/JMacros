# JMacros
## A simple macro tool made in Java 

![Github Total Downloads](https://img.shields.io/github/downloads/yodaheYT/JMacros/total?style=for-the-badge&logo=github)
![GitHub last commit](https://img.shields.io/github/last-commit/yodaheYT/JMacros?style=for-the-badge)
![GitHub Issues or Pull Requests](https://img.shields.io/github/issues/yodaheYT/JMacros?style=for-the-badge)

![GitHub forks](https://img.shields.io/github/forks/yodaheYT/JMacros?style=for-the-badge)
![GitHub Repo stars](https://img.shields.io/github/stars/yodaheYT/JMacros?style=for-the-badge)
![GitHub Release](https://img.shields.io/github/v/release/yodaheYT/JMacros?display_name=release&style=for-the-badge)

| Release | Link                                                                               | Status                                                                                                                                                                                                          |
|---------|------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Testing | [GitHub Releases](https://github.com/yodaheYT/JMacros/releases/tag/V0.3) | [![GitHub Testing Releases](https://img.shields.io/github/downloads/yodaheYT/JMacros/V0.3/total?style=for-the-badge&logo=github)](https://github.com/yodaheYT/HomelabTelevision/releases/tag/Testing) |

# What is JMacros?
JMacros is a tool to write simple macro scripts and export/import them as `.jmacro` files.

# Usage
1. Install a version of JDK-21 ([Recommended 21.02](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html))
3. Run the .jar
```bash
# Replace (release) with your downloaded file name and (path) with the path to your directory of videos
java -jar (release).jar
```
OR<br>
double click the file

### To build from source:
2. Download the source code of the latest release [Here](https://github.com/yodaheYT/HomelabTelevision/releases) (stable recommended)
3. Run the "jar" Gradle Task.
4. Run the following commands.
```bash
# Replace (release) with your downloaded file name
java -jar (release).jar
```
OR<br>
double click the file

# Instructions
ClickKey -> presses and releases x key
ClickMouse -> presses and releases x mouse button
JumpToMouse -> jumps mouse to position
MoveToMouse -> smoothly moves mouse to x position over one second
PressKey -> press x key
PressMouse -> press x mouse button
ReleaseKey -> releases x key
Scroll -> scrolls x notches (use -int to scroll backwards)
UnpressMouse -> releases x mouse button
Wait -> waits x milliseconds

# Importing and exporting
To export a macro:
- Go to Macro menu -> Export
- Select a Location
- Enter a file name
- Click save

To Import a macro:
- Go to Macro menu -> Import
- Go to the location of your `.jmacro` file
- Select your `.jmacro` file
- Click Open

# Creating and running a macro
## Currently you CANNOT reorder objects in a macro without exporting, opening the `.jmacro` file in a text editor, and moving objects around, and reimporting
1. Add action by going to JMacros Menu -> Add Instruction -> Whatever you want to add
2. Use the properties panel to modify the object <Br>
<span style="color:#aaffaa">TIP</span>: if you make a mistake and your macro doesn't work, you can click on an instruction in the macro instruction list to modify it.
3. Repeat steps 1 & 2 until your macro is finished
4. Press Run and watch it run
5. Export

# Finding mouse coordinates
1. Go to JMacros menu then mouse position finder
2. Put your mouse at the desired position
3. Note down the coordinates
4. Put them in the properties panel for your instruction

# Mouse buttons
1: left click<br>
2: middle click<br>
3: right click

# Keys
Just type the letter in the properties panel