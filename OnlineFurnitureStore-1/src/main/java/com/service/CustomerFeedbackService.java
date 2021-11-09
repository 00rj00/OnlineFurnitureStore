package com.service;

import java.util.List;

import com.entity.Review;
import com.exception.CustomerFeedbackException;

public interface CustomerFeedbackService {
	
	List<Review> getAllReviews() throws CustomerFeedbackException;
	
	int getReviewByreviewRating(int reviewRating) throws CustomerFeedbackException;
	
	Review addReview(Review review) throws CustomerFeedbackException;
	
	Review updateReview(int feedbackId,Review review) throws CustomerFeedbackException;

}
