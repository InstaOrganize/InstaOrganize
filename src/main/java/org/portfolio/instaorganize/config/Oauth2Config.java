package org.portfolio.instaorganize.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Configuration
public class Oauth2Config extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationFailureHandler handler;

    @Value("${oauthenabled}")
    boolean oauthEnabled;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(oauthEnabled) {
            http.authorizeRequests(a -> a
                    .antMatchers("/", "/h2-console/**", "/spring-security-rest/**", "/error", "/webjars/**").permitAll()
                    .anyRequest().authenticated())
                    .logout(l -> l
                            .logoutSuccessUrl("/").permitAll())
                    /*.csrf(c -> c
                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    )*/
                    .csrf().disable()
                    .headers().frameOptions().disable();
            http.exceptionHandling(e -> e
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                    .oauth2Login(o -> o
                            .failureHandler((request, response, exception) -> {
                                request.getSession().setAttribute("error.message", exception.getMessage());
                                handler.onAuthenticationFailure(request, response, exception);
                            })
                    );
        } else  {
            http.httpBasic().and()
                    .authorizeRequests()
                    .antMatchers("/**")
                    .permitAll().anyRequest().authenticated()
                    .and().csrf().disable();
        }
        /*http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
            private Pattern allowedMethods = Pattern.compile("^ (GET | HEAD | TRACE | OPTIONS) $");
            private RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/ console /.*",null);

            @Override
            public boolean matches(HttpServletRequest request) {
                if (allowedMethods.matcher(request.getMethod()).matches())
                    return false;
                if (apiMatcher.matches(request))
                    return false;
                return true;
            }
        });*/
    }
}
