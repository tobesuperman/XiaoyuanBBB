package mjxm.service.impl;

import mjxm.mapping.RecordMapper;
import mjxm.pojo.Record;
import mjxm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void browse(Record record) {
        recordMapper.insert(record);
    }
}
