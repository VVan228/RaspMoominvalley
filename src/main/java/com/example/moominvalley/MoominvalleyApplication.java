package com.example.moominvalley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

@SpringBootApplication
public class MoominvalleyApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoominvalleyApplication.class, args);
	}
}
