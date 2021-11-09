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
public class UserManagementServices implements UserManagementService 
{
	@Autowired
	UserManagementRepository UserRepo;

	
	@Override
	public String loginUser(FurnitureUser user) throws UserNotFoundException  
	{
		Optional<FurnitureUser> optionalUser=UserRepo.findById(user.getUId());
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

	
	@Override
	public FurnitureUser registerNewUser(FurnitureUser user) throws UserNotFoundException{
		Optional<FurnitureUser> userTemp = UserRepo.findById(user.getUId());
		try 
		{
			if (userTemp != null) 
			{
				user = UserRepo.save(user);
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

	
	@Override
	public FurnitureUser updateUser(FurnitureUser user) throws UserNotFoundException{
		Optional<FurnitureUser> resultUser = UserRepo.findById(user.getUId());
		try {
			
			if ((resultUser != null)) 
			{
				FurnitureUser updateUser = UserRepo.save(user);
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

	
	@Override
	public String deleteUser(FurnitureUser user) throws UserNotFoundException{
		List<FurnitureUser> resultUser = new ArrayList<FurnitureUser>();
		try 
		{
			resultUser = UserRepo.findAll();
			if (resultUser != null) 
			{
				UserRepo.deleteAll();
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

	
	@Override
	public FurnitureUser deleteUserById(int uid) throws UserNotFoundException{
		Optional<FurnitureUser> del = UserRepo.findById(uid);
		
		if (del == null) 
		{
			throw new UserNotFoundException("No user found");
		}
		else 
		{
			UserRepo.deleteById(uid);
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
