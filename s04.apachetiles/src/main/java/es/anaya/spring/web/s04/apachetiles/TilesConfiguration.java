package es.anaya.spring.web.s04.apachetiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration {

  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    String[] definitions = { "WEB-INF/tiles.xml" };
    tilesConfigurer.setDefinitions(definitions);
    return tilesConfigurer;
  }

  @Bean
  public UrlBasedViewResolver tilesViewResolver() {
    UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
    tilesViewResolver.setViewClass(TilesView.class);
    return tilesViewResolver;
  }
}