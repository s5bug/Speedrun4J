package com.tsunderebug.speedrun4j.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PersonalBestsTest {

    private static PersonalBests pbs;

    @BeforeAll
    public static void setup() {

        pbs = User.fromID("lundylizard").getPBs();

    }

    @Test
    void getData() {

        assertNotNull(pbs);

    }

}