import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerTest {
    DesktopComputer desktop;
    LaptopComputer laptop;

    @Before
    public void before() {
        desktop = new DesktopComputer();
        laptop = new LaptopComputer();
    }

//    @Test
//    public void desktopCanRunApplication(){
//        assertEquals("I am running IntelliJ", desktop.runApplication("IntelliJ"));
//    }
//
//    @Test
//    public void laptopCanRunApplication() {
//        assertEquals("Program CC Caraoke is running", laptop.runApplication("CC Caraoke"));
//    }

    @Test
    public void desktopCanRunApplication() {
        assertEquals("CC Caraoke Status: I am running CC Caraoke", desktop.runApplication("CC Caraoke"));
    }

    @Test
    public void laptopCanRunApplication() {
        assertEquals("CC Caraoke Status: Program CC Caraoke is running", laptop.runApplication("CC Caraoke"));
    }

    @Test
    public void desktopCanCloseApplication() {
        assertEquals("I am closing down CC Caraoke", desktop.closeApplication("CC Caraoke"));
    }

    @Test
    public void laptopCanCloseApplication() {
        assertEquals("Program CC Caraoke is closing down", laptop.closeApplication("CC Caraoke"));
    }

    @Test
    public void desktopCanShutDown() {
        assertEquals("Shutting down...", desktop.shutDown());
    }

    @Test
    public void laptopCanShutDown() {
        assertEquals("Shutting down...", laptop.shutDown());
    }

    @Test
    public void computerCanCloseApplicationAsLaptop() {
        Computer computer = new LaptopComputer();
        assertEquals("Shutting down...",computer.shutDown());
    }

    @Test
    public void computerCanCloseApplicationAsDesktop() {
        Computer computer = new LaptopComputer();
        computer = new DesktopComputer();
        assertEquals("Shutting down...",computer.shutDown());
    }

}
