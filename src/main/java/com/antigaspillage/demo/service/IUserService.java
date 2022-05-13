package com.antigaspillage.demo.service;

import com.antigaspillage.demo.data.User;

public interface IUserService {
    User findByEmail(String email);

}
