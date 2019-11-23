package com.xinghuo.service.Impl;

import com.xinghuo.mapper.TbPatentMapper;
import com.xinghuo.mapper.UserPatentMapper;
import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mypatent
 * @description: 用户专利service实现类
 * @author: Yuyue
 * @create: 2019-11-20 19:41
 **/
@Service
public class UserPatentServiceImpl implements UserPatentService {

   @Autowired TbPatentMapper patentMapper;

    @Autowired
    private UserPatentMapper userPatentMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //段炼
    @Override
    public List<TbPatent> findAll() {
        /*if((redisTemplate.boundSetOps("findAll").members()) != null) {
            List list = redisTemplate.boundListOps("findAll").range(0, 1);
            System.out.println("用上redis了！");
            System.out.println(list);
            return list;
        }else {*/
        List<TbPatent> list = userPatentMapper.findAll();
        /*redisTemplate.boundListOps("findAll").rightPush(list);
            System.out.println(list);*/
        return list;


    }
    //段炼
    @Override
    public List<TbPatent> findDetail(Integer id) {
        List<TbPatent> list =userPatentMapper.findDetail(id);
        return list;
    }
    //段炼
    @Override
    public int update(Integer id) {
        return userPatentMapper.update(id);
    }


    /**
     *@Author:Yuyue
     *@Description:获取用户专利列表
     *@Date:18:04  2019/11/22
     *@Param:
     *@Return:
     */
    @Override
    public List<TbPatent> getPatentByUser(Integer userId) {

        return patentMapper.getPatentByUser(userId);
    }

    /**
     *@Author:Yuyue
     *@Description:获取专利详情，通过专利id
     *@Date:18:05  2019/11/22
     *@Param:
     *@Return:
     */
    @Override
    public TbPatent getPatentById(Integer patentId) {
        return patentMapper.getPatentById(patentId);
    }

    /**
     *@Author:Yuyue
     *@Description:更新专利信息
     *@Date:18:05  2019/11/22
     *@Param:
     *@Return:
     */
    @Override
    public void updatePatentById(TbPatent tbPatent) {
        //修改专利的基本信息
        patentMapper.updatePatentById(tbPatent);
        if(tbPatent.getTbIndicators()!=null){
            //删除专利对应的指标
            System.out.println("删除啦"+tbPatent.getTbIndicators());
            patentMapper.deleteIndicatorsByPatentId(tbPatent.getPatentId());
            //添加修改的所有指标
            for(int i=0;i<tbPatent.getTbIndicators().size();i++){
                patentMapper.insertIndicatorsByPatentId(tbPatent.getTbIndicators().get(i));
            }

        }

    }

    /**
     *@Author:Yuyue
     *@Description:上传文件到数据库
     *@Date:18:06  2019/11/22
     *@Param:
     *@Return:
     */
    @Override
    public void addFile(TbDocument tbDocument) {
        patentMapper.addFile(tbDocument);
    }

    /**
     *@Author:Yuyue
     *@Description:查询每一类别最新的文件
     *@Date:18:06  2019/11/22
     *@Param:
     *@Return:
     */
    @Override
    public List<TbDocument> selectLatestDocumentById(Integer patentId) {
        return patentMapper.selectLatestDocumentById(patentId);
    }

    /**
     *@Author:Yuyue
     *@Description:查询专利每一次上传的文件
     *@Date:18:07  2019/11/22
     *@Param:
     *@Return:
     */
    @Override
    public List<TbDocument> selectAllDocumentById(Integer patentId) {
        return patentMapper.selectAllDocumentById(patentId);
    }

    //添加专利
    @Override
    public void addPatent(TbPatent tbPatent){
        patentMapper.addPatent(tbPatent);
    }

    //根据专利名称查询专利信息
    @Override
    public TbPatent findPatentByName(String patentName) {
        return patentMapper.findPatentByName(patentName);
    }

    //根据专利id查询专利信息
    @Override
    public TbPatent findPatentById(Integer patentId) {
        return patentMapper.findPatentById(patentId);
    }

    //通过专利id修改专利进度
    @Override
    public void updPlan(TbPatent tbPatent) {
        patentMapper.updPlan(tbPatent);
    }


}
