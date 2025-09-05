package org.sinobridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 启动程序
 *
 * @author Zhao Yun
 */

@SpringBootApplication
public class SubmachineApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SubmachineApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("系统启动成功");
    }

}
