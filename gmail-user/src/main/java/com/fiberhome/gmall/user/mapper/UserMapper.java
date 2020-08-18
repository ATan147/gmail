package com.fiberhome.gmall.user.mapper;


import com.fiberhome.gmall.user.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ATan147
 * @create 2020-08-17 21:58
 */
public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();
}
