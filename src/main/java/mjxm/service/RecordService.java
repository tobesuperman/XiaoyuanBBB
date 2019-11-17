package mjxm.service;

import mjxm.pojo.Record;

import java.util.List;

public interface RecordService {
    public void add(Record record);

    public Record findByUserAndRequirement(Integer userId, Integer requirementId);

    public int update(Record record);

    public List<Record> findUserAllRecord(Integer userId);
}
