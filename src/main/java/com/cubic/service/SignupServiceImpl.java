package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.dao.Signup;
import com.cubic.dao.SignupDao;
import com.cubic.dto.SignupDTO;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDao signupDao;

	@Override
	public void deleteById(int sid) {
		signupDao.deleteById(sid);
	}

	@Override
	public List<SignupDTO> findAll() {
		List<Signup> list = signupDao.findAll();

		List<SignupDTO> dtos = new ArrayList<>();
		for (Signup signup : list) {
			SignupDTO dto = new SignupDTO();
			BeanUtils.copyProperties(signup, dto);
			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public void save(SignupDTO signupDTO) {

		Signup signup = new Signup();
		BeanUtils.copyProperties(signupDTO, signup);
		signupDao.save(signup);
	}
	
	@Override
	public void update(SignupDTO signupDTO) {
		Signup signup = new Signup();
		BeanUtils.copyProperties(signupDTO, signup);
		signupDao.update(signup);
	}
	
	@Override
	public boolean findByUsername(String username) {
		return signupDao.findByUsername(username);
	}
	
	@Override
	public void updatePassword(String username, String newpassword) {
		signupDao.updatePassword(username, newpassword);
	}
	

	@Override
	public SignupDTO findById(int sid) {
		Signup signup = signupDao.findById(sid);
		SignupDTO dto = new SignupDTO();
		BeanUtils.copyProperties(signup, dto);
		return dto;
	}

	@Override
	public void updateImage(int sid, String newimage) {
		signupDao.updateImage(sid, newimage);
	}

	@Override
	public SignupDTO findByUsernameAndPassword(String username, String password) {
		Signup signup = signupDao.findByUsernameAndPassword(username, password);
		SignupDTO dto = null;
		if (signup != null) {
			dto = new SignupDTO();
			BeanUtils.copyProperties(signup, dto);
		}
		return dto;
	}

}
