package ZSystemDesign.Behavioural;

import java.util.Stack;

/**
 The Command Pattern is a behavioral design pattern that encapsulates a request as an object,
 allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests.
 It lets you add features like undo, redo, logging, and dynamic command execution without changing the core business logic.
 This allows you to execute commands at a later time, in a flexible manner,
 without having to interact directly with the request's execution details.

 Four Key Components:
 Client – Initiates the request and sets up the command object.
 Invoker – Asks the command to execute the request.
 Command – Defines a binding between a receiver object and an action.
 Receiver – Knows how to perform the actions to satisfy a request.

 Trade Off:
 Increases the Number of Classes:
 Implementing the Command Pattern can result in a large number of small classes for each command, potentially increasing the complexity.
 Can Add Unnecessary Complexity for Simple Tasks:
 For simple applications, the Command Pattern may introduce unnecessary complexity, making it harder to manage than simpler alternatives.
 Requires Careful Design for Undo/Redo:
 Implementing undo/redo functionality correctly requires careful design and additional effort, especially for complex command chains.
 */


// ========= Client code ===========
public class Ptn16_Command {
    public static void main(String[] args) {
        Light light = new Light();
        AC ac = new AC();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command acOn = new AConCommand(ac);
        Command acOff = new ACOffCommand(ac);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, acOn);
        remote.setCommand(3, acOff);

        remote.pressButton(0); // Light ON
        remote.pressButton(2); // AC ON
        remote.pressButton(1); // Light OFF
        remote.pressUndo();    // Undo Light OFF -> Light ON
        remote.pressUndo();    // Undo AC ON -> AC OFF
    }
}


// ========= Receiver classes ===========
// Light and AC with basic on/off methods
class Light {
    public void on() {
        System.out.println("Light turned ON");
    }

    public void off() {
        System.out.println("Light turned OFF");
    }
}

class AC {
    public void on() {
        System.out.println("AC turned ON");
    }

    public void off() {
        System.out.println("AC turned OFF");
    }
}

// ========= Command interface ===========
//    defines the command structure
interface Command {
    void execute();
    void undo();
}

// Concrete commands for Light ON and OFF
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

// Concrete commands for AC ON and OFF
class AConCommand implements Command {
    private AC ac;

    public AConCommand(AC ac) {
        this.ac = ac;
    }

    public void execute() {
        ac.on();
    }

    public void undo() {
        ac.off();
    }
}

class ACOffCommand implements Command {
    private AC ac;

    public ACOffCommand(AC ac) {
        this.ac = ac;
    }

    public void execute() {
        ac.off();
    }

    public void undo() {
        ac.on();
    }
}

// ========== Remote control class (Invoker) ==========
class RemoteControl {
    private Command[] buttons = new Command[4];  // Assigning 4 slots for commands
    private Stack<Command> commandHistory = new Stack<>();

    // Assign command to slot
    public void setCommand(int slot, Command command) {
        buttons[slot] = command;
    }

    // Press the button to execute the command
    public void pressButton(int slot) {
        if (buttons[slot] != null) {
            buttons[slot].execute();
            commandHistory.push(buttons[slot]);
        } else {
            System.out.println("No command assigned to slot " + slot);
        }
    }

    // Undo the last action
    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            commandHistory.pop().undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }
}