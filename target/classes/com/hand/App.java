package com.hand;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Film;
import dao.FilmDao;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext apc = new ClassPathXmlApplicationContext("/conf/ApplicationContext.xml");
		apc.start();
		FilmDao filmdao = (FilmDao) apc.getBean("FilmMapper");

		Film film = (Film) apc.getBean("film");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入电影名称(title):");
		String title = sc.nextLine();
		System.out.println("请输入电影描述(description):");
		String description = sc.nextLine();
		System.out.println("请输入语言 ID(language_id):");
		int language_id = sc.nextInt();
		while (filmdao.checkLan(language_id) <= 0) {
			System.out.println("language_id错误,请重新输入。");
			language_id = sc.nextInt();
		}
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);

		filmdao.addFilm(film);

		apc.stop();
	}
}
