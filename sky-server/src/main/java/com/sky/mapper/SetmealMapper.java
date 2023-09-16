package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {
    /**
     * 根据分类id查询套餐数量
     */
    @Select("select count(*) from setmeal where category_id = #{id}")
    Integer countByCategoryId(Long id);

    /**
     * 添加套餐
     */
    @AutoFill(OperationType.INSERT)
    void insert(Setmeal setmeal);
    
    /**
     * 分页查询
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);
}
