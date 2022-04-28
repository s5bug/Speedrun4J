package com.tsunderebug.speedrun4j.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    static User testUser;

    @BeforeAll
    static void createTestUserFromId() {
        testUser = User.fromID("lundylizard");
    }

    @Test
    void getId() {
        assertEquals("qj224k6j", testUser.getId());
        assertNotEquals("obama", testUser.getId());
    }

    @Test
    void getNames() {
        assertEquals("lundylizard", testUser.getNames().get("international"));
        assertNull(testUser.getNames().get("japanese"));
    }

    @Test
    void hasSupporterAnimation() {
        assertFalse(testUser.hasSupporterAnimation());
    }

    @Test
    void getPronouns() {
        assertEquals("They/Them", testUser.getPronouns());
    }

    @Test
    void getWeblink() {
        assertEquals("https://www.speedrun.com/user/lundylizard", testUser.getWeblink());
    }

    @Test
    void getNameStyle() {

        NameStyle testNameStyle = testUser.getNameStyle();
        assertNotNull(testNameStyle);
        assertNotNull(testNameStyle.getColorFrom());
        assertNotNull(testNameStyle.getColorTo());
        assertEquals("gradient", testNameStyle.getStyle());
        assertEquals("#000000", testNameStyle.getColorFrom().get("light"));
        assertEquals("#FFFFFF", testNameStyle.getColorFrom().get("dark"));
        assertEquals("#000000", testNameStyle.getColorTo().get("light"));
        assertEquals("#FFFFFF", testNameStyle.getColorTo().get("dark"));

    }

    @Test
    void getRole() {
        assertNotNull(testUser.getRole());
        assertEquals("user", testUser.getRole());
    }

    @Test
    void getSignup() {
        assertNotNull(testUser.getSignup());
        assertEquals("2017-12-23T12:17:43Z", testUser.getSignup());
    }

    @Test
    void getLocation() {

        assertNotNull(testUser.getLocation());
        Location testLocation = testUser.getLocation();
        Location.SubLocation country = testLocation.getCountry();
        assertNull(testLocation.getRegion());
        assertNotNull(country);
        assertEquals("de", country.getCode());
        assertEquals("Germany", country.getNames().get("international"));
        assertNull(country.getNames().get("japanese"));

    }

    @Test
    void getTwitch() {
        assertNotNull(testUser.getTwitch());
        assertEquals("https://www.twitch.tv/iundylizard", testUser.getTwitch().getUri());
    }

    @Test
    void getHitbox() {
        assertNull(testUser.getHitbox());
    }

    @Test
    void getYoutube() {
        assertNotNull(testUser.getYoutube());
        assertEquals("https://www.youtube.com/channel/UCdV3VaEpm-amnsnqsqqXxUA", testUser.getYoutube().getUri());
    }

    @Test
    void getTwitter() {
        assertNull(testUser.getTwitter());
    }

    @Test
    void getSpeedrunslive() {
        assertNull(testUser.getSpeedrunslive());
    }

    @Test
    void getLinks() {

        assertNotNull(testUser.getLinks());

        for (int i = 0; i < testUser.getLinks().length; i++) {
            assertNotNull(testUser.getLinks()[i]);
        }

    }

    @Test
    void getPBs() {

        assertNotNull(testUser.getPBs());
        assertNotNull(testUser.getPBs().getData());

    }

    @Test
    void getAssets() {

        assertNull(testUser.getAssets().getSupporterIcon());
        assertEquals("https://www.speedrun.com/userasset/qj224k6j/icon?v=cd54cc1", testUser.getAssets().getIcon().getUri());
        assertEquals("https://www.speedrun.com/userasset/qj224k6j/image?v=f74250a", testUser.getAssets().getImage().getUri());

    }


}