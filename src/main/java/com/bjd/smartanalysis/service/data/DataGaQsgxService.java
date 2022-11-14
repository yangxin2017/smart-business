package com.bjd.smartanalysis.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjd.smartanalysis.entity.data.DataGaQsgx;

import java.util.List;

public interface DataGaQsgxService extends IService<DataGaQsgx> {
    public Boolean isExist(Integer projectId, DataGaQsgx dataGaQsgx);
    public List<DataGaQsgx> GetAllPersonList(Integer projectId, String xm);

    public DataGaQsgx GetQsgxByNames(Integer projectId, String xm);
}
