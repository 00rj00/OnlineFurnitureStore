package com.service;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureUser;
import com.exception.UserNotFoundException;
import com.repository.UserManagementRepository;


@Service
//User Management Service
public class UserManagementServices implements UserManagementService 
{
	//Auto wiring the objects for using the JpaRepository methods
	@Autowired
	private UserManagementRepository userRepo;

	//This method is for USER LOGIN / AUTHENTICATION
	@Override
	public String loginUser(FurnitureUser user) throws UserNotFoundException  
	{
		Optional<FurnitureUser> optionalUser=userRepo.findById(user.getUId());
		if(!optionalUser.isEmpty())
		{
			if(optionalUser.get().getPassword().equals(user.getPassword()))
			{
				return "Login successfull!";
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	//This method is for registration for new user
	@Override
	public FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException{
		Optional<FurnitureUser> userTemp = userRepo.findById(user.getUId());
		try 
		{
			if (userTemp != null) 
			{
				user = userRepo.save(user);
				return user;
			} 
			else 
			{
				throw new UserNotFoundException("The given User already exists");
			}
		} 
		catch (Exception e) 
		{
			throw new UserNotFoundException("The given User already exists");
		}
	}

	//This method is to update user details
	@Override
	public FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException{
		Optional<FurnitureUser> resultUser = userRepo.findById(user.getUId());
		try {
			
			if ((resultUser != null)) 
			{
				FurnitureUser updateUser = userRepo.save(user);
				return updateUser;
			} 
			else 
			{
				throw new UserNotFoundException("User already exists");
			}
		} 
		catch (Exception e) 
		{
			throw new UserNotFoundException("User already exists");
		}
	}

	//This method is for deleting a user
	@Override
	public String deleteUser(FurnitureUser user) throws UserNotFoundException{
		List<FurnitureUser> resultUser = new ArrayList<FurnitureUser>();
		try 
		{
			resultUser = userRepo.findAll();
			if (resultUser != null) 
			{
				userRepo.deleteAll();
				return "Deleted successfully";
			} 
			else 
			{
				throw new UserNotFoundException("There are no users to delete");
			}

		} 
		catch (Exception e) 
		{
			throw new UserNotFoundException("There are no users to delete");
		}
	}

	//This method is for deleting a user based on UserID
	@Override
	public FurnitureUser deleteUserById(int uid) throws UserNotFoundException{
		Optional<FurnitureUser> del = userRepo.findById(uid);
		
		if (del == null) 
		{
			throw new UserNotFoundException("No user found");
		}
		else 
		{
			userRepo.deleteById(uid);
			if (del.isPresent()) 
			{
				return del.get();
			} 
			else 
			{
				throw new UserNotFoundException("Not Present");
			}

		}
	}

}
