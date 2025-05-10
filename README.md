# 🟡 Pacman Maze Game (Java Swing)

A desktop maze game built in Java using Swing, where a robot (styled as Pacman) autonomously navigates a generated grid. The robot explores walkable paths to reach the endpoint, updating visuals and direction dynamically, with interactive panels guiding the user through gameplay.

---

## 📋 Project Specifications

- **Language**: Java (Java Swing GUI)
- **Grid Size Options**: 5, 8, 10
- **Core Components**:
  - `IntroPanel`: Start screen with map size selection
  - `MapPanel`: Main gameplay view with tile updates and robot movement
  - `EndPanel`: Displays results and play-again option
- **Robot Behavior**:
  - Moves using available walkable tiles
  - Avoids previously visited tiles unless backtracking
  - Dynamically updates facing direction using visual cues
- **Visual Feedback**:
  - Tile state transitions: unknown → shown → walked-on
  -  Pacman orientation updates based on direction (`PacU`, `PacD`, etc.)
- **File Features**:
  - Saves run data to `Results.txt`
  - Displays game summary in scrollable view on completion

---

## 🎮 Game Panels & UI

### Intro Screen

Select your maze size and start the game:
![GamePanels](https://github.com/user-attachments/assets/8d991127-c6d3-4fd1-afee-45b2fd2f2022)



---

### Gameplay

Pacman explores the maze, changing direction and stepping over tiles.


![GamePlay](https://github.com/user-attachments/assets/49509949-f5c8-4989-9da5-5059231190e9)

---

## How to Run the Project

### Requirements

- Java Development Kit (JDK 8 or higher)
- A system with a properly installed Java Virtual Machine (JVM)

### Run Options

You can run the project in one of the following ways:

1. **Using an IDE** (IntelliJ, Eclipse, VS Code):
   - Open the project.
   - Set `Main.java` as the entry point.
   - Run the program from the IDE.

2. **Compiling and Running Locally**:
   - Compile all Java source files using `javac`.
   - Run the game using the `java` command with `Main` as the entry class.

3. **Packaging as an Executable JAR**:
   - Compile the project.
   - Package it using `jar` with `Main` as the entry point.
   - Run the JAR using `java -jar`.


