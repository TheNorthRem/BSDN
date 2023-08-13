package com.bupt.bsdn.mapper;

import com.bupt.bsdn.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liyehui
 * @description 针对表【User】的数据库操作Mapper
 * @createDate 2023-08-04 15:51:58
 * @Entity com.bupt.bsdn.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from  User where user_id=#{id}")
    public List<User> getUser(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "userid")
    @Insert("insert into User (user_id,user_name,password,isAdmin,nickName) values (#{userid},#{userName},#{password},#{isadmin},#{nickname}))")
    public void InsertUser(User user);

}




