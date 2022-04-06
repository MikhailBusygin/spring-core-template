package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Random;

@Configuration
public class InitializerConfiguration {

    @Lazy
    @Component
    public static class ColorFactory {

        private final Color[] colors = Color.values();

        public Color getColor() {
            return colors[new Random().nextInt(colors.length)];
        }
    }
}
