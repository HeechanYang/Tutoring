package ec.springframework.tutoring.service;

import ec.springframework.tutoring.model.Tutor;

import java.util.List;

public interface TuteeService {
    public List<Tutor> getTutorList();

    public List<Tutor> getMyTutorList(int tuteeIdx);
}
