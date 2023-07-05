package Polymorphism.Exercise.word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface command = new AdvancedCommandInterfaceInterface(text);
        command.init();

        return command;
    }
}
