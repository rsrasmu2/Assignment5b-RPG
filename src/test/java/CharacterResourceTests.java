import characters.resources.CharacterResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterResourceTests {
    @Test
    public void testCreation() {
        CharacterResource resource = new CharacterResource("TestName", 100);
        assertEquals("TestName", resource.getName());
        assertEquals(100, resource.getCurrentValue());
        assertEquals(100, resource.getMaxValue());
    }

    @Test
    public void testCreationWithStarting() {
        CharacterResource resource = new CharacterResource("TestName", 0, 100);
        assertEquals("TestName", resource.getName());
        assertEquals(0, resource.getCurrentValue());
        assertEquals(100, resource.getMaxValue());
    }

    @Test
    public void testSettingCurrentValue() {
        CharacterResource resource = new CharacterResource("TestName", 100);
        resource.setCurrentValue(50);
        assertEquals(50, resource.getCurrentValue());
        resource.setCurrentValue(-1);
        assertEquals(0, resource.getCurrentValue());
        resource.setCurrentValue(101);
        assertEquals(100, resource.getCurrentValue());
    }

    @Test
    public void testSettingMaxValue() {
        CharacterResource resource = new CharacterResource("TestName", 100);
        resource.setMaxValue(200);
        assertEquals(200, resource.getMaxValue());
        resource.setMaxValue(50);
        assertEquals(50, resource.getMaxValue());
        assertEquals(50, resource.getCurrentValue());
    }
}
