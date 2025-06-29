package com.thr.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thr.picturebackend.model.dto.picture.PictureQueryRequest;
import com.thr.picturebackend.model.dto.picture.PictureReviewRequest;
import com.thr.picturebackend.model.dto.picture.PictureUploadByBatchRequest;
import com.thr.picturebackend.model.dto.picture.PictureUploadRequest;
import com.thr.picturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thr.picturebackend.model.entity.User;
import com.thr.picturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author 屠皓然
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-06-27 13:45:41
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    void fillReviewParams(Picture picture, User loginUser);

    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest, User loginUser);
}
