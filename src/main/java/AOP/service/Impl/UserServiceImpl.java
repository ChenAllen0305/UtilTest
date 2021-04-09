package AOP.service.Impl;

import AOP.service.UserService;

/**
 * @title: UserServiceImpl
 * @Author Chen Lun
 * @Date: 2021/4/8
 */
public class UserServiceImpl implements UserService {
    @Override
    public void selectUser() {
        System.out.println("Call user select");
    }
}
