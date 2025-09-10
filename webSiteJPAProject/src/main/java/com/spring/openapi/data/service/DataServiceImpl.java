package com.spring.openapi.data.service;

import com.spring.common.openapi.URLConnectUtil;
import com.spring.openapi.data.dto.OpenApiDTO;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService{
    private final String serviceKey = "035bf9883b6516d3ec7e443705bfd30cca9bffcb8988350bdd5d5f78e4a17ab0";

    @Override
    public String busanWalkingList() {
        try {
            String baseUrl = "http://apis.data.go.kr/6260000/WalkingService/getWalkingKr";
            String params = String.format("?serviceKey=%s&pageNo=1&numOfRows=12&resultType=json", serviceKey);
            String site = baseUrl + params;

            OpenApiDTO openApi = new OpenApiDTO(site, "GET");
            return URLConnectUtil.openAPIData(openApi).toString();
        } catch(Exception e) {
            return "API 호출 중 오류 발생";
        }
    }
}
