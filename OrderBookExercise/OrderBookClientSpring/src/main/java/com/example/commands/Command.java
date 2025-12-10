package com.example.commands;
/**
 * Command Interface. Every command must provide two behaviors:
 * 1.Determine whether it supports a given input
 * 2.Execute its logic based on the input
 */
public interface Command {
    boolean supports(String input);
    void execute(String input) throws Exception;
}