package mjxm.mapping;

import mjxm.pojo.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    Record selectRecordByUserAndRequirement(@Param("userId") Integer userId, @Param("requirementId") Integer requirementId);

    List<Record> selectUserAllRecord(Integer userId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    int updateTime(Record record);
}