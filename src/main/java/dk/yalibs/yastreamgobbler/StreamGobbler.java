package dk.yalibs.yastreamgobbler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * The infamous streamgobbler construct. Use this to "gobble" / consume string-based streams.
 *
 * Example usage:
 * <pre>
 * {@code
 * var process = new ProcessBuilder("ls").start();
 * var streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
 * }
 * </pre>
 */
public class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumeInputLine;

    /**
     * Constructs an instance based on an input stream and consumer function.
     * @param inputStream the stream to "gobble"
     * @param consumeInputLine the function to use when "gobbling"
     */
    public StreamGobbler(InputStream inputStream, Consumer<String> consumeInputLine) {
        this.inputStream = inputStream;
        this.consumeInputLine = consumeInputLine;
    }

    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumeInputLine);
    }
}

