package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQsgx;

public interface DataGaQsgxService extends IService<DataGaQsgx> {
    public Boolean isExist(Integer projectId, DataGaQsgx dataGaQsgx);
}
