package com.puzhibing.study_notes;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@MapperScan(value = "com.puzhibing.study_notes.mapper")
public class StudyNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyNotesApplication.class, args);
	}
}
