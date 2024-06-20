package entities;

import java.time.Duration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DurationAttributeConverter implements AttributeConverter<Duration, String>{

    @Override
    public String convertToDatabaseColumn(Duration duree) {
        if (duree == null){
            return null;
        }
        return duree.toString();
    }

    @Override
    public Duration convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Duration.parse(dbData);
    }
    
}
