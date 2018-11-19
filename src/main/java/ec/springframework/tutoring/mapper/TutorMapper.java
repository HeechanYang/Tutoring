package ec.springframework.tutoring.mapper;

import ec.springframework.tutoring.model.Tutee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TutorMapper {

    public List<Tutee> getTuteeList();

    public List<Tutee> getMyTuteeList(@Param("tutorIdx") int tutorIdx);
}
