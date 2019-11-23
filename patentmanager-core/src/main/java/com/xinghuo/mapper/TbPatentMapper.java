package com.xinghuo.mapper;

import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import java.util.List;

@Mapper
@Repository
public interface TbPatentMapper {
    /**
     *@Author:Yuyue
     *@Description:查询用户专利通过用户id
     *@Date:18:08  2019/11/22
     *@Param:
     *@Return:
     */
    List<TbPatent> getPatentByUser(Integer userId);
    /**
     *@Author:Yuyue
     *@Description:获取专利信息通过专利id
     *@Date:18:08  2019/11/22
     *@Param:
     *@Return:
     */
    TbPatent getPatentById(Integer patentId);
    /**
     *@Author:Yuyue
     *@Description:修改专利
     *@Date:18:09  2019/11/22
     *@Param:
     *@Return:
     */
    void updatePatentById(TbPatent tbPatent);
    /**
     *@Author:Yuyue
     *@Description:删除指标通过专利id
     *@Date:18:09  2019/11/22
     *@Param:
     *@Return:
     */
    void deleteIndicatorsByPatentId(Integer patentId);
    /**
     *@Author:Yuyue
     *@Description:插入专利指标
     *@Date:18:10  2019/11/22
     *@Param:
     *@Return:
     */
    void insertIndicatorsByPatentId(TbIndicator tbIndicator);



    /**
     *@Author:Yuyue
     *@Description:添加文件到数据库
     *@Date:18:11  2019/11/22
     *@Param:
     *@Return:
     */
    void addFile(TbDocument tbDocument);
    /**
     *@Author:Yuyue
     *@Description:查询专利每个文件类别最新的文件
     *@Date:18:12  2019/11/22
     *@Param:
     *@Return:
     */
    List<TbDocument> selectLatestDocumentById(Integer patentId);
    /**
     *@Author:Yuyue
     *@Description:查询专利的所有文件
     *@Date:18:12  2019/11/22
     *@Param:
     *@Return:
     */
    List<TbDocument> selectAllDocumentById(Integer patentId);
    //根据相关专利信息查询所有专利包含认领和未被认领（管理员） zhou_gc
    List<TbPatent>  getPatentList(TbPatent tbPatent);
    //根据专利id查询相关专利信息  zhou_gc
    TbPatent  getPatentByPatentId(Integer patent_id);

    //添加专利  刘建
    void addPatent(TbPatent tbPatent);

    //根据专利名称查询专利信息  刘健
    TbPatent findPatentByName(String patentName);

    //根据专利id查询专利信息   刘健
    TbPatent findPatentById(Integer patentId);

    //修改专利进度                刘健
    void updPlan(TbPatent tbPatent);


}
