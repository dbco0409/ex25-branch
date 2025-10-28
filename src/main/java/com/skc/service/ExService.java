package com.skc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExService {

	private static final Logger log = LoggerFactory.getLogger(ExService.class);

	public String sayHello(String hi) {
		String msg = hi + " 좋은날";
//		msg = "안녕 좋은날"

		log.info(msg);
		log.debug(msg);
		log.warn(msg);
		log.error(msg);
		return msg;
	}

	public Integer exInt() {
		return 999;
	}

	public String ex321() {
		int number = 1;
		String result = "";

		if (number == 1) {
			result = "if 블록입니다.";
		} else if (number == 2) {
			result = "else if 블록입니다.";
		} else {
			result = "else 블록입니다.";
		}
		log.info(result);
		return result;
	}

	public String ex322() {
		int[] array = { 1, 2, 3, 4, 5 };
		String result = "";

		for (int i = 0; i < array.length; i++) {

			result += (" (i = " + array[i] + ")");
		}
		log.info(result);
		return result;
	}

	public String ex323() {
		int[] array = { 1, 2, 3, 4, 5 };
		int i = 0;
		String result = "";

		while (i < array.length) {
			result += ("i = " + array[i] + "<br>");
			i++;
		}
		log.info(result);
		return result;
	}

	public interface Car {
		public String getColor();
	}

	public class Sonata implements Car {
		public Sonata() {
			log.info("=== 출고===Sonata");
		}

		@Override
		public String getColor() {
			return "=== 색상:RED ===Sonata";
		}
	}

	public class K5 implements Car {
		public K5() {
			log.info("=== 출고===K5");
		}

		@Override
		public String getColor() {
			return "=== 색상:YELLOW ===K5";
		}
	}

	public String ex324() {
		Car car1 = new Sonata();
		String re1 = car1.getColor();
		Car car2 = new K5();
		String re2 = car2.getColor();

		String result = re1 + "<br>" + re2 + "<br>" + "차 두대를 출고하였음";
		return result;
	}

}
