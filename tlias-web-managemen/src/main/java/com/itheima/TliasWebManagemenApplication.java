package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 李阳
 */
@ServletComponentScan // 扫描过滤器
@SpringBootApplication
public class TliasWebManagemenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebManagemenApplication.class, args);
	}

}
