
# Arcade Game Project

## Project Overview
This project is an arcade-style game developed as part of an Object-Oriented Programming course. The goal is to clear all blocks across three unique levels by controlling a paddle and bouncing a ball. Completing all levels results in victory, while losing all balls ends the game.

## How to Run
1. **Clone the Repository**: Download or clone the project files.
2. **Compile the Code**:
   - Use the provided `build.xml` to compile the project:
     ```bash
     ant compile
     ```
3. **Run the Game**:
   - Execute the game using the `run` target:
     ```bash
     ant run
     ```
   - Alternatively, use the `.jar` file with:
     ```bash
     java -jar ass6example.jar
     ```

## Gameplay Description

### Levels

#### Level 1: Direct Hit
 <img src="/Proof/Screenshot 2025-01-26 234001.png">
#### Level 2: London Bridge
 <img src="Proof/Screenshot 2025-01-27 001801.png">
#### Level 3: Last Level
<img src="/Proof/Screenshot 2025-01-27 001831.png">

### Screens

#### Victory Screen
 <img src="Proof/Screenshot 2025-01-27 002731.png">
 
#### Game Over Screen
<img src="Proof/Screenshot 2025-01-27 001741.png">

## Project Structure
The project is organized into several packages, each handling a specific aspect of the game logic. Below is a detailed breakdown of the structure:

### Directories
- **src**: Contains all source code files.
- **bin**: Destination directory for compiled `.class` files.
- **assets**: Stores additional resources, such as configuration files.

### Packages

#### Geometry
Handles geometric calculations and shapes used in the game.
- **`Point`**: Represents a point in a 2D space.
- **`Line`**: Models a line and provides methods for intersection.
- **`Rectangle`**: Represents rectangular shapes used for blocks and collision detection.
- **`Velocity`**: Represents the movement speed and direction of objects.

#### SpriteAndCollidables
Defines interactive and drawable objects in the game.
- **`Ball`**: Represents the game ball with movement and collision behavior.
- **`Block`**: Represents blocks that can be hit and removed by the ball.
- **`Paddle`**: Represents the player-controlled paddle.
- **`ScoreIndicator`**: Displays the current score on the screen.

#### ListenersAndNotifiers
Handles game events and notifications.
- **`HitListener`**: Interface for objects listening to hit events.
- **`HitNotifier`**: Interface for objects that notify listeners of hits.
- **`BallRemover`**: Removes balls from the game and updates the ball counter.
- **`BlockRemover`**: Removes blocks from the game and updates the block counter.
- **`ScoreTrackingListener`**: Updates the score whenever a block is hit.

#### GameSupporters
Provides utility classes and core game functionality.
- **`GameLevel`**: Manages a single level, including initialization, rendering, and progression.
- **`GameFlow`**: Handles the flow of the game across multiple levels.
- **`CollisionInfo`**: Stores information about collisions.
- **`Counter`**: Tracks numeric values such as score and remaining balls.

#### Levels
Defines the game levels and their specific configurations.
- **`Level1`**: The first level, "Direct Hit".
- **`Level2`**: The second level, "London Bridge" .
- **`Level3`**: The final level, "Last Level".
- **`LevelInformation`**: Interface defining the structure and properties of a level.

### Build Configuration
- **`build.xml`**: Used by Apache Ant to compile, run, and clean the project.
- **`biuoop-1.4.jar`**: Library for graphical and input handling.
- **`biuoop.xml`**: Checkstyle configuration file for enforcing coding standards.

### Additional Files
- **`ass6example.jar`**: A precompiled JAR file to directly run the game.
- **`checkstyle-8.44-all.jar`**: Tool for static code analysis to ensure code quality.


### Libraries and Tools Used:
- **biuoop-1.4.jar**: For graphical and input handling.
- **Ant**: Used for building and running the project.
- **Checkstyle**: For code quality and consistency checks.

