package ec.springframework.tutoring.mapper;

import ec.springframework.tutoring.model.Tutor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TuteeMapper {
    public List<Tutor> getTutorList();

    public List<Tutor> getMyTutorList(@Param("tuteeIdx") int tuteeIdx);
}
