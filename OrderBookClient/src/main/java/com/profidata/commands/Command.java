package com.profidata.commands;

public interface Command {
    boolean supports(String input);
    void execute(String input) throws Exception;
}
