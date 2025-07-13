package com.thr.picturebackend.api.imagesearch;


import com.thr.picturebackend.api.imagesearch.model.ImageSearchResult;
import com.thr.picturebackend.api.imagesearch.sub.GetImageFirstUrlApi;
import com.thr.picturebackend.api.imagesearch.sub.GetImageListApi;
import com.thr.picturebackend.api.imagesearch.sub.GetImagePageUrlApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ImageSearchApiFacade {

    public static List<ImageSearchResult> getImageList (String imageUrl) {
        String pageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(pageUrl);
        return GetImageListApi.getImageList(imageFirstUrl);
    }

    public static void main(String[] args) {
        System.out.println(getImageList("http://mms2.baidu.com/it/u=2614048980,3918066711&fm=253&app=138&f=JPEG?w=570&h=285"));
    }
}
