package mjxm.service.impl;

import mjxm.mapping.RecordMapper;
import mjxm.pojo.Record;
import mjxm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void add(Record record) {
        recordMapper.insert(record);
    }
}
