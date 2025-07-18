package com.thr.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thr.picturebackend.model.dto.space.SpaceAddRequest;
import com.thr.picturebackend.model.dto.space.SpaceQueryRequest;
import com.thr.picturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thr.picturebackend.model.entity.User;
import com.thr.picturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 屠皓然
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-06-30 12:41:26
*/
public interface SpaceService extends IService<Space> {

    void validSpace(Space space, boolean add);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    void fillSpaceBySpaceLevel(Space space);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    long addSpace (SpaceAddRequest spaceAddRequest, User loginUser);

    void checkSpaceAuth(User loginUser, Space space);
}
