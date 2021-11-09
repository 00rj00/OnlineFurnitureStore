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
	@Autowired
	private FeedbackRepository feedbackRepo;

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

	@Override
	public int getReviewByreviewRating(int reviewRating) throws CustomerFeedbackException
	{
		//return feedbackRepo.findReviewByRating(reviewRating);
		return 0;
		
	}

	@Override
	public Review addReview(Review review) throws CustomerFeedbackException {
		Review addReview = feedbackRepo.save(review);
		return addReview;
	}

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
