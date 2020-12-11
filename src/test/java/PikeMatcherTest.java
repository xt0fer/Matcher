import static org.junit.jupiter.api.Assertions.*;

class PikeMatcherTest {

    @org.junit.jupiter.api.Test
    void t1_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "bar";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void t2_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "kris";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t3_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "bat";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t4_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "^foo";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void t5_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "baz$";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void t6_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "o*";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
        pattern="r*";
        actual = pm.match(pattern, text);
        assertTrue(actual);
        pattern="fo*";
        actual = pm.match(pattern, text);
        assertTrue(actual);

    }

    @org.junit.jupiter.api.Test
    void t7_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "jkl";
        String text = "foobarbazabcabdcabcdexyz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t8_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "^cab";
        String text = "foobarbazabcabdcabcdexyz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    public void testmatch1() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("abc", "abc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch2() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a", "abc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch3() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("^b", "abc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch4() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("abc", "aaabcbbcc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch5() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("c$", "aaabcbbcc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch6() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match(".*cc", "aaabcbbcc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch7() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("jkl", "aaabcbbcc"));
    }
    @org.junit.jupiter.api.Test
    public void testmatch8() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("cb.", "aaabcbbcc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch9() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("cb.", "aaabcabcc"));
    }

}