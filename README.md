# yastreamgobbler
Yet another [StreamGobbler](https://www.baeldung.com/run-shell-command-in-java#Output) implementation for java applications

## Usage
First, you need to add the library to your project:

```gradle
// Add mavenCentral to your repositories
repositories {
    mavenCentral();
}

// Add the library (NOTE: Check the latest version on github)
depdendencies {
    implementation group: 'dk.yalibs', name: 'yaerrors', version: '1.0.0';
}
```

Then use it e.g. when invoking processes:
```
import dk.yalibs.yastreamgobbler.StreamGobbler; // Import it

// ...

var process = new ProcessBuilder("ls").start();
var streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
var future = executorService.submit(streamGobbler);
var exitCode = process.waitFor();
```

