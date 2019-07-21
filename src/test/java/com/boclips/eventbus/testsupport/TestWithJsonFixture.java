package com.boclips.eventbus.testsupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TestWithJsonFixture {
    protected String loadExample(String filename) throws IOException {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(filename)) {
            try (InputStreamReader reader = new InputStreamReader(stream)) {
                try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                    return bufferedReader.lines().collect(Collectors.joining());
                }
            }
        }
    }
}
