import bikerepair.BikeSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestBikeSystem {

    private BikeSystem bikeSystem;
    private ByteArrayOutputStream outStream;
    private PrintStream outOrig;
    private String bike1 = "Bike|Emily|Spinner|14|0|1";
    private String bike2 = "MTB|Kirstin|Explorer|26|10|200|120";
    private String bike3 = "RB|Alexander|Roadster|27|12|100|5";
    private String bike4 = "Bike|Caroline|Toddler|10|0|1";
    private String bike5 = "MTB|Anthony|Reign|27|10|500|170";
    private String bike6 = "RB|George|Thunder|29|7|1000|4";
    private String bike7 = "Bike|Sharon|Alley|24|5|20";
    private String bike8 = "MTB|Susan|Nomad|29|11|400|180";
    private String bike9 = "RB|Micahel|Highway|26|15|750|4";

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        outOrig = System.out;
        System.setOut(out);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
    }

    @Test
    public void testInsertBike() {
        bikeSystem = new BikeSystem(8);
        assertTrue(bikeSystem.insertBike(bike1));
        assertTrue(bikeSystem.insertBike(bike2));
        assertTrue(bikeSystem.insertBike(bike3));
        assertTrue(bikeSystem.insertBike(bike4));

        assertFalse(bikeSystem.insertBike(bike1));

        assertTrue(bikeSystem.insertBike(bike5));
        assertTrue(bikeSystem.insertBike(bike6));
        assertTrue(bikeSystem.insertBike(bike7));
        assertTrue(bikeSystem.insertBike(bike8));

        assertFalse(bikeSystem.insertBike(bike9));
    }

    @Test
    public void testBikeExists() {
        bikeSystem = new BikeSystem(3);
        assertTrue(bikeSystem.insertBike(bike1));
        assertFalse(bikeSystem.bikeExists("Alexander", "Roadster"));
        assertTrue(bikeSystem.bikeExists("Emily", "Spinner"));
    }

    @Test
    public void testPrintSystem() {
        bikeSystem = new BikeSystem(3);
        assertTrue(bikeSystem.insertBike(bike1));
        assertTrue(bikeSystem.insertBike(bike2));

        bikeSystem.printSystem();
        String expectedOutput = "Bike|Emily|Spinner|14|0|1" + System.lineSeparator() + "MTB|Kirstin|Explorer|26|10|200|120";
        assertEquals(expectedOutput, outStream.toString().trim());
    }

    @Test
    public void testCloseGarage() {
        bikeSystem = new BikeSystem(3);
        assertTrue(bikeSystem.insertBike(bike1));
        assertTrue(bikeSystem.insertBike(bike3));
        assertTrue(bikeSystem.insertBike(bike5));
        assertFalse(bikeSystem.insertBike(bike7));
        bikeSystem.closeGarage();
        assertTrue(bikeSystem.insertBike(bike2));
        assertTrue(bikeSystem.insertBike(bike4));
        assertTrue(bikeSystem.insertBike(bike8));
    }

    @Test
    public void testPrintServiceIntervals() {
        bikeSystem = new BikeSystem(8);
        assertTrue(bikeSystem.insertBike(bike1));
        assertTrue(bikeSystem.insertBike(bike2));
        assertTrue(bikeSystem.insertBike(bike3));
        assertTrue(bikeSystem.insertBike(bike4));
        assertTrue(bikeSystem.insertBike(bike5));
        assertTrue(bikeSystem.insertBike(bike6));
        assertTrue(bikeSystem.insertBike(bike7));
        assertTrue(bikeSystem.insertBike(bike8));

        bikeSystem.printServiceIntervals();

        String expectedOutput = "Emily, Spinner, 0" + System.lineSeparator() +
                "Kirstin, Explorer, 140" + System.lineSeparator() +
                "Alexander, Roadster, 500" + System.lineSeparator() +
                "Caroline, Toddler, 0" + System.lineSeparator() +
                "Anthony, Reign, 100" + System.lineSeparator() +
                "George, Thunder, 4000" + System.lineSeparator() +
                "Sharon, Alley, 30" + System.lineSeparator() +
                "Susan, Nomad, 139";
        assertEquals(expectedOutput, outStream.toString().trim());
    }
}