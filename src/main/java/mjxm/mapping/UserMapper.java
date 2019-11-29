package mjxm.mapping;

import mjxm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    int selectByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    int countByUserName(String userName);

    int updateWxNameAndWxImg(@Param("userId") Integer userId, @Param("wxName") String wxName, @Param("wxImg") String wxImg);

    int updateIdentifiedAndNumber(@Param("userId") Integer userId, @Param("number") String number);

    User selectByPrimaryKey(Integer userId);

    List<User> selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}