package uz.khumoyun.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"uz.khumoyun.persistencelibrary","uz.khumoyun.admin"})
@EnableJpaRepositories(basePackages = "uz.khumoyun.persistencelibrary.repository")
@EntityScan(basePackages =  "uz.khumoyun.persistencelibrary.entities")
public class AdminControlPanelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminControlPanelApplication.class, args);
    }

}
