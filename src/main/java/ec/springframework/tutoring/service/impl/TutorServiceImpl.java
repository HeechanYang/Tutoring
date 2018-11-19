package ec.springframework.tutoring.service.impl;

import ec.springframework.tutoring.mapper.TutorMapper;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.service.CommonDao;
import ec.springframework.tutoring.service.TutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl  extends CommonDao implements TutorService{

    private final TutorMapper tutorMapper;

    public TutorServiceImpl(TutorMapper tutorMapper) {
        this.tutorMapper = tutorMapper;
    }

    @Override
    public List<Tutee> getTuteeList() {
        return tutorMapper.getTuteeList();
    }

    @Override
    public List<Tutee> getMyTuteeList(int tuteeIdx) {
        return tutorMapper.getMyTuteeList(tuteeIdx);
    }
}
