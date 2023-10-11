package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrdersMapper {


    /**
     * 添加订单数据
     */
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     */
    void update(Orders orders);

    /**
     * 订单搜索（分页查询）
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO pageQueryDTO);

    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);

    /**
     * 根据状态统计订单数量
     */
    @Select("select count(*) from orders where status = #{status}")
    Integer countStatus(Integer toBeConfirmed);

    /**
     * 通过用户id查询订单
     */
    Page<Orders> getByUserId(Long userId, Integer status);
}
