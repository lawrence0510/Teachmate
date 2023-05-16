package teachmate;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("teachmate.repository")
@EnableTransactionManagement
public class AppConfig {
    // 配置內容...
}
