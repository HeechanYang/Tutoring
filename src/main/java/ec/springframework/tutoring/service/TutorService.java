package ec.springframework.tutoring.service;

import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;

import java.util.List;

public interface TutorService {
    public List<Tutee> getTuteeList();

    public List<Tutee> getMyTuteeList(int tutorIdx);
}
