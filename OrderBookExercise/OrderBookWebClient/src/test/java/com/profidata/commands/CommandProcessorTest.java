/*package com.profidata.commands;

import com.profidata.cli.CommandProcessor;
import com.profidata.commands.Command;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class CommandProcessorTest {

    @Test
    void testCommandIsRoutedToTheCorrectHandler() throws Exception {
        Command unknown = Mockito.mock(Command.class);
        Command correct = Mockito.mock(Command.class);

        when(unknown.supports("hello")).thenReturn(false);
        when(correct.supports("hello")).thenReturn(true);

        CommandProcessor processor = new CommandProcessor(List.of(unknown, correct));
        processor.process("hello");

        verify(correct).execute("hello");
        verify(unknown, never()).execute(anyString());
    }
}

 */