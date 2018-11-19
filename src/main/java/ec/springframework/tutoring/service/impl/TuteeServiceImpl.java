package ec.springframework.tutoring.service.impl;

import ec.springframework.tutoring.mapper.TuteeMapper;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.service.CommonDao;
import ec.springframework.tutoring.service.TuteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuteeServiceImpl extends CommonDao implements TuteeService {

    private final TuteeMapper tuteeMapper;

    public TuteeServiceImpl(TuteeMapper tuteeMapper) {
        this.tuteeMapper = tuteeMapper;
    }

    @Override
    public List<Tutor> getTutorList() {
        return tuteeMapper.getTutorList();
    }

    @Override
    public List<Tutor> getMyTutorList(int tuteeIdx) {
        return tuteeMapper.getMyTutorList(tuteeIdx);
    }
}
