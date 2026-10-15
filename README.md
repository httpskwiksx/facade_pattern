# Assignment 4 — Facade Pattern

**Student:** Ulzhan Musakhan  
**Group:** SE-2524  
**Course:** Software Design Patterns  
**Topic:** Option A — Media/File Conversion Facade  
**Language:** Java 17

**GitHub Repository:** https://github.com/httpskwiksx/facade_pattern

## 1. Project Overview

This project demonstrates the Facade structural design pattern using a simulated media conversion system.

Media conversion involves several operations, including reading file metadata, selecting a codec, calculating the target bitrate, and processing audio channels.

The `MediaConversionFacade` simplifies these operations by providing one method:

`convert(fileName, targetFormat)`

The client does not need to know how the subsystem classes work or in which order they must be called.

**Note:** The application simulates media conversion using predefined metadata and calculation rules. It does not modify real media files.

## 2. Project Structure

| File | Role |
|---|---|
| `Main.java` | Client that uses the Facade |
| `MediaConversionFacade.java` | Coordinates subsystem operations |
| `MediaInfo.java` | Stores media metadata |
| `MetadataReader.java` | Validates source files and reads simulated metadata |
| `CodecFactory.java` | Selects the target codec |
| `BitrateReader.java` | Calculates the estimated target bitrate |
| `AudioMixer.java` | Processes the number of audio channels |

## 3. Facade Pattern Implementation

The project contains three main components.

**Client — Main**

The client creates a `MediaConversionFacade` object and calls its `convert()` method. It does not create or directly call subsystem objects.

**Facade — MediaConversionFacade**

The Facade provides a simplified interface and coordinates four subsystem classes in the correct order.

**Complex Subsystem**

The subsystem includes `MetadataReader`, `CodecFactory`, `BitrateReader`, and `AudioMixer`.

Each class performs a separate operation. The `MediaInfo` class stores the data shared between conversion steps.

## 4. Conversion Workflow

When the client requests a conversion, the Facade performs these steps:

1. `MetadataReader.read()` validates the file name and creates a `MediaInfo` object.
2. `CodecFactory.selectCodec()` chooses a codec for the requested format.
3. `BitrateReader.calculateTargetBitrate()` calculates the estimated target bitrate.
4. `AudioMixer.mixChannels()` determines the resulting number of audio channels.
5. The Facade returns a formatted conversion summary.

For example, converting `movie.mkv` to `mp4` uses H264, calculates a target bitrate of 2240 kbps, and reduces the simulated audio channel count from 6 to 2.

## 5. Build and Run

**Requirements:** Java Development Kit (JDK) 17.

Open a terminal in the project root directory.

**Compile:**

`javac --release 17 -encoding UTF-8 -d out src/*.java`

**Run:**

`java -cp out Main`

The application runs three successful conversion scenarios and two error-handling scenarios.

## 6. Expected Output

    Converted video.avi from avi to mp4 | codec=H264 | bitrate=1680 kbps | audioChannels=2
    Converted movie.mkv from mkv to mp4 | codec=H264 | bitrate=2240 kbps | audioChannels=2
    Converted clip.mov from mov to mkv | codec=H265 | bitrate=1650 kbps | audioChannels=6
    ERROR: Conversion failed: Unsupported source format: txt
    ERROR: Conversion failed: Unsupported target format: xyz

The last two lines demonstrate expected error handling rather than unexpected program failures.

## 7. Clean Code Principles

The implementation demonstrates five Clean Code practices.

**1. Meaningful Names**

Methods such as `read()`, `selectCodec()`, `calculateTargetBitrate()`, and `mixChannels()` describe their responsibilities.

**2. Single Responsibility Principle**

Each subsystem class performs one specific task. The Facade coordinates the operations without implementing all subsystem logic itself.

**3. Information Hiding**

Subsystem objects are stored in private fields inside the Facade. Clients use the simple `convert()` method instead of dealing with internal processing details.

**4. Small, Focused Methods**

Subsystem methods perform specific operations, making the code easier to understand and maintain.

**5. Error Handling**

Invalid file names, unsupported formats, and invalid processing values are handled using `IllegalArgumentException`. The client displays clear error messages.

## 8. Benefits of the Facade Pattern

- Provides one simplified interface for media conversion.
- Reduces direct dependencies between the client and subsystem classes.
- Keeps subsystem responsibilities separated.
- Centralizes the coordination of conversion steps.
- Allows subsystem classes to remain usable independently.

## 9. Conclusion

The Media Conversion Facade demonstrates how a complex sequence of operations can be accessed through one simple method.

The Facade hides subsystem coordination from the client, while the individual subsystem classes remain available for direct use by advanced clients.

This design improves readability, reduces coupling, and makes the application easier to maintain.

## 10. References

- Course Lecture 6 — Facade Design Pattern.
- Assignment 4 — Facade Pattern Instructions.
- Freeman, E., & Robson, E. *Head First Design Patterns*.
- Refactoring.Guru — Facade Design Pattern.
