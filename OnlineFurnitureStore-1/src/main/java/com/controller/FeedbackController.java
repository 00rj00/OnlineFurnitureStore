package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.*;
import com.service.*;
import com.exception.*;

@RestController
@RequestMapping("api/reviews")
public class FeedbackController 
{
	@Autowired
	FeedbackServices feedbackservice;
	
	@PostMapping("/addReview")
	public ResponseEntity<Review> addReview(@RequestBody Review review) throws CustomerFeedbackException
	{
		Review newReview = feedbackservice.addReview(review);
		ResponseEntity<Review> re = new ResponseEntity<Review>(newReview,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/updateReview/{feedbackId}")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) throws CustomerFeedbackException
	{
		Review uReview = feedbackservice.updateReview(review.getFeedBackId(),review);
		ResponseEntity<Review> re = new ResponseEntity<Review>(uReview,HttpStatus.OK);
		return re;
		
	}
	
	@GetMapping("/Reviews")
	public ResponseEntity<List<Review>> getAllReviews() throws CustomerFeedbackException
	{
		List<Review> reviews = feedbackservice.getAllReviews();
		ResponseEntity<List<Review>> re = new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping("getReviewByRating") public ResponseEntity<int>
	 * getReviewByRating(int reviewRating) throws CustomerFeedbackException { int r
	 * = feedbackservice.getReviewByreviewRating(reviewRating);
	 * ResponseEntity<Review> re = new ResponseEntity<Review>(r,HttpStatus.OK);
	 * return re; }
	 */
	

}
