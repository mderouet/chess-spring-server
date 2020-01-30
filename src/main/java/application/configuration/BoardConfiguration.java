package application.configuration;

import application.service.BoardManagementService;
import application.service.BoardService;
import application.service.BoardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfiguration {

  @Bean
  BoardManagementService boardManagement(){
    return new BoardManagementService();
  }

  @Bean
  BoardService boardService(){
    return new BoardServiceImpl();
  }
}
