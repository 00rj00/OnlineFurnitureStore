package com.service;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Review;
import com.exception.CustomerFeedbackException;
import com.repository.FeedbackRepository;


@Service
public class FeedbackServices implements CustomerFeedbackService 
{
	
	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	private FeedbackRepository feedbackRepo;

	//This method is for returning all the available reviews
	@Override
	public List<Review> getAllReviews() throws CustomerFeedbackException
	{
		
		List<Review> getReview;
		try {
			getReview = feedbackRepo.findAll();
			if (!getReview.isEmpty()) 
			{
				return getReview;
			} 
			else 
			{
				throw new CustomerFeedbackException("NO REVIEWS YET");
			}
		} 
		catch (Exception e) 
		{
			throw new CustomerFeedbackException("NO REVIEWS YET");
		}
		
		
	}

	
	//This method is for adding a new review for certain furniture in the table
	@Override
	public Review addReview(Review review) throws CustomerFeedbackException {
		Review addReview = feedbackRepo.save(review);
		return addReview;
	}

	
	//This method is for updating the already given review 
	@Override
	public Review updateReview(int feedbackId, Review review) throws CustomerFeedbackException {
		Review updateReview;
		Review resultReview = feedbackRepo.findById(review.getFeedBackId()).orElse(null);
		try {
			
			if (resultReview!=null) 
			{
				updateReview = feedbackRepo.save(review);
				
			} 
			else 
			{
				throw new CustomerFeedbackException("Id not found");
			}
		} 
		catch (Exception e) 
		{
			throw new CustomerFeedbackException("id not found");
		}
		return updateReview;
	}

}
