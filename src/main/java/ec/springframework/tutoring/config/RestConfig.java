package ec.springframework.tutoring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfig
{
    /**
     * Bean to make jackson automatically convert from
     * camelCase (java) to under_scores (json) in property names
     *
     * @return ObjectMapper that maps from Java camelCase to json under_score names
     */
    @Bean
    public ObjectMapper jacksonObjectMapper()
    {
        return new ObjectMapper().setPropertyNamingStrategy(propertyNamingStrategy());
    }

    @Bean
    public PropertyNamingStrategy propertyNamingStrategy()
    {
        return PropertyNamingStrategy.LOWER_CAMEL_CASE;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(jacksonObjectMapper());
        messageConverters.add(jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }
}
