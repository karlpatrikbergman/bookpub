package org.test.bookpub;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * The configurer.setUseSuffixPatternMatch(false) method indicates that	we don’t want to us the .* 	suffix so as to
     * strip the trailing characters after the last	dot. This translates into Spring parsing out the entire
     * 978-1-78528-415-1.1 as an {isbn} parameter for BookController.
     * <p>
     * So http://localhost:8080/books/978-1-78528-415-1.1 and http://localhost:8080/books/978-1-78528-415-1
     * <p>
     * will	become different URLs.
     * <p>
     * The configurer.setUseTrailingSlashMatch(true) method indicates that we want to use the trailing / in the URL as a
     * match as if it were not there.
     * <p>
     * This effectively makes http://localhost:8080/books/978-1-78528-415-1
     * <p>
     * the same as http://localhost:8080/books/978-1-78528-415-1/ .
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
                .setUseTrailingSlashMatch(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/internal/**")
                .addResourceLocations("classpath:/");
    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return (ConfigurableEmbeddedServletContainer container) -> container.setSessionTimeout(1, TimeUnit.MINUTES);
    }

//    @Autowired
//    private BookRepository bookRepository;
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new BookFormatter(bookRepository));
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        return new LocaleChangeInterceptor();
//    }
//
//    @Bean
//    public RemoteIpFilter remoteIpFilter() {
//        return new RemoteIpFilter();
//    }
}
