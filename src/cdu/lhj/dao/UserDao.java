package cdu.lhj.dao;

import cdu.lhj.model.User;
import cdu.lhj.model.User;

import java.util.List;

public interface UserDao {

    User loginCheck(String username, String password);
}
