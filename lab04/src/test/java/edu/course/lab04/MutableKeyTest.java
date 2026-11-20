package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MutableKeyTest {

    static class MutableKey {

        private String value;

        MutableKey(String value) {
            this.value = value;
        }

        void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof MutableKey)) {
                return false;
            }

            MutableKey other = (MutableKey) obj;
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }

    @Test
    void changingKeyCanBreakHashMapLookup() {
        Map<MutableKey, String> map = new HashMap<>();

        MutableKey key = new MutableKey("A");

        map.put(key, "Значение");

        assertEquals("Значение", map.get(key));

        key.setValue("B");

        assertNull(map.get(key));
    }
}