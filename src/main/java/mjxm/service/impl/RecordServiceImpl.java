package mjxm.service.impl;

import mjxm.mapping.RecordMapper;
import mjxm.pojo.Record;
import mjxm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void add(Record record) {
        recordMapper.insert(record);
    }

    @Override
    public Record findByUserAndRequirement(Integer userId, Integer requirementId) {
        return recordMapper.selectRecordByUserAndRequirement(userId, requirementId);
    }

    @Override
    public int update(Record record) {
        return recordMapper.updateTime(record);
    }

    @Override
    public List<Record> findUserAllRecord(Integer userId) {
        return recordMapper.selectUserAllRecord(userId);
    }
}
