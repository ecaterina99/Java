package com.profidata.commands;

import java.util.List;

public class CommandProcessor {

    private final List<Command> commands;

    public CommandProcessor(List<Command> commands) {
        this.commands = commands;
    }

    public void process(String input) throws Exception {
        for (Command command : commands) {
            if (command.supports(input)) {
                command.execute(input);
                return;
            }
        }
        System.out.println("Unknown command: " + input);
    }
}