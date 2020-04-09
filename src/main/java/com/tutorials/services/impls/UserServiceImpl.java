package com.tutorials.services.impls;

import com.tutorials.models.UserModel;
import com.tutorials.repositories.UserRepository;
import com.tutorials.repositories.entities.UserEntity;
import com.tutorials.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel addUser(UserModel userRq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userRq.getUserId());
        userEntity.setUserName(userRq.getUserName());
        userEntity.setUserRole(userRq.getUserRole());
        userEntity.setUserEmail(userRq.getUserEmail());
        userEntity.setUserContact(userRq.getUserContact());
        UserEntity savedEntity = userRepository.save(userEntity);
        UserModel userRs = new UserModel();
        userRs.setId(savedEntity.getId());
        userRs.setUserId(savedEntity.getUserId());
        userRs.setUserName(savedEntity.getUserName());
        userRs.setUserRole(savedEntity.getUserRole());
        userRs.setUserEmail(savedEntity.getUserEmail());
        userRs.setUserContact(savedEntity.getUserContact());
        return userRs;
    }

    @Override
    public List<UserModel> retrieveAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> allUser = userEntities.parallelStream().map(userEntity -> {
            UserModel userModel = new UserModel();
            userModel.setId(userEntity.getId());
            userModel.setUserId(userEntity.getUserId());
            userModel.setUserName(userEntity.getUserName());
            userModel.setUserRole(userEntity.getUserRole());
            userModel.setUserEmail(userEntity.getUserEmail());
            userModel.setUserContact(userEntity.getUserContact());
            return userModel;
        }).collect(Collectors.toList());
        return allUser;
    }

    @Override
    public UserModel retrieveUserById(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setUserId(userEntity.getUserId());
        userModel.setUserName(userEntity.getUserName());
        userModel.setUserRole(userEntity.getUserRole());
        userModel.setUserEmail(userEntity.getUserEmail());
        userModel.setUserContact(userEntity.getUserContact());
        return userModel;
    }

    @Override
    public UserModel updateUser(String userId, UserModel userRq) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        userEntity.setUserName(userRq.getUserName());
        userEntity.setUserRole(userRq.getUserRole());
        userEntity.setUserEmail(userRq.getUserEmail());
        userEntity.setUserContact(userRq.getUserContact());
        UserEntity savedEntity = userRepository.save(userEntity);
        UserModel userRs = new UserModel();
        userRs.setId(savedEntity.getId());
        userRs.setUserId(savedEntity.getUserId());
        userRs.setUserName(savedEntity.getUserName());
        userRs.setUserRole(savedEntity.getUserRole());
        userRs.setUserEmail(savedEntity.getUserEmail());
        userRs.setUserContact(savedEntity.getUserContact());
        return userRs;
    }

    @Override
    public Boolean deleteUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        userRepository.delete(userEntity);
        return true;
    }

}
