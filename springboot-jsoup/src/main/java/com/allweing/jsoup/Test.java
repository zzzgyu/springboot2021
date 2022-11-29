package com.allweing.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther: zzzgyu
 */

public class Test {
	public static void main( String[] args ) {
		System.out.println(Runtime.getRuntime().availableProcessors());//获取cpu核数

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 17, 5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(200));
		long time = new Date().getTime();
		System.out.println("================"+time);
		for (int i = 103000; i <= 103217; i++) {

				String url="https://www.dy2018.com/i/"+i+".html";
				System.out.println(url);
			try {
				threadPoolExecutor.execute(()->{
					System.out.println("==========================="+Thread.currentThread().getName()+"============");
					Document document = null;
					try {
						document = Jsoup.connect(url).get();
						System.out.println("title---------------"+document.title());
						Element body = document.body();
						Element head = document.head();

						Elements a = body.getElementsByTag("img");
						for (Element element : a) {
							String href = element.attr("src");
							System.out.println(href);
						}
					} catch (IOException e) {
						System.out.println("异常:"+url+"--------------------------------------------------------");
					}

				});
			} catch (Exception e) {
				System.out.println("异常:"+url+"--------------------------------------------------------");

			}
		}
		threadPoolExecutor.shutdown();

		long time1 = new Date().getTime()-time;

		System.out.println("====================="+time1);

	}
}
