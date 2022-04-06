package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		SimpleItemService simpleItemService = context.getBean(SimpleItemService.class);
		simpleItemService.createItem(new Item(15, "apple", 15.0, Color.RED));
		System.out.println(simpleItemService.getById(15).getName());

		InitializerConfiguration.ColorFactory colorFactory = context.getBean(InitializerConfiguration.ColorFactory.class);
		Color colorFirst = colorFactory.getColor();
		Color colorSecond = colorFactory.getColor();
		if (colorFirst.equals(colorSecond)) {
			System.out.println(colorFirst);
		} else {
			System.out.println(colorFirst);
			System.out.println(colorSecond);
		}
	}
}
