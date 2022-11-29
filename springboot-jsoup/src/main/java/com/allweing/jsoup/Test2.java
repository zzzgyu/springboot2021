package com.allweing.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @auther: zzzgyu
 */

public class Test2 {
	public static void main( String[] args ) {
		try {
			Document document = Jsoup.connect("https://www.dy2018.com/i/103258.html").get();
			Elements a = document.body().getElementsByTag("a");
			for (Element element : a) {
				String href = element.attr("abs:href");
				System.out.println(href);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
