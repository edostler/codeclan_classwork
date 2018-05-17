import Behaviours.IOutput;
import device_management.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComputerTest {
    Computer computer;
    Monitor monitor;
    Keyboard keyboard;

    @Before
    public void before() {
        keyboard = new Keyboard("Logitech");
        monitor = new Monitor(22, 786432);
        computer = new Computer(8, 512, monitor, keyboard);
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

    @Test
    public void hasMonitor() {
        IOutput outputDevice = computer.getOutputDevice();
        assertNotNull(outputDevice);
    }

    @Test
    public void canOutputDataViaMonitor() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputDataViaPrinter() {
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        Computer computer = new Computer(8, 512, printer, keyboard);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputDataViaSpeaker() {
        Speaker speaker = new Speaker(11);
        Computer computer = new Computer(8, 512, speaker, keyboard);
        assertEquals("playing: Beep", computer.outputData("Beep"));
    }

    @Test
    public void canSetOutputDevice() {
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        computer.setOutputDevice(printer);
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

    @Test
    public void canSetInputDevice() {
        Mouse mouse = new Mouse("Logitech", 3);
        computer.setInputDevice(mouse);
        assertEquals("clicking button: 2", computer.inputData("2"));
    }

    @Test
    public void canInputDataViaKeyboard() {
        assertEquals("pressing key: g", computer.inputData("g"));
        assertEquals("g", computer.getDataStream());
    }

    @Test
    public void canInputDataViaMouse() {
        Mouse mouse = new Mouse("Logitech", 3);
        Computer computer = new Computer(8, 512, monitor, mouse);
        assertEquals("clicking button: 2", computer.inputData("2"));
        assertEquals("2", computer.getDataStream());
    }

    @Test
    public void hasDataStream() {
        assertEquals(null, computer.getDataStream());
    }

    @Test
    public void canOutputDataStreamFromKeyboardViaMonitor() {
        computer.inputData("g");
        assertEquals("g is now on screen", computer.outputDataStream());
    }

    @Test
    public void canOutputDataStreamFromKeyboardViaPrinter() {
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        computer.setOutputDevice(printer);
        computer.inputData("g");
        assertEquals("printing: g", computer.outputDataStream());
    }

    @Test
    public void canOutputDataStreamFromKeyboardViaSpeaker() {
        Speaker speaker = new Speaker(11);
        computer.setOutputDevice(speaker);
        computer.inputData("g");
        assertEquals("playing: g", computer.outputDataStream());
    }

    @Test
    public void canOutputDataStreamFromMouseViaMonitor() {
        Mouse mouse = new Mouse("Logitech", 3);
        computer.setInputDevice(mouse);
        computer.inputData("2");
        assertEquals("2 is now on screen", computer.outputDataStream());
    }

    @Test
    public void canOutputDataStreamFromMouseViaPrinter() {
        Mouse mouse = new Mouse("Logitech", 3);
        computer.setInputDevice(mouse);
        Printer printer = new Printer("Epson", "Stylus", 120, 4);
        computer.setOutputDevice(printer);
        computer.inputData("2");
        assertEquals("printing: 2", computer.outputDataStream());
    }

    @Test
    public void canOutputDataStreamFromMouseViaSpeaker() {
        Mouse mouse = new Mouse("Logitech", 3);
        computer.setInputDevice(mouse);
        Speaker speaker = new Speaker(11);
        computer.setOutputDevice(speaker);
        computer.inputData("2");
        assertEquals("playing: 2", computer.outputDataStream());
    }

}
