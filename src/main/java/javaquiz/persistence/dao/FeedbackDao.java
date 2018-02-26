package javaquiz.persistence.dao;

import javaquiz.persistence.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback,Integer> {
}
