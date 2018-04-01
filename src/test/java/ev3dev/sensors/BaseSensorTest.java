package ev3dev.sensors;

import ev3dev.hardware.EV3DevFileSystem;
import ev3dev.hardware.EV3DevPlatform;
import fake_ev3dev.ev3dev.sensors.FakeBattery;
import fake_ev3dev.ev3dev.sensors.FakeLegoSensor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.SensorMode;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseSensorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void resetTest() throws Exception {

        FakeBattery.deleteEV3DevFakeSystemPath();
        FakeBattery.createEV3DevFakeSystemPath();
    }

    @Test
    public void getModeOkWithStringTest() throws Exception {

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        assertThat(baseSensor.getMode("Test").getName(), is("Test"));
    }

    @Test
    public void getModeOkWithIntegerTest() throws Exception {

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        assertThat(baseSensor.getMode(0).getName(), is("Test"));
    }

    @Test
    public void getModeKoWithStringTest() throws Exception {

        thrown.expect(IllegalArgumentException.class);

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.getMode("NoTest");
    }

    @Test
    public void getModeKoWithIntegerTest() throws Exception {

        thrown.expect(IllegalArgumentException.class);

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.getMode(-1);
    }

    @Test
    public void getModeKoWithIntegerTest2() throws Exception {

        thrown.expect(IllegalArgumentException.class);

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.getMode(2);
    }

    @Test
    public void setModeTest() throws Exception {

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.setCurrentMode("Test");

        assertThat(baseSensor.getCurrentMode(), is(0));
    }

    @Test
    public void setModeKoTest() throws Exception {

        thrown.expect(IllegalArgumentException.class);

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.setCurrentMode("TestKo");
    }

    @Test
    public void setNameTest() throws Exception {

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.setCurrentMode("Test");

        assertThat(baseSensor.getName(), is("Test"));
    }

    @Test
    public void getSampleSizeTest() throws Exception {

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.setCurrentMode("Test");

        assertThat(baseSensor.sampleSize(), is(1));
    }

    @Test
    public void geFetchSampleTest() throws Exception {

        System.setProperty(EV3DevFileSystem.EV3DEV_TESTING_KEY, FakeBattery.EV3DEV_FAKE_SYSTEM_PATH);

        final FakeBattery fakeBattery = new FakeBattery(EV3DevPlatform.EV3BRICK);
        final FakeLegoSensor fakeLegoSensor = new FakeLegoSensor(EV3DevPlatform.EV3BRICK);

        BaseSensor baseSensor = new BaseSensor(SensorPort.S1, "");
        baseSensor.setModes(new SensorMode[] {new ModeTestMode(new File(""))});

        baseSensor.setCurrentMode("Test");

        float [] sample = new float[baseSensor.sampleSize()];
        baseSensor.fetchSample(sample, 0);

        assertThat(sample[0], is(10f));
    }

    //Sensor Mode created for the tests

    private class ModeTestMode extends EV3DevSensorMode {

        private static final String MODE = "TEST-MODE";

        private final File pathDevice;

        public ModeTestMode(final File pathDevice) {
            this.pathDevice = pathDevice;
        }

        @Override
        public int sampleSize() {
            return 1;
        }

        @Override
        public void fetchSample(float[] sample, int offset) {
            sample[offset] = 10f;
        }

        @Override
        public String getName() {
            return "Test";
        }
    }

}
