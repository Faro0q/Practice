package io.wcygan.modern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class VarUtilsTest {

  private static final String HELLO = "Hello";
  private static final String WORLD = "World";

  @Test
  public void testCreateMap() {
    Map<String, String> map = VarUtils.createMap(HELLO, WORLD);
    Assertions.assertTrue(map.containsKey(HELLO));
    Assertions.assertEquals(WORLD, map.get(HELLO));
  }
}
