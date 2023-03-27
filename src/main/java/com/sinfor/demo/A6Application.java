package com.sinfor.demo;

import com.sinfor.scanner.starter.scanner.Scanner;
import com.sinfor.stater.net.SinforNettyServer;
import io.netty.channel.ChannelFuture;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.sinfor.demo.mapper")
public class A6Application implements CommandLineRunner {

    @Resource
    private SinforNettyServer sinforNettyServer;

    public static void main(String[] args) {
        SpringApplication.run(A6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 扫描自定义注解
        Scanner.getInstance().scan("com.sinfor.demo.service");

        ChannelFuture channelFuture = sinforNettyServer.startServer();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                sinforNettyServer.close();
            }
        });
        channelFuture.channel().closeFuture().sync();
    }
}
