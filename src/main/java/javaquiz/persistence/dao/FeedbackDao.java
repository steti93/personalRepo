package javaquiz.persistence.dao;

import javaquiz.persistence.model.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackDao extends CrudRepository<Feedback,Integer> {
}
