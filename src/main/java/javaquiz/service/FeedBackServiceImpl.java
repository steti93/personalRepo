package javaquiz.service;

import javaquiz.persistence.model.Feedback;
import javaquiz.persistence.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public void saveFeddback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
