package com.example.cli;

import com.example.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
/**
 * Command processor. Receives raw user input from the console
 * and attempts to locate and execute the corresponding command implementation.
 */
@Slf4j
@Component
public class CommandProcessor {
    // All available command
    private final List<Command> commands;

    @Autowired
    public CommandProcessor(List<Command> commands) {
        this.commands = commands;
    }

    public void process(String input) throws Exception {
        try {
            // Iterate through all commands
            for (Command command : commands) {
                if (command.supports(input)) {
                    log.info("Executing command: {}", command.getClass().getSimpleName());
                    command.execute(input);
                    return;
                }
            }
            // No command recognized the input
            log.warn("Unknown command: {}", input);
            System.out.println("Unknown command: " + input);

        } catch (Exception e) {
            log.error("Command processing error for input '{}': {}", input, e.getMessage(), e);
            throw e;
        }
    }
}